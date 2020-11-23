package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.api.client.util.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Claender {
    private String gmail;
    private String time;
    private ArrayList<JSONObject> events;
    private String url;

    public Claender(String gmail) {
        this.gmail = gmail;
        DateTime dateTime = new DateTime(System.currentTimeMillis());
        String nowtime = dateTime.toString();
        time = nowtime.replace("+03:30","Z");
        this.url = "https://www.googleapis.com/calendar/v3/calendars/"+this.gmail+"/events?alwaysIncludeEmail=true&timeMin="+this.time+"&maxResults=5&singleEvents=true&key=AIzaSyB9KuRnQ-LDmVB8GMR1M_ROZ6iAzT13NhQ";
//        https://www.googleapis.com/calendar/v3/calendars/sajjaddg%40gmail.com/events?singleEvents=true&timeMin=2020-10-09T09%3A41%3A13.506%2B03%3A30&key=[YOUR_API_KEY] HTTP/1.1



    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public String getGmail() {
        return gmail;
    }

    public ArrayList<JSONObject> getEvents() throws IOException, JSONException {
        setEvents();
        return events;
    }

    public void setEvents() throws IOException, JSONException {
        ArrayList<JSONObject> x = new ArrayList<>();
        JSONObject jsonObject = readJsonFromUrl(url);
        JSONArray json = new JSONArray(jsonObject.getJSONArray("items").toString());
        for (int i = 0; i < 5; i++) {
            try {
                JSONObject name = (JSONObject) json.get(i);
                x.add(name);
            } catch (Exception e) {
                break;
            }
        }
        this.events = x;
    }
}
