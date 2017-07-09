package com.emmiasilk.urealms.core.item.card.jumbo;

import com.emmiasilk.urealms.api.item.card.jumbo.RaceCard;

public class URealmsRaceCard extends URealmsJumboCard implements RaceCard {

    private int stamina;
    private int gold;

    public URealmsRaceCard(String name, int stamina, int gold) {
        super(name);
        this.stamina = stamina;
        this.gold = gold;
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
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }
}
