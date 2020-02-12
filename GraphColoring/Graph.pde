class Graph {

  String name;
  int n;
  int coloring;
  int size = 100;
  int[][] matrix;
  color[] colors = {color(255, 0, 0), color(0, 255, 0), color(0, 0, 255), color(255, 255, 0), color(0, 255, 255), color(255, 0, 255)};
  int colorIndex[];
  PVector pos = new PVector(width/2, height/2);
  PVector points[];

  Graph(int[][] mat, int s, String nm) {
    matrix = mat;
    n = matrix.length;
    size = s;
    name = nm;
    coloring = Coloring.getColoring(this);
    colorIndex = Coloring.colorIndex;

    points = new PVector[n];
    float step = TWO_PI / n;
    float angle = 0;
    for (int i = 0; i < n; i++) {
      float vx = sin(angle) * size;
      float vy = cos(angle) * size;

      points[i] = new PVector(vx, vy);
      angle += step;
    }
  }

  void setPos(float x, float y) {
    pos.x = x;
    pos.y = y;
  }

  void show() {
    pushMatrix();
    translate(pos.x, pos.y);

    for (int i = 0; i < points.length; i++) {
      //Bridovi
      strokeWeight(2);
      for (int j = 0; j < matrix[i].length; j++) {
        if (i != j && i < j && matrix[i][j] == 1) {
          stroke(0);
          noFill();
          line(points[i].x, points[i].y, points[j].x, points[j].y);
        }
      }
      //Vrhovi
      noStroke();
      fill(colors[colorIndex[i % colors.length]]);
      ellipse(points[i].x, points[i].y, size / 5, size / 5);
    }
    popMatrix();
  }
}
