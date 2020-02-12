color COLOR[] = {#e6194b, #3cb44b, #ffe119, #f58231, #911eb4, #f032e6, #bfef45, #fabebe, 
  #e6beff, #469990, #fffac8, #800000, #aaffc3, #ffd8b1};

class MeshTriangle {
  float radius;
  HE_Face tiles[];
  float elevation[];
  HE_Mesh mesh;

  MeshTriangle(float r) {
    radius = r;
    HEC_Geodesic geo = new HEC_Geodesic(radius);
    mesh = new HE_Mesh(geo);

    HES_Planar planar = new HES_Planar();
    mesh.subdivide(planar, 1);

    tiles = mesh.getFacesAsArray();
    mesh.clearFaces();

    elevation = new float[tiles.length];
    for (int i = 0; i < tiles.length; i++) {
      tiles[i].setColor(#412DA5);
      elevation[i] = 0;
    }
    //int t = 0;
    //tiles[t].setColor(#1F5828);
    //ArrayList<HE_Face> ns = findN(tiles[t]);
    //for (HE_Face f : ns) {
    //  f.setColor(#2DA540);
    //}
    mesh.addFaces(tiles);

    HEM_Extrude ex = new HEM_Extrude();
    ex.setDistances(elevation);
    mesh.modify(ex);
  }

  void clearTiles() {
    for (int i = 0; i < tiles.length; i++) {
      tiles[i].setColor(#412DA5);
    }
  }

  void generate(int cc, int numTiles[]) {
    for (int c = 0; c < cc; c++) {
      int counter = 0;
      int index = int(random(tiles.length));
      HE_Face start = tiles[index];
      while (start.getColor() != #412DA5) {
        index = int(random(tiles.length));
        start = tiles[index];
      }
      start.setColor(COLOR[c]);
      int left = numTiles[c];
      while (left > 0 && counter <= 1000) {
        for (int i = 0; i < tiles.length; i++) {
          HE_Face tile = tiles[i];
          if (tile.getColor() == start.getColor()) {
            ArrayList<HE_Face> closest = findN(tile);
            int cIndex = int(random(closest.size()));
            HE_Face cTile = closest.get(cIndex);
            if (cTile.getColor() != start.getColor()) {
              cTile.setColor(start.getColor());
              left--;
            }
          }
        }
        counter++;
      }
    }
  }

  void show(WB_Render r) {
    //stroke(#503CB4);
    noStroke();
    fill(#412DA5);
    r.drawFaces(mesh);
    //r.drawFacesFC(mesh);
    for (int i = 0; i < tiles.length; i++) {
      HE_Face tile = tiles[i];
      if (tile.getColor() != #412DA5) {
        List<HE_Vertex> vertices = tile.getFaceVertices();
        fill(tile.getColor());
        beginShape();
        for (HE_Vertex v : vertices) {
          float x = v.xf();// + noise(frameCount);
          float y = v.yf();// + noise(frameCount);
          float z = v.zf();// + noise(frameCount);
          vertex(x, y, z);
        }
        endShape();
      }
    }
  }

  ArrayList<HE_Face> findN(HE_Face tile) {
    ArrayList<HE_Face> result = new ArrayList<HE_Face>();

    WB_Coord tc = tile.getFaceCenter();
    PVector ptc = new PVector(tc.xf(), tc.yf(), tc.zf());

    for (int i = 0; i < tiles.length; i++) {
      HE_Face other = tiles[i];
      if (!tile.equals(other)) {
        WB_Coord oc = other.getFaceCenter();
        PVector otc = new PVector(oc.xf(), oc.yf(), oc.zf());

        if (ptc.dist(otc) < radius * 0.06) result.add(other);
      }
    }
    return result;
  }
}
