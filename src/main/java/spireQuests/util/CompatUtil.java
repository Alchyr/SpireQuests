package spireQuests.util;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.CardLibrary;

public class CompatUtil {
    public static final String CARDISTRY_ID = "anniv5:Cardistry";
    public static final String SNAPSHOT_ID = "hermit:Snapshot";

    public static AbstractCard.CardColor PM_COLOR = AbstractCard.CardColor.COLORLESS;
    public static AbstractCard.CardColor HERMIT_COLOR = AbstractCard.CardColor.COLORLESS;

    public static void postInit() {
        AbstractCard card = CardLibrary.getCard(CARDISTRY_ID);
        if(card != null) {
            PM_COLOR = card.color;
        }

        card = CardLibrary.getCard(SNAPSHOT_ID);
        if (card != null) {
            HERMIT_COLOR = card.color;
        }
    }
}
