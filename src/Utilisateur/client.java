package Utilisateur;

import java.util.ArrayList;
public class client extends Personne
{
    private String Telephone;
    private ArrayList<String> Preference =  new ArrayList<String>();
    private ArrayList<ListeFavoris> oeuvreFavorite;

    public client()
    {
        String Telephone = " ";

    }
    public client(String nomPersonne, String prenomPersonne, String login, String motDePasse, String telephone , String preference, ArrayList<ListeFavoris> l, int id)
    {
        super(nomPersonne, prenomPersonne, login, motDePasse,id);
        Telephone = telephone;
        Preference.add(preference);
        oeuvreFavorite = l;
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

    public void setFavoris ()
    {

    }

    public void ajoutFavoris(int test)
    {
        ListeFavoris Test = new ListeFavoris(test);
        oeuvreFavorite.add(Test);
        System.out.println(this.toString());
    }

    public void ResetMotDePasse()
    {
        if(MotDePasse != null)
        {
            MotDePasse = null;
        }
    }

    @Override
    public String toString() {
        return "client{" +
                "Telephone='" + Telephone + '\'' +
                ", Preference=" + Preference +
                ", oeuvreFavorite=" + oeuvreFavorite +
                ", Nompersonne='" + Nompersonne + '\'' +
                ", PrenomPersonne='" + PrenomPersonne + '\'' +
                ", Identifiant = '" + identifiant +
                ", Login='" + Login + '\'' +
                ", MotDePasse='" + MotDePasse + '\'' +
                '}';
    }


    @Override
    public  void affiche()
    {

        System.out.println(toString());

    }

    public static boolean isValidPassword(String motDePasse)
    {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}$";
        return motDePasse.matches(passwordRegex);
    }

    public static boolean isValidLogin(String login)
    {

        return login.length() >= 5;
    }

    public static boolean isValidTelephone(String telephone)
    {
        // Utilisation d'une expression régulière pour vérifier l'encodage du numéro de téléphone
        String regex = "^\\+32 \\(\\d{3}\\) \\d{3}-\\d{4}$";
        return telephone.matches(regex);
    }

    public static void main(String[] args)
    {
        ArrayList<ListeFavoris> test1 = new ArrayList<>();
        ListeFavoris test2 = new ListeFavoris(9);
        ListeFavoris test3 = new ListeFavoris(45);
        ListeFavoris test4 = new ListeFavoris(36);
        test1.add(test2);
        test1.add(test3);
        test1.add(test4);
        client client1= new client("Castellani", "Josue", "Sparkwillo", "Jcast05","0479/044211" ,"Horreur", test1,145398);
        //System.out.println(client1.toString());
        client1.ajoutFavoris(200);
    }
}