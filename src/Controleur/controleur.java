package Controleur;

import InterfaceGraphique.InterfaceConnection;
import InterfaceGraphique.InterfaceCreate_Account;
import InterfaceGraphique.InterfaceFilmSerieAnime;
import InterfaceGraphique.InterfacePrincipale;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.*;

public class controleur implements ActionListener, WindowListener
{

    private InterfacePrincipale fenetrePrincipale;

    public controleur(InterfacePrincipale fenetrePrincipale) {
        this.fenetrePrincipale = fenetrePrincipale;
        this.fenetrePrincipale.setControleur(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Se connecter")) {
            InterfaceConnection interfaceConnection = new InterfaceConnection(null, true, "Entrée en session...");
            interfaceConnection.setVisible(true);
            if (interfaceConnection.isConfirmer()) {
                System.out.println("Login = " + interfaceConnection.getLogin());
                System.out.println("Mot de passe = " + interfaceConnection.getMotDePasse());
            }
            interfaceConnection.dispose();
        } else if (e.getActionCommand().equals("Créer un compte")) {
            InterfaceCreate_Account fenetreCreationCompte = new InterfaceCreate_Account(null, true, "Session de connexion");
            fenetreCreationCompte.setVisible(true);
            if (fenetreCreationCompte.isConfirmer()) {
                System.out.println("Login = " + fenetreCreationCompte.getLogin());
                System.out.println("Mot de passe = " + fenetreCreationCompte.getMotDePasse());
            }
            fenetreCreationCompte.dispose();
        } else if (e.getActionCommand().equals("Film")) {
            InterfaceFilmSerieAnime fenetreFilm = new InterfaceFilmSerieAnime();
            fenetreFilm.setVisible(true);
        }
        else if (e.getActionCommand().equals("Anime")) {
            InterfaceFilmSerieAnime fenetreFilm = new InterfaceFilmSerieAnime();
            fenetreFilm.setVisible(true);
        }
        else if (e.getActionCommand().equals("Série")) {
            InterfaceFilmSerieAnime fenetreFilm = new InterfaceFilmSerieAnime();
            fenetreFilm.setVisible(true);
        }
        else if (e.getActionCommand().equals("Trailer")) {
            InterfaceFilmSerieAnime fenetreFilm = new InterfaceFilmSerieAnime();
            fenetreFilm.setVisible(true);
        }

    }


    public void windowClosing(WindowEvent we) { System.exit(0); }

    public void windowOpened(WindowEvent we) {}
    public void windowClosed(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent we) {}
}
