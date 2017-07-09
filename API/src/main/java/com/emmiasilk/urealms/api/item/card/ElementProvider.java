package com.emmiasilk.urealms.api.item.card;

import com.emmiasilk.urealms.api.item.card.element.ElementType;

import java.util.Collection;

/**
 * Provides a card with the functionality to have elements
 * associated with it.
 *
 * <p>
 * Note: Most classes implementing this interface will have a
 * list of up to 5 elements, however some classes will only
 * have a single, non changing, element.
 *
 * @since 0.0.1
 */
public interface ElementProvider {

    /**
     * Adds a element to the card.
     *
     * @param elementToAdd The element to add to the card.
     */
    void addElement(ElementType elementToAdd);

    /**
     * Adds a Collection of elements to the card.
     *
     * @param elementsToAdd The elements to add to the card.
     */
    void addElements(Collection<? extends ElementType> elementsToAdd);

    /**
     * Gets all the elements the card contains.
     *
     * @return A collection of all the elements in the card.
     */
    Collection<ElementType> getElements();

    /**
     * Returns true if the cards collection is not empty.
     *
     * @return True if the card has elements.
     */
    boolean hasElements();
}
