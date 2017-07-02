package com.emmiasilk.urealms.server;

import com.emmiasilk.urealms.api.logging.Logging;
import com.emmiasilk.urealms.api.util.I18n;
import com.emmiasilk.urealms.server.gui.ServerGui;

import java.awt.GraphicsEnvironment;
import java.util.Map;

/**
 * Represents the server it's self.
 *
 * @since 0.0.1
 */
public class URealmsServer {

    /**
     * Instance of the server.
     */
    private static URealmsServer instance;

    /**
     * Constructor for the server.
     *
     * Initializes all server variables, the starts the server
     *
     * @param args Map of arguments from the command line.
     */
    URealmsServer(Map<String, String> args) {
        Logging.logInfo(I18n.getInstance().getLocalizedString("server.starting"));

        if (Boolean.parseBoolean(args.get("resources/server_gui")) && !GraphicsEnvironment.isHeadless()) {
            new Thread(() -> ServerGui.launch(ServerGui.class)).start();
        }

        instance = this;
    }

    /**
     * Save the server
     */
    public void save() {
        Logging.logInfo(I18n.getInstance().getLocalizedString("server.saving"));
    }

    /**
     * Close the server with a status of 0.
     *
     * Used when the server is exiting normally.
     */
    public void close() {
        this.close(0);
    }

    /**
     * Close the server.
     *
     * Generally used when the server is not normally exiting.
     *
     * @param status the exit status code for the server
     */
    public void close(int status) {
        this.save();

        Logging.logInfo(I18n.getInstance().getLocalizedString("server.exiting"));
        System.exit(status);
    }

    /**
     * Get the instance of the server.
     *
     * @return the instance of the server.
     */
    public static URealmsServer getInstance() {
        return instance;
    }
}
