package ohtu;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.Map;
import java.util.Iterator;



public class CourseStat {
  JsonObject parsedData;
  int totalSubmissions;
  int totalExercises;
  float totalHours;



  private int getSubmissions(JsonObject obj){
    try {
      return obj.get("students").getAsInt();
    } catch (Exception e) {
      return 0;
    }
  }
  private int getExercises(JsonObject obj){
    try {
      return obj.get("exercise_total").getAsInt();
    } catch (Exception e) {
      return 0;
    }
  }
  private int getHours(JsonObject obj){
    try {
      return obj.get("hour_total").getAsInt();
    } catch (Exception e) {
      return 0;
    }
  }

  private void extractValues(){
    totalSubmissions=0;
    totalExercises=0;
    totalHours=0;
    Iterator it = parsedData.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, JsonElement> entry = (Map.Entry)it.next();
      JsonObject obj = entry.getValue().getAsJsonObject();
      totalSubmissions += getSubmissions(obj);
      totalExercises += getExercises(obj);
      totalHours += getHours(obj);
    }
  }

  public void parseFromString(String data){
    JsonParser parser = new JsonParser();
    parsedData = parser.parse(data).getAsJsonObject();
    extractValues();
  }


  public CourseStat(String data){
    parseFromString(data);
  }

  @Override
  public String toString() {
    return "kurssilla on yhteensä "+totalSubmissions+" palautusta, palautettuja tehtäviä "+totalExercises+" kpl, aikaa käytetty yhteensä "+totalHours+" tuntia";
  }
  
}