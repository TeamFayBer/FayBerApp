package Models;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import codepath.fayberapp.R;

public class Services implements Serializable {

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    String title;
    String details;
    int image;



    public Services() {
    }

    public static ArrayList<Services> fromFakeData()
    {
        ArrayList<Services> results = new ArrayList<>();

        Services services = new Services();
        services.setImage(R.drawable.nurse);
        services.setTitle("HYGIENE CORPORELLE");
        services.setDetails("Soins et procédés visant à assurer l’hygiène corporelle du patient/client et de son environnement.");
        //
        Services services3 = new Services();
        services3.setImage(R.drawable.diabetes);
        services3.setTitle("ASSISTANCE MEDICALE");
        services3.setDetails("Aide à la prise des médicaments présents sous forme injectable et non injectable, surveillance de leurs effets secondaires.");
        //
        Services services1 = new Services();
        services1.setImage(R.drawable.blood);
        services1.setTitle("LABORATOIRE");
        services1.setDetails("Prélèvement et transfert de spécimen (sang, selles, urines, etc.) aux laboratoires.");
        //
        Services services2 = new Services();
        services2.setImage(R.drawable.diab);
        services2.setTitle("REALISATION DES TESTS");
        services2.setDetails("Réalisation des tests rapides (malaria, hémogramme, glycémie, HIV, RPR, et autres.)");
        //
        Services services4 = new Services();
        services4.setImage(R.drawable.tape);
        services4.setTitle("SURVEILLANCE DES DIETES");
        services4.setDetails("Surveillance des diètes suivant l’ordonnance médicale.");
        //
        Services services5 = new Services();
        services5.setImage(R.drawable.ok);
        services5.setTitle("INSTALATION DE SOLUTE & CATHETER");
        services5.setDetails("Installation de soluté, contrôle de la diurèse horaire et changement de sondes vésicales (Changement de cathéter).");
        //
        Services services6 = new Services();
        services6.setImage(R.drawable.education);
        services6.setTitle("EDUCATION & REEDUCATION");
        services6.setDetails("Installation et éducation du patient/client par rapport à sa pathologie ou de son handicap.");
        //
        Services services7 = new Services();
        services7.setImage(R.drawable.bandage);
        services7.setTitle("SOINS PANSEMENTS");
        services7.setDetails("Réalisation, surveillance et renouvellement de pansements.");
        //
        Services services8 = new Services();
        services8.setImage(R.drawable.mental);
        services8.setTitle("SOUTIEN");
        services8.setDetails("Aide et soutien psychologique au besoin.");

        results.add(services);
        results.add(services1);
        results.add(services2);
        results.add(services3);
        results.add(services4);
        results.add(services5);
        results.add(services6);
        results.add(services7);
        results.add(services8);
        
        return results;
    }

    public static ArrayList<Services> searchFakeData(String query) {
        query = query.toLowerCase();

        ArrayList<Services> results = new ArrayList<>();

        ArrayList<Services> services = Services.fromFakeData();

        for (Services s: services) {

            if (s.getTitle().toLowerCase().contains(query) || TextUtils.isEmpty(query)){
                results.add(s);
                Log.d("DEBUG-Search", s.getTitle());
            }

        }

        return results;
    }
    /*

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
    }*/
}
