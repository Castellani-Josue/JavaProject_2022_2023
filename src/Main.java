import Controleur.controleur;
import InterfaceGraphique.InterfaceConnection;
import InterfaceGraphique.InterfaceCreate_Account;
import InterfaceGraphique.InterfaceFilmSerieAnime;
import InterfaceGraphique.InterfacePrincipale;
import Utilisateur.client;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {

        InterfacePrincipale fenetreprincipale= new InterfacePrincipale();
        InterfaceCreate_Account fenetreCreate = new InterfaceCreate_Account(null, true, "Create Account");
        InterfaceFilmSerieAnime fenF = new InterfaceFilmSerieAnime(null,true,"Ajout Oeuvre");
        InterfaceConnection fenC = new InterfaceConnection(null,true,"dc");
        controleur controleur1 = new controleur(fenetreprincipale,fenC , fenetreCreate ,fenF);
        fenetreprincipale.setControleur(controleur1);
        fenetreCreate.setControleur(controleur1);
        fenC.setControleur(controleur1);
        fenF.setControleur(controleur1);
        fenetreprincipale.setVisible(true);





    }
}

