package model;

import main.CustomDice;

public class DiceSides extends ExpansionPack{

    public DiceSides(BoardGame game) {
        super(game);
    }

    @Override
    public String getExpansionName() {
        return "Sides Expansion Upgrade";
    }

    @Override
    public double getExpansionAmount() {
        return 49.99;
    }

    @Override
    public double getPrice() {
        return gameWithExpansion.getPrice();
    }

    @Override
    public int getStart() {
        return gameWithExpansion.getStart();
    }

    @Override
    public String getPrefix() {
        return gameWithExpansion.getPrefix();
    }

    @Override
    public CustomDice getColor() {
        return CustomDice.GOLD;
    }

    private void setColor() {
        gameWithExpansion.paintDice(CustomDice.GOLD);
    }
}
