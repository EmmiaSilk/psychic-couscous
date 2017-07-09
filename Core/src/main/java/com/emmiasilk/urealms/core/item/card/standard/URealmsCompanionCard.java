package com.emmiasilk.urealms.core.item.card.standard;

import com.emmiasilk.urealms.api.item.card.gem.Gem;
import com.emmiasilk.urealms.api.item.card.standard.CompanionCard;

import java.util.Collection;
import java.util.HashSet;

public class URealmsCompanionCard extends URealmsStandardCard implements CompanionCard {

    private Collection<Gem> gems;
    private int stamina;

    public URealmsCompanionCard(String name, int stamina, Collection<? extends Gem> gems) {
        super(name);

        this.stamina = stamina;

        this.gems = new HashSet<>();
        this.gems.addAll(gems);
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

}
