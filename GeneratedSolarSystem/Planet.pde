class Planet {
  HE_Mesh mesh;
  HE_Face tiles[];
  float elevation[];
  ArrayList<PVector> trail;

  float radius;
  PVector pos;
  color col;
  boolean orbiting;
  Planet orbitParent = null;
  float orbitRadius;
  float angle = 0;
  float orbitSpeed;
  boolean doneOrbit = false;
  int orbitIndex = 0;
  PVector orbitSkew = new PVector(0, 0, 0);

  Planet(float x, float y, float z, float r, int dens, color c) {
    pos = new PVector(x, y, z);
    radius = r;
    col = c;

    trail = new ArrayList<PVector>();

    HEC_Geodesic geo = new HEC_Geodesic(radius);
    mesh = new HE_Mesh(geo);
    HES_Planar planar = new HES_Planar();
    mesh.subdivide(planar, dens);

    tiles = mesh.getFacesAsArray();
    mesh.clearFaces();
    elevation = new float[tiles.length];
    for (int i = 0; i < tiles.length; i++) {
      tiles[i].setColor(col);
      elevation[i] = 0;
    }
    mesh.addFaces(tiles);

    HEM_Extrude ex = new HEM_Extrude();
    ex.setDistances(elevation);
    mesh.modify(ex);
  }

  void setOrbit(Planet o, float r, float s, PVector skew) {
    orbiting = true;
    orbitParent = o;
    orbitRadius = r;
    orbitSpeed = map(s, 0, 100, 0, 2);
    orbitSkew = skew;
  }

  void update() {
    if (orbiting) {
      rotateX(orbitSkew.x);
      rotateY(orbitSkew.y);
      rotateZ(orbitSkew.z);
      pos.x = orbitParent.pos.x + cos(angle) * orbitRadius;
      pos.y = orbitParent.pos.y + sin(angle) * orbitRadius;
      angle = (angle < TWO_PI) ? angle + orbitSpeed * 0.01 : 0;

      trail.add(new PVector(pos.x, pos.y, pos.z));
      if (doneOrbit) trail.remove(0);

      if ((!orbitParent.equals(sun) && orbitParent.doneOrbit) || 
        (orbitParent.equals(sun) && angle >= TWO_PI)) {
        doneOrbit = true;
      }
    }
  }

  void clearTiles() {
    for (int i = 0; i < tiles.length; i++) {
      tiles[i].setColor(col);
    }
  }

  void generate(int cc, int numTiles[]) {
    for (int c = 0; c < cc; c++) {
      int counter = 0;
      int index = int(random(tiles.length));
      HE_Face start = tiles[index];
      while (start.getColor() != col) {
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

  void show(WB_Render render) {
    pushMatrix();
    translate(pos.x, pos.y, pos.z);
    noStroke();
    fill(col);
    render.drawFaces(mesh);

    for (int i = 0; i < tiles.length; i++) {
      HE_Face tile = tiles[i];
      if (tile.getColor() != col) {
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
    popMatrix();

    noFill();
    stroke(col);
    strokeWeight(2);
    beginShape();
    for (PVector p : trail) {
      vertex(p.x, p.y, p.z);
    }
    //if (doneOrbit && orbitParent.equals(sun)) endShape(CLOSE);
    //else endShape();
    endShape();
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

  void push(ArrayList<PVector> array, PVector p) {
    for (int i = 0; i < array.size() - 2; i++) {
      array.set(i + 1, array.get(i));
    }
    array.set(0, p);
  }
}
