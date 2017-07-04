package com.emmiasilk.urealms.api.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Lang {

    private Locale locale = Locale.US;
    private Properties langFile = new Properties();
    private static Lang instance;

    public static Locale getCurrentLocale() {
        return instance.locale;
    }

    public static void setLocale(Locale loc) {
        try {
            instance.locale = loc;
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        File file = new File("/resources/lang/" + loc + ".lang");
        InputStream stream = Lang.class.getResourceAsStream(file.getAbsolutePath());
        try {
            instance.langFile.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String format(String key, Object... vars) {
        if (instance.langFile == null) setLocale(instance.locale);
        String entry = instance.langFile.getProperty(key);
        return String.format(entry, vars);
    }

}
