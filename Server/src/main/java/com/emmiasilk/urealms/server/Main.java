package com.emmiasilk.urealms.server;

import com.emmiasilk.urealms.core.logging.Logging;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class of the server application.
 *
 * @since 0.0.1
 */
public class Main {

    /**
     * A map of command line arguments.
     */
    private static Map<String, String> argsMap = new HashMap<>();

    /**
     * Server application entry point.
     *
     * @param args the arguments passed to the application from the command line.
     */
    public static void main(String[] args) {
        Logging.logInfo("Alright..... I wanna cast a spell");

        parseArgs(Arrays.asList(args));

        new UrealmsServer(argsMap);
    }

    /**
     * Parses the array of arguments in to a map.
     *
     * @param args List of arguments.
     */
    private static void parseArgs(List<String> args) {
        if (args.contains("nogui")) {
            argsMap.put("gui", "false");
        }
        else {
            argsMap.put("gui", "true");
        }

    }
}
