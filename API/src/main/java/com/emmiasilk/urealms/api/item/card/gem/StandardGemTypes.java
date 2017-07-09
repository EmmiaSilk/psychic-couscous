package com.emmiasilk.urealms.api.item.card.gem;

import com.emmiasilk.urealms.api.util.I18n;

/**
 * Standard vanilla gem types.
 *
 * These are the gem types in standard URealms.
 *
 * @since 0.0.1
 */
public enum StandardGemTypes implements GemType {

    /**
     * Area of Effect
     *
     * A card with this gem applies it's effect
     * distributed across an area.
     */
    AREA,

    /**
     * Item - Armor
     */
    ARMOR,

    /**
     * Attribute
     */
    ATTRIBUTE,

    /**
     * Companion
     */
    COMPANION,

    /**
     *
     */
    COMPANION_BEAST,

    /**
     *
     */
    COMPANION_HUMAN,

    /**
     *
     */
    COMPANION_LARGE,

    /**
     *
     */
    COMPANION_MAGIC,

    /**
     *
     */
    COMPANION_MECH,

    /**
     *
     */
    COMPANION_TALK,

    /**
     * Item - Consumable
     */
    CONSUMABLE,

    /**
     * Cornerstone
     */
    CORNERSTONE,

    /**
     * Item
     */
    ITEM,

    /**
     * Item - Legendary
     */
    LEGENDARY,

    /**
     *
     */
    LIMITED,

    /**
     * Line of sight.
     *
     * <p>
     * A card with this gem requires the user to
     * have a line of sight to their target.
     */
    LINE,

    /**
     * Melee
     */
    MELEE,

    /**
     * Passive
     */
    PASSIVE,

    /**
     * Range
     */
    RANGE,

    /**
     *
     */
    REGULAR,

    /**
     * Item - Shield
     */
    SHIELD,

    /**
     * Spell
     */
    SPELL,

    /**
     * Item - weapon
     */
    WEAPON;

    /**
     * Returns the unlocalized name of the gem type.
     *
     * <p>
     * The unlocalized name is the key in the lang file
     * corresponding to this gem type.
     *
     * @return the unlocalized name
     */
    @Override
    public String getUnlocalizedName() {
        return "gem.name." + name().toLowerCase();
    }

    /**
     * The localized name of this gem type.
     *
     * @return the localized name.
     */
    @Override
    public String getLocalizedName() {
        return I18n.getLocalizedString(getUnlocalizedName());
    }
}
