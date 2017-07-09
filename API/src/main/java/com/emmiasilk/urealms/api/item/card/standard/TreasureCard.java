package com.emmiasilk.urealms.api.item.card.standard;

import com.emmiasilk.urealms.api.item.card.ElementProvider;
import com.emmiasilk.urealms.api.item.card.GemProvider;
import com.emmiasilk.urealms.api.item.card.GoldProvider;
import com.emmiasilk.urealms.api.item.card.standard.StandardCard;

/**
 * Base class of a Treasure Card
 *
 * @since 0.0.1
 */
public interface TreasureCard extends StandardCard, GemProvider, GoldProvider, ElementProvider {
}
