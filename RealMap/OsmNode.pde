class OsmNode {

  public long ID;

  public float latitude, longitude;
  public float x, y;

  public OsmNode(XML node) {
    ID = node.getLong("id", 0);
    latitude = node.getFloat("lat");
    longitude = node.getFloat("lon");

    x = (float)Mercator.lonToX(longitude);
    y = (float)Mercator.latToY(latitude);
  }

  public PVector getVector() {
    return new PVector(x, y, 0);
  }
}
