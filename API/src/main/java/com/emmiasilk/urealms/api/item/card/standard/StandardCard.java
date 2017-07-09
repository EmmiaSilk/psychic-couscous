package com.emmiasilk.urealms.api.item.card.standard;

import com.emmiasilk.urealms.api.item.card.Card;

/**
 * Base class for standard cards.
 *
 * @since 0.0.1
 */
public interface StandardCard extends Card {

    /**
     *  Get the unlocalized subtitle of the card
     *
     * @return the unlocalized subtitle of the card
     */
    String getUnlocalizedSubtitle();

    /**
     *  Get the localized subtitle of the card
     *
     * @return the localized subtitle of the card
     */
    String getLocalizedSubtitle();
}
