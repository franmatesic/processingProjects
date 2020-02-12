enum Rarity {
  Common, 
    Uncommon, 
    Rare, 
    Epic, 
    Legendary
}
abstract class Item {

  private int id;
  private String name;
  private String description;
  private float weight;
  private float durability;
  private Rarity type;
  private PImage sprite;
  private int stackSize;
  public InventoryStatus invStatus;

  Item(int id, String name, String desc, float weight, float durability, Rarity type, InventoryStatus invStatus, int stackSize, PImage sprite) {
    this.id = id;
    this.name = name;
    this.description = desc;
    this.weight = weight;
    this.durability = durability;
    this.type = type;
    this.sprite = sprite;
    this.stackSize = stackSize;
    this.invStatus = invStatus;
  }

  public int getId() {
    return id;
  }

  abstract void use();
  abstract void show(float x, float y);
}
