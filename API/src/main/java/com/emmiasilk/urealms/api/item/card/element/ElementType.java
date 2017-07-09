package com.emmiasilk.urealms.api.item.card.element;

/**
 * Represents a type of element.
 *
 * <p>
 * Element types are implemented as an Enumeration. This
 * interface allows for element types to be extensible.
 *
 * @since 0.0.1
 */
public interface ElementType {

    /**
     * Returns the unlocalized name of the element type.
     *
     * <p>
     * The unlocalized name is the key in the lang file
     * corresponding to this element type.
     *
     * @return the unlocalized name
     */
    String getUnlocalizedName();

    /**
     * The localized name of this element type.
     *
     * @return the localized name.
     */
    String getLocalizedName();
}
