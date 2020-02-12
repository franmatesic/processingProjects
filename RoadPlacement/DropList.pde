class DropList {

  PVector pos;
  PVector vol;
  float margin;
  ArrayList<Item> items;
  boolean opened;
  int indexPos;
  int selected;
  int numItems;

  DropList(ArrayList<PImage> image, ArrayList<String> title) {
    pos = new PVector(0, 0);
    vol = new PVector(100, 50);

    items = new ArrayList<Item>();
    items.add(new Item(null, null));
    for (int i = 0; i < image.size(); i++) {
      items.add(new Item(image.get(i), title.get(i)));
    }
    selected = -1;
    opened = false;
    indexPos = 0;
    margin = 0.8;
    numItems = 10;
  }

  void setDim(float x, float y, float w, float h) {
    pos.x = x;
    pos.y = y;
    vol.x = w;
    vol.y = h;
  }

  void setSelected(int i) { 
    selected = i;
  }

  void mouseClick() {
    if (!opened && mouseX > pos.x && mouseX < pos.x + vol.x && mouseY > pos.y && mouseY < pos.y + vol.y) {
      opened = true;
      if (selected == -1) indexPos = 1;
    } else if (opened && mouseX > pos.x && mouseX < pos.x + vol.x && mouseY > pos.y + vol.y && mouseY < pos.y + vol.y + 10 * vol.y * 0.75) {
      int py = int((mouseY - pos.y - vol.y) / (vol.y * 0.75));
      selected = (py == 0)? -1 : indexPos + py;
      indexPos = (selected == -1)? 1 : selected;
      opened = false;
    } else {
      opened = false;
    }
  }

  boolean onList() {
    return (opened && mouseX > pos.x && mouseX < pos.x + vol.x && mouseY > pos.y + vol.y && mouseY < pos.y + vol.y + 10 * vol.y * 0.75);
  }
  boolean onSelected() {
    return (mouseX > pos.x && mouseX < pos.x + vol.x && mouseY > pos.y && mouseY < pos.y + vol.y);
  }


  void show() {
    strokeWeight(2);
    stroke(0);
    if (opened) {
      indexPos = constrain(indexPos, 0, items.size() - numItems);
      for (int i = 0; i < numItems; i++) {
        float s = vol.y * 0.75;
        Item item = items.get(i + indexPos);
        item.setDim(pos.x, pos.y+ pos.y + i*s, vol.x, vol.y *0.75);
        item.showCard();
      }
      fill(255);
      rect(pos.x + vol.x * 0.98, pos.y + vol.y, vol.x * 0.02, vol.y * 0.75 * numItems);
      fill(0);
      float index = map(indexPos, 0, items.size() - numItems, 0, numItems - 0.05);
      rect(pos.x + vol.x * 0.98, pos.y + vol.y + vol.y * 0.75 * index, vol.x * 0.02, vol.y * 0.05);
    }
    if (selected >= 0) {
      Item item = items.get(selected);
      item.setDim(pos.x, pos.y, vol.x, vol.y);
      item.showCard();

      if (!onList() && !onSelected()) cursor(item.img, 16, 16);
    } else {
      fill(255);
      rect(pos.x, pos.y, vol.x, vol.y);
      fill(0);
      textSize(30);
      text("Selection", pos.x + vol.x / 2, pos.y + vol.y / 2);
    }
    if (onList() || onSelected()) cursor(HAND);
    else if (selected == -1) cursor(ARROW);
  }
}
