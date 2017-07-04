package com.emmiasilk.urealms.api.item.card.gem;

import com.emmiasilk.urealms.api.util.I18n;

public enum StandardGemTypes implements GemType {

    AREA,
    ARMOR,
    ATTRIBUTE,
    COMPANION,
    COMPANION_BEAST,
    COMPANION_HUMAN,
    COMPANION_LARGE,
    COMPANION_MAGIC,
    COMPANION_MECH,
    COMPANION_TALK,
    CONSUMABLE,
    CORNERSTONE,
    ITEM,
    LEGANDARY,
    LIMITED,
    LINE,
    MELEE,
    PASSIVE,
    RANGE,
    REGULAR,
    SHIELD,
    SPELL,
    WEAPON;

    @Override
    public String getUnlocalizedName() {
        return "gem.name." + name().toLowerCase();
    }

    @Override
    public String getLocalizedName() {
        return I18n.getLocalizedString(getUnlocalizedName());
    }
}
