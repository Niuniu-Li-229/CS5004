package P2_Game_Character_Creation_System;

import java.util.ArrayList;
import java.util.List;

public class CharacterBuilder {

  private String type;
  private String name;
  private int health;
  private int attack;
  private int defense;
  private List<Equipment> equipmentList = new ArrayList<>();

  public CharacterBuilder setType(String type) {
    this.type = type;
    return this;
  }

  public CharacterBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CharacterBuilder setHealth(int health) {
    this.health = health;
    return this;
  }

  public CharacterBuilder setAttack(int attack) {
    this.attack = attack;
    return this;
  }

  public CharacterBuilder setDefense(int defense) {
    this.defense = defense;
    return this;
  }

  public CharacterBuilder addEquipment(Equipment equipment) {
    equipmentList.add(equipment);
    return this;
  }

  public GameCharacter build() {
    GameCharacter character;
    switch (type) {
      case "warrior":
        character = new Warrior(name, health, attack, defense); break;
      case "mage":
        character = new Mage(name, health, attack, defense); break;
      case "archer":
        character = new Archer(name, health, attack, defense); break;
      default:
        throw new IllegalArgumentException("Unknown type: " + type);
    }

    for (Equipment e : equipmentList){
      if (e instanceof WeaponDecorator) {
        character = new WeaponDecorator(character);
      }
      else if (e instanceof ArmorDecorator){
        character = new ArmorDecorator(character);
      }
    }
    return character;
  }
}