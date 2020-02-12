class OsmBounds {

  public float minLat, maxLat, minLon, maxLon;

  public PVector center;

  public OsmBounds(XML node) {

    minLat = node.getFloat("minlat");
    maxLat = node.getFloat("maxlat");
    minLon = node.getFloat("minlon");
    maxLon = node.getFloat("maxlon");

    float x = (float)((Mercator.lonToX(maxLon) + Mercator.lonToX(minLon)) / 2.0);
    float y = (float)((Mercator.latToY(maxLat) + Mercator.latToY(minLat)) / 2.0);
    center = new PVector(x, y, 0);
  }
}
