class MeshVoronoi {
  float radius;
  HE_Face tiles[];
  WB_Coord pos[];
  float elevation[];
  HE_Mesh mesh;

  MeshVoronoi(float r, float t1, float t2) {
    radius = r;

    HEC_Cube geo = new HEC_Cube();
    geo.setEdge(r);
    mesh = new HE_Mesh(geo);

    HEM_ChamferCorners chamfer = new HEM_ChamferCorners().setDistance(t1);
    HEM_ChamferEdges edges = new HEM_ChamferEdges().setDistance(t2);

    mesh.modify(chamfer);
    mesh.modify(edges);

    //tiles = mesh.getFacesAsArray();
    //mesh.clearFaces();

    //elevation = new float[tiles.length];
    //for (int i = 0; i < tiles.length; i++) {
    //  tiles[i].setColor(#412DA5);
    //}
    //mesh.addFaces(tiles);
  }

  void show() {
    stroke(255, 100);
    render.drawEdges(mesh);
    
  }
}
