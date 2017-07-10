package com.emmiasilk.urealms.core.item;

import com.emmiasilk.urealms.api.item.Deck;
import com.emmiasilk.urealms.api.item.card.Card;
import com.emmiasilk.urealms.api.util.I18n;

import java.util.*;

public class URealmsDeck implements Deck {

    private String name;
    private ArrayList<Card> cards = new ArrayList<>();

    public URealmsDeck(String name, Collection<? extends Card> cards) {
        this.name = name;
        this.cards.addAll(cards);
    }

    public String getName() {
        return "urealms:" + name;
    }

    public String getUnlocalizedName() {
        return "item.deck." + name;
    }

    public String getLocalizedName() {
        return I18n.getLocalizedString(getUnlocalizedName());
    }

    public void add(Card card) {
        cards.add(cards.size(), card);
    }

    public void addAll(Collection<? extends Card> cards) {
        cards.forEach(card -> this.cards.add(this.cards.size(), card));
    }

    public Card draw() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public List<Card> draw(int numberToDraw) {
        List<Card> cardsToReturn = new ArrayList<>();

        for(int i = 0; i < numberToDraw; i++) {
            cardsToReturn.add(this.draw());
        }

        return cardsToReturn;
    }

    public void shuffle() {
        ArrayList<Card> newCards = new ArrayList<>();
        Random rng = new Random();

        while(!cards.isEmpty()) {
            int i = rng.nextInt(cards.size());
            newCards.add(cards.get(i));
            cards.remove(i);
        }

        cards = newCards;
    }
}