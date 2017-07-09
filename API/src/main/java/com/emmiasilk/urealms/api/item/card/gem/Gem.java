package com.emmiasilk.urealms.api.item.card.gem;

/**
 * Represents a gem on a card.
 *
 * @since 0.0.1
 */
public interface Gem {

    /**
     * Returns this gems type.
     *
     * @return the gem's type
     */
    GemType getGemType();

    /**
     * Set the type for the Gem.
     *
     * @param gemType the new gem type
     */
    void setGemType(GemType gemType);

    /**
     * Returns the numeric value associated with this gem.
     *
     * @return the gems numeric value
     */
    int getGemValue();

    /**
     * Set a new numeric value for this gem.
     *
     * @param gemValue the new numeric value
     */
    void setGemValue(int gemValue);
}
