package Controleur;

import InterfaceGraphique.InterfaceConnection;
import InterfaceGraphique.InterfaceCreate_Account;
import InterfaceGraphique.InterfaceFilmSerieAnime;
import InterfaceGraphique.InterfacePrincipale;
import Singleton.ListeOeuvre;
import TypeOeuvre.*;
import Utilisateur.Administrateur;
import Utilisateur.client;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class controleur extends Component implements ActionListener, WindowListener , ListDataListener
{

    private InterfacePrincipale fenetrePrincipale;

    private InterfaceConnection fenetreConnexion;

    private  InterfaceCreate_Account fenetreCreationCompte;

    private InterfaceFilmSerieAnime fenetreFilm;

    private  ListeOeuvre InstanceCourante;

    private  String Genre;

    private String Preference;


    private  int Pegi;

    private  boolean Confirmer;


    private client cli;

    public controleur(InterfacePrincipale fp,InterfaceConnection fc ,InterfaceCreate_Account fcr ,  InterfaceFilmSerieAnime fA )
    {

        //InstanceCourante = ListeOeuvre.getInstance();
        fenetrePrincipale = fp;
        fenetreFilm = fA;
        fenetreConnexion = fc;
        fenetreCreationCompte = fcr;

    }
    public void contentsChanged(ListDataEvent e)
    {

    }



    public void actionPerformed(ActionEvent e) {

        System.out.println("Hello");
        if (e.getActionCommand().equals("Se connecter")) {
            //fenetreConnexion = new InterfaceConnection(null, true, "Entrée en session...");
            fenetreConnexion.setVisible(true);

            fenetreConnexion.dispose();
        } else if (e.getActionCommand().equals("Créer un compte")) {
            //fenetreCreationCompte = new InterfaceCreate_Account(null, true, "Session de création");
            fenetreCreationCompte.setVisible(true);

            fenetreCreationCompte.dispose();


            } else if (e.getActionCommand().equals("Film")) {
            fenetreFilm.setTitle("Film");
            fenetreFilm.setVisible(true);
            System.out.println("Bonjour");

            fenetreFilm.dispose();

            } else if (e.getActionCommand().equals("Anime")) {
            fenetreFilm.setTitle("Anime");
            fenetreFilm.setVisible(true);

            fenetreFilm.dispose();


            } else if (e.getActionCommand().equals("Série")) {
                fenetreFilm.setTitle("Serie");
                fenetreFilm.setVisible(true);


                fenetreFilm.dispose();
            } else if (e.getActionCommand().equals("Trailer")) {
                fenetreFilm.setTitle("Trailer");
                fenetreFilm.setVisible(true);

                fenetreFilm.dispose();
            } else if (e.getActionCommand().equals("Reset mot de passe")) {
                //ResetMotDePasse();
                JOptionPane.showMessageDialog(this, "Mot de passe a été reset", "ResetMotDePasse", JOptionPane.INFORMATION_MESSAGE, null);
            }
            else if (e.getActionCommand().equals("CONFIRMER")) {
                System.out.println("Bonsoir");

            Pegi = 0;
            Genre = String.valueOf(false);
            String id = fenetreFilm.getId().getText();
            int id2 = Integer.parseInt(id);
            String Titre = fenetreFilm.getTitre().getText();
            String description = fenetreFilm.getDescription().getText();
            String Duree = fenetreFilm.getDuree().getText();
            int duree = Integer.parseInt(Duree);
            String editeur = fenetreFilm.getEditeur().getText();
            String audio = fenetreFilm.getAudio().getText();
            String Soustitre = fenetreFilm.getSoustitre().getText();
            String dateSaisie = fenetreFilm.getDate().getText();
            LocalDate date = LocalDate.parse(dateSaisie, DateTimeFormatter.ISO_LOCAL_DATE);

            if (fenetreFilm.getPegi10Button().isSelected()) {


                Pegi = 14;
            } else if (fenetreFilm.getPegi12Button().isSelected()) {


                Pegi = 12;
            } else if (fenetreFilm.getPegi16Button().isSelected()) {


                Pegi = 16;
            } else if (fenetreFilm.getPegi18Button().isSelected()) {


                Pegi = 18;
            } else {


                Pegi = 0;

            }

            if (fenetreFilm.getGenreSF().isSelected()) {
                Genre = "Science Fiction";

            } else if (fenetreFilm.getGenreAction().isSelected()) {
                Genre = "Action";
            } else if (fenetreFilm.getGenreAventure().isSelected()) {
                Genre = "Aventure";
            }
            else if (fenetreFilm.getGenreHorreur().isSelected()) {
                Genre = "Horreur";
            } else if (fenetreFilm.getGenreDrame().isSelected()) {
                Genre = "Drame";
            } else {
                Genre = String.valueOf(false);
            }

            if(fenetreFilm.getTitle().equals("Film"))
            {
                Film filmtemporaire = new Film(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(filmtemporaire.toString());
                ListeOeuvre.getInstance().ajouterFilm(filmtemporaire);

            }
            else if(fenetreFilm.getTitle().equals("Anime"))
            {
                Anime Animetempo = new Anime(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(Animetempo.toString());
                ListeOeuvre.getInstance().ajouterAnime(Animetempo);

            }
            else if(fenetreFilm.getTitle().equals("Serie"))
            {
                Serie serietemporaire = new Serie(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(serietemporaire.toString());
                ListeOeuvre.getInstance().ajouterSerie(serietemporaire);

            }
            else if(fenetreFilm.getTitle().equals("Trailer"))
            {
                Trailer trailertempo = new Trailer(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(trailertempo.toString());
                ListeOeuvre.getInstance().ajouterTrailer(trailertempo);
            }

            //fenetreFilm.dispose();

        }
        else if (e.getActionCommand().equals("Creer")) {
            //+32 (123) 456-7890
            System.out.println("création");
            String login = fenetreCreationCompte.getLogin().getText();
            boolean isValidLogin = client.isValidLogin(login);
            String motDePasse = String.valueOf(fenetreCreationCompte.getMotDePasse().getPassword());
            boolean isValidPassword = client.isValidPassword(motDePasse);
            String Nompersonne = fenetreCreationCompte.getNompersonne().getText();
            String PrenomPersonne = fenetreCreationCompte.getPrenomPersonne().getText();
            String Telephone = fenetreCreationCompte.getTelephone().getText();
            boolean isValidTelephone = client.isValidTelephone(Telephone);


            if (fenetreCreationCompte.getGenreSF().isSelected()) {
                Preference = "Science Fiction";

            } else if (fenetreCreationCompte.getGenreAction().isSelected()) {
                Preference = "Action";
            } else if (fenetreCreationCompte.getGenreAventure().isSelected()) {
                Preference = "Aventure";
            }
            else if (fenetreCreationCompte.getGenreHorreur().isSelected()) {
                Preference = "Horreur";
            } else if (fenetreCreationCompte.getGenreDrame().isSelected()) {
                Preference = "Drame";
            }

            if (isValidLogin && isValidPassword && isValidTelephone) {


                if(motDePasse.equals("Admin1"))
                {
                    Administrateur AdminTempo = new Administrateur(Nompersonne,PrenomPersonne,login,motDePasse,1);
                    System.out.println(AdminTempo.toString());
                    ListeOeuvre.getInstance().ajouterAdmin(AdminTempo);
                    fenetreCreationCompte.setVisible(false);

                }
                else
                {
                    client clienttempo = new client(Nompersonne,PrenomPersonne,login,motDePasse,Telephone,Preference,null,6);
                    System.out.println((clienttempo.toString()));
                    ListeOeuvre.getInstance().ajouterClient(clienttempo);
                    ListeOeuvre.getInstance().AffichageClient();
                    fenetreCreationCompte.setVisible(false);

                }

            } else {
                //System.out.println("Erreur(s) d'encodation");
                if (!isValidLogin && isValidPassword) {
                    JOptionPane.showMessageDialog(fenetreCreationCompte, "login incorrect", "Erreur(s) d'encodation", JOptionPane.INFORMATION_MESSAGE, null);
                    fenetreCreationCompte.setVisible(true);
                } else if (!isValidPassword && isValidLogin) {
                    JOptionPane.showMessageDialog(fenetreCreationCompte, "Password incorrect", "Erreur(s) d'encodation", JOptionPane.INFORMATION_MESSAGE, null);
                    fenetreCreationCompte.setVisible(true);
                } else if (!isValidTelephone) {
                    JOptionPane.showMessageDialog(fenetreCreationCompte, "N° telephone incorrect", "Erreur(s) d'encodation", JOptionPane.INFORMATION_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(fenetreCreationCompte, "Login et password incorect", "Erreur(s) d'encodation", JOptionPane.INFORMATION_MESSAGE, null);
                    fenetreCreationCompte.setVisible(true);
                }

            }
        }
        else if (e.getActionCommand().equals("Connexion")) {
            System.out.println("connexion");
            String login = fenetreConnexion.getLogin().getText();
            boolean isValidLogin = client.isValidLogin(login);
            String motDePasse = Arrays.toString(fenetreConnexion.getMotDePasse().getPassword());
            boolean isValidPassword = client.isValidPassword(motDePasse);


            if (isValidLogin && isValidPassword) {

                fenetreConnexion.setVisible(false);
            } else {
                //System.out.println("Erreur(s) d'encodation");
                if (!isValidLogin && isValidPassword) {
                    JOptionPane.showMessageDialog(fenetreConnexion, "login incorrect", "Erreur d'authentification", JOptionPane.INFORMATION_MESSAGE, null);
                    fenetreConnexion.setVisible(true);
                } else if (!isValidPassword && isValidLogin) {
                    JOptionPane.showMessageDialog(fenetreConnexion, "Password incorrect", "Erreur d'authentification", JOptionPane.INFORMATION_MESSAGE, null);
                    fenetreConnexion.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(fenetreConnexion, "Login et password incorect", "Erreur d'authentification", JOptionPane.INFORMATION_MESSAGE, null);
                    fenetreConnexion.setVisible(true);
                }
            }
            //setInteractionsEnabled(true);
        }

        }

    public void windowClosing(WindowEvent we) { System.exit(0); }

    public void windowOpened(WindowEvent we) {}
    public void windowClosed(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent we) {}

    public void intervalAdded(ListDataEvent e) {}

    @Override
    public void intervalRemoved(ListDataEvent e) {}




}
