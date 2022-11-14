import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import models.Test;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mortbay.log.Log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main (String args[]) throws IOException, ParseException {
        Path tests = Path.of(args[0]);
        String testStr = Files.readString(tests);
        Path values = Path.of(args[1]);
        String valueStr = Files.readString(values);


        Gson g = new Gson();
        JsonElement testsJson = g.fromJson(testStr,JsonObject.class);
        JsonElement valuesJson = g.fromJson(valueStr,JsonElement.class);




       treeSearch(testsJson, valuesJson.getAsJsonObject().get("values").getAsJsonArray());


        //JsonObject a = (JsonObject) valueStr;
        Path report = Path.of(tests.getParent()+"reports.json");
       // Files reports = Files.createFile(Path.of(tests.getParent()+"reports.json"));
        Files.writeString(report, g.toJson(testsJson));


    }
    public static void treeSearch(JsonElement root, JsonArray search){
        if (root.isJsonArray()){
            for (JsonElement j:root.getAsJsonArray()) {
                treeSearch(j,search);
            }
        }

        if (root.isJsonObject())  {
          JsonElement elem =  root.getAsJsonObject().get("id");
          if (elem!=null){
          root.getAsJsonObject().remove("value");
            for (JsonElement j:search) {
               String id = j.getAsJsonObject().get("id").toString();
               if (id.equals(elem.toString())){
                   root.getAsJsonObject().add("value",j.getAsJsonObject().get("value"));
               }
            }

        }
        }
    }
}


