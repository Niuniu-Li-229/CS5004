package P2_Game_Character_Creation_System;

public class CharacterManager {

  public void demonstrate() {

    // Factory — create archetypes
    System.out.println("--- Factory Characters ---");
    GameCharacter tank = CharacterFactory.createCharacter("tank");
    GameCharacter dps = CharacterFactory.createCharacter("dps");
    GameCharacter support = CharacterFactory.createCharacter("support");
    System.out.println(tank.getDescription());
    System.out.println(dps.getDescription());
    System.out.println(support.getDescription());

    // Builder — create custom character
    System.out.println("\n--- Custom Character ---");
    GameCharacter custom = new CharacterBuilder()
        .setType("mage")
        .setName("Snow Woman")
        .setHealth(120)
        .setAttack(80)
        .setDefense(100)
        .build();
    System.out.println(custom.getDescription());

    // Prototype — clone and show both
    System.out.println("\n--- Clone ---");
    GameCharacter clone = custom.clone();
    System.out.println("Original: " + custom.getDescription());
    System.out.println("Clone:    " + clone.getDescription());

    // Decorator — stack weapon and armor
    System.out.println("\n--- Decorated ---");
    GameCharacter decorated = new WeaponDecorator(clone);
    decorated = new ArmorDecorator(decorated);
    System.out.println("Before: " + custom.getDescription());
    System.out.println("After:  " + decorated.getDescription());

  }
}
