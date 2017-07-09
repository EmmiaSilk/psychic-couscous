package com.emmiasilk.urealms.core.item.card;

import com.emmiasilk.urealms.api.item.card.gem.Gem;
import com.emmiasilk.urealms.api.item.card.gem.GemType;

public class URealmsGem implements Gem {

    private GemType gemType;
    private int value;

    public URealmsGem(GemType gemType) {
        this(gemType, -1);
    }

    public URealmsGem(GemType gemType, int value) {
        this.gemType = gemType;
        this.value = value;
    }

    @Override
    public GemType getGemType() {
        return gemType;
    }

    @Override
    public void setGemType(GemType gemType) {
        this.gemType = gemType;
    }

    @Override
    public int getGemValue() {
        return value;
    }

    @Override
    public void setGemValue(int gemValue) {
        this.value = gemValue;
    }
}
