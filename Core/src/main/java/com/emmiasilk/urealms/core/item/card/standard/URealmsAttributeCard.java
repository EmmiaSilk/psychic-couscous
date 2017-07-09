package com.emmiasilk.urealms.core.item.card.standard;

import com.emmiasilk.urealms.api.item.card.gem.Gem;
import com.emmiasilk.urealms.api.item.card.gem.StandardGemTypes;
import com.emmiasilk.urealms.api.item.card.standard.AttributeCard;
import com.emmiasilk.urealms.core.item.card.URealmsGem;
import com.google.common.collect.ImmutableSet;

import java.util.Collection;

public class URealmsAttributeCard extends URealmsStandardCard implements AttributeCard {

    private int stamina;
    private Collection<Gem> gems;

    public URealmsAttributeCard(String name, int stamina) {
        super(name);
        this.stamina = stamina;

        gems = ImmutableSet.of(new URealmsGem(StandardGemTypes.ATTRIBUTE));
    }

    @Override
    public int getStamina() {
        return stamina;
    }

    @Override
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public void addGem(Gem gemToAdd) {
    }

    @Override
    public void addGems(Collection<? extends Gem> gemsToAdd) {
    }

    @Override
    public Collection<Gem> getGems() {
        return this.gems;
    }

    @Override
    public boolean hasGems() {
        return gems != null && !gems.isEmpty();
    }
}
