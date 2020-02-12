import java.awt.*;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

Robot robot;

PImage screen;

void setup() {
  size(500, 500);
  background(0);
  try {
    robot = new Robot();
  }
  catch(Exception e) {
    e.printStackTrace();
  }

  screen = createImage(displayWidth, displayHeight, ARGB);
  
}


void draw() {
  background(0);
  image(screen, 0, 0, width, height);
}
void mousePressed() {
  screenShot(System.currentTimeMillis() + "");
}


void mouseClick() {
  //Click left mouse button
  robot.mousePress(InputEvent.BUTTON1_MASK);
  robot.delay(200);
  robot.mouseRelease(InputEvent.BUTTON1_MASK);
  robot.delay(200);
}

void mouseMove(int x, int y) {
  //Move mouse to (x, y) position on screen
  robot.mouseMove(x, y);
}

void keyPress(int i) {
  //Press selected key
  robot.delay(40);
  robot.keyPress(i);
  robot.keyRelease(i);
}

void screenShot(String fileName) {
  try {
    //Make a new image and save it to /data/
    screen = new PImage(robot.createScreenCapture(new Rectangle(0, 0, displayWidth, displayHeight)));
    screen.save(dataPath("") + "/" + fileName + ".png");
  } 
  catch(Exception e) {
    e.printStackTrace();
  }
}
