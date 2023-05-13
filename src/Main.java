import Controleur.controleur;
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

        controleur controleur1 = new controleur(fenetreprincipale);
        fenetreprincipale.setVisible(true);


    }
}

