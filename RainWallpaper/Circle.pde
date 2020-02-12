class Circle {

  PVector pos;
  float size = 0;
  float maxSize = 0;
  color col = color(100, 100, 200);

  Circle(float x, float y, float size) {
    pos = new PVector(x, y);
    maxSize = size * 2;
  }

  boolean ended() {
    return size >= maxSize;
  }

  void update() {
    size++;
  }

  void show() {
    noFill();
    stroke(col);
    ellipse(pos.x, pos.y, size, size * 0.5);
    //filter(BLUR, 5);
  }
}
