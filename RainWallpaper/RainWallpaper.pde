
ArrayList<Drop> drops;

void setup() {
  //size(500, 500);
  fullScreen();
  frameRate(60);
  background(26, 6, 51);

  drops = new ArrayList<Drop>();
}

void draw() {
  noStroke();
  fill(26, 6, 51, 50);
  rect(0, 0, width, height);

  for (int i = 0; i < 5; i++)
    drops.add(new Drop());

  for (int i = drops.size() - 1; i >= 0; i--) {
    Drop drop = drops.get(i);
    drop.update();
    drop.show();
  }
}
