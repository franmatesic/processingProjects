class Drop {

  PVector pos = new PVector(random(width), random(-200, -100));
  PVector vel = new PVector(0, 0);
  PVector acc = new PVector(0, 0);
  color col = color(95, 100, 200, 150);
  float size = random(2, 7);
  float fallDist = map(size, 2, 7, height * 0.85, height * 0.98);
  Circle c = null;
  PVector gravity = new PVector(0, 0.1);

  void applyForce(PVector force) {
    acc.add(force);
  }

  void update() {
    pos.add(vel);
    vel.add(acc);
    acc.mult(0);

    if (c == null && pos.y >= fallDist) {
      c = new Circle(pos.x, pos.y, size);
    }
    applyForce(gravity);
  }

  void show() {
    noStroke();
    fill(col);
    if (pos.y < fallDist) ellipse(pos.x, pos.y, size, size);
    else if (c != null) {
      c.update();
      c.show();
      if (c.ended()) drops.remove(this);
    }
  }
}
