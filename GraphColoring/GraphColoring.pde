
Graph g;

int[][] c4 = {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}};
int[][] k5 = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};
int[][] graf = {{0, 1, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 0, 1}, {0, 0, 1, 1, 0}};
int[][] c3 = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
int[][] k34 = {{0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 0}};

ArrayList<Graph> graphs;

void setup() {
  size(500, 500);
  background(255);
  textAlign(CENTER, CENTER);
  textSize(20);


  File dir = new File(sketchPath() + "/data");
  File[] files = dir.listFiles();

  graphs = new ArrayList<Graph>();
  for (File file : files) {
    //if (file.getName().endsWith(".txt")) {
    //  graphs.add(convert(file));
    //}
    graphs.add(convert(file));
  }

  g = graphs.get(0);
}

int gi = 0;

void draw() {
  background(255);
  g.show();

  noStroke();
  fill(0);
  text("Kromatski broj " + g.name + " je " + g.coloring, width/2, 50);
}

void keyPressed() {
  g = graphs.get(gi);
  gi = (gi + 1) % graphs.size();
}

Graph convert(File file) {
  Graph result = null;
  String txt[] = loadStrings(file);
  int n = Integer.parseInt(txt[0]);
  int m[][] = new int[n][n];
  for (int i = 0; i < n; i++) {
    String[] line = txt[i + 2].split(" ");
    for (int j = 0; j < line.length; j++) {
      m[i][j] = Integer.parseInt(line[j]);
    }
  }
  result = new Graph(m, int(map(n, 2, 64, 100, 200)), file.getName().replace(".txt", ""));
  return result;
}
