package Controleur;

import CompareMethod.MultiTypeComparator;
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
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Arrays;
import java.util.Collections;

public class controleur extends Component implements ActionListener, WindowListener , ListDataListener , MouseListener
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
        //+32 (123) 456-7890
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
            String userInput = JOptionPane.showInputDialog(null, "Vérification du mot de passe actuel", "Reset du mot de passe", JOptionPane.QUESTION_MESSAGE);
            if (userInput != null) {


                if (userInput.equals("Admin1")) {
                    JOptionPane.showMessageDialog(null, "Impossible de reset ce mot de passe!!", "Error", JOptionPane.INFORMATION_MESSAGE, null);
                } else if (userInput.equals(ListeOeuvre.getInstance().getClientCourant().getMotDePasse())) {
                    String user = JOptionPane.showInputDialog(null, "Veuillez entrer votre nouveau mot de passe", "Nouveau mot de passe", JOptionPane.QUESTION_MESSAGE);
                    ListeOeuvre.getInstance().getClientCourant().setMotDePasse(user);
                    System.out.println(ListeOeuvre.getInstance().getClientCourant().toString());
                }
            }
            else {
                System.out.println("Valeur non saisie");
            }
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

            if (fenetreFilm.getPegi6Button().isSelected()) {


                Pegi = 6;
                fenetreFilm.getPegi6Button().setSelected(false);
            } else if (fenetreFilm.getPegi12Button().isSelected()) {


                Pegi = 12;
                fenetreFilm.getPegi12Button().setSelected(false);
            } else if (fenetreFilm.getPegi14Button().isSelected()) {

                Pegi = 14;
                fenetreFilm.getPegi14Button().setSelected(false);
            } else if (fenetreFilm.getPegi16Button().isSelected()) {


                Pegi = 16;
                fenetreFilm.getPegi16Button().setSelected(false);
            } else if (fenetreFilm.getPegi18Button().isSelected()) {


                Pegi = 18;
                fenetreFilm.getPegi18Button().setSelected(false);
            } else {


                Pegi = 0;

            }

            if (fenetreFilm.getGenreSF().isSelected()) {
                Genre = "Science-Fiction";
                fenetreFilm.getGenreSF().setSelected(false);

            } else if (fenetreFilm.getGenreAction().isSelected()) {
                Genre = "Action";
                fenetreFilm.getGenreAction().setSelected(false);
            } else if (fenetreFilm.getGenreAventure().isSelected()) {
                Genre = "Aventure";
                fenetreFilm.getGenreAventure().setSelected(false);
            }
            else if (fenetreFilm.getGenreHorreur().isSelected()) {
                Genre = "Horreur";
                fenetreFilm.getGenreHorreur().setSelected(false);
            } else if (fenetreFilm.getGenreDrame().isSelected()) {
                Genre = "Drame";
                fenetreFilm.getGenreDrame().setSelected(false);
            } else {
                Genre = String.valueOf(false);
            }

            if(fenetreFilm.getTitle().equals("Film"))
            {
                Film filmtemporaire = new Film(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(filmtemporaire.toString());
                ListeOeuvre.getInstance().ajouterFilm(filmtemporaire);
                fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());


            }
            else if(fenetreFilm.getTitle().equals("Anime"))
            {
                Anime Animetempo = new Anime(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(Animetempo.toString());
                ListeOeuvre.getInstance().ajouterAnime(Animetempo);
                fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());

            }
            else if(fenetreFilm.getTitle().equals("Serie"))
            {
                Serie serietemporaire = new Serie(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(serietemporaire.toString());
                ListeOeuvre.getInstance().ajouterSerie(serietemporaire);
                fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());

            }
            else if(fenetreFilm.getTitle().equals("Trailer"))
            {
                Trailer trailertempo = new Trailer(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(trailertempo.toString());
                ListeOeuvre.getInstance().ajouterTrailer(trailertempo);
                fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
            }

            //fenetreFilm.dispose();
            fenetreFilm.getId().setText("");
            fenetreFilm.getTitre().setText("");
            fenetreFilm.getDescription().setText("");
            fenetreFilm.getDuree().setText("");
            fenetreFilm.getSoustitre().setText("");
            fenetreFilm.getAudio().setText("");
            fenetreFilm.getEditeur().setText("");
            fenetreFilm.getDate().setText("");
            fenetreFilm.getButtonGrp1().clearSelection();
            fenetreFilm.getButtonGroupPegi().clearSelection();
            fenetreFilm.setVisible(false);

        }
        else if (e.getActionCommand().equals("Creer")) {
            //+32 (123) 456-7890
            System.out.println("création");
            String id = fenetreCreationCompte.getId().getText();
            int Id = Integer.parseInt(id);
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
                    Administrateur AdminTempo = new Administrateur(Nompersonne,PrenomPersonne,login,motDePasse,Id);
                    System.out.println(AdminTempo.toString());
                    ListeOeuvre.getInstance().ajouterAdmin(AdminTempo);
                    fenetreCreationCompte.setVisible(false);

                }
                else
                {
                    client clienttempo = new client(Nompersonne,PrenomPersonne,login,motDePasse,Telephone,Preference,null,Id);
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
            fenetreCreationCompte.dispose();
            fenetreCreationCompte.getTelephone().setText("");
            fenetreCreationCompte.getNompersonne().setText("");
            fenetreCreationCompte.getPrenomPersonne().setText("");
            fenetreCreationCompte.getId().setText("");
            fenetreCreationCompte.getLogin().setText("");
            fenetreCreationCompte.getMotDePasse().setText("");
            fenetreCreationCompte.getButtonGroupGenre().clearSelection();

        }
        else if (e.getActionCommand().equals("Connexion")) {
            System.out.println("connexion");
            if (ListeOeuvre.getInstance().getAdminCourant() == null && ListeOeuvre.getInstance().getClientCourant() == null) {
                String login = fenetreConnexion.getLogin().getText();
                boolean isValidLogin = client.isValidLogin(login);
                String motDePasse = String.valueOf(fenetreConnexion.getMotDePasse().getPassword());
                boolean isValidPassword = client.isValidPassword(motDePasse);

                boolean loginVerif = false;
                boolean mdpVerif = false;
                if (motDePasse.equals("Admin1")) {
                    String loginRechercheAdmin = login;
                    //Administrateur administrateur = new Administrateur();
                    Administrateur administrateur = ListeOeuvre.getInstance().rechercherLoginAdmin(ListeOeuvre.getInstance().getInstanceAdmin(), loginRechercheAdmin);
                    if (administrateur != null) {
                        System.out.println("L'Administrateur recherché  " + loginRechercheAdmin + "est trouvé.");
                        loginVerif = true;
                    } else {
                        System.out.println("L'Administrateur recherché" + loginRechercheAdmin + " n'est  pas trouvé. ");
                    }

                    String MdpRechercheAdmin = motDePasse;
                    administrateur = ListeOeuvre.getInstance().rechercherMdpAdmin(ListeOeuvre.getInstance().getInstanceAdmin(), MdpRechercheAdmin);
                    if (administrateur != null) {
                        System.out.println("L'Administrateur recherché  " + MdpRechercheAdmin + "est trouvé.");
                        mdpVerif = true;
                    } else {
                        System.out.println("L'Administrateur recherché" + MdpRechercheAdmin + " n'est  pas trouvé. ");
                    }

                    if (mdpVerif && loginVerif) {
                        JOptionPane.showMessageDialog(fenetreConnexion, " N'oubliez pas d'enlever vos chaussures", "Bienvenue", JOptionPane.INFORMATION_MESSAGE, null);
                        ListeOeuvre.getInstance().ajoutAdminCourant(administrateur);
                        ListeOeuvre.getInstance().AffichageAdminCourant();

                    } else {
                        if (!mdpVerif) {
                            JOptionPane.showMessageDialog(fenetreConnexion, " Mot De passe incorrect", "Error", JOptionPane.INFORMATION_MESSAGE, null);
                        } else {
                            JOptionPane.showMessageDialog(fenetreConnexion, " Login incorrect", "Error", JOptionPane.INFORMATION_MESSAGE, null);

                        }
                    }

                } else {
                    String loginRecherche = login;
                    client clientTrouve = new client();
                    clientTrouve = ListeOeuvre.getInstance().rechercherLoginClient(ListeOeuvre.getInstance().getInstanceClient(), loginRecherche);
                    //int index = ListeOeuvre.getInstance().getInstanceClient().indexOf(ListeOeuvre.getInstance().getClientCourant());
                    if (clientTrouve != null) {
                        System.out.println("Le client recherché  " + loginRecherche + "est trouvé.");
                        loginVerif = true;
                    } else {
                        System.out.println("Le client recherché  " + loginRecherche + " n'est  pas trouvé. ");
                    }

                    String MdpRch = motDePasse;
                    clientTrouve = ListeOeuvre.getInstance().rechercherMdpClient(ListeOeuvre.getInstance().getInstanceClient(), MdpRch);
                    //int index = ListeOeuvre.getInstance().getInstanceClient().indexOf(ListeOeuvre.getInstance().getClientCourant());
                    if (clientTrouve != null) {
                        System.out.println("Le client recherché  " + MdpRch + "est trouvé.");
                        mdpVerif = true;
                        //System.out.println(clientTrouve.toString());
                    } else {
                        System.out.println("Le client recherché  " + MdpRch + " n'est  pas trouvé. ");
                    }

                    if (mdpVerif && loginVerif) {
                        JOptionPane.showMessageDialog(fenetreConnexion, " N'oubliez pas d'enlever vos chaussures", "Bienvenue", JOptionPane.INFORMATION_MESSAGE, null);
                        ListeOeuvre.getInstance().ajoutClientCourant(clientTrouve);
                        ListeOeuvre.getInstance().AffichageClientCourant();
                    } else {
                        if (!mdpVerif) {
                            JOptionPane.showMessageDialog(fenetreConnexion, " Mot De passe incorrect", "Error", JOptionPane.INFORMATION_MESSAGE, null);
                        } else {
                            JOptionPane.showMessageDialog(fenetreConnexion, " Login incorrect", "Error", JOptionPane.INFORMATION_MESSAGE, null);

                        }
                    }
                }

                fenetreConnexion.setVisible(false);
                fenetreConnexion.getLogin().setText("");
                fenetreConnexion.getMotDePasse().setText("");
                //setInteractionsEnabled(true)
            }
            else
            {
                JOptionPane.showMessageDialog(fenetreConnexion, "Il y a déjà un compte connecté", "Connexion", JOptionPane.INFORMATION_MESSAGE, null);
            }
        } else if (e.getActionCommand().equals("Se déconnecter")) {
            System.out.println("ok");
            if(ListeOeuvre.getInstance().getClientCourant() != null)
            {

                ListeOeuvre.getInstance().DeconnectClient();
                JOptionPane.showMessageDialog(fenetreConnexion, "Vous avez été déconnecté avec succès !", "Deconnexion", JOptionPane.INFORMATION_MESSAGE, null);
            } else if (ListeOeuvre.getInstance().getAdminCourant() != null) {

                ListeOeuvre.getInstance().DeconnectAdmin();
                JOptionPane.showMessageDialog(fenetreConnexion, "Vous avez été déconnecté avec succès !", "Deconnexion", JOptionPane.INFORMATION_MESSAGE, null);

            }
            else{
                JOptionPane.showMessageDialog(fenetreConnexion, "Aucune personne connecté", "Error", JOptionPane.INFORMATION_MESSAGE, null);
            }

        }

    }

    public void mouseClicked(MouseEvent e)
    {
        TreePath path = fenetrePrincipale.getArbre().getPathForLocation(e.getX(), e.getY());

        if (path != null && path.getLastPathComponent() != null && !fenetrePrincipale.getArbre().getModel().isLeaf(path.getLastPathComponent())) {

        }
        else
        {
            DefaultMutableTreeNode nodefinal = (DefaultMutableTreeNode) path.getLastPathComponent();
            String nodeNameFinal = nodefinal.toString();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getPathComponent(path.getPathCount() - 3);
            String nodeName = node.toString();
            if (nodeName.equals("Film"))
            {
                if(nodeNameFinal.equals("6+"))
                {

                }
                if(nodeNameFinal.equals("9+"))
                {

                }
                if(nodeNameFinal.equals("12+"))
                {

                }
                if(nodeNameFinal.equals("14+"))
                {

                }
                if(nodeNameFinal.equals("16+"))
                {

                }
                if(nodeNameFinal.equals("18+"))
                {

                }
                if(nodeNameFinal.equals("Horreur"))
                {
                    MultiTypeComparator comparator = new MultiTypeComparator();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("Science-Fiction"))
                {

                }
                if(nodeNameFinal.equals("Aventure"))
                {

                }
                if(nodeNameFinal.equals("Drame"))
                {

                }
                if(nodeNameFinal.equals("Action"))
                {

                }
            }

            if (nodeName.equals("Serie"))
            {
                if(nodeNameFinal.equals("6+"))
                {

                }
                if(nodeNameFinal.equals("9+"))
                {

                }
                if(nodeNameFinal.equals("12+"))
                {

                }
                if(nodeNameFinal.equals("14+"))
                {

                }
                if(nodeNameFinal.equals("16+"))
                {

                }
                if(nodeNameFinal.equals("18+"))
                {

                }
                if(nodeNameFinal.equals("Horreur"))
                {
                    MultiTypeComparator comparator = new MultiTypeComparator();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("Science-Fiction"))
                {

                }
                if(nodeNameFinal.equals("Aventure"))
                {

                }
                if(nodeNameFinal.equals("Drame"))
                {

                }
                if(nodeNameFinal.equals("Action"))
                {

                }
            }

            if (nodeName.equals("Anime"))
            {
                if(nodeNameFinal.equals("6+"))
                {

                }
                if(nodeNameFinal.equals("9+"))
                {

                }
                if(nodeNameFinal.equals("12+"))
                {

                }
                if(nodeNameFinal.equals("14+"))
                {

                }
                if(nodeNameFinal.equals("16+"))
                {

                }
                if(nodeNameFinal.equals("18+"))
                {

                }
                if(nodeNameFinal.equals("Horreur"))
                {
                    MultiTypeComparator comparator = new MultiTypeComparator();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("Science-Fiction"))
                {

                }
                if(nodeNameFinal.equals("Aventure"))
                {

                }
                if(nodeNameFinal.equals("Drame"))
                {

                }
                if(nodeNameFinal.equals("Action"))
                {

                }
            }

            if (nodeName.equals("Trailer"))
            {
                if(nodeNameFinal.equals("6+"))
                {

                }
                if(nodeNameFinal.equals("9+"))
                {

                }
                if(nodeNameFinal.equals("12+"))
                {

                }
                if(nodeNameFinal.equals("14+"))
                {

                }
                if(nodeNameFinal.equals("16+"))
                {

                }
                if(nodeNameFinal.equals("18+"))
                {

                }
                if(nodeNameFinal.equals("Horreur"))
                {
                    MultiTypeComparator comparator = new MultiTypeComparator();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("Science-Fiction"))
                {

                }
                if(nodeNameFinal.equals("Aventure"))
                {

                }
                if(nodeNameFinal.equals("Drame"))
                {

                }
                if(nodeNameFinal.equals("Action"))
                {

                }
            }
        }
    }

    public void windowClosing(WindowEvent we) {
        Serializer.serializeObjectOeuvre("Oeuvre.bin");
        Serializer.serializeObjectPersonne(ListeOeuvre.getInstance(),"Personne.bin");
        System.out.println("fini 1 ");
        System.exit(0);

    }


    public void windowOpened(WindowEvent we) {}
    public void windowClosed(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent we) {}

    public void intervalAdded(ListDataEvent e) {}
    public void intervalRemoved(ListDataEvent e) {}

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
}
