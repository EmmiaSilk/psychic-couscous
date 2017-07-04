package com.emmiasilk.urealms.api.item.card.element;

import com.emmiasilk.urealms.api.util.I18n;

public enum StandardElementTypes implements ElementType {

    NONE,
    ARCANE,
    DARK,
    EARTH,
    FIRE,
    ICE,
    LIGHT;

    @Override
    public String getUnlocalizedName() {
        return "element.name." + name().toLowerCase();
    }

    @Override
    public String getLocalizedName() {
        return I18n.getLocalizedString(getUnlocalizedName());
    }
}
