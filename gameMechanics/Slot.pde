class Slot {
  private Item item;
  private int n;

  Slot(Item item, int n) {
    this.item = item;
    this.n = n;
  }

  public Item getItem() {
    return item;
  }
  public int getId() {
    return item.getId();
  }
  public int getCount() {
    return n;
  }
  public void setCount(int n) {
    this.n = n;
  }
  public void addCount(int n) {
    this.n += n;
  }
}
