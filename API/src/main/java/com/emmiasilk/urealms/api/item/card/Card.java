package com.emmiasilk.urealms.api.item.card;

/**
 * Base class for a card.
 *
 * @since 0.0.1
 */
public interface Card {

    /**
     * Sets the name of the card,
     *
     * The cards name is used to localized strings
     * and is also used as a unique identifier for a card.
     *
     * Standard cards use a name like <code>urealms:card:[name]</code>
     *
     * @param name The name of the card
     */
    void setName(String name);

    String getName();

    String getUnlocalizedTitle();

    String getLocalizedTitle();

    String getUnlocalizedDescription();

    String getLocalizedDescription();
}
