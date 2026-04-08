package P2_Game_Character_Creation_System;

public class CharacterFactory {

  private CharacterFactory() {}

  public static GameCharacter createCharacter(String archetype) {
    switch (archetype) {
      case "tank":
        return new CharacterBuilder()
            .setType("warrior")
            .setName("Tank Warrior")
            .setHealth(150)
            .setAttack(60)
            .setDefense(100)
            .build();
      case "dps":
        return new CharacterBuilder()
            .setType("mage")
            .setName("DPS Mage")
            .setHealth(80)
            .setAttack(120)
            .setDefense(40)
            .build();
      case "support":
        return new CharacterBuilder()
            .setType("archer")
            .setName("Support Archer")
            .setHealth(100)
            .setAttack(70)
            .setDefense(70)
            .build();
      default:
        throw new IllegalArgumentException("Unknown archetype: " + archetype);
    }
  }
}