package Controleur;

import InterfaceGraphique.InterfaceConnection;
import InterfaceGraphique.InterfaceCreate_Account;
import InterfaceGraphique.InterfaceFilmSerieAnime;
import InterfaceGraphique.InterfacePrincipale;
import Singleton.ListeOeuvre;
import TypeOeuvre.Film;
import Utilisateur.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class controleur extends Component implements ActionListener, WindowListener
{

    private InterfacePrincipale fenetrePrincipale;

    private InterfaceConnection fenetreConnexion;

    private  InterfaceCreate_Account fenetreCreationCompte;

    private InterfaceFilmSerieAnime fenetreFilm;



    private  String Genre;
    private  int Pegi;

    private  boolean Confirmer;


    private client cli;

    public controleur(InterfacePrincipale fp,InterfaceConnection fc ,InterfaceCreate_Account fcr ,  InterfaceFilmSerieAnime fA )
    {
        /*this.fenetrePrincipale = fenetrePrincipale;
        this.fenetrePrincipale.setControleur(this);*/
        fenetrePrincipale = fp;
        fenetreFilm = fA;
        fenetreConnexion = fc;
        fenetreCreationCompte = fcr;

        //initializeListeners();


    }

    private void initializeListeners() {
       // fenetrePrincipale.getSeConnecterButton().addActionListener(this);
        //fenetrePrincipale.getCreerCompteButton().addActionListener(this);
    }



    public void actionPerformed(ActionEvent e) {

        System.out.println("Hello");
        Confirmer = false;
        if (e.getActionCommand().equals("Se connecter")) {
            //fenetreConnexion = new InterfaceConnection(null, true, "Entrée en session...");
            fenetreConnexion.setVisible(true);
            /*if (e.getActionCommand().equals("Connexion")) {
                String login = fenetreConnexion.getLogin().getText();
                boolean isValidLogin = client.isValidLogin(login);
                String motDePasse = Arrays.toString(fenetreConnexion.getMotDePasse().getPassword());
                boolean isValidPassword = client.isValidPassword(motDePasse);
                fenetreConnexion.setVisible(false);

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
            }*/
            fenetreConnexion.dispose();
        } else if (e.getActionCommand().equals("Créer un compte")) {
            //fenetreCreationCompte = new InterfaceCreate_Account(null, true, "Session de création");
            fenetreCreationCompte.setVisible(true);
            //Confirmer = false;
            /*if (e.getSource().equals("Créer")) {
                String login = fenetreCreationCompte.getLogin().getText();
                boolean isValidLogin = client.isValidLogin(login);
                String motDePasse = Arrays.toString(fenetreCreationCompte.getMotDePasse().getPassword());
                boolean isValidPassword = client.isValidPassword(motDePasse);
                String Nompersonne = fenetreCreationCompte.getNompersonne().getText();
                String PrenomPersonne = fenetreCreationCompte.getPrenomPersonne().getText();
                String Telephone = fenetreCreationCompte.getTelephone().getText();
                boolean isValidTelephone = client.isValidTelephone(Telephone);
                Confirmer = true;
                fenetreCreationCompte.setVisible(false);


                if (isValidLogin && isValidPassword && isValidTelephone) {

                    Confirmer = true;
                    fenetreCreationCompte.setVisible(false);
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
                fenetreCreationCompte.dispose();

            }*/
            fenetreCreationCompte.dispose();


            } else if (e.getActionCommand().equals("Film")) {
            fenetreFilm.setTitle("Film");

            fenetreFilm.setVisible(true);
            System.out.println("Bonjour");


           /* if (e.getSource().equals("Confirmer")) {
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


                    Pegi = 1;
                } else if (fenetreFilm.getPegi12Button().isSelected()) {


                    Pegi = 1;
                } else if (fenetreFilm.getPegi16Button().isSelected()) {


                    Pegi = 1;
                } else if (fenetreFilm.getPegi18Button().isSelected()) {


                    Pegi = 1;
                } else {


                    Pegi = 0;

                }

                if (fenetreFilm.getGenreComedie().isSelected()) {
                    Genre = String.valueOf(true);
                } else if (fenetreFilm.getGenreAction().isSelected()) {
                    Genre = String.valueOf(true);
                } else if (fenetreFilm.getGenreHorreur().isSelected()) {
                    Genre = String.valueOf(true);
                } else if (fenetreFilm.getGenreThriller().isSelected()) {
                    Genre = String.valueOf(true);
                } else {
                    Genre = String.valueOf(false);
                }

            }*/

                /*Film film = new Film(fenetreFilm.getTitre(),fenetreFilm.getDuree(),fenetreFilm.getId(), fenetreFilm.getDate(),fenetreFilm.getDescription(),fenetreFilm.getEditeur(),fenetreFilm.getAudio(), fenetreFilm.getSoustitre(),fenetreFilm.getGenre(),fenetreFilm.getPegi());
                ListeOeuvre.getInstance().ajouterFilm(film);*/

            //fenetreFilm.setVisible(false);
            fenetreFilm.dispose();



            } else if (e.getActionCommand().equals("Anime")) {
            fenetreFilm.setTitle("Anime");
            fenetreFilm.setVisible(true);

           /* Pegi = 0;
            Genre = String.valueOf(false);

            if (e.getSource().equals("Confirmer")) {
                String id = fenetreAnime.getId().getText();
                int id2 = Integer.parseInt(id);
                String Titre = fenetreAnime.getTitre().getText();
                String description = fenetreAnime.getDescription().getText();
                String Duree = fenetreAnime.getDuree().getText();
                int duree = Integer.parseInt(Duree);
                String editeur = fenetreAnime.getEditeur().getText();
                String audio = fenetreAnime.getAudio().getText();
                String Soustitre = fenetreAnime.getSoustitre().getText();
                String dateSaisie = fenetreAnime.getDate().getText();
                LocalDate date = LocalDate.parse(dateSaisie, DateTimeFormatter.ISO_LOCAL_DATE);

                if (fenetreAnime.getPegi10Button().isSelected()) {


                    Pegi = 1;
                } else if (fenetreAnime.getPegi12Button().isSelected()) {


                    Pegi = 1;
                } else if (fenetreAnime.getPegi16Button().isSelected()) {


                    Pegi = 1;
                } else if (fenetreAnime.getPegi18Button().isSelected()) {


                    Pegi = 1;
                } else {


                    Pegi = 0;

                }

                if (fenetreAnime.getGenreComedie().isSelected()) {
                    Genre = String.valueOf(true);
                } else if (fenetreAnime.getGenreAction().isSelected()) {
                    Genre = String.valueOf(true);
                } else if (fenetreAnime.getGenreHorreur().isSelected()) {
                    Genre = String.valueOf(true);
                } else if (fenetreAnime.getGenreThriller().isSelected()) {
                    Genre = String.valueOf(true);
                } else {
                    Genre = String.valueOf(false);
                }

            }*/
            fenetreFilm.dispose();


            } else if (e.getActionCommand().equals("Série")) {
                fenetreFilm.setTitle("Serie");
                fenetreFilm.setVisible(true);

                /*Pegi = 0;
                Genre = String.valueOf(false);

                if (e.getSource().equals("Confirmer")) {
                    String id = fenetreSerie.getId().getText();
                    int id2 = Integer.parseInt(id);
                    String Titre = fenetreSerie.getTitre().getText();
                    String description = fenetreSerie.getDescription().getText();
                    String Duree = fenetreSerie.getDuree().getText();
                    int duree = Integer.parseInt(Duree);
                    String editeur = fenetreSerie.getEditeur().getText();
                    String audio = fenetreSerie.getAudio().getText();
                    String Soustitre = fenetreSerie.getSoustitre().getText();
                    String dateSaisie = fenetreSerie.getDate().getText();
                    LocalDate date = LocalDate.parse(dateSaisie, DateTimeFormatter.ISO_LOCAL_DATE);

                    if (fenetreSerie.getPegi10Button().isSelected()) {


                        Pegi = 1;
                    } else if (fenetreSerie.getPegi12Button().isSelected()) {


                        Pegi = 1;
                    } else if (fenetreSerie.getPegi16Button().isSelected()) {


                        Pegi = 1;
                    } else if (fenetreSerie.getPegi18Button().isSelected()) {


                        Pegi = 1;
                    } else {


                        Pegi = 0;

                    }

                    if (fenetreSerie.getGenreComedie().isSelected()) {
                        Genre = String.valueOf(true);
                    } else if (fenetreSerie.getGenreAction().isSelected()) {
                        Genre = String.valueOf(true);
                    } else if (fenetreSerie.getGenreHorreur().isSelected()) {
                        Genre = String.valueOf(true);
                    } else if (fenetreSerie.getGenreThriller().isSelected()) {
                        Genre = String.valueOf(true);
                    } else {
                        Genre = String.valueOf(false);
                    }

                }*/
                fenetreFilm.dispose();
            } else if (e.getActionCommand().equals("Trailer")) {
                fenetreFilm.setTitle("Trailer");
                fenetreFilm.setVisible(true);
                /*Pegi = 0;
                Genre = String.valueOf(false);

                if (e.getSource().equals("Confirmer")) {
                    String id = fenetreTrailer.getId().getText();
                    int id2 = Integer.parseInt(id);
                    String Titre = fenetreTrailer.getTitre().getText();
                    String description = fenetreTrailer.getDescription().getText();
                    String Duree = fenetreTrailer.getDuree().getText();
                    int duree = Integer.parseInt(Duree);
                    String editeur = fenetreTrailer.getEditeur().getText();
                    String audio = fenetreTrailer.getAudio().getText();
                    String Soustitre = fenetreTrailer.getSoustitre().getText();
                    String dateSaisie = fenetreTrailer.getDate().getText();
                    LocalDate date = LocalDate.parse(dateSaisie, DateTimeFormatter.ISO_LOCAL_DATE);

                    if (fenetreTrailer.getPegi10Button().isSelected()) {


                        Pegi = 1;
                    } else if (fenetreTrailer.getPegi12Button().isSelected()) {


                        Pegi = 1;
                    } else if (fenetreTrailer.getPegi16Button().isSelected()) {


                        Pegi = 1;
                    } else if (fenetreTrailer.getPegi18Button().isSelected()) {


                        Pegi = 1;
                    } else {


                        Pegi = 0;

                    }

                    if (fenetreTrailer.getGenreComedie().isSelected()) {
                        Genre = String.valueOf(true);
                    } else if (fenetreTrailer.getGenreAction().isSelected()) {
                        Genre = String.valueOf(true);
                    } else if (fenetreTrailer.getGenreHorreur().isSelected()) {
                        Genre = String.valueOf(true);
                    } else if (fenetreTrailer.getGenreThriller().isSelected()) {
                        Genre = String.valueOf(true);
                    } else {
                        Genre = String.valueOf(false);
                    }

                }*/
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


                Pegi = 1;
            } else if (fenetreFilm.getPegi12Button().isSelected()) {


                Pegi = 1;
            } else if (fenetreFilm.getPegi16Button().isSelected()) {


                Pegi = 1;
            } else if (fenetreFilm.getPegi18Button().isSelected()) {


                Pegi = 1;
            } else {


                Pegi = 0;

            }

            if (fenetreFilm.getGenreComedie().isSelected()) {
                Genre = String.valueOf(true);
            } else if (fenetreFilm.getGenreAction().isSelected()) {
                Genre = String.valueOf(true);
            } else if (fenetreFilm.getGenreHorreur().isSelected()) {
                Genre = String.valueOf(true);
            } else if (fenetreFilm.getGenreThriller().isSelected()) {
                Genre = String.valueOf(true);
            } else {
                Genre = String.valueOf(false);
            }

            if(fenetreFilm.getTitle().equals("Film"))
            {

            }
            //fenetreFilm.dispose();

        }
        else if (e.getActionCommand().equals("Creer")) {
            System.out.println("création");
            String login = fenetreCreationCompte.getLogin().getText();
            boolean isValidLogin = client.isValidLogin(login);
            String motDePasse = Arrays.toString(fenetreCreationCompte.getMotDePasse().getPassword());
            boolean isValidPassword = client.isValidPassword(motDePasse);
            String Nompersonne = fenetreCreationCompte.getNompersonne().getText();
            String PrenomPersonne = fenetreCreationCompte.getPrenomPersonne().getText();
            String Telephone = fenetreCreationCompte.getTelephone().getText();
            boolean isValidTelephone = client.isValidTelephone(Telephone);
            Confirmer = true;
            fenetreCreationCompte.setVisible(false);


            if (isValidLogin && isValidPassword && isValidTelephone) {

                Confirmer = true;
                fenetreCreationCompte.setVisible(false);
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





    /*public void setInteractionsEnabled(boolean enabled) {
        fenetrePrincipale.setEnabled(enabled);

        //fenetrePrincipale.getSeConnecterButton().setEnabled(enabled);
        //fenetrePrincipale.getCreerCompteButton().setEnabled(enabled);


    }*/

    public void windowClosing(WindowEvent we) { System.exit(0); }

    public void windowOpened(WindowEvent we) {}
    public void windowClosed(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent we) {}




}
