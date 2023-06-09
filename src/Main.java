import Controleur.controleur;
import InterfaceGraphique.*;
import Serialisation.Serializer;
import Singleton.ListeOeuvre;
import Utilisateur.client;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    private ListeOeuvre listeOeuvre;
    public static void main(String[] args)
    {

        InterfacePrincipale fenetreprincipale= new InterfacePrincipale();
        InterfaceCreate_Account fenetreCreate = new InterfaceCreate_Account(fenetreprincipale, true, "Create Account");
        InterfaceFilmSerieAnime fenF = new InterfaceFilmSerieAnime(fenetreprincipale,true,"Ajout Oeuvre");
        InterfaceConnection fenC = new InterfaceConnection(fenetreprincipale,true,"dc");
        InformationOeuvre fenI = new InformationOeuvre(fenetreprincipale,true,"informations");
        controleur controleur1 = new controleur(fenetreprincipale,fenC , fenetreCreate ,fenF,fenI);
        //ListeOeuvre listeOeuvre1 = ListeOeuvre.
        fenetreprincipale.setControleur(controleur1);
        fenetreCreate.setControleur(controleur1);
        fenC.setControleur(controleur1);
        fenF.setControleur(controleur1);
        fenetreprincipale.setVisible(true);
        if(new File("Oeuvre.bin").exists())
        {
            Serializer.deserializeObjectOeuvre("Oeuvre.bin");
            System.out.println("ça fonctionne");
        }
        if(new File("Personne.bin").exists())
        {
            Serializer.deserializeObjectPersonne("Personne.bin");
            System.out.println("ça fonctionne aussi");
        }






    }
}

