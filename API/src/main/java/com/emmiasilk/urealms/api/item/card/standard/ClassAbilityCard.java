package com.emmiasilk.urealms.api.item.card.standard;

import com.emmiasilk.urealms.api.item.card.ElementProvider;
import com.emmiasilk.urealms.api.item.card.GemProvider;
import com.emmiasilk.urealms.api.item.card.GoldProvider;

/**
 * Base class of a Class ability card
 *
 * @since 0.0.1
 */
public interface ClassAbilityCard extends StandardCard, GemProvider, ElementProvider, GoldProvider {
}
