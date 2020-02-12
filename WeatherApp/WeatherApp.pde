import java.text.SimpleDateFormat;
import java.util.Date;

Weather weather;
Location here;

Date today;
SimpleDateFormat todayDate;

float time = 0;
float timeSpeed = 3601;

boolean realTime = false;

void setup() {
  size(500, 500);

  //here = new Location(); //Only 9982 uses
  String loc = "Samobor,HR";//here.getLocation();
  weather = new Weather(loc);
  //weather.printData(0);

  today = new Date();
  todayDate = new SimpleDateFormat("HH:mm");
}

void draw() {
  //background(76, 172, 222);
  getBackground(8, 18);

  //weather.showIcon(0, width/2, height/2);
  today = new Date();

  time = (realTime)? getTime(today) : time + 0.0000046 * timeSpeed;
  if (time >= 24) time = 0;
  
  text(int(timeSpeed-1), 0, 32);

  fill(255);
  textSize(32);
  if (!realTime) text(nf(int(time), 2, 0)+":"+nf(getMinutes(time), 2, 0), width-96, 32);
  else text(todayDate.format(today), width-96, 32);
}

void keyPressed() {
  if (key == 'r' || key == 'R') realTime = true;
  else if (key == 's' || key == 'S') realTime = false;
  if (!realTime && key == '+') timeSpeed += 100;
  if (!realTime && key == '-') timeSpeed = constrain(timeSpeed-100, 1, timeSpeed-100);
}

int getMinutes(float time) {
  int hours = int(time);
  float minutes = time - hours;
  float temp = map(minutes, 0, 1, 0, 60);
  return int(temp);
}

float getTime(Date date) {
  int hours = date.getHours();
  int minutes = date.getMinutes();
  float temp = map(minutes, 0, 60, 0, 1);
  return hours + temp;
}

void getBackground(int m, int n) {
  // [6] -> (240,150,110) [14] -> (100, 180, 230) [22] -> (30, 60, 80)
  color morning = color(240, 150, 110);
  color noon = color(120, 170, 220);
  color night = color(30, 30, 70);

  float mLower = 0.6;
  float mUpper = 1.8;
  float nLower = 0.9;
  float nUpper = 1.2;

  color bkg = night;
  if (time <= (m+n)/2) {
    float temp = map(time, m * mLower, m * mUpper, 0, 1);
    bkg = lerpColor(night, noon, temp);
  } else {
    float temp = map(time, n * nLower, n * nUpper, 0, 1);
    bkg = lerpColor(noon, night, temp);
  }
  background(bkg);
}
