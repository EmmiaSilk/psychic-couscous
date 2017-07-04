package com.emmiasilk.urealms.api.util;

import com.emmiasilk.urealms.api.logging.Logging;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Internationalization.
 *
 * <p>
 * Handles all internationalization of Strings.
 *
 * <p>
 * Localized language files are stored in <code>/resources/lang/</code>
 * and end with <code>*.lang</code>. Language files need to follow the
 * standard formatting of <code>*.properties</code> files. The typical
 * format for the name of a language file is the lowercase 2 letter
 * abbreviation of the language name and the uppercase 2 letter abbreviation
 * of the country separated by an underscore.
 *
 * <p>
 * Examples:
 * <ul>
 * <li>en_US.lang -- English/United States</li>
 * <li>de_DE.lang -- German/Germany</li>
 * <li>fr_CA.lang -- French/Canada</li>
 * </ul>
 *
 * @since 0.0.1
 */
public class I18n {

    private static I18n instance;

    private Properties langFile = new Properties();
    private Properties defaultLang = new Properties();

    /**
     * Construct a new instance of the i18n handler.
     *
     * @param localizationName the locale to use
     */
    public I18n(String localizationName) {
        setLocalization(localizationName);

        try {
            InputStream defaultStream = I18n.class.getResourceAsStream("/resources/lang/en_US.lang");
            defaultLang.load(defaultStream);
        }
        catch (IOException exception) {
            Logging.logError("Unable it setup default locale.", exception);
        }

        instance = this;
    }

    /**
     * Set the locale being used.
     *
     * @param localizationName the locale to use
     */
    public void setLocalization(String localizationName) {
        try {
            String path = "/resources/lang/" + localizationName + ".lang";
            InputStream stream = I18n.class.getResourceAsStream(path);

            if (stream != null) {
                langFile.load(stream);
            }
            else {
                stream = I18n.class.getResourceAsStream("/resources/lang/en_US.lang");
                langFile.load(stream);
            }
        }
        catch (IOException exception) {
            Logging.logError("An Error occurred during localization.", exception);
        }
    }

    /**
     * Gets a localized string.
     *
     * @param key    the key of the string in the language file
     * @param format the objects to use when formatting
     * @return the localized string
     */
    public static String getLocalizedString(String key, Object... format) {
        String localized = instance.langFile.getProperty(key);

        if (localized == null) {
            localized = instance.defaultLang.getProperty(key);
        }

        return String.format(localized, format);
    }

    /**
     * Returns the instance of the i18n handler.
     *
     * @return this instance
     */
    public static I18n getInstance() {
        return instance;
    }
}