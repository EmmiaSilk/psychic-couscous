package com.emmiasilk.urealms.api.item.card;

import com.emmiasilk.urealms.api.item.card.gem.Gem;

import java.util.Collection;

/**
 * Provides a card with the functionality to have gems
 * associated with it.
 *
 * <p>
 * Note: Most classes implementing this interface will have a
 * list of up to 5 gems, however some classes will only
 * have a single, non changing, gem.
 *
 * @since 0.0.1
 */
public interface GemProvider {

    /**
     * Adds a gem to the card.
     *
     * @param gemToAdd The gem to add to the card.
     */
    void addGem(Gem gemToAdd);

    /**
     * Adds a Collection of gems to the card.
     *
     * @param gemsToAdd The gems to add to the card.
     */
    void addGems(Collection<? extends Gem> gemsToAdd);

    /**
     * Gets all the gems the card contains.
     *
     * @return A collection of all the gems in the card.
     */
    Collection<Gem> getGems();

    /**
     * Returns true if the cards collection is not empty.
     *
     * @return True if the card has gems.
     */
    boolean hasGems();
}
