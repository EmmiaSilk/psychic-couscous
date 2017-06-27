package com.emmiasilk.urealms.server;

import com.emmiasilk.urealms.core.logging.Logging;
import com.emmiasilk.urealms.server.gui.ServerGui;

import java.awt.GraphicsEnvironment;
import java.util.Map;

public class UrealmsServer {

    private static UrealmsServer server;

    UrealmsServer(Map<String, String> args) {
        Logging.logInfo("Starting server...");

        if(Boolean.parseBoolean(args.get("gui")) && !GraphicsEnvironment.isHeadless()) {
            new Thread(() -> ServerGui.launch(ServerGui.class)).start();
        }

        server = this;
    }

    public void save() {
        Logging.logInfo("Saving server...");
    }

    public void close() {
        this.close(0);
    }

    public void close(int status) {
        this.save();

        Logging.logInfo("Exiting server...");
        System.exit(status);
    }

    public static UrealmsServer getServer() {
        return server;
    }
}
