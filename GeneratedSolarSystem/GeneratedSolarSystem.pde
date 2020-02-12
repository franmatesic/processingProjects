import wblut.geom.*;
import wblut.hemesh.*;
import wblut.core.*;
import wblut.math.*;
import wblut.nurbs.*;
import wblut.*;
import wblut.processing.*;
import java.util.List;
import peasy.*;

color COLOR[] = {#e6194b, #3cb44b, #ffe119, #f58231, #911eb4, #f032e6, #bfef45, 
  #fabebe, #e6beff, #469990, #fffac8, #800000, #aaffc3, #ffd8b1};

PeasyCam cam;
WB_Render render;

ArrayList<Planet> system;
Planet sun;
Planet mercury, venus, earth, moon, mars, jupiter, saturn, uranus, neptune;

Planet looking;

void setup() {
  fullScreen(P3D);
  randomSeed(0);

  cam = new PeasyCam(this, 2000);
  render = new WB_Render(this);

  system = new ArrayList<Planet>();

  float sunR = 403;
  sun = new Planet(0, 0, 0, sunR, 0, color(#FFF829));

  float sunToKm = 1391900 / sunR;
  float scale = 0.03 / sunToKm;

  float mercuryR = sunR/277;
  float mercuryD = 57950000 * scale;
  float mercuryS = 47.87;
  mercury = new Planet(0, 0, 0, mercuryR, 0, color(#867D77));
  mercury.setOrbit(sun, mercuryD, mercuryS, new PVector(0, 0, 0));

  float venusR = sunR/113;
  float venusD = 108110000 * scale;
  float venusS = 35.02;
  venus = new Planet(0, 0, 0, venusR, 0, color(#9B5C4C));
  venus.setOrbit(sun, venusD, venusS, new PVector(0, 0, 0));

  float earthR = sunR/108;
  float earthD = 149570000 * scale;
  float earthS = 29.78;
  earth = new Planet(0, 0, 0, earthR, 0, color(#6544C1));
  earth.setOrbit(sun, earthD, earthS, new PVector(0, 0, 0));

  float moonR = sunR/403;
  float moonD = 384000 * scale;
  float moonS = 3.683;
  moon = new Planet(0, 0, 0, moonR, 0, color(#A39FAF));
  moon.setOrbit(earth, moonD, moonS, new PVector(0, 0, 0));

  float marsR = sunR/208;
  float marsD = 227840000 * scale;
  float marsS = 24.077;
  mars = new Planet(0, -marsD, 0, marsR, 0, color(#CE8455));
  mars.setOrbit(sun, marsD, marsS, new PVector(0, 0, 0));

  float jupiterR = sunR/9.7;
  float jupiterD = 778140000 * scale;
  float jupiterS = 13.07;
  jupiter = new Planet(0, 0, 0, jupiterR, 0, color(#C9AD72));
  jupiter.setOrbit(sun, jupiterD, jupiterS, new PVector(0, 0, 0));

  float saturnR = sunR/11.4;
  float saturnD = 1427000000 * scale;
  float saturnS = 9.69;
  saturn = new Planet(0, 0, 0, saturnR, 0, color(#D6C9AD));
  saturn.setOrbit(sun, saturnD, saturnS, new PVector(0, 0, 0));

  float uranusR = sunR/26.8;
  float uranusD = 287030000 * scale * 1000;
  float uranusS = 6.81;
  uranus = new Planet(0, 0, 0, uranusR, 0, color(#B2C3E5));
  uranus.setOrbit(sun, -uranusD, uranusS, new PVector(0, 0, 0));

  float neptuneR = sunR/27.7;
  float neptuneD = 449990000 * 100 * scale;
  float neptuneS = 5.43;
  neptune = new Planet(0, 0, 0, neptuneR, 0, color(#7990C1));
  neptune.setOrbit(sun, neptuneD, neptuneS, new PVector(0, 0, 0));

  system.add(sun);
  system.add(mercury);
  system.add(venus);
  system.add(earth);
  system.add(moon);
  system.add(mars);
  system.add(jupiter);
  system.add(saturn);
  system.add(uranus);
  system.add(neptune);

  looking = sun;
}

void draw() {
  cam.lookAt(looking.pos.x, looking.pos.y, looking.pos.z);
  background(0);

  for (Planet p : system) {
    p.update();
    p.show(render);
  }
}

void keyPressed() {
  switch(key) {
  case 'e':
    looking = earth;
    break;
  case 'j':
    looking = jupiter;
    break;
  case 'n':
    looking = neptune;
    break;
  case 'm':
    looking = mars;
    break;
  case 'v':
    looking = venus;
    break;
  case 'u':
    looking = uranus;
    break;
  default:
    looking = sun;
  }
}
