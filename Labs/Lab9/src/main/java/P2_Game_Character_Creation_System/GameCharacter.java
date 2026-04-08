package P2_Game_Character_Creation_System;

public abstract class GameCharacter implements Cloneable{
  protected String name;
  protected int health;
  protected int attack;
  protected int defense;

  // Constructor and basic methods
  public GameCharacter(String name, int health, int attack, int defense){
    this.name = name;
    this.health = health;
    this.attack = attack;
    this.defense = defense;
  }

  public abstract GameCharacter clone();
  public abstract String getDescription();
}
