package Controleur;

import InterfaceGraphique.InterfaceConnection;
import InterfaceGraphique.InterfaceCreate_Account;
import InterfaceGraphique.InterfaceFilmSerieAnime;
import InterfaceGraphique.InterfacePrincipale;
import Utilisateur.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class controleur extends Component implements ActionListener, WindowListener
{

    private InterfacePrincipale fenetrePrincipale;

    private client cli;

    public controleur(InterfacePrincipale fenetrePrincipale)
    {
        this.fenetrePrincipale = fenetrePrincipale;
        this.fenetrePrincipale.setControleur(this);
        this.cli = new client();
        //this.controleurCreationCompte = new controleurCreateAcc();
    }



    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Se connecter")) {
            InterfaceConnection interfaceConnection = new InterfaceConnection(null, true, "Entrée en session...");
            interfaceConnection.setVisible(true);
            if (interfaceConnection.isConfirmer()) {
                System.out.println("Login = " + interfaceConnection.getLogin());
                System.out.println("Mot de passe = " + interfaceConnection.getMotDePasse());
                setInteractionsEnabled(true);
            }
            interfaceConnection.dispose();
        } else if (e.getActionCommand().equals("Créer un compte")) {
            InterfaceCreate_Account fenetreCreationCompte = new InterfaceCreate_Account(null, true, "Session de création");
            fenetreCreationCompte.setVisible(true);
            if (fenetreCreationCompte.isConfirmer()) {
                System.out.println("Nom = " + fenetreCreationCompte.getNompersonne());
                System.out.println("Prenom = " + fenetreCreationCompte.getPrenomPersonne());
                System.out.println("N° de telephone = " + fenetreCreationCompte.getTelephone());
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
        else if (e.getActionCommand().equals("Reset mot de passe"))
        {
            cli.ResetMotDePasse();
            JOptionPane.showMessageDialog(this,"Mot de passe a été reset","ResetMotDePasse",JOptionPane.INFORMATION_MESSAGE,null);
        }

    }


    public void setInteractionsEnabled(boolean enabled) {
        fenetrePrincipale.setEnabled(enabled);

        //fenetrePrincipale.getSeConnecterButton().setEnabled(enabled);
        //fenetrePrincipale.getCreerCompteButton().setEnabled(enabled);


    }

    public void windowClosing(WindowEvent we) { System.exit(0); }

    public void windowOpened(WindowEvent we) {}
    public void windowClosed(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent we) {}
}
