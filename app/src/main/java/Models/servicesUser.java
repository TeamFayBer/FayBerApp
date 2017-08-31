package Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by East Coast Pawn on 8/31/2017.
 */

public class servicesUser implements Serializable {

    public String getIdcl() {
        return idcl;
    }

    public String getNomCl() {
        return nomCl;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    String idcl;
    String nomCl;
    String telephone;
    String username;
    String email;

    public servicesUser(JSONObject jsonObject) throws JSONException
    {
        this.idcl = jsonObject.getString("id_client");
        this.nomCl = jsonObject.getString("nom_client");
        this.telephone= jsonObject.getString("telephone_client");
        this.username = jsonObject.getString("username_client");
        this.email = jsonObject.getString("email_client");

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
