package com.emmiasilk.urealms.core.item.card.standard;

import com.emmiasilk.urealms.api.item.card.element.ElementType;
import com.emmiasilk.urealms.api.item.card.gem.Gem;
import com.emmiasilk.urealms.api.item.card.standard.LegendaryCard;

import java.util.Collection;
import java.util.HashSet;

public class URealmsLegendaryCard extends URealmsStandardCard implements LegendaryCard {

    private int gold;
    private Collection<ElementType> elements;
    private Collection<Gem> gems;

    public URealmsLegendaryCard(String name, int gold, Collection<? extends Gem> gems,
                                Collection<? extends ElementType> elements) {
        super(name);
        this.gold = gold;

        this.gems = new HashSet<>();
        this.gems.addAll(gems);

        this.elements = new HashSet<>();
        this.elements.addAll(elements);
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public void addGem(Gem gemToAdd) {
        if (!gems.contains(gemToAdd)) {
            gems.add(gemToAdd);
        }
    }

    @Override
    public void addGems(Collection<? extends Gem> gemsToAdd) {
        for (Gem gem : gemsToAdd) {
            if (!gems.contains(gem)) {
                gems.add(gem);
            }
        }
    }

    @Override
    public Collection<Gem> getGems() {
        return gems;
    }

    @Override
    public boolean hasGems() {
        return gems != null && !gems.isEmpty();
    }

    @Override
    public void addElement(ElementType elementToAdd) {
        if (!elements.contains(elementToAdd)) {
            elements.add(elementToAdd);
        }
    }

    @Override
    public void addElements(Collection<? extends ElementType> elementsToAdd) {
        for (ElementType element : elementsToAdd) {
            if (!elements.contains(element)) {
                elements.add(element);
            }
        }
    }

    @Override
    public Collection<ElementType> getElements() {
        return elements;
    }

    @Override
    public boolean hasElements() {
        return elements != null && !elements.isEmpty();
    }
}
