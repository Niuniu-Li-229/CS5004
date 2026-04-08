package P2_Game_Character_Creation_System;

public class ArmorDecorator extends GameCharacter implements Equipment {
  private GameCharacter character;

  public ArmorDecorator (GameCharacter character){
    super(character.name, character.health, character.attack, character.defense + 20);
    this.character = character;
  }

  @Override
  public int getAttackBonus(){
    return 0;
  }

  @Override
  public int getDefenseBonus(){
    return 20;
  }

  @Override
  public String getDescription(){
    return character.getDescription() + " + shield (+20 DEF)";
  }

  @Override
  public GameCharacter clone(){
    return new ArmorDecorator(character.clone());
  }
}
