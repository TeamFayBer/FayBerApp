package Models;

import android.text.TextUtils;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

import codepath.fayberapp.R;

public class Equipe implements Serializable {

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



    public Equipe() {
    }

    public static ArrayList<Equipe> fromFakeData()
    {
        ArrayList<Equipe> results = new ArrayList<>();

        Equipe Equipe = new Equipe();
        Equipe.setImage(R.drawable.berimage);
        Equipe.setTitle("Bertrand SALOMON");
        Equipe.setDetails("Fondateur, directeur administratif et marketing de Fay&Ber\n" +
                " Gestionnaire public et privé, Gestionnaire d'opérations clientèles à ECONOSURANCE Inc. de Boston, Haïti étant.");
        //
        Equipe Equipe3 = new Equipe();
        Equipe3.setImage(R.drawable.fayimage);
        Equipe3.setTitle("Marie Faydie CELAN");
        Equipe3.setDetails(" Fondatrice, directrice des soins de Fay&Ber\n" +
                " Infirmière spécialisée en maladies infectieuses,  professeur, directrice des soins infirmiers à  Saint François de Sales.");
        //
        Equipe Equipe1 = new Equipe();
        Equipe1.setImage(R.drawable.corimage);
        Equipe1.setTitle("Chantal CORRIOLAND");
        Equipe1.setDetails("Assistante directrice des soins de Fay&Ber\n" +
                " Infirmière spécialisée en maladie infectieuse,  professeur, chef de service SOP à  Saint François de Sales.");
        //
        Equipe Equipe2 = new Equipe();
        Equipe2.setImage(R.drawable.jerimage);
        Equipe2.setTitle("Jerry BAZILE");
        Equipe2.setDetails("Responsable partenariat et relation entre médecins traitants \n" +
                "et/ou associations de médecins et FAY&BER. \n" +
                "* Docteur Obstétricien, Gynécologue spécialisé en infertilité. ");
        //
        Equipe Equipe4 = new Equipe();
        Equipe4.setImage(R.drawable.nurse);
        Equipe4.setTitle("INFIRMIERES LICENCIEES");
        Equipe4.setDetails("Recrutées par l’agence");

        results.add(Equipe);
        results.add(Equipe1);
        results.add(Equipe2);
        results.add(Equipe3);
        results.add(Equipe4);

        return results;
    }
    /*
    public static ArrayList<Equipe> searchFakeData(String query) {
        query = query.toLowerCase();

        ArrayList<Equipe> results = new ArrayList<>();

        ArrayList<Equipe> Equipe = Models.Equipe.fromFakeData();

        for (Equipe s: Equipe) {

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

    public Equipe(JSONObject jsonObject) throws JSONException
    {
        this.title = jsonObject.getString("title");
        this.details = jsonObject.getString("details");

    }

    public Equipe(String title) {
        this.title = title;
    }

    public static ArrayList<Equipe> fromJSONArray (JSONArray array)
    {
        ArrayList<Equipe> results = new ArrayList<>();
        for (int x= 0; x < array.length(); x++)
        {
            try
            {
                results.add(new Equipe(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }*/
}
