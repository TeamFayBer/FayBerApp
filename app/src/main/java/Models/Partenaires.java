package Models;

import android.text.TextUtils;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

import codepath.fayberapp.R;

public class Partenaires implements Serializable {

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



    public Partenaires() {
    }

    public static ArrayList<Partenaires> fromFakeData()
    {
        ArrayList<Partenaires> results = new ArrayList<>();

        Partenaires Partenaires = new Partenaires();
        Partenaires.setImage(R.drawable.berimage);
        Partenaires.setTitle("Bertrand SALOMON");
        Partenaires.setDetails("Fondateur, directeur administratif et marketing de Fay&Ber\n" +
                " Gestionnaire public et privé, Gestionnaire d'opérations clientèles à ECONOSURANCE Inc. de Boston, Haïti étant.");
        //
        Partenaires Partenaires3 = new Partenaires();
        Partenaires3.setImage(R.drawable.fayimage);
        Partenaires3.setTitle("Marie Faydie CELAN");
        Partenaires3.setDetails(" Fondatrice, directrice des soins de Fay&Ber\n" +
                " Infirmière spécialisée en maladies infectieuses,  professeur, directrice des soins infirmiers à  Saint François de Sales.");
        //
        Partenaires Partenaires1 = new Partenaires();
        Partenaires1.setImage(R.drawable.corimage);
        Partenaires1.setTitle("Chantal CORRIOLAND");
        Partenaires1.setDetails("Assistante directrice des soins de Fay&Ber\n" +
                " Infirmière spécialisée en maladie infectieuse,  professeur, chef de service SOP à  Saint François de Sales.");
        //
        Partenaires Partenaires2 = new Partenaires();
        Partenaires2.setImage(R.drawable.jerimage);
        Partenaires2.setTitle("Jerry BAZILE");
        Partenaires2.setDetails("Responsable partenariat et relation entre médecins traitants \n" +
                "et/ou associations de médecins et FAY&BER. \n" +
                "* Docteur Obstétricien, Gynécologue spécialisé en infertilité. ");
        //
        Partenaires Partenaires4 = new Partenaires();
        Partenaires4.setImage(R.drawable.nurse);
        Partenaires4.setTitle("INFIRMIERES LICENCIEES");
        Partenaires4.setDetails("Recrutées par l’agence");

        results.add(Partenaires);
        results.add(Partenaires1);
        results.add(Partenaires2);
        results.add(Partenaires3);
        results.add(Partenaires4);

        return results;
    }

    public static ArrayList<Partenaires> searchFakeData(String query) {
        query = query.toLowerCase();

        ArrayList<Partenaires> results = new ArrayList<>();

        ArrayList<Partenaires> Partenaires = Models.Partenaires.fromFakeData();

        for (Partenaires s: Partenaires) {

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

    public Partenaires(JSONObject jsonObject) throws JSONException
    {
        this.title = jsonObject.getString("title");
        this.details = jsonObject.getString("details");

    }

    public Partenaires(String title) {
        this.title = title;
    }

    public static ArrayList<Partenaires> fromJSONArray (JSONArray array)
    {
        ArrayList<Partenaires> results = new ArrayList<>();
        for (int x= 0; x < array.length(); x++)
        {
            try
            {
                results.add(new Partenaires(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }*/
}
