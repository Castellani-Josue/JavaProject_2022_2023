package Singleton;

import TypeOeuvre.Anime;
import TypeOeuvre.Film;
import TypeOeuvre.Serie;
import TypeOeuvre.Trailer;

import java.util.ArrayList;

public class ListeOeuvre
{
   //Ces listes permettent de stocker toutes les œuvres de chaque type dans une liste ordonnée et d'y accéder facilement.
    private ArrayList<Film> listeFilm = new ArrayList<Film>();
    private ArrayList<Serie> listeSerie = new ArrayList<Serie>();
    private ArrayList<Anime> listeAnime = new ArrayList<Anime>();
    private ArrayList<Trailer> listeTrailer = new ArrayList<Trailer>();

    //utilisateur à rajouter
    private static ListeOeuvre instance = null;

    private ListeOeuvre()
    {
        //constructeur privé pour empêcher l'instanciation directe de la classe
    }
    public static ListeOeuvre getInstance() //verif si instance existe deja si non ça cree et permet qu'1 instance share aux clients
    {
        if(instance == null)
            instance = new ListeOeuvre();
        return instance;
    }
}
