package P2_Game_Character_Creation_System;

/**
 * Note: Class Archer extends the GameCharacter. implements for interfaces, extends for abstract
 * classes and regular classes.
 */
public class Archer extends GameCharacter {

  /**
   * Note: fields are already declared in GameCharacter, we do not need to redeclare them.
   */
  public Archer(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  @Override
  public Archer clone() {
    return new Archer(name, health, attack, defense);
  }

  @Override
  public String getDescription() {
    return "Archer | Name: " + name + ", HP: " + health + ", ATK: " + attack + ", DEF: " + defense;
  }
}