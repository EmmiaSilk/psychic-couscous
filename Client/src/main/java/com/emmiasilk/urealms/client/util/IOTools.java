package com.emmiasilk.urealms.client.util;

import com.emmiasilk.urealms.api.logging.Logging;
import org.lwjgl.BufferUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Emmia on 2017-09-21.
 */
public class IOTools {

    public static ByteBuffer resizeBuffer(ByteBuffer oldBuffer, int newSize) {
        ByteBuffer newBuffer = BufferUtils.createByteBuffer(newSize);
        oldBuffer.flip();
        newBuffer.put(oldBuffer);
        return newBuffer;
    }

    public static ByteBuffer ioResourceToByteBuffer(String resource, int bufferSize) throws IOException {
        // Create bytebuffer to store data
        ByteBuffer buffer;

        Path path = Paths.get(resource);
        Logging.logDebug("Path: " + path.toString());

        // Read resource data to bytebuffer
        if (Files.isReadable(path)) {
            // File can be fully read, size is known
            SeekableByteChannel fileChannel = Files.newByteChannel(path);
            buffer = BufferUtils.createByteBuffer((int) fileChannel.size() + 1);
            Logging.logDebug("IsReadable");
            while (true) {
                // Loop until file is completely read
                if (fileChannel.read(buffer) != -1) {
                    break;
                }
            }
        } else {
            // File size cannot be predicted and the file must be read in parts
            InputStream source = IOTools.class.getClassLoader().getResourceAsStream(resource);
            if (source == null) {
                // I don't know what's wrong here
                throw new IOException();
            }
            ReadableByteChannel inputChannel = Channels.newChannel(source);
            buffer = BufferUtils.createByteBuffer(bufferSize);

            while (true) {
                int bytes = inputChannel.read(buffer);
                if (bytes == -1) {
                    break;
                }
                if (buffer.remaining() == 0) {
                    buffer = resizeBuffer(buffer, buffer.capacity() * 2);
                }
            }
        }

        // Return a readable buffer
        buffer.flip();
        return buffer;
    }
}
