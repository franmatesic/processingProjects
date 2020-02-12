class Cubie {
  PMatrix3D matrix;
  int x = 0;
  int y = 0;
  int z = 0;
  color c;

  Face[] faces = new Face[6];

  boolean highlight = false;

  Cubie(PMatrix3D m, int xi, int yi, int zi) {
    matrix = m;
    x = xi;
    y = yi;
    z = zi;
    c = color(255);

    faces[0] = new Face(new PVector(0, 0, -1), color(0, 0, 255));
    faces[1] = new Face(new PVector(0, 0, 1), color(0, 255, 0));
    faces[2] = new Face(new PVector(0, 1, 0), color(255, 255, 0));
    faces[3] = new Face(new PVector(0, -1, 0), color(255));
    faces[4] = new Face(new PVector(1, 0, 0), color(255, 0, 0));
    faces[5] = new Face(new PVector(-1, 0, 0), color(255, 160, 0));
  }

  void turnFacesZ(int dir) {
    for (Face f : faces) {
      f.turnZ(HALF_PI * dir);
    }
  }
  void turnFacesY(int dir) {
    for (Face f : faces) {
      f.turnY(HALF_PI * dir);
    }
  }
  void turnFacesX(int dir) {
    for (Face f : faces) {
      f.turnX(HALF_PI * dir);
    }
  }

  void update(int xi, int yi, int zi) {
    matrix.reset();
    matrix.translate(xi, yi, zi);
    x = xi;
    y = yi;
    z = zi;
  }

  void show() {
    //fill(c);
    noFill();
    stroke(0);
    strokeWeight(0.1);
    pushMatrix();
    applyMatrix(matrix);
    box(1);    
    for (Face f : faces) {
      f.show();
    }

    popMatrix();
  }
}
