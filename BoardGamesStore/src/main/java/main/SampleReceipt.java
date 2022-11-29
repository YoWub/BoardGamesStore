package main;

import model.Avatars;
import model.BoardGame;

import java.util.ArrayList;

public class SampleReceipt {
    private double total = 0.0;

    ArrayList<BoardGame> boardGameCart;
    ArrayList<Avatars> avatarCart;

    public SampleReceipt(ArrayList<BoardGame> boardGameList, ArrayList<Avatars> avatarList) {
        this.boardGameCart = boardGameList;
        this.avatarCart = avatarList;
        showTitle();
        showColumnHeader();
        showBoardGameCart();
        showAvatarCart();
        showShipping();
        // prep for sale (promo)
    }

    private void showTitle() {
        String company = String.format("%30s", "The Board Game Store");
        String address = String.format("%33s", "123 Main St, City, St, zip");
        String phone = String.format("%27s", "(000) 000 - 0000");
        System.out.println(company.toUpperCase());
        System.out.println(address);
        System.out.println(phone);
        showStars();
        String cash = String.format("%25s", "MONEY RECEIPT");
        System.out.println(cash);
        showStars();
    }

    private void showColumnHeader() {
        String price = String.format("%23s |\n", "| Price");
        System.out.print("\n| Description |");
        System.out.println(price);
    }

    private void showAvatarCart() {
        if(avatarCart.size() > 0) {
            for(Avatars item: avatarCart) {
                System.out.print("  " + item.getItemName());
                String price = String.format("%27s", "$" + item.getPrice());
                System.out.print(price);
                System.out.println();
                total += item.getPrice();
            }
        }
    }

    private void showBoardGameCart() {
        if(boardGameCart.size() > 0) {
            for(BoardGame boardGame: boardGameCart) {
                System.out.println(boardGame);
                System.out.println("  Dice Color: " + boardGame.getColor());
                System.out.println("  Serial #: " + boardGame.getModel());
                total += boardGame.getPrice();
                if(boardGame.getExpansionName() != null) {
                    String customPrice = String.format("%15s", "$" + boardGame.getExpansionAmount());
                    System.out.print("  " + boardGame.getExpansionName());
                    System.out.print(customPrice);
                    total += boardGame.getExpansionAmount();
                }
                System.out.println();
            }
        }
    }

    private void showShipping() {
        double ship = 49.99;
        showStars();
        System.out.print("Sub Total");
        System.out.printf("%27s %.2f%n", "$", total);
        System.out.print("Shipping Cost");
        System.out.printf("%23s %.2f%n", "$", ship);
        System.out.print("Total");
        double totalShip = total + ship;
        System.out.printf("%30s %.2f%n", "$", totalShip);
    }

    private void showStars() {
        for(int i = 0; i < 40; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
