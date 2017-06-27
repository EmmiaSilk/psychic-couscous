package com.emmiasilk.urealms.server;

import com.emmiasilk.urealms.core.logging.Logging;
import com.emmiasilk.urealms.server.gui.ServerGui;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<String, String> argsMap = new HashMap<>();

    public static void main(String[] args) {
        Logging.logInfo("Alright..... I wanna cast a spell");

        parseArgs(Arrays.asList(args));

        new UrealmsServer(argsMap);
    }

    private static void parseArgs(List<String> args) {
        if (args.contains("nogui")) {
            argsMap.put("gui", "false");
        }
        else {
            argsMap.put("gui", "true");
        }

    }
}
