package Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by East Coast Pawn on 8/18/2017.
 */

public class Services {

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    String title;
    String details;

    public Services(JSONObject jsonObject) throws JSONException
    {
        this.title = jsonObject.getString("title");
        this.details = jsonObject.getString("details");

    }

    public Services(String title) {
        this.title = title;
    }

    public static ArrayList<Services> fromJSONArray (JSONArray array)
    {
        ArrayList<Services> results = new ArrayList<>();
        for (int x= 0; x < array.length(); x++)
        {
            try
            {
                results.add(new Services(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
