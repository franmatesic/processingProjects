
Player p;

void setup() {
  size(1000, 600);
  background(0);
  rectMode(CENTER);
  ellipseMode(CENTER);
  //noCursor();

  p = new Player(width/2, height/2, 1);
}

void draw() {
  background(0);

  p.update();
  p.show();

  stroke(255, 0, 0);
  line(width/2, 0, width/2, height);
  line(0, height/2, width, height/2);
}

void keyPressed() {
  p.setMove(keyCode, true);
}
void keyReleased() {
  p.setMove(keyCode, false);
}
public void mouseWheel(MouseEvent event) {
  p.scroll(event.getCount());
}
