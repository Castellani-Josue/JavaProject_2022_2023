package Controleur;

import CompareMethod.*;
import InterfaceGraphique.*;
import Serialisation.Serializer;
import Singleton.ListeOeuvre;
import TypeOeuvre.*;
import Utilisateur.Administrateur;
import Utilisateur.ListeFavoris;
import Utilisateur.client;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.WindowListener;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class controleur extends Component implements ActionListener, WindowListener , ListDataListener , MouseListener , ListSelectionListener , PropertyChangeListener
{

    private InterfacePrincipale fenetrePrincipale;

    private InterfaceConnection fenetreConnexion;

    private  InterfaceCreate_Account fenetreCreationCompte;

    private InterfaceFilmSerieAnime fenetreFilm;

    private InformationOeuvre infosOeuvre;
    
    private InterfaceFavoris favoris;

    private  ListeOeuvre InstanceCourante;

    private  String Genre;

    private String Preference;


    private  int Pegi;

    private  boolean Confirmer;


    private client cli;

    public controleur(InterfacePrincipale fp,InterfaceConnection fc ,InterfaceCreate_Account fcr ,  InterfaceFilmSerieAnime fA , InformationOeuvre fI , InterfaceFavoris fav )
    {

        //InstanceCourante = ListeOeuvre.getInstance();
        fenetrePrincipale = fp;
        fenetreFilm = fA;
        fenetreConnexion = fc;
        fenetreCreationCompte = fcr;
        infosOeuvre=  fI;
        favoris = fav;
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
                //fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());


            }
            else if(fenetreFilm.getTitle().equals("Anime"))
            {
                Anime Animetempo = new Anime(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(Animetempo.toString());
                ListeOeuvre.getInstance().ajouterAnime(Animetempo);
                //fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());

            }
            else if(fenetreFilm.getTitle().equals("Serie"))
            {
                Serie serietemporaire = new Serie(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(serietemporaire.toString());
                ListeOeuvre.getInstance().ajouterSerie(serietemporaire);
                //fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());

            }
            else if(fenetreFilm.getTitle().equals("Trailer"))
            {
                Trailer trailertempo = new Trailer(Titre,duree,id2,date,description,editeur,audio,Soustitre,Genre,Pegi);
                System.out.println(trailertempo.toString());
                ListeOeuvre.getInstance().ajouterTrailer(trailertempo);
                //fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
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
                        ListeOeuvre.getInstance().writerCSVadmin("ConnexionAdmin.txt","Connexion Admin : ");

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
                        ListeOeuvre.getInstance().writeCSVClient("ConnexionClient.txt","Connexion Client :");
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
                ListeOeuvre.getInstance().writeCSVClient("DeconnexionClient.txt","Deconnexion Client : ");
            } else if (ListeOeuvre.getInstance().getAdminCourant() != null) {

                ListeOeuvre.getInstance().DeconnectAdmin();
                JOptionPane.showMessageDialog(fenetreConnexion, "Vous avez été déconnecté avec succès !", "Deconnexion", JOptionPane.INFORMATION_MESSAGE, null);
                ListeOeuvre.getInstance().writerCSVadmin("DeconnexionAdmin.txt","Deconnexion Admin : ");

            }
            else{
                JOptionPane.showMessageDialog(fenetreConnexion, "Aucune personne connecté", "Error", JOptionPane.INFORMATION_MESSAGE, null);
            }

        } else if(e.getActionCommand().equals("Voir Favoris")) {
            if (ListeOeuvre.getInstance().getClientCourant() != null) {
                ArrayList<Object> listeObjet = new ArrayList<>();
                for (ListeFavoris favorisTmp : ListeOeuvre.getInstance().getClientCourant().getListeFavoris()) {
                    for (Anime animetmp : ListeOeuvre.getInstance().getInstanceAnime()) {
                        if (animetmp.getIdentifiant() == favorisTmp.getIdentifiant()) {
                            listeObjet.add(animetmp);
                            break;
                        }
                    }
                    for (Serie serieTmp : ListeOeuvre.getInstance().getInstanceSerie()) {
                        if (serieTmp.getIdentifiant() == favorisTmp.getIdentifiant()) {
                            listeObjet.add(serieTmp);
                            break;
                        }
                    }
                    for (Film filmTmp : ListeOeuvre.getInstance().getInstanceFilm()) {
                        if (filmTmp.getIdentifiant() == favorisTmp.getIdentifiant()) {
                            listeObjet.add(filmTmp);
                            break;
                        }
                    }
                }
                favoris.getListeFavoris().setListData(listeObjet.toArray());
                favoris.setVisible(true);
                favoris.dispose();
            }
            else
            {

                JOptionPane.showMessageDialog(fenetrePrincipale, "Aucun client connecté", "Erreur", JOptionPane.INFORMATION_MESSAGE, null);
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
                    Comparator0 comparator = new Comparator0();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("9+"))
                {
                    Comparator9 comparator = new Comparator9();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("12+"))
                {
                    Comparator12 comparator = new Comparator12();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("14+"))
                {
                    Comparator14 comparator = new Comparator14();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("16+"))
                {
                    Comparator16 comparator = new Comparator16();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("18+"))
                {
                    Comparator18 comparator = new Comparator18();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("Horreur"))
                {
                    MultiTypeComparator comparator = new MultiTypeComparator();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("Science-Fiction"))
                {
                    ComparatorSF comparator = new ComparatorSF();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("Aventure"))
                {
                    ComparatorAventure comparator = new ComparatorAventure();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("Drame"))
                {
                    ComparatorDrame comparator = new ComparatorDrame();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
                if(nodeNameFinal.equals("Action"))
                {
                    ComparatorAction comparator = new ComparatorAction();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceFilm(), comparator);
                    fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());
                }
            }

            if (nodeName.equals("Serie"))
            {
                if(nodeNameFinal.equals("6+"))
                {
                    Comparator0 comparator = new Comparator0();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("9+"))
                {
                    Comparator9 comparator = new Comparator9();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("12+"))
                {
                    Comparator12 comparator = new Comparator12();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("14+"))
                {
                    Comparator14 comparator = new Comparator14();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("16+"))
                {
                    Comparator16 comparator = new Comparator16();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("18+"))
                {
                    Comparator18 comparator = new Comparator18();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("Horreur"))
                {
                    MultiTypeComparator comparator = new MultiTypeComparator();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("Science-Fiction"))
                {
                    ComparatorSF comparator = new ComparatorSF();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("Aventure"))
                {
                    ComparatorAventure comparator = new ComparatorAventure();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("Drame"))
                {
                    ComparatorDrame comparator = new ComparatorDrame();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
                if(nodeNameFinal.equals("Action"))
                {
                    ComparatorAction comparator = new ComparatorAction();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceSerie(), comparator);
                    fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());
                }
            }

            if (nodeName.equals("Anime"))
            {
                if(nodeNameFinal.equals("6+"))
                {
                    Comparator0 comparator = new Comparator0();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("9+"))
                {
                    Comparator9 comparator = new Comparator9();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("12+"))
                {
                    Comparator12 comparator = new Comparator12();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("14+"))
                {
                    Comparator14 comparator = new Comparator14();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("16+"))
                {
                    Comparator16 comparator = new Comparator16();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("18+"))
                {
                    Comparator18 comparator = new Comparator18();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("Horreur"))
                {
                    MultiTypeComparator comparator = new MultiTypeComparator();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("Science-Fiction"))
                {
                    ComparatorSF comparator = new ComparatorSF();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("Aventure"))
                {
                    ComparatorAventure comparator = new ComparatorAventure();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("Drame"))
                {
                    ComparatorDrame comparator = new ComparatorDrame();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
                if(nodeNameFinal.equals("Action"))
                {
                    ComparatorAction comparator = new ComparatorAction();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceAnime(), comparator);
                    fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());
                }
            }

            if (nodeName.equals("Trailer"))
            {
                if(nodeNameFinal.equals("6+"))
                {
                    Comparator0 comparator = new Comparator0();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("9+"))
                {
                    Comparator9 comparator = new Comparator9();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("12+"))
                {
                    Comparator12 comparator = new Comparator12();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("14+"))
                {
                    Comparator14 comparator = new Comparator14();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("16+"))
                {
                    Comparator16 comparator = new Comparator16();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("18+"))
                {
                    Comparator18 comparator = new Comparator18();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("Horreur"))
                {
                    MultiTypeComparator comparator = new MultiTypeComparator();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("Science-Fiction"))
                {
                    ComparatorSF comparator = new ComparatorSF();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("Aventure"))
                {
                    ComparatorAventure comparator = new ComparatorAventure();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("Drame"))
                {
                    ComparatorDrame comparator = new ComparatorDrame();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
                if(nodeNameFinal.equals("Action"))
                {
                    ComparatorAction comparator = new ComparatorAction();
                    Collections.sort(ListeOeuvre.getInstance().getInstanceTrailer(), comparator);
                    fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
                }
            }
        }
    }

    public void valueChanged(ListSelectionEvent e)
    {
        if(ListeOeuvre.getInstance().getClientCourant() != null) {
            if (!e.getValueIsAdjusting()) {
                JList<?> source = (JList<?>) e.getSource();
                Object selectedValue = source.getSelectedValue();
                Trailer trailertmp;
                Serie serieTmp;
                Film filmtmp;
                Anime animeTmp;
                if (selectedValue != null) {

                    if (selectedValue instanceof Trailer) {
                        trailertmp = (Trailer) selectedValue;
                        infosOeuvre.getLabelTitre().setText(trailertmp.getNom());
                        infosOeuvre.getLabelAudio().setText(String.valueOf(trailertmp.getAudio()));
                        infosOeuvre.getLabelCategorie().setText(trailertmp.getCategorieTrailer());
                        infosOeuvre.getLabelDate().setText(String.valueOf(trailertmp.getDateSortie()));
                        infosOeuvre.getLabelDescription().setText(trailertmp.getDescription());
                        infosOeuvre.getLabelClassification().setText(String.valueOf(trailertmp.getClassificationTrailer()));
                        infosOeuvre.getLabelDuree().setText(String.valueOf(trailertmp.getTemps()));
                        infosOeuvre.getLabelSousTitre().setText(String.valueOf(trailertmp.getSousTitre()));
                        infosOeuvre.getLabelEditeur().setText(trailertmp.getEditeur());
                        infosOeuvre.getLabelCote().setVisible(false);
                        infosOeuvre.getSlider1().setVisible(false);
                        infosOeuvre.getFavorisRadioButton().setVisible(false);
                        infosOeuvre.getLabelCote1().setText("pas de cote pour un Trailer");

                        infosOeuvre.setVisible(true);
                        infosOeuvre.getLabelCote().setVisible(true);
                        infosOeuvre.getSlider1().setVisible(true);
                        infosOeuvre.getFavorisRadioButton().setVisible(true);

                    }
                    if (selectedValue instanceof Film) {
                        filmtmp = (Film) selectedValue;
                        infosOeuvre.getLabelTitre().setText(filmtmp.getNom());
                        infosOeuvre.getLabelAudio().setText(String.valueOf(filmtmp.getAudio()));
                        infosOeuvre.getLabelCategorie().setText(filmtmp.getCategorieFilm());
                        infosOeuvre.getLabelDate().setText(String.valueOf(filmtmp.getDateSortie()));
                        infosOeuvre.getLabelDescription().setText(filmtmp.getDescription());
                        infosOeuvre.getLabelClassification().setText(String.valueOf(filmtmp.getClassificationFilm()));
                        infosOeuvre.getLabelDuree().setText(String.valueOf(filmtmp.getTemps()));
                        infosOeuvre.getLabelSousTitre().setText(String.valueOf(filmtmp.getSousTitre()));
                        infosOeuvre.getLabelEditeur().setText(filmtmp.getEditeur());
                        if (filmtmp.getCotation() == 0) {
                            infosOeuvre.getLabelCote1().setText("pas encore de côte");
                        } else {
                            infosOeuvre.getLabelCote1().setText(String.valueOf(filmtmp.getCotation()));
                        }

                        ListeFavoris Test = new ListeFavoris(filmtmp.getIdentifiant());

                        if (ListeOeuvre.getInstance().getClientCourant().getListeFavoris().contains(Test)) {
                            System.out.println("Favoris present !");
                            infosOeuvre.getFavorisRadioButton().setSelected(true);
                        } else {
                            System.out.println("Favoris non present !");
                            infosOeuvre.getFavorisRadioButton().setSelected(false);
                        }

                    /*if(filmtmp.getCotePersonelleFilm() != 0)
                    {
                        infosOeuvre.getSlider1().setValue(filmtmp.getCotePersonelleFilm());
                    }*/


                        infosOeuvre.setVisible(true);

                        if (infosOeuvre.getFavorisRadioButton().isSelected() && ListeOeuvre.getInstance().getClientCourant() != null) {
                            System.out.println("boutton Favoris appuyé");
                            ListeOeuvre.getInstance().getClientCourant().ajoutFavoris(filmtmp.getIdentifiant());
                        } else if (!infosOeuvre.getFavorisRadioButton().isSelected() && ListeOeuvre.getInstance().getClientCourant() != null) {
                            ListeOeuvre.getInstance().getClientCourant().retirerFavoris(filmtmp.getIdentifiant());
                        }

                        if (infosOeuvre.getSlider1().getValue() != 0) {
                            //filmtmp.retirerValeur(filmtmp.getCotePersonelleFilm());
                            filmtmp.calculerMoyenne(infosOeuvre.getSlider1().getValue());
                            System.out.println(filmtmp.getCotation());
                            //filmtmp.setCotePersonelleFilm(infosOeuvre.getSlider1().getValue());
                            infosOeuvre.getSlider1().setValue(0);
                        }
                        //else if(infosOeuvre.getSlider1().getValue() != filmtmp.getCotePersonelleFilm() && filmtmp.getCotePersonelleFilm() == 0 )
                    }
                    if (selectedValue instanceof Anime) {
                        animeTmp = (Anime) selectedValue;
                        infosOeuvre.getLabelTitre().setText(animeTmp.getNom());
                        infosOeuvre.getLabelAudio().setText(String.valueOf(animeTmp.getAudio()));
                        infosOeuvre.getLabelCategorie().setText(animeTmp.getCategorieAnime());
                        infosOeuvre.getLabelDate().setText(String.valueOf(animeTmp.getDateSortie()));
                        infosOeuvre.getLabelDescription().setText(animeTmp.getDescription());
                        infosOeuvre.getLabelClassification().setText(String.valueOf(animeTmp.getClassificationAnime()));
                        infosOeuvre.getLabelDuree().setText(String.valueOf(animeTmp.getTemps()));
                        infosOeuvre.getLabelSousTitre().setText(String.valueOf(animeTmp.getSousTitre()));
                        infosOeuvre.getLabelEditeur().setText(animeTmp.getEditeur());

                        ListeFavoris Test = new ListeFavoris(animeTmp.getIdentifiant());
                        if (ListeOeuvre.getInstance().getClientCourant().getListeFavoris().contains(Test)) {
                            infosOeuvre.getFavorisRadioButton().setSelected(true);
                        } else {
                            infosOeuvre.getFavorisRadioButton().setSelected(false);
                        }

                        if (animeTmp.getCotePersonelleAnime() != 0) {
                            infosOeuvre.getSlider1().setValue(animeTmp.getCotePersonelleAnime());
                        }

                        infosOeuvre.setVisible(true);

                        if (infosOeuvre.getFavorisRadioButton().isSelected() && ListeOeuvre.getInstance().getClientCourant() != null) {
                            System.out.println("boutton Favoris appuyé");
                            ListeOeuvre.getInstance().getClientCourant().ajoutFavoris(animeTmp.getIdentifiant());
                        } else if (!infosOeuvre.getFavorisRadioButton().isSelected() && ListeOeuvre.getInstance().getClientCourant() != null) {
                            ListeOeuvre.getInstance().getClientCourant().retirerFavoris(animeTmp.getIdentifiant());
                        }

                        if (infosOeuvre.getSlider1().getValue() != 0) {
                            animeTmp.calculerMoyenne(infosOeuvre.getSlider1().getValue());
                            System.out.println(animeTmp.getCotation());
                            infosOeuvre.getSlider1().setValue(0);
                        }
                    }
                    if (selectedValue instanceof Serie) {
                        serieTmp = (Serie) selectedValue;
                        infosOeuvre.getLabelTitre().setText(serieTmp.getNom());
                        infosOeuvre.getLabelAudio().setText(String.valueOf(serieTmp.getAudio()));
                        infosOeuvre.getLabelCategorie().setText(serieTmp.getCategorieSerie());
                        infosOeuvre.getLabelDate().setText(String.valueOf(serieTmp.getDateSortie()));
                        infosOeuvre.getLabelDescription().setText(serieTmp.getDescription());
                        infosOeuvre.getLabelClassification().setText(String.valueOf(serieTmp.getClassificationSerie()));
                        infosOeuvre.getLabelDuree().setText(String.valueOf(serieTmp.getTemps()));
                        infosOeuvre.getLabelSousTitre().setText(String.valueOf(serieTmp.getSousTitre()));
                        infosOeuvre.getLabelEditeur().setText(serieTmp.getEditeur());

                        ListeFavoris Test = new ListeFavoris(serieTmp.getIdentifiant());
                        if (ListeOeuvre.getInstance().getClientCourant().getListeFavoris().contains(Test)) {
                            infosOeuvre.getFavorisRadioButton().setSelected(true);
                        } else {
                            infosOeuvre.getFavorisRadioButton().setSelected(false);
                        }

                        if (serieTmp.getCotePersonelleSerie() != 0) {
                            infosOeuvre.getSlider1().setValue(serieTmp.getCotePersonelleSerie());
                        }

                        infosOeuvre.setVisible(true);

                        if (infosOeuvre.getFavorisRadioButton().isSelected() && ListeOeuvre.getInstance().getClientCourant() != null) {
                            System.out.println("boutton Favoris appuyé");
                            ListeOeuvre.getInstance().getClientCourant().ajoutFavoris(serieTmp.getIdentifiant());
                        } else if (!infosOeuvre.getFavorisRadioButton().isSelected() && ListeOeuvre.getInstance().getClientCourant() != null) {
                            ListeOeuvre.getInstance().getClientCourant().retirerFavoris(serieTmp.getIdentifiant());
                        }

                        if (infosOeuvre.getSlider1().getValue() != 0) {
                            serieTmp.calculerMoyenne(infosOeuvre.getSlider1().getValue());
                            System.out.println(serieTmp.getCotation());
                            infosOeuvre.getSlider1().setValue(0);
                        }
                    }

                    //mettre toutes les infos de l'objet récuperé dans le bon Jlabel
                    source.clearSelection();
                    infosOeuvre.dispose(); //mettre à la fin
                }
                //récuperer la valeur du Jslider et du Jbutton et en faire des trucs
            }
        }
        else
        {
            JOptionPane.showMessageDialog(fenetreConnexion, "Aucun client connecté", "Erreur", JOptionPane.INFORMATION_MESSAGE, null);
        }
    }

    public void windowClosing(WindowEvent we) {

        //Serializer.serializeObject(ListeOeuvre.getInstance(),"Mesdonnees.bin");
        ListeOeuvre.getInstance().Serialise("C:\\Users\\josue\\Java_Project_2022_2023\\JavaProject\\Fichier");
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


    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Je suis rentré chéri !");
        if(fenetreFilm.getTitle().equals("Film"))
        {

            fenetrePrincipale.getFilmIp().setListData(ListeOeuvre.getInstance().getInstanceFilm().toArray());


        }
        else if(fenetreFilm.getTitle().equals("Anime"))
        {

            fenetrePrincipale.getAnimeIp().setListData(ListeOeuvre.getInstance().getInstanceAnime().toArray());

        }
        else if(fenetreFilm.getTitle().equals("Serie"))
        {

            fenetrePrincipale.getSerieIp().setListData(ListeOeuvre.getInstance().getInstanceSerie().toArray());

        }
        else if(fenetreFilm.getTitle().equals("Trailer"))
        {

            fenetrePrincipale.getTrailerIp().setListData(ListeOeuvre.getInstance().getInstanceTrailer().toArray());
        }
    }
}
