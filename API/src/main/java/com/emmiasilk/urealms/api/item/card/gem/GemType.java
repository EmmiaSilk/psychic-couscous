package com.emmiasilk.urealms.api.item.card.gem;

/**
 * Represents a type of gem.
 *
 * <p>
 * Gem types are implemented as an Enumeration. This
 * interface allows for gem types to be extensible.
 *
 * @since 0.0.1
 */
public interface GemType {

    /**
     * Returns the unlocalized name of the gem type.
     *
     * <p>
     * The unlocalized name is the key in the lang file
     * corresponding to this gem type.
     *
     * @return the unlocalized name
     */
    String getUnlocalizedName();

    /**
     * The localized name of this gem type.
     *
     * @return the localized name.
     */
    String getLocalizedName();
}
