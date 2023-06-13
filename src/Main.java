import Controleur.controleur;
import InterfaceGraphique.*;
import Serialisation.Serializer;
import Singleton.ListeOeuvre;
import Utilisateur.client;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    private  static   ListeOeuvre listeOeuvre;
    public static void main(String[] args)
    {
        FlatLaf.install(new FlatDarculaLaf());
        ListeOeuvre.getInstance().Deserializer("C:\\Users\\josue\\Java_Project_2022_2023\\JavaProject\\Fichier");
        InterfacePrincipale fenetreprincipale= new InterfacePrincipale();
        fenetreprincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
        fenetreprincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
        fenetreprincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
        fenetreprincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
        InterfaceCreate_Account fenetreCreate = new InterfaceCreate_Account(fenetreprincipale, true, "Create Account");
        InterfaceFilmSerieAnime fenF = new InterfaceFilmSerieAnime(fenetreprincipale,true,"Ajout Oeuvre");
        InterfaceConnection fenC = new InterfaceConnection(fenetreprincipale,true,"dc");
        InformationOeuvre fenI = new InformationOeuvre(fenetreprincipale,true,"informations");
        InterfaceFavoris fenFav = new InterfaceFavoris(fenetreprincipale,true,"Informations favoris");
        controleur controleur1 = new controleur(fenetreprincipale,fenC , fenetreCreate ,fenF,fenI,fenFav);
        //ListeOeuvre.getInstance().Deserializer("Mesdonnees.dat");
        fenetreprincipale.setControleur(controleur1);
        fenetreCreate.setControleur(controleur1);
        fenC.setControleur(controleur1);
        fenF.setControleur(controleur1);
        fenFav.setControleur(controleur1);
        ListeOeuvre.getInstance().addPropertyChangeListener(controleur1);

        //ListeOeuvre.getInstance().Deserializer("Mesdonnees.dat");
        /*if(new File("Mesdonnees.data").exists())
        {
            ListeOeuvre.getInstance().Deserializer("Mesdonnees.data");
            System.out.println("ça fonctionne aussi");
        }*/

        fenetreprincipale.setVisible(true);




    }
}

