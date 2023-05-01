package Utilisateur;
public class Administrateur extends Personne
{

    //Ajoiuteer dans classe métier "AfficherOeuvre"
    public void AjouterOeuvre()
    {
        
    }

    public Administrateur(String nomPersonne,String prenomPersonne,String login,String motDePasse)
    {
        super(nomPersonne, prenomPersonne, login, motDePasse);

    }



    @Override
    public String toString()
    {
        return "Administrateur{" +
                "Nompersonne='" + Nompersonne + '\'' +
                ", PrenomPersonne='" + PrenomPersonne + '\'' +
                ", Login='" + Login + '\'' +
                ", MotDePasse='" + MotDePasse + '\'' +
                '}';
    }

    @Override
    public void affiche()
    {
        System.out.println(toString());

    }

    public static void main(String[] args)
    {
        Administrateur admin= new Administrateur("Castellani", "Josue", "Sparkwillo", "Jcast05");
        System.out.println(admin.toString());
    }



}
