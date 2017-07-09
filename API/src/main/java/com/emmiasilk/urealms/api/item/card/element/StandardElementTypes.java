package com.emmiasilk.urealms.api.item.card.element;

import com.emmiasilk.urealms.api.util.I18n;

/**
 * Standard vanilla element types.
 *
 * These are the element types in standard URealms.
 *
 * @since 0.0.1
 */
public enum StandardElementTypes implements ElementType {

    NONE,
    ARCANE,
    DARK,
    EARTH,
    FIRE,
    ICE,
    LIGHT;

    /**
     * Returns the unlocalized name of the element type.
     *
     * <p>
     * The unlocalized name is the key in the lang file
     * corresponding to this element type.
     *
     * @return the unlocalized name
     */
    @Override
    public String getUnlocalizedName() {
        return "element.name." + name().toLowerCase();
    }

    /**
     * The localized name of this element type.
     *
     * @return the localized name.
     */
    @Override
    public String getLocalizedName() {
        return I18n.getLocalizedString(getUnlocalizedName());
    }
}
