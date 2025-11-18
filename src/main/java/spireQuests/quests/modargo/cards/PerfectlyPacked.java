package spireQuests.quests.modargo.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import spireQuests.abstracts.AbstractSQCard;
import spireQuests.quests.modargo.actions.PerfectlyPackedAction;

import static spireQuests.Anniv8Mod.makeID;

public class PerfectlyPacked extends AbstractSQCard {
    public static final String ID = makeID(PerfectlyPacked.class.getSimpleName());

    public PerfectlyPacked() {
        super(ID,"modargo", 0, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new PerfectlyPackedAction());
    }

    @Override
    public void upp() {
        this.isInnate = true;
    }
}
