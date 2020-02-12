enum InventoryStatus {
  Stackable, 
    Unstackable
}
class Inventory {

  Slot[] inv = new Slot[9];
  int pointer = inv.length / 2;
  int slotSize = 32;

  Inventory(int size) {
    inv = new Slot[size];
    for (int i = 0; i < inv.length; i++) inv[i] = null;
  }

  public void addToPointer(int p) {
    pointer += p;
    pointer = (pointer < 0)? inv.length - 1 : (pointer >= inv.length)? 0 : pointer;
  }

  public void setPointer(int p) {
    pointer = (p >= 0 && p < inv.length)? p : 0;
  }

  public boolean addItem(Item item, int value) {
    //Get index of next free slot
    int index = nextIndex();
    if (item.invStatus == InventoryStatus.Stackable && index > 0) {
      //Get item if exists in inventory
      Slot slot = findSlot(item);
      if (slot != null) {
        //fill slot and if there is more call addItem with remainder of value
        int stack = slot.getItem().stackSize;
        if (slot.getCount() + value > stack) {
          int remain = slot.getCount() + value - stack;
          slot.setCount(stack);
          addItem(item, remain);
        } else slot.addCount(value);
        return true;
      }
    }
    //add slot to inventory
    if (index < inv.length) {
      Slot slot = new Slot(item, (item.invStatus == InventoryStatus.Stackable)? value : -1);
      inv[index] = slot;
      return true;
    }
    return false;
  }

  //Get next free index
  private int nextIndex() {
    for (int i = inv.length - 1; i >= 0; i--) {
      if (inv[i] != null) return i + 1;
    }
    return 0;
  }
  //Get index of item
  private int indexOf(Slot slot) {
    for (int i = 0; i < nextIndex(); i++) {
      Slot s = inv[i];
      if (s.getId() == slot.getId()) return i;
    }
    return -1;
  }

  public boolean removeItem(Item item, int value) {
    Slot slot = findSlot(item);
    if (slot == null) return false;
    int index = indexOf(slot); 
    if (slot.getCount() > value) 
      slot.addCount(-value);
    else {
      int remain = value - slot.getItem().stackSize;
      inv[index] = null;
      removeItem(item, remain);
    }
    return true;
  }

  //Find slot with item in inventory
  private Slot findSlot(Item item) {
    for (int i = 0; i < nextIndex(); i++) {
      Slot slot = inv[i];
      if (slot.getId() == item.getId() && slot.getCount() < slot.getItem().stackSize) {
        return slot;
      }
    }
    return null;
  }


  //Show inventory with slots
  public void show(float x, float y) {
    pushMatrix();
    translate(-(inv.length * .5) * slotSize + 5, 0);
    for (int i = 0; i < inv.length; i++) {
      strokeWeight(1);
      stroke(0);
      if (pointer == i) {
        strokeWeight(2);
        stroke(255, 0, 0);
      }
      fill(180);
      rect(x + i*5 + i*slotSize, y + 5, slotSize, slotSize);
      Slot slot = inv[i];
      if (slot != null) {
        slot.getItem().show(x + i*5 + i*slotSize + 10, y + 15);
        if (slot.getCount() > 0)
          text(slot.getCount(), x + i*5 + i*slotSize + 10, y + 35);
      }
    }
    popMatrix();
  }
}
