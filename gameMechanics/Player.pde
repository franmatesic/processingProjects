class Player {

  float x, y;
  boolean isLeft, isRight, isUp, isDown;
  int level;
  int size = 64;
  int vel = 8;
  int range = 256;
  float angle = 0;
  Inventory inv = new Inventory(5);

  Player(float px, float py, int l) {
    x = px;
    y = py;
    level = l;
  }

  public void update() {
    move();
  }

  public void show() {
    noStroke();
    fill(255, 255, 255);
    ellipse(x, y, size, size);

    inv.show(width * .5, height * .9);

    pushMatrix();
    translate(x, y);
    float tempAngle = atan2(mouseY - y, mouseX - x);
    float dir = (tempAngle - angle) / TWO_PI;
    dir = (dir - round(dir)) * TWO_PI;
    angle += dir * .1;
    angle %= TWO_PI;

    rotate(angle);

    noStroke();
    fill(0);
    ellipse(16, 0, 24, 24);
    fill(0, 255, 0);
    ellipse(16, 0, 12, 12);

    popMatrix();
  }

  public void scroll(int e) {
    inv.addToPointer(e);
  }


  private void move() {
    final int r = size >> 1;
    x = constrain(x + vel * (int(isRight) - int(isLeft)), r, width - r);
    y = constrain(y + vel * (int(isDown) - int(isUp)), r, height - r);
  }

  public boolean setMove(int k, boolean b) {
    switch (k) {
    case +'W':
    case UP:
      return isUp = b;
    case +'S':
    case DOWN:
      return isDown = b;
    case +'A':
    case LEFT:
      return isLeft = b;
    case +'D':
    case RIGHT:
      return isRight = b;
    default:
      return b;
    }
  }
}
