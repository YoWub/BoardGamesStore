package model;

import main.CustomDice;

public class GryphonsAndChimeras extends RolePlayGame{
    public GryphonsAndChimeras() {
        super(CustomDice.GREEN);
    }

    @Override
    public double getPrice() {
        return 299.99;
    }

    @Override
    public String getPrefix() {
        return "GC234";
    }

    @Override
    public int getStart() {
        return 209384;
    }
}
