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

    String getUnlocalizedName();

    String getLocalizedName();
}
