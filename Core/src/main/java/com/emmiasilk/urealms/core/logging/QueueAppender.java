package com.emmiasilk.urealms.core.logging;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Plugin(name = "Queue", category = "Core", elementType = "appender", printObject = true)
public class QueueAppender extends AbstractAppender {
    private static final int MAX_CAPACITY = 250;
    private static final ReadWriteLock QUEUE_LOCK = new ReentrantReadWriteLock();
    private static final Map<String, BlockingQueue<String>> QUEUES = new HashMap<>();

    private final BlockingQueue<String> queue;

    private QueueAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions,
                          BlockingQueue<String> queue) {
        super(name, filter, layout, ignoreExceptions);
        this.queue = queue;
    }

    @Override
    public void append(LogEvent event) {
        if (queue.size() >= MAX_CAPACITY) {
            queue.clear();
        }
        queue.add(getLayout().toSerializable(event).toString());
    }

    @PluginFactory
    public static QueueAppender createAppender(@PluginAttribute("name") String name,
                                               @PluginElement("Filters") Filter filter,
                                               @PluginElement("Layout") Layout<? extends Serializable> layout,
                                               @PluginAttribute("ignoreExceptions") String ignore,
                                               @PluginAttribute("target") String target) {

        boolean ignoreExceptions = Boolean.parseBoolean(ignore);
        QueueAppender appender = null;

        if (name != null) {
            target = target == null ? name : target;

            QUEUE_LOCK.writeLock().lock();
            BlockingQueue<String> queue = QUEUES.computeIfAbsent(target, k -> new LinkedBlockingQueue<>());
            QUEUE_LOCK.writeLock().unlock();

            layout = layout == null ? PatternLayout.newBuilder().build() : layout;
            appender = new QueueAppender(name, filter, layout, ignoreExceptions, queue);
        }
        else {
            LOGGER.error("No name provided for QueueAppender");
        }


        return appender;
    }

    public static String getNext(String queueName) {
        QUEUE_LOCK.readLock().lock();
        BlockingQueue<String> queue = QUEUES.get(queueName);
        QUEUE_LOCK.readLock().unlock();

        if (queue != null) {
            try {
                return queue.take();
            }
            catch (InterruptedException exception) {
                LOGGER.error(exception);
            }
        }

        return null;
    }
}
