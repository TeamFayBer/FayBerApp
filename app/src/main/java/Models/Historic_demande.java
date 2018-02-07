package Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ingdjason on 2/7/18.
 */

public class Historic_demande implements Serializable {
    String id_demande;
    String naissance_user_demande;
    String lieu_naissance_user_demande;
    String sexe_user_demande;
    String occupation_user_demande;
    String personn_user_demande;
    String relation_personn_demande;
    String gsanguin_user_demande;
    String description_demande;
    String nom_client;
    String tit_liste;
    String telephone_client;
    String created;

    public Historic_demande() {
    }

    public String getId_demande() {
        return id_demande;
    }

    public void setId_demande(String id_demande) {
        this.id_demande = id_demande;
    }

    public String getNaissance_user_demande() {
        return naissance_user_demande;
    }

    public void setNaissance_user_demande(String naissance_user_demande) {
        this.naissance_user_demande = naissance_user_demande;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLieu_naissance_user_demande() {
        return lieu_naissance_user_demande;
    }

    public void setLieu_naissance_user_demande(String lieu_naissance_user_demande) {
        this.lieu_naissance_user_demande = lieu_naissance_user_demande;
    }

    public String getSexe_user_demande() {
        return sexe_user_demande;
    }

    public void setSexe_user_demande(String sexe_user_demande) {
        this.sexe_user_demande = sexe_user_demande;
    }

    public String getOccupation_user_demande() {
        return occupation_user_demande;
    }

    public void setOccupation_user_demande(String occupation_user_demande) {
        this.occupation_user_demande = occupation_user_demande;
    }

    public String getPersonn_user_demande() {
        return personn_user_demande;
    }

    public void setPersonn_user_demande(String personn_user_demande) {
        this.personn_user_demande = personn_user_demande;
    }

    public String getRelation_personn_demande() {
        return relation_personn_demande;
    }

    public void setRelation_personn_demande(String relation_personn_demande) {
        this.relation_personn_demande = relation_personn_demande;
    }

    public String getGsanguin_user_demande() {
        return gsanguin_user_demande;
    }

    public void setGsanguin_user_demande(String gsanguin_user_demande) {
        this.gsanguin_user_demande = gsanguin_user_demande;
    }

    public String getDescription_demande() {
        return description_demande;
    }

    public void setDescription_demande(String description_demande) {
        this.description_demande = description_demande;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getTit_liste() {
        return tit_liste;
    }

    public void setTit_liste(String tit_liste) {
        this.tit_liste = tit_liste;
    }

    public String getTelephone_client() {
        return telephone_client;
    }

    public void setTelephone_client(String telephone_client) {
        this.telephone_client = telephone_client;
    }

    public Historic_demande(JSONObject jsonObject) throws JSONException
    {
        this.id_demande = jsonObject.getString("id_demande");
        this.naissance_user_demande = jsonObject.getString("naissance_user_demande");
        this.lieu_naissance_user_demande = jsonObject.getString("lieu_naissance_user_demande");
        this.sexe_user_demande = jsonObject.getString("sexe_user_demande");
        this.occupation_user_demande = jsonObject.getString("occupation_user_demande");
        this.personn_user_demande = jsonObject.getString("personn_user_demande");
        this.relation_personn_demande = jsonObject.getString("relation_personn_demande");
        this.gsanguin_user_demande = jsonObject.getString("gsanguin_user_demande");
        this.description_demande = jsonObject.getString("description_demande");
        this.nom_client = jsonObject.getString("nom_client");
        this.tit_liste = jsonObject.getString("tit_liste");
        this.telephone_client = jsonObject.getString("telephone_client");
        this.created = jsonObject.getString("created");

    }

    public static ArrayList<Historic_demande> fromJSONArray (JSONArray array)
    {
        ArrayList<Historic_demande> results = new ArrayList<>();
        for (int x= 0; x < array.length(); x++)
        {
            try
            {
                results.add(new Historic_demande(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
    
}
