package com.emmiasilk.urealms.client;

import com.emmiasilk.urealms.api.logging.Logging;
import com.emmiasilk.urealms.api.util.I18n;

public class Main {

    public static void main(String[] args) {
        Logging.logInfo(I18n.getLocalizedString("client.starting"));
    }
}
