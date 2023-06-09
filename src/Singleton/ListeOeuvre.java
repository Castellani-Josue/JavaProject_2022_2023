package Singleton;

import TypeOeuvre.Anime;
import TypeOeuvre.Film;
import TypeOeuvre.Serie;
import TypeOeuvre.Trailer;
import Utilisateur.Administrateur;
import Utilisateur.client;

import java.io.Serializable;
import java.util.ArrayList;

public class ListeOeuvre implements Serializable
{
    private static final long serialVersionUID = 1L;
    private ArrayList<Film> listeFilm = new ArrayList<Film>();
    private ArrayList<Serie> listeSerie = new ArrayList<Serie>();
    private ArrayList<Anime> listeAnime = new ArrayList<Anime>();
    private ArrayList<Trailer> listeTrailer = new ArrayList<Trailer>();

    private ArrayList<client> listeClient = new ArrayList<client>();

    private ArrayList<Administrateur> listeAdmin = new ArrayList<Administrateur>();
    private Administrateur AdminCourant = null;
    private client ClientCourant = null;





    //utilisateur à rajouter
    private static ListeOeuvre instance = null;

    private ListeOeuvre()
    {
        //constructeur privé pour empêcher l'instanciation directe de la classe
    }
    public static ListeOeuvre getInstance()
    {
        if(instance == null)
            instance = new ListeOeuvre();
        return instance;
    }



    public ArrayList<client> getInstanceClient()
    {
        return listeClient;
    }

    public client getClientCourant()
    {
        return ClientCourant;
    }

    public Administrateur getAdminCourant()
    {
        return AdminCourant;
    }


    public  client rechercherLoginClient(ArrayList<client> listeClient,String loginRecherche)
    {
        for(client clientrch : listeClient)
        {
            if(clientrch.getLogin().equals(loginRecherche))
            {
                return clientrch;
            }
        }

        return null;
    }

    public  client rechercherMdpClient(ArrayList<client> listeClient,String mdpRecherche)
    {
        for(client clientrch : listeClient)
        {
            if(clientrch.getMotDePasse().equals(mdpRecherche))
            {
                return clientrch;
            }
        }

        return null;
    }

    public  Administrateur rechercherMdpAdmin(ArrayList<Administrateur> listeAdmin,String mdpRecherche)
    {
        for(Administrateur AdminRch : listeAdmin)
        {
            if(AdminRch.getMotDePasse().equals(mdpRecherche))
            {
                return AdminRch;
            }
        }

        return null;
    }

    public  Administrateur rechercherLoginAdmin(ArrayList<Administrateur> listeAdmin,String LoginRecherche)
    {
        for(Administrateur AdminRch : listeAdmin)
        {
            if(AdminRch.getLogin().equals(LoginRecherche))
            {
                return AdminRch;
            }
        }

        return null;
    }

    public ArrayList<Administrateur> getInstanceAdmin()
    {
        return listeAdmin;
    }


    public ArrayList<Film> getInstanceFilm() {
        return listeFilm;
    }

    public ArrayList<Anime> getInstanceAnime(){
        return listeAnime;
    }

    public ArrayList<Serie> getInstanceSerie(){
        return listeSerie;
    }

    public ArrayList<Trailer> getInstanceTrailer(){
        return listeTrailer;
    }

    public void AffichageClient()
    {
        for (client clienttmp : listeClient)
        {
            System.out.println("Nom :" + clienttmp.getNompersonne() + "Prenom : " + clienttmp.getNompersonne() + "LOgin : " + clienttmp.getLogin() + "Mdp :" + clienttmp.getMotDePasse() + "Tel : " + clienttmp.getTelephone() + "Pref : "+ clienttmp.getPreference()+ "Id :" + clienttmp.getIdentifiant());
        }
    }

    public void AffichageClientCourant()
    {
        System.out.println(ClientCourant.toString());
    }

    public void AffichageAdminCourant()
    {
        System.out.println(AdminCourant.toString());
    }

    public void ajouterFilm(Film film)
    {

        listeFilm.add(film);
    }

    public void ajouterSerie(Serie serie) {
        listeSerie.add(serie);
    }

    public void ajouterAnime(Anime anime) {
        listeAnime.add(anime);
    }

    public void ajouterTrailer(Trailer trailer) {
        listeTrailer.add(trailer);
    }

    public void ajouterClient(client client1) {listeClient.add(client1);}

    public void ajoutClientCourant(client clienttmp){ClientCourant =clienttmp;}


    public void ajouterAdmin( Administrateur administrateur) {listeAdmin.add(administrateur);}

    public void ajoutAdminCourant(Administrateur administrateurtmp){AdminCourant = administrateurtmp;}

    public void DeconnectClient()
    {
        if(ClientCourant != null)
        {
            ClientCourant = null;
        }

    }

    public void DeconnectAdmin()
    {
        if(AdminCourant != null)
        {
            AdminCourant = null;
        }

    }

    //Cela permet de garantir qu'une nouvelle instance n'est pas créée lors de la désérialisation.
    protected Object readResolve() {
        return getInstance();
    }


}