package model;

import main.CustomDice;

public abstract class BoardGame implements PriceInterface, BoardGameInterface {
    private CustomDice color;
    private String model;

    public BoardGame(CustomDice color) {
        this.color = color;
    }

    public CustomDice getColor() {
        return color;
    }

    public abstract double getPrice();

    public abstract int getStart();

    public abstract String getPrefix();

    public abstract String getExpansionName();
    public abstract double getExpansionAmount();

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void paintDice(CustomDice color) {
        this.color = color;
    }

    @Override
    public void checkForDefects() {
        System.out.println("We try to check each and every piece for any defect. If by chance you receive " +
                "a defective product, we will replace the defective products. " +
                "Just reach out through our Customer Service line.");
    }

    @Override
    public void assembleComponents() {
        System.out.println("We assemble the pieces and components prior to shipping.");
    }

    @Override
    public void provideTutorial() {
        System.out.println("We provide web links to instructional videos on how to play our board games.");
    }

    @Override
    public String toString() {
        String price = String.format("%24s", "$" + getPrice());
        return "  " + getClass().getSimpleName() + price;
    }
}
