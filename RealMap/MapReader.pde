import java.util.*;


class MapReader {

  public Map<Long, OsmNode> nodes;

  public List<OsmWay> ways;

  public OsmBounds bounds;

  public MapReader(String resourceFile) {

    nodes = new HashMap<Long, OsmNode>();
    ways = new ArrayList<OsmWay>();

    XML doc = loadXML("data/" + resourceFile);

    setBounds(doc.getChildren("bounds"));
    getNodes(doc.getChildren("node"));
    getWays(doc.getChildren("way"));
  }

  public MapReader(XML file) {

    nodes = new HashMap<Long, OsmNode>();
    ways = new ArrayList<OsmWay>();

    setBounds(file.getChildren("bounds"));
    getNodes(file.getChildren("node"));
    getWays(file.getChildren("way"));
  }

  void update(color c1, color c2) {
    for (OsmWay w : ways) {
      if (w.visible) {
        color c = c1;
        if (w.isRoad) c = c2;

        for (int i = 1; i < w.nodeIDs.size(); i++) {
          OsmNode p1 = nodes.get(w.nodeIDs.get(i - 1));
          OsmNode p2 = nodes.get(w.nodeIDs.get(i));

          PVector v1 = PVector.sub(p1.getVector(), bounds.center);
          PVector v2 = PVector.sub(p2.getVector(), bounds.center);

          noFill();
          stroke(c);
          line(v1.x, v1.y, v2.x, v2.y);
        }
      }
    }
  }

  void setBounds(XML[] xmlNode) {
    bounds = new OsmBounds(xmlNode[0]);
  }

  void getNodes(XML[] xmlNodeList) {
    for (XML n : xmlNodeList) {
      OsmNode node = new OsmNode(n);
      nodes.put(node.ID, node);
    }
  }

  void getWays(XML[] xmlNodeList) {
    for (XML node : xmlNodeList) {
      OsmWay way = new OsmWay(node);
      ways.add(way);
    }
  }
}
