static class Coloring {

  static Graph graph;
  static int colorIndex[];

  static int getColoring(Graph g) {
    graph = g;
    colorIndex = new int[graph.n];
    int result = -1;
    for (int i = 2; i < 100; i++) {
      if (graphColoring(i)) {
        result = i;
        break;
      }
    }
    return result;
  }

  static boolean isSafe(int v, int colors[], int c) { 
    for (int i = 0; i < graph.n; i++) 
      if (graph.matrix[v][i] == 1 && c == colors[i]) 
        return false;
    return true;
  }

  static boolean graphColoringUtil(int m, int colors[], int v) {
    if (v == graph.n) 
      return true;

    for (int c = 1; c <= m; c++) {
      if (isSafe(v, colors, c)) { 
        colors[v] = c; 
        colorIndex[v] = c - 1;

        if (graphColoringUtil(m, colors, v + 1)) 
          return true;

        colors[v] = 0;
        colorIndex[v] = 0;
      }
    }
    return false;
  }

  static boolean graphColoring(int m) { 
    int colors[] = new int[graph.n]; 
    for (int i = 0; i < graph.n; i++) 
      colors[i] = 0; 

    if (!graphColoringUtil(m, colors, 0)) {
      return false;
    }
    return true;
  }
}
