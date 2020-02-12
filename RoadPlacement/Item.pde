class Item {

  PVector pos, vol;
  PImage img;
  String title;
  float margin = 0.8;

  Item(PImage im, String t) {
    pos = new PVector(0, 0);
    vol = new PVector(100, 50);
    img = im;
    title = t;
  }

  void setDim(float x, float y, float w, float h) {
    pos.x = x;
    pos.y = y;
    vol.x = w;
    vol.y = h;
  }

  void showCard() {
    fill(255);
    rect(pos.x, pos.y, vol.x, vol.y);
    if (img != null && title != null)
      label(pos.x, pos.y, vol.x, vol.y);
    else {
      fill(0);
      textSize(30);
      text("Selection", pos.x + vol.x / 2, pos.y + vol.y / 2);
    }
  }

  void showItem() {
  }

  void label(float xx, float yy, float w, float h) {
    float s = (w > h)? h * margin : w * margin;
    float x = xx + (w/2 - s/2) * 0.15;
    float y = yy + (h/2 - s/2);
    image(img, x, y, s, s);

    fill(0);
    textSize(map(title.length(), 0, 30, 35, 10));
    x = xx + (w/2) * 1.25;
    y = yy + h/2;
    text(title, x, y);
  }
}
