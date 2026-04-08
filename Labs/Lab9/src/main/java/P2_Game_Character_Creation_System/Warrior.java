package P2_Game_Character_Creation_System;

/**
 * Note: Class Warrior extends the GameCharacter. implements for interfaces, extends for abstract
 * classes and regular classes.
 */
public class Warrior extends GameCharacter {

  /**
   * Note: fields are already declared in GameCharacter, we do not need to redeclare them.
   */
  public Warrior(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  @Override
  public Warrior clone() {
    return new Warrior(name, health, attack, defense);
  }

  @Override
  public String getDescription() {
    return "Warrior | Name: " + name +
        ", HP: " + health + ", ATK: " + attack +
        ", DEF: " + defense;
  }
}