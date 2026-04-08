package P2_Game_Character_Creation_System;

/**
 * Note: Class Mage extends the GameCharacter. implements for interfaces, extends for abstract
 * classes and regular classes.
 */
public class Mage extends GameCharacter {

  /**
   * Note: fields are already declared in GameCharacter, we do not need to redeclare them.
   */
  public Mage(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  @Override
  public Mage clone() {
    return new Mage(name, health, attack, defense);
  }

  @Override
  public String getDescription() {
    return "Mage | Name: " + name +
        ", HP: " + health + ", ATK: " + attack +
        ", DEF: " + defense;
  }
}