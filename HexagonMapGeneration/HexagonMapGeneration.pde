import toxi.geom.mesh2d.Voronoi;
import toxi.geom.*;
import java.util.List;


int mapRows = 50;
int mapCols = 100;
int tileSize = 50;
int tileUsed = 1000;
int minCont = 100;
int conts = 6; //Max 14

Map map;

boolean moving = false;
float zoom = 1;

void setup() {
  //size(800, 600, P3D);
  fullScreen(P3D);
  //randomSeed(1);
  map = new Map(mapCols, mapRows, tileSize);
  map.setContinents(conts);
}

void draw() {
  pushMatrix();
  translate(width/2, height/2, -height/2);
  scale(zoom);
  translate(-width/2, -height/2, height/2);
  rotateX(radians(30));
  background(255);
  map.show();
  popMatrix();
}

void mousePressed() {
  moving = true;
  map.drag();
}

void mouseReleased() {
  moving = false;
}

void mouseDragged() {
  if (moving) {
    map.move();
  }
}

void mouseWheel(MouseEvent event) {
  float e = event.getCount();
  zoom = constrain(zoom - e/10.0, 0.6, 1.5);
  map.zoom();
}
