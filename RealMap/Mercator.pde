public static class Mercator {
  final private static double R_MAJOR = 6378137.0;
  final private static double R_MINOR = 6356752.3142;
  final private static double RATIO = R_MINOR / R_MAJOR;
  final private static double ECCENT = Math.sqrt(1.0 - (RATIO * RATIO));
  final private static double COM = 0.5 * ECCENT;
  final private static double DEG2RAD = Math.PI / 180.0;
  final private static double RAD2DEG = 180.0 / Math.PI;

  public static double lonToX(double lon) {
    return R_MAJOR * DegToRad(lon);
  }

  public static double xToLon(double x) {
    return RadToDeg(x) / R_MAJOR;
  }

  public static double latToY(double lat) {
    lat = Math.min(89.5, Math.max(lat, -89.5));
    double phi = DegToRad(lat);
    double sinphi = Math.sin(phi);
    double con = ECCENT * sinphi;
    con = Math.pow(((1.0 - con) / (1.0 + con)), COM);
    double ts = Math.tan(0.5 * ((Math.PI * 0.5) - phi)) / con;
    return 0 - R_MAJOR * Math.log(ts);
  }

  public static double yToLat(double y) {
    double ts = Math.exp(-y / R_MAJOR);
    double phi = HALF_PI - 2 * Math.atan(ts);
    double dphi = 1.0;
    int i = 0;
    while ((Math.abs(dphi) > 0.000000001) && (i < 15)) {
      double con = ECCENT * Math.sin(phi);
      dphi = HALF_PI - 2 * Math.atan(ts * Math.pow((1.0 - con) / (1.0 + con), COM)) - phi;
      phi += dphi;
      i++;
    }
    return RadToDeg(phi);
  }

  private static double RadToDeg(double rad) {
    return rad * RAD2DEG;
  }

  private static double DegToRad(double deg) {
    return deg * DEG2RAD;
  }
}
