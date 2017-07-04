package com.emmiasilk.urealms.api.item.card;

/**
 * Provides a card with the functionality to have a stamina amount
 * associated with it.
 *
 * <p>
 * Used primarily by cards that add or subtract from the player's
 * base stamina.
 *
 * @since 0.0.1
 */
public interface StaminaProvider {

    /**
     *  Get the value of stamina that the card.
     *
     * @return The stamina value of the card.
     */
    int getStamina();

    /**
     * Set the stamina value of the card.
     *
     * @param stamina The new stamina value of the card.
     */
    void setStamina(int stamina);
}