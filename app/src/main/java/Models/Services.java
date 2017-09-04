package Models;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import codepath.fayberapp.R;

<<<<<<< HEAD
import static android.support.design.R.id.image;

/**
 * Created by East Coast Pawn on 8/18/2017.
 */

=======
>>>>>>> aae36905c1ac897fb7ab1d139ba2eb82860016ca
public class Services implements Serializable {

    public String getTitle()

    {
        return title;
    }

    public String getDetails()
    {
        return details;
    }

    String title;
    String details;

    public String getId()
    {
        return id;
    }

    String id;
    public String getImage()
    {
        return image;
    }

    String image;

    public Services(JSONObject jsonObject) throws JSONException
    {
        this.title = jsonObject.getString("tit_liste");
        this.details = jsonObject.getString("desc_liste");
        this.id = jsonObject.getString("id_liste");
        this.image = jsonObject.getString("img_liste");

    }

    public Services(String title) {
        this.title = title;
    }

    public static ArrayList<Services> fromJSONArray (JSONArray array)
    {
        ArrayList<Services> results = new ArrayList<>();
<<<<<<< HEAD
        for (int x= 0; x < array.length(); x++)
        {
            try
            {
                results.add(new Services(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
=======

        Services services = new Services();

        services.setImage(R.drawable.beauty);
        services.setTitle("HYGIENE CORPORELLE");
        services.setDetails("Soins et procédés visant à assurer l’hygiène corporelle du patient/client et de son environnement.");
        //
        Services services3 = new Services();
        services3.setImage(R.drawable.test);
        services3.setTitle("ASSISTANCE MEDICALE");
        services3.setDetails("Aide à la prise des médicaments présents sous forme injectable et non injectable, surveillance de leurs effets secondaires.");
        //
        Services services1 = new Services();
        services1.setImage(R.drawable.science);
        services1.setTitle("LABORATOIRE");
        services1.setDetails("Prélèvement et transfert de spécimen (sang, selles, urines, etc.) aux laboratoires.");
        //
        Services services2 = new Services();
        services2.setImage(R.drawable.laboratoire);
        services2.setTitle("REALISATION DES TESTS");
        services2.setDetails("Réalisation des tests rapides (malaria, hémogramme, glycémie, HIV, RPR, et autres.)");
        //
        Services services4 = new Services();
        services4.setImage(R.drawable.diet);
        services4.setTitle("SURVEILLANCE DES DIETES");
        services4.setDetails("Surveillance des diètes suivant l’ordonnance médicale.");
        //
        Services services5 = new Services();
        services5.setImage(R.drawable.catheter);
        services5.setTitle("INSTALATION DE SOLUTE & CATHETER");
        services5.setDetails("Installation de soluté, contrôle de la diurèse horaire et changement de sondes vésicales (Changement de cathéter).");
        //
        Services services6 = new Services();
        services6.setImage(R.drawable.reeducationbarres);
        services6.setTitle("EDUCATION & REEDUCATION");
        services6.setDetails("Installation et éducation du patient/client par rapport à sa pathologie ou de son handicap.");
        //
        Services services7 = new Services();
        services7.setImage(R.drawable.pansement);
        services7.setTitle("SOINS PANSEMENTS");
        services7.setDetails("Réalisation, surveillance et renouvellement de pansements.");
        //
        Services services8 = new Services();
        services8.setImage(R.drawable.soutienpsy);
        services8.setTitle("SOUTIEN PSYCHOLOGIQUE ");
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
        
>>>>>>> aae36905c1ac897fb7ab1d139ba2eb82860016ca
        return results;
    }
   /* public static ArrayList<Services> searchFakeData(String query) {
        query = query.toLowerCase();

        ArrayList<Services> results = new ArrayList<>();

        ArrayList<Services> services = Services.searchFakeData();

        for (Services s : services) {

            if (s.getTitle().toLowerCase().contains(query) || TextUtils.isEmpty(query)) {
                results.add(s);
                Log.d("DEBUG-Search", s.getTitle());
            }

        }

        return results;
    }*/


}
    /*
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

   public static ArrayList<Services> fromFakeData() {
       ArrayList<Services> results = new ArrayList<>();

       Services services = new Services();
       services.setImage(R.drawable.fitness);
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

       for (Services s : services) {

           if (s.getTitle().toLowerCase().contains(query) || TextUtils.isEmpty(query)) {
               results.add(s);
               Log.d("DEBUG-Search", s.getTitle());
           }

       }

       return results;
   }
}*/





