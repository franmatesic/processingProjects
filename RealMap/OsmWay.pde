class OsmWay {

  public long ID;

  public boolean visible, isBoundary, isBuilding, isRoad;

  public List<Long> nodeIDs;

  public float h;

  public String name;

  public int lanes;

  public OsmWay(XML node) {

    nodeIDs = new ArrayList<Long>();
    h = 3.0f; //Default height for structures
    lanes = 1; //Number of lanes either side of the divide
    isBuilding = isRoad = false;
    name = "";

    ID = node.getLong("id", 0);
    visible = node.getString("visible").equals("true");
    XML[] nds = node.getChildren("nd");
    for (XML n : nds) {
      long refNo = n.getLong("ref", 0);
      nodeIDs.add(refNo);
    }

    if (nodeIDs.size() > 1) {
      isBoundary = nodeIDs.get(0) == nodeIDs.get(nodeIDs.size() - 1);
    }

    XML[] tags = node.getChildren("tag");
    for (XML t : tags) {
      String tagKey = t.getString("k");
      try {
        if (tagKey.equals("building:levels")) {
          h = 3.0f * t.getFloat("v");
        } else if (tagKey.equals("height")) {
          h = 0.3048f * t.getFloat("v");
        } else if (tagKey.equals("building")) {
          isBuilding = true;
        } else if (tagKey.equals("highway")) {
          isRoad = true;
        } else if (tagKey.equals("lanes")) {
          lanes = t.getInt("v");
        } else if (tagKey.equals("name")) {
          name = t.getString("v");
        }
      }
      catch(NumberFormatException e) {
        println(e);
      }
    }
  }
}
