class Tile {

  PVector pos;
  PVector size;
  float radius;
  int state;
  int cont = -1;
  PVector index;
  color contColor;
  color states[] = {color(255), color(0), color(5, 50, 120)};

  Tile(PVector p, float r, int s, int i, int j) {
    pos = p;
    radius = r + 0.4;
    state = s;
    index = new PVector(i, j);
  }

  Tile(PVector p, float r, int s) {
    pos = p;
    radius = r;
    state = s;
    index = new PVector(0, 0);
  }

  void setContinent(int c, color cc) {
    cont = c;
    contColor = cc;
  }

  void show() {
    fillShape();
    lineShape();

    fill(states[abs(state - 2) / 2]);
    textAlign(CENTER, CENTER);
    textSize(radius / 3);
    //text(int(index.x) + "," + int(index.y), pos.x, pos.y);
  }

  void lineShape() {
    noFill();
    stroke(states[abs(state - 1)]);
    beginShape();
    for (int i = 0; i < 4; i++) {
      float angle = (60 * i - 210) * PI / 180;
      float x = pos.x + cos(angle) * radius;
      float y = pos.y + sin(angle) * radius;
      vertex(x, y);
    }
    endShape();
  }

  void fillShape() {
    if (cont >= 0) fill(contColor);
    else fill(states[state]);
    noStroke();
    beginShape();
    for (int i = 0; i < 6; i++) {
      float angle = (60 * i - 30) * PI / 180;
      float x = pos.x + cos(angle) * radius;
      float y = pos.y + sin(angle) * radius;
      vertex(x, y);
    }
    endShape();
  }
}
