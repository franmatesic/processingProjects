import java.io.File;

ArrayList<PImage> assets;
ArrayList<String> tags;

float mw = 25;
float mh = 25;

String directory = "D:\\Assets\\Racing\\Isometric";

DropList list;

void setup() {
  fullScreen();
  background(250);
  textAlign(CENTER, CENTER);

  loadFiles(directory);

  list = new DropList(assets, tags);
  list.setDim(100, 100, 300, 100);
  list.setSelected(-1);
}

void draw() {
  background(250);

  list.show();

  //fill(0);
  //noStroke();
  //beginShape();
  //vertex(mouseX, mouseY);
  //vertex(mouseX + mw, mouseY + mh/2);
  //vertex(mouseX + mw/2, mouseY + mh);
  //endShape();
}

void mousePressed() {
  list.mouseClick();
}

void mouseWheel(MouseEvent event) {
  float e = event.getCount();
  if (list.onList()) {
    list.indexPos = int(constrain(list.indexPos + e, 0, list.items.size() - 10));
  } else if (list.onSelected()) {
    list.selected = int(constrain(list.selected + e, 0, list.items.size() - 1));
    list.indexPos = int(constrain(list.selected + 1, 0, list.items.size() - 10));
  }
}

void loadFiles(String dir) {
  File folder = new File(dir);
  File[] files = folder.listFiles();

  assets = new ArrayList<PImage>();
  tags = new ArrayList<String>();

  for (int i = 0; i < files.length; i++) {
    String name = files[i].getAbsolutePath();
    if (name.contains("road") && !name.contains("Ramp") && !name.contains("Bridge") && !name.contains("Sand") 
      && !name.contains("Border") && !name.contains("Wall")) {
      assets.add(loadImage(name));
      String title = name.replace(dir + "\\", "");
      tags.add(title.replace(".png", ""));
    }
  }
}
