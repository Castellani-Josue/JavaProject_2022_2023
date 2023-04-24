package Utilisateur;

import java.util.ArrayList;

public class client extends Personne
{
    private String Telephone;

    private ArrayList<String> Preference =  new ArrayList<String>();

    //private  int IdClient;

    public client()
    {
        String Telephone = " ";

    }
    public client(String nomPersonne, String prenomPersonne, String login, String motDePasse, String telephone , String preference)
    {
        super(nomPersonne, prenomPersonne, login, motDePasse);
        Telephone = telephone;
        Preference.add(preference);

    }

    public String getTelephone()
    {
        return Telephone;
    }

    public void setTelephone(String telephone)
    {
        Telephone = telephone;
    }

    public ArrayList<String> getPreference()
    {
        return Preference;
    }

    public void setPreference(ArrayList<String> preference)
    {
        Preference = preference;
    }


    public void ResetMotDePasse()
    {
        if(MotDePasse != null)
        {
            MotDePasse = null;
        }
    }

    @Override
    public String toString()
    {
        return "client{" +
                "Nompersonne='" + Nompersonne + '\'' +
                ", PrenomPersonne='" + PrenomPersonne + '\'' +
                ", Login='" + Login + '\'' +
                ", MotDePasse='" + MotDePasse + '\'' +
                ",Telephone='" + Telephone + '\'' +
                ",Preference=" + Preference + '\'' +
                '}';
    }



    @Override
    public  void affiche()
    {

        System.out.println(toString());

    }


}
