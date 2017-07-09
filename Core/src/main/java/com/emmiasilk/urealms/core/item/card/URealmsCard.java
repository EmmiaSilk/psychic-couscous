package com.emmiasilk.urealms.core.item.card;

import com.emmiasilk.urealms.api.item.card.Card;
import com.emmiasilk.urealms.api.util.I18n;

/**
 * Base implementation of a Card.
 *
 * @since 0.0.1
 */
public abstract class URealmsCard implements Card {

    private static final String NAME_PREFIX = "urealms:";
    protected static final String LOCALIZATION_PREFIX = "item.card.";

    /**
     * The name of the card.
     */
    protected String name;

    public URealmsCard(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return NAME_PREFIX + name;
    }

    @Override
    public String getUnlocalizedTitle() {
        return LOCALIZATION_PREFIX + name + ".title";
    }

    @Override
    public String getLocalizedTitle() {
        return I18n.getLocalizedString(getUnlocalizedTitle());
    }

    @Override
    public String getUnlocalizedDescription() {
        return LOCALIZATION_PREFIX + name + ".description";
    }

    @Override
    public String getLocalizedDescription() {
        return I18n.getLocalizedString(getUnlocalizedDescription());
    }
}
