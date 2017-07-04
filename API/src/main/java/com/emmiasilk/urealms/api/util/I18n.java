package com.emmiasilk.urealms.api.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class I18n {

    private Locale locale = Locale.US;
    private Properties langFile = new Properties();
    private static I18n instance;

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
        InputStream stream = I18n.class.getResourceAsStream(file.getAbsolutePath());
        try {
            instance.langFile.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLocalizedString(String key, Object... vars) {
        if (instance.langFile == null) {
            setLocale(instance.locale);
        }
        String entry = instance.langFile.getProperty(key);
        return String.format(entry, vars);
    }

}
