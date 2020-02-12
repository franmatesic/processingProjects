import wblut.geom.*;
import wblut.hemesh.*;
import wblut.core.*;
import wblut.math.*;
import wblut.nurbs.*;
import wblut.*;
import wblut.processing.*;
import java.util.List;
import peasy.*;

PeasyCam cam;
WB_Render render;

MeshTriangle world1;
MeshVoronoi world2;

int r = 200;
float vx = 120;
float vy = 120;

void setup() {
  size(600, 600, P3D);
  //fullScreen(P3D);
  randomSeed(0);

  cam = new PeasyCam(this, 500);
  render = new WB_Render(this);

  world1 = new MeshTriangle(r);
  //world1.generate(5, 50);

  world2 = new MeshVoronoi(r * 2.25, 80, 80);
}

void draw() {
  background(0);

  //lights();

  rotateX(HALF_PI);
  //rotateZ(-frameCount * 0.005);

  world1.show(render);
  world2.show();
}

void mousePressed() {
  // (20, 39), (50, 42)
  int x = int(map(mouseX, 0, width, 0, 150));
  int y = int(map(mouseY, 0, height, 0, 150));
  //world2 = new MeshVoronoi(r * 2.25, x, y);
  println("X: " + x + ", Y: " + y);
}

void keyPressed() {
  world1.clearTiles();
  int array[] = {int(random(40, 100)), 20, int(random(40, 100)), 
    int(random(40, 100)), int(random(80, 160)), int(random(40, 100)), int(random(40, 100))};
  world1.generate(7, array);
}
