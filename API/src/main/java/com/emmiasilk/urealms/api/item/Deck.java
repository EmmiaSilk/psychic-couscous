package com.emmiasilk.urealms.api.item;

import com.emmiasilk.urealms.api.item.card.Card;

import java.util.Collection;
import java.util.List;

public interface Deck {

    String getName();

    String getUnlocalizedName();

    String getLocalizedName();

    void add(Card card);

    void addAll(Collection<? extends Card> cards);

    Card draw();

    List<Card> draw(int numberToDraw);

    void shuffle();
}
