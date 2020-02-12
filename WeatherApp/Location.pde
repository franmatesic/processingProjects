String locationAPI = "b46fdbe462cb8aabfc15c21c4b11bb01";
class Location {

  private XML data;
  private String country;
  private String city;

  Location() {
    data = loadXML("http://api.ipstack.com/check?access_key=" + locationAPI + "&output=xml");
    country = data.getChild("country_code").getContent();
    city = data.getChild("city").getContent();
  }

  String getLocation() {
    return city + "," + country;
  }
}
