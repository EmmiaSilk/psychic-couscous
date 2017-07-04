package com.emmiasilk.urealms.api.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Lang {

    private Locale locale = Locale.US;
    private Properties langFile = new Properties();

    public Locale getCurrentLocale() {
        return locale;
    }

    public String getUnlocalizedName(String type, String name) {
        return String.format("%s.%s.name", type, name);
    }

    public void setLocale(Locale loc) {
        try {
            locale = loc;
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        File file = new File("/resources/lang/" + loc + ".lang");
        InputStream stream = Lang.class.getResourceAsStream(file.getAbsolutePath());
        try {
            langFile.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String format(String key, Object... vars) {
        if (langFile == null) setLocale(locale);
        String entry = langFile.getProperty(key);
        return String.format(entry, vars);
    }

}
