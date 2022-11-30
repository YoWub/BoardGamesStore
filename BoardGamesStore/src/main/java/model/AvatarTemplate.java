//package model;
//
//import main.*;
//
//public class AvatarTemplate implements PriceInterface{
//    private double price;
//    public AvatarColorEnum hairColor;
//    public AvatarColorEnum armorColor;
//    public AvatarWeaponsEnum weaponChoice;
//    public AvatarClassificationEnum classification;
//    public AvatarSpeciesEnum species;
//    public AvatarArmorTypeEnum armorType;
//
//    public AvatarTemplate( AvatarSpeciesEnum species, AvatarClassificationEnum classification,
//                          AvatarColorEnum hairColor, AvatarColorEnum armorColor,
//                          AvatarWeaponsEnum weaponChoice, AvatarArmorTypeEnum armorType, double price) {
//        this.classification = classification;
//        this.species = species;
//        this.hairColor = hairColor;
//        this.armorColor = armorColor;
//        this.weaponChoice = weaponChoice;
//        this.armorType = armorType;
//        this.price = price;
//    }
//
//    public void classification(AvatarClassificationEnum classification) {
//        this.classification = classification;
//    }
//
//    public void species(AvatarSpeciesEnum species) {
//        this.species = species;
//    }
//
//    public void hairColor(AvatarColorEnum hairColor) {
//        this.hairColor = hairColor;
//    }
//
//    public void armorColor(AvatarColorEnum armorColor) {
//        this.armorColor = armorColor;
//    }
//
//    public void weaponChoice(AvatarWeaponsEnum weaponChoice) {
//        this.weaponChoice = weaponChoice;
//    }
//
//    public void armorType(AvatarArmorTypeEnum armorType) {
//        this.armorType = armorType;
//    }
//
//    @Override
//    public double getPrice() {
//        return price;
//    }
//}

/*
package model;

public class Avatars implements PriceInterface{

    private double price;
    private String name;

    public Avatars(String itemName, double price) {
        this.name = itemName;
        this.price = price;
    }

    public String getItemName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
 */