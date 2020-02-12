String weatherAPI = "cbda1d8d755311c20d1004258d3cb1b6";
class Weather {

  XML data;
  ArrayList<WeatherData> timeStamps;
  String Country, City;
  SimpleDateFormat sunrise, sunset; 
  float lat, lon;

  Weather(String loc) {
    getWeather(loc);
    println(data);
    getData();
  }

  void getWeather(String location) {
    data = loadXML("http://api.openweathermap.org/data/2.5/forecast?q="+location+"&appid=" + weatherAPI + "&mode=xml&units=metric");
  }

  void getData() {
    timeStamps = new ArrayList<WeatherData>();
    XML[] times = data.getChildren("forecast/time");
    for (int i = 0; i < times.length; i++) {
      WeatherData item = new WeatherData();
      String from = times[i].getString("from").replace("T", " ");
      String to = times[i].getString("to").replace("T", " ");
      item.timeFrom = new SimpleDateFormat(from);
      item.timeTo = new SimpleDateFormat(to);
      item.iconTag = getStringItem(times[i], "symbol", "var");
      item.iconName = getStringItem(times[i], "symbol", "name");
      item.icon = loadImage("http://openweathermap.org/img/w/"+item.iconTag+".png");
      item.fallings = getFloatItem(times[i], "precipitation", "value");
      item.fallingsName = getStringItem(times[i], "precipitation", "type");
      item.windSpeed = getFloatItem(times[i], "windSpeed", "mps");
      item.windName = getStringItem(times[i], "windSpeed", "name");
      item.windCode = getStringItem(times[i], "windDirection", "code");
      item.tempCur = getFloatItem(times[i], "temperature", "value");
      item.tempMin = getFloatItem(times[i], "temperature", "min");
      item.tempMax = getFloatItem(times[i], "temperature", "max");
      item.pressure = getFloatItem(times[i], "pressure", "value");
      item.humidity = getIntItem(times[i], "humidity", "value");
      item.clouds = getIntItem(times[i], "clouds", "all");
      item.cloudsName = getStringItem(times[i], "clouds", "value");
      timeStamps.add(item);
    }
    Country = data.getChild("location/country").getContent();
    City = data.getChild("location/name").getContent();
    lat = getFloatItem(data, "location/location", "latitude");
    lon = getFloatItem(data, "location/location", "longitude");
    String rise = getStringItem(data, "meta/sun", "rise").replace("T", " ");
    String set = getStringItem(data, "meta/sun", "set").replace("T", " ");
    sunrise = new SimpleDateFormat(rise);
    sunset = new SimpleDateFormat(set);
  }

  void printData(int i) {
    println(Country+", "+City+" {");
    String from = timeStamps.get(i).timeFrom.format(new Date());
    String to = timeStamps.get(i).timeTo.format(new Date());
    println("\tFrom: "+from+", To: "+to);
    println("\tTemperature: "+timeStamps.get(i).tempCur+"°C [current], "+timeStamps.get(i).tempMin+"°C [min], "+timeStamps.get(i).tempMax+"°C [max]");
    println("\tHumidity: "+timeStamps.get(i).humidity+"%\n\tPressure: "+timeStamps.get(i).pressure+"hPa");
    println("\tWind: "+timeStamps.get(i).windSpeed+"m/s ["+timeStamps.get(i).windName+"], "+timeStamps.get(i).windCode);
    println("\tClouds: "+timeStamps.get(i).clouds+"% ["+timeStamps.get(i).cloudsName+"]");
    println("\tPrecipation: "+timeStamps.get(i).fallings+"mm ["+timeStamps.get(i).fallingsName+"]\n}");
  }

  void showIcon(int i, float x, float y) {
    image(timeStamps.get(i).icon, x, y);
  }

  int getIntItem(XML data, String path, String item) {
    return data.getChild(path).getInt(item);
  } 
  Float getFloatItem(XML data, String path, String item) {
    return data.getChild(path).getFloat(item);
  }
  String getStringItem(XML data, String path, String item) {
    return data.getChild(path).getString(item);
  }
}

class WeatherData {
  SimpleDateFormat timeFrom, timeTo;
  String iconName, iconTag;
  float fallings, windSpeed, tempCur, tempMin, tempMax;
  float pressure;
  int humidity, clouds;
  String fallingsName, windName, windCode, cloudsName;
  PImage icon;
}
