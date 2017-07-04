package com.emmiasilk.urealms.api.item.card;

/**
 * Provides a card with the functionality to have a gold amount
 * associated with it.
 *
 * <p>
 * Can either provide addition gold like race and class cards or
 * can cost gold like item cards. Cards can also have a value of
 * zero.
 *
 * @since 0.0.1
 */
public interface GoldProvider {

    /**
     *  Get the value of gold that the card.
     *
     * @return The gold value of the card.
     */
    int getGold();

    /**
     * Set the gold value of the card.
     *
     * @param gold The new gold value of the card.
     */
    void setGold(int gold);
}
