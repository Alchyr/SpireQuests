package spireQuests.quests.gk.cards;

import basemod.ReflectionHacks;
import basemod.cardmods.ExhaustMod;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.defect.AnimateOrbAction;
import com.megacrit.cardcrawl.actions.defect.EvokeOrbAction;
import com.megacrit.cardcrawl.actions.defect.EvokeWithoutRemovingOrbAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import spireQuests.abstracts.AbstractSQCard;
import spireQuests.quests.gk.BasicProficiencyQuest;
import spireQuests.util.Wiz;

import static com.megacrit.cardcrawl.core.Settings.GREEN_TEXT_COLOR;
import static spireQuests.Anniv8Mod.makeID;

public class TripleCast extends AbstractSQCard {
    public static final String ID = makeID(TripleCast.class.getSimpleName());

    public TripleCast() {
        super(ID, "gk", 1, CardType.SKILL, CardRarity.BASIC, CardTarget.NONE, CardColor.BLUE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new AnimateOrbAction(1));
        addToBot(new EvokeWithoutRemovingOrbAction(1));
        addToBot(new AnimateOrbAction(1));
        addToBot(new EvokeWithoutRemovingOrbAction(1));
        addToBot(new AnimateOrbAction(1));
        addToBot(new EvokeOrbAction(1));
    }

    @Override
    public void upp() {
        upgradeBaseCost(0);
    }

    @Override
    protected void renderTitle(SpriteBatch sb) {
        boolean inCombat = Wiz.isInCombat();
        Color save = GREEN_TEXT_COLOR.cpy();
        Color renderColor = ReflectionHacks.getPrivate(this, AbstractCard.class, "renderColor");
        Color rcSave = renderColor.cpy();
        if (inCombat) {
            renderColor.set(BasicProficiencyQuest.TITLE_PURPLE);
            GREEN_TEXT_COLOR.set(BasicProficiencyQuest.TITLE_PURPLE);
        }
        super.renderTitle(sb);
        if (inCombat) {
            GREEN_TEXT_COLOR.set(save);
            renderColor.set(rcSave);
        }
    }
}
