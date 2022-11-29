package main;

import controller.InventoryGenerator;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SampleOrder {

    private ArrayList<BoardGame> boardGameOrder;
    private ArrayList<Avatars> avatarOrder;
    private Scanner userIn;
    private InventoryGenerator inventory;
    private BoardGame boardGameChoice;
    private Avatars boardGameExtra;

    public SampleOrder() {
        boardGameOrder = new ArrayList<>();
        userIn = new Scanner(System.in);
        inventory = new InventoryGenerator();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to The Board Game Store!");
        System.out.println("The place for Board Games and Avatars");
        buySomething();
    }

    private void buySomething() {
        System.out.println("What kind of Board Games would you like?");
        System.out.println("Your options are :\n1 for Avatars \n2 for a Board Game");
        String type = userIn.next();
        validateSomething(type);
    }

    private void buyBoardGame() {
        System.out.println("Are you here to buy Avatars or a Board Game or both?");
        System.out.println("Your options are : \nc - Guess The Place\n" +
                "d - Show YOur Talent\nt - Space Runners\nv - Pirates Ocean" +
                "d - Gryphons and Chimeras\nt - Cloud Travels\n");
        String type = userIn.next();
        validateBoardGameType(type);
        customDiceOffer(boardGameChoice);
        offerUpgrades();
        boardGameOrder.add(boardGameChoice);
        anotherBoardGame();
        orderDone();
    }

    private void orderDone() {
        new SampleReceipt(boardGameOrder, avatarOrder);
    }

    private void anotherBoardGame() {
        System.out.println("Do you want to add any other Board Games? yes or no");
        String answer = userIn.next();
        validateAnotherBoardGame(answer);
    }

    private void offerAvatars() {
        System.out.println("Do you want to buy any Avatars?");
        String answer = userIn.next();
        validateOffer(answer);
    }

    private void buyAvatars() {
        System.out.println("What Avatars are you interested in ?");
        System.out.println("Your options are:\nh - Helmet\ng - Gloves\n" +
                "b - bell\nbk - basket\nt - tire pump\nbh - bottle + holder" +
                "l - lights");
        String item = userIn.next();
        validateAvatar(item.toLowerCase());
        avatarOrder.add(boardGameExtra);
        moreAvatars();
    }

    private void offerUpgrades() {
        System.out.println("We offer upgrades for your Dices besides dice color.");
        System.out.println("We offer the following:\nCE - Card Expansion\nBE - Board Expansion" +
                "\nDE - Dice Side Count Changes\nnone - for no upgrades");
        String upgrade = userIn.next();
        validateUpgrade(upgrade);
    }

    private void customDiceOffer(BoardGame boardGame) {
        System.out.println("Our Dices come with a default paint color.");
        System.out.println("Your current dice color is " + boardGame.getColor().toString().toLowerCase());
        System.out.println("Would you like this dice with a different color. yes or no");
        String choice = userIn.next();
        switch (choice.toLowerCase()) {
            case "yes":
                customDiceChange(boardGame);
                break;
            case "no":
                break;
            default:
                System.out.println("You have entered an invalid choice.");
                customDiceOffer(boardGame);
        }
    }

    private void customDiceChange(BoardGame boardGame) {
        System.out.println("What dice color would you like?");
        System.out.println("Your choices are:\nbk - black\nbl - blue\n +" +
                "ch - chrome\ngr - green\nrd - red\ngd - gold (extra charge)");
        String color = userIn.next();
        validateColorChoice(color);

    }

    private void validateColorChoice(String color) {
        switch(color) {
            case "bk":
                boardGameChoice.paintDice(CustomDice.BLACK);
                break;
            case "bl":
                boardGameChoice.paintDice(CustomDice.BLUE);
                break;
            case "ch":
                boardGameChoice.paintDice(CustomDice.CHROME);
                break;
            case "gr":
                boardGameChoice.paintDice(CustomDice.GREEN);
                break;
            case "rd":
                boardGameChoice.paintDice(CustomDice.RED);
                break;
            default:
                System.out.println("You have entered an incorrect color.");
                customDiceChange(boardGameChoice);
        }
    }

    private void moreAvatars() {
        System.out.println("Do you want to add more Avatars? yes or no");
        String val = userIn.next();

        switch (val) {
            case "yes":
                boardGameExtra = null;
                buyAvatars();
                break;
            case "no":
                orderDone();
                break;
            default:
                System.out.println("You have entered an invalid choice");
                moreAvatars();
        }
    }

    private void validateOffer(String answer) {
        switch(answer) {
            case "yes":
                buyAvatars();
                break;
            case "no":
                break;
            default:
                System.out.println("You have entered an invalid choice");
                offerAvatars();
        }
    }

    private void validateAnotherBoardGame(String answer) {
        switch(answer.toLowerCase()) {
            case "yes":
                boardGameChoice = null;
                buyBoardGame();
                break;
            case "no":
                offerAvatars();
                // offer Avatars
                break;
            default:
                System.out.println("You have entered an invalid choice");
                anotherBoardGame();
        }
    }

    private void validateUpgrade(String upgrade) {
        switch (upgrade.toLowerCase()) {
            case "CE":
                boardGameChoice = new CardPackExpansion(boardGameChoice);
                break;
            case "BE":
                boardGameChoice = new BoardExpansion(boardGameChoice);
                break;
            case "DE":
                boardGameChoice = new DiceSides(boardGameChoice);
                break;
            case "none":
                break;
            default:
                System.out.println("You have made an invalid choice");
                offerUpgrades();
        }
    }

    private void validateBoardGameType(String type) {
        switch (type) {
            case "c":
                boardGameChoice = inventory.getCloudTravelsList().get(0);
                inventory.getCloudTravelsList().remove(0);
                break;
            case "d":
                boardGameChoice = inventory.getGuessThePlaceList().get(0);
                inventory.getGuessThePlaceList().remove(0);
                break;
            case "t":
                boardGameChoice = inventory.getShowYourTalentList().get(0);
                inventory.getShowYourTalentList().remove(0);
                break;
            case "v":
                boardGameChoice = inventory.getPiratesOceansList().get(0);
                inventory.getPiratesOceansList().remove(0);
                break;
            default:
                System.out.println("You have entered an incorrect type");
                buyBoardGame();
        }
    }

    private void validateAvatar (String choice) {
        switch (choice) {
            case "h":
                boardGameExtra = new Avatars("Helmet", 29.99);
                break;
            case "g":
                boardGameExtra = new Avatars("Gloves", 19.99);
                break;
            case "b":
                boardGameExtra = new Avatars("Bell", 9.99);
                break;
            case "bk":
                boardGameExtra = new Avatars("Basket", 29.99);
                break;
            case "t":
                boardGameExtra = new Avatars("Tire Pump", 39.99);
                break;
            case "bh":
                boardGameExtra = new Avatars("Bottle & Holder", 34.99);
                break;
            case "l":
                boardGameExtra = new Avatars("Gloves", 36.99);
                break;
            default:
                System.out.println("You have entered an invalid choice");
                buyAvatars();
        }
    }

    private void validateSomething(String type) {
        switch (type) {
            case "1":
                buyAvatars();
                break;
            case "2":
                buyBoardGame();
                break;
            default:
                System.out.println("You have entered an invalid choice");
                buySomething();
        }
    }
}
