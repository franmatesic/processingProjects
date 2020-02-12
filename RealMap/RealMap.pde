import peasy.*;

String files[] = new String[]{"house.txt", "smb.txt", "zg1.txt"};

PeasyCam cam;

MapReader map;

void setup() {
  fullScreen(P3D);

  cam = new PeasyCam(this, 500);

  XML data = loadXML(makeURL(15.7244, 45.7962, 0.0127, 0.005));
  map = new MapReader(data);

}

void draw() {

  //rotateX(PI);
  //scale(5);

  background(240);
  map.update(color(0, 220, 220), color(0));
}

public String makeURL(double x, double y, double dx, double dy) {
  return "https://api.openstreetmap.org/api/0.6/map?bbox=" + (x-dx) + "," + (y-dy) + "," + (x+dx) + "," + (y+dy);
}
