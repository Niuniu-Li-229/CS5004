package P2_Game_Character_Creation_System;

public class WeaponDecorator extends GameCharacter implements Equipment{

  private GameCharacter character;

  public WeaponDecorator (GameCharacter character){
    super(character.name, character.health, character.attack + 20, character.defense);
    this.character = character;
  }

  @Override
  public int getAttackBonus(){
    return 20;
  }

  @Override
  public int getDefenseBonus(){
    return 0;
  }

  @Override
  public String getDescription(){
    return character.getDescription() + " + sword (+20 ATK)";
  }

  @Override
  public GameCharacter clone(){
    return new WeaponDecorator(character.clone());
  }
}
