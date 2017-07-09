package com.emmiasilk.urealms.core.item.card.standard;

import com.emmiasilk.urealms.api.item.card.standard.StandardCard;
import com.emmiasilk.urealms.api.util.I18n;
import com.emmiasilk.urealms.core.item.card.URealmsCard;

public abstract class URealmsStandardCard extends URealmsCard implements StandardCard {

    public URealmsStandardCard(String name) {
        super(name);
    }

    @Override
    public String getUnlocalizedSubtitle() {
        return LOCALIZATION_PREFIX + name + ".subtitle";
    }

    @Override
    public String getLocalizedSubtitle() {
        return I18n.getLocalizedString(getUnlocalizedSubtitle());
    }
}
