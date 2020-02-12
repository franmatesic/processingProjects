class Map {

  float tileW, tileH, tileS;
  float tileRadius;
  PVector size;
  ArrayList<Tile> tiles;

  //for continents
  int conts[];

  //for scrolling and zooming
  PVector drag = new PVector();
  PVector pos = new PVector();
  float offsetUp, offsetDown;
  Tile upLeft, downRight;
  int WHdiff = 0;
  float viewOffset = 18;

  Map(int w, int h, float r) {
    size = new PVector(w, h);
    WHdiff = 0;
    tiles = new ArrayList<Tile>();
    tileRadius = r;
    tileW = r * sqrt(3.0);
    tileH = r * 2;
    tileS = tileH * 3.0/4.0;


    setTiles();

    upLeft = tiles.get(0);
    downRight = tiles.get(tiles.size() - 1);
    offsetUp = - upLeft.pos.y + tileH;
    offsetDown = height - downRight.pos.y - tileH;

    move();
  }

  void drag() {
    drag.x = pos.x - mouseX;
    drag.y = pos.y - mouseY;
  }

  void move() {
    pos.x = mouseX + drag.x;
    pos.y = constrain(mouseY + drag.y, offsetDown * zoom * 1.3, offsetUp * zoom);

    for (Tile t : tiles) {
      t.pos.x = (t.pos.x + pos.x < - tileW * viewOffset)? t.pos.x + (size.x - WHdiff) * tileW :
        (t.pos.x + pos.x > width + tileW * viewOffset)? t.pos.x - (size.x - WHdiff) * tileW : t.pos.x;
    }
  }

  void zoom() {
    pos.y = constrain(pos.y, offsetDown * zoom, offsetUp * zoom);
  }

  void setTiles() {
    float cx = (size.x * tileW - width) / 2;
    float cy = (size.y * tileS - height) / 2;
    for (int i = 0; i < size.x; i++) {
      for (int j = 0; j < size.y; j++) {
        float x = i * tileW + tileW / (j % 2 + 1) - cx*2;
        float y = j * tileS  + tileH / 2 - cy/2;
        PVector pos = new PVector(x, y);
        tiles.add(new Tile(pos, tileRadius, 2, i, j));
      }
    }
  }

  void setContinents(int n) {
    conts = toPartitions(tileUsed, n, minCont);

    //Continent positions
    ArrayList<PVector> points = new ArrayList<PVector>();
    for (int i = 0; i < n; i++) {
      float x = random(size.x * tileW);
      float y = random(size.y * tileH);
      boolean can = (points.size() == 0) ? true : false;
      while (!can) {
        x = random(size.x * tileW);
        y = random(size.y * tileH);
        for (PVector p : points) {
          if (getTileAt(p.x, p.y).pos.dist(getTileAt(x, y).pos) > 1000 && getTileAt(x, y).index.y != 0 && getTileAt(x, y).index.y != size.y - 1) {
            can = true;
          } else {
            can = false;
            break;
          }
        }
      }
      points.add(new PVector(x, y));
    }
    //Continent starting points
    for (int i = 0; i < points.size(); i++) {
      Tile t = getTileAt(points.get(i).x, points.get(i).y);
      t.setContinent(i, COLOR[i]);
      conts[i]--;
    }
    //Continent shape
    int counter = 0;
    while (arrSum(conts) > 0 && counter < tileUsed * 2) {
      for (Tile t : tiles) {
        if (t.cont >= 0 && conts[t.cont] > 0) {
          ArrayList<Tile> closest = getClose(t);
          int r = int(random(closest.size()));
          Tile c = closest.get(r);
          if (c.cont < 0 && c.index.y != 0 && c.index.y != size.y - 1 && random(1) > 0.4) {
            closest.get(r).setContinent(t.cont, t.contColor);
            conts[t.cont]--;
          }
        }
      }
      counter++;
    }
  }

  void show() {
    pushMatrix();
    translate(pos.x, pos.y);
    for (Tile t : tiles) {
      //if (t.pos.x + pos.x >= -tileW * viewOffset && t.pos.x + pos.x <= width + tileW * viewOffset &&
      // t.pos.y + pos.y >= -tileH * viewOffset && t.pos.y + pos.y <= height + tileH * viewOffset) 
      t.show();
    }
    popMatrix();
  }


  Tile getTileBy(float i, float j) {
    for (Tile t : tiles) {
      if (t.index.x == int(i) && t.index.y == int(j)) return t;
    }
    return null;
  }

  Tile getTileAt(float x, float y) {
    float mindist = 9999;
    Tile result = null;
    for (Tile t : tiles) {
      float d = dist(t.pos.x, t.pos.y, x, y);
      if (result == null || d < mindist) {
        mindist = d;
        result = t;
      }
    }
    return result;
  }

  ArrayList<Tile> getClose(Tile t) {
    ArrayList<Tile> close = new ArrayList<Tile>();
    float x = t.index.x;
    float y = t.index.y;
    if (y != 0 && y != size.y - 1) {
      for (int i = 0; i < 6; i++) {
        if(i < 2) {
          close.add(getTileBy((y % 2 == 0)? (x + 1) % (size.x - 1) : (x - 1 < 0)? size.x - 1 : x - 1, y - 1));
          close.add(getTileBy(x, y - 1));
        }else if(i < 4) {
          close.add(getTileBy((x - 1 < 0)? size.x - 1 : x - 1, y));
          close.add(getTileBy((x + 1) % (size.x - 1), y));
        }else {
          close.add(getTileBy((y % 2 == 0)? (x + 1) % (size.x - 1) :  (x - 1 < 0)? size.x - 1 : x - 1, y + 1));
          close.add(getTileBy(x, y + 1));
        }
      }
    }
    return close;
  }
}
