import Controleur.controleur;
import Controleur.controleurCreateAcc;
import InterfaceGraphique.InterfaceConnection;
import InterfaceGraphique.InterfaceCreate_Account;
import InterfaceGraphique.InterfaceFilmSerieAnime;
import InterfaceGraphique.InterfacePrincipale;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {

        InterfacePrincipale fenetreprincipale= new InterfacePrincipale();
        //InterfaceCreate_Account fenetreCreate = new InterfaceCreate_Account(null, true, "Session de connexion");


        controleur controleur1 = new controleur(fenetreprincipale);
        fenetreprincipale.setVisible(true);




    }
}

