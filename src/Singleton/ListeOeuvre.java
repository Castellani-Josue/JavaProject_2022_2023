package Singleton;

import Serialisation.Serializer;
import TypeOeuvre.Anime;
import TypeOeuvre.Film;
import TypeOeuvre.Serie;
import TypeOeuvre.Trailer;
import Utilisateur.Administrateur;
import Utilisateur.client;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ListeOeuvre implements Serializable
{
    private static final long serialVersionUID = 1L;
    private ArrayList<Film> listeFilm = new ArrayList<Film>();
    private ArrayList<Serie> listeSerie = new ArrayList<Serie>();
    private ArrayList<Anime> listeAnime = new ArrayList<Anime>();
    private ArrayList<Trailer> listeTrailer = new ArrayList<Trailer>();

    private ArrayList<client> listeClient = new ArrayList<client>();

    private ArrayList<Administrateur> listeAdmin = new ArrayList<Administrateur>();
    private Administrateur AdminCourant = null;
    private client ClientCourant = null;





    //utilisateur à rajouter
    private static ListeOeuvre instance = null;
    //private static  ListeOeuvre instance2 =new ListeOeuvre();

    private ListeOeuvre()
    {
        //constructeur privé pour empêcher l'instanciation directe de la classe
        //listeClient = new ArrayList<>();
        //listeFilm = new ArrayList<>();
        //listeAdmin = new ArrayList<>();





    }
    public static ListeOeuvre getInstance()
    {
        if(instance == null)
            instance = new ListeOeuvre();
        return instance;
    }

    /*public static ListeOeuvre getInstance2()
    {
        return instance2;
    }*/


    public ArrayList<client> getInstanceClient()
    {
        return listeClient;
    }

    public client getClientCourant()
    {
        return ClientCourant;
    }

    public Administrateur getAdminCourant()
    {
        return AdminCourant;
    }


    public  client rechercherLoginClient(ArrayList<client> listeClient,String loginRecherche)
    {
        for(client clientrch : listeClient)
        {
            if(clientrch.getLogin().equals(loginRecherche))
            {
                return clientrch;
            }
        }

        return null;
    }

    public  client rechercherMdpClient(ArrayList<client> listeClient,String mdpRecherche)
    {
        for(client clientrch : listeClient)
        {
            if(clientrch.getMotDePasse().equals(mdpRecherche))
            {
                return clientrch;
            }
        }

        return null;
    }

    public  Administrateur rechercherMdpAdmin(ArrayList<Administrateur> listeAdmin,String mdpRecherche)
    {
        for(Administrateur AdminRch : listeAdmin)
        {
            if(AdminRch.getMotDePasse().equals(mdpRecherche))
            {
                return AdminRch;
            }
        }

        return null;
    }

    public  Administrateur rechercherLoginAdmin(ArrayList<Administrateur> listeAdmin,String LoginRecherche)
    {
        for(Administrateur AdminRch : listeAdmin)
        {
            if(AdminRch.getLogin().equals(LoginRecherche))
            {
                return AdminRch;
            }
        }

        return null;
    }

    public ArrayList<Administrateur> getInstanceAdmin()
    {
        return listeAdmin;
    }


    public ArrayList<Film> getInstanceFilm() {
        return listeFilm;
    }

    public ArrayList<Anime> getInstanceAnime(){
        return listeAnime;
    }

    public ArrayList<Serie> getInstanceSerie(){
        return listeSerie;
    }

    public ArrayList<Trailer> getInstanceTrailer(){
        return listeTrailer;
    }

    public void AffichageClient()
    {
        for (client clienttmp : listeClient)
        {
            System.out.println("Nom :" + clienttmp.getNompersonne() + "Prenom : " + clienttmp.getNompersonne() + "LOgin : " + clienttmp.getLogin() + "Mdp :" + clienttmp.getMotDePasse() + "Tel : " + clienttmp.getTelephone() + "Pref : "+ clienttmp.getPreference()+ "Id :" + clienttmp.getIdentifiant());
        }
    }

    public void AffichageClientCourant()
    {
        System.out.println(ClientCourant.toString());
    }

    public void AffichageAdminCourant()
    {
        System.out.println(AdminCourant.toString());
    }

    public void ajouterFilm(Film film)
    {

        listeFilm.add(film);
    }

    public void ajouterSerie(Serie serie) {
        listeSerie.add(serie);
    }

    public void ajouterAnime(Anime anime) {
        listeAnime.add(anime);
    }

    public void ajouterTrailer(Trailer trailer) {
        listeTrailer.add(trailer);
    }

    public void ajouterClient(client client1) {listeClient.add(client1);}

    public void ajoutClientCourant(client clienttmp){ClientCourant =clienttmp;}


    public void ajouterAdmin( Administrateur administrateur) {listeAdmin.add(administrateur);}

    public void ajoutAdminCourant(Administrateur administrateurtmp){AdminCourant = administrateurtmp;}

    public void DeconnectClient()
    {
        if(ClientCourant != null)
        {
            ClientCourant = null;
        }

    }

    public void DeconnectAdmin()
    {
        if(AdminCourant != null)
        {
            AdminCourant = null;
        }

    }

    //Cela permet de garantir qu'une nouvelle instance n'est pas créée lors de la désérialisation.
    protected Object readResolve() {
        return getInstance();
    }

    public  void  Deserializer(String filePath)
    {
        ListeOeuvre listeOeuvre = null;
        try {


            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            listeClient = (ArrayList<client>) objectIn.readObject();
            listeAdmin = (ArrayList<Administrateur>) objectIn.readObject();
            listeFilm = (ArrayList<Film>) objectIn.readObject();
            listeAnime = (ArrayList<Anime>) objectIn.readObject();
            listeSerie = (ArrayList<Serie>) objectIn.readObject();
            listeTrailer = (ArrayList<Trailer>) objectIn.readObject();


            objectIn.close();
            fileIn.close();


            System.out.println("L'objet a été désérialisé avec succès.");


        } catch (FileNotFoundException e) {
            System.out.println("Fichier Non Trouvé !");
        } catch (IOException e) {
            System.out.println("Erreur IO");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur ! Classe non trouvée...");
        }

    }

    public void Serialise(String filePath)
    {
        try {

        FileOutputStream fileOut = new FileOutputStream(filePath);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(getInstanceTrailer());
        objectOut.writeObject(getInstanceSerie());
        objectOut.writeObject(getInstanceFilm());
        objectOut.writeObject(getInstanceAnime());
        objectOut.writeObject(getInstanceAdmin());
        objectOut.writeObject(getInstanceClient());

        objectOut.close();
        fileOut.close();



        System.out.println("L'objet  a été sérialisé avec succès.");

    } catch (FileNotFoundException e)
        {
    System.out.println("Fichier Non Trouvé !");
    } catch (IOException e)
        {
    System.out.println("Erreur IO");
    }
    }

    public void ReaderCSVclient(String filePath )
    {
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
           filePath = in.readLine(); // Ignorer la première ligne

            String line;
            while ((line = in.readLine()) != null) {
                // Diviser la ligne en champs en utilisant  / comme séparateur
                String[] fields = line.split("/");

                if (fields.length >= 4) { // Vérifier la longueur du tableau
                    System.out.println(fields[0]);
                    System.out.println(fields[1]);
                    System.out.println(fields[2]);
                    System.out.println(fields[3]);




                    // Extraire les champs individuels et les stocker dans des variables
                    int Id = Integer.parseInt(fields[0].trim());
                    String login = fields[1].trim();
                    String mdp = fields[2].trim();
                    String dateSaisie = fields[3].trim();
                    LocalDate date = LocalDate.parse(dateSaisie, DateTimeFormatter.ISO_LOCAL_DATE);



                    // Créer un objet en utilisant les valeurs extraites
                    //client objet = new client(nom,prenom,login,mdp,telephone,preference,null,Id);

                    //ListeOeuvre.getInstance().ajouterClient(objet);
                } else {
                    System.out.println("La ligne ne contient pas suffisamment de champs.");
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Fichier Non Trouvé !");
        } catch (IOException e)
        {
            System.out.println("Erreur IO");
        }

    }

    public void ReaderCSVadmin(String filePath )
    {
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            filePath = in.readLine(); // Ignorer la première ligne

            String line;
            while ((line = in.readLine()) != null) {
                // Diviser la ligne en champs en utilisant  / comme séparateur
                String[] fields = line.split("/");

                if (fields.length >= 6) { // Vérifier la longueur du tableau

                    System.out.println(fields[3]);
                    System.out.println(fields[4]);
                    System.out.println(fields[5]);


                    // Extraire les champs individuels et les stocker dans des variables
                    int id = Integer.parseInt(fields[0].trim());
                    String nom = fields[1].trim();
                    String prenom = fields[2].trim();
                    String login = fields[3].trim();
                    String mdp = fields[4].trim();
                    String dateSaisie = fields[5].trim();
                    LocalDate date = LocalDate.parse(dateSaisie, DateTimeFormatter.ISO_LOCAL_DATE);
                    String heureconnexion = fields[5].trim();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime heure = LocalTime.parse(heureconnexion,formatter);



                    // Créer un objet en utilisant les valeurs extraites
                    //Administrateur objet = new Administrateur(nom,prenom,login,mdp,id);

                    //ListeOeuvre.getInstance().ajouterAdmin(objet);
                } else {
                    System.out.println("La ligne ne contient pas suffisamment de champs.");
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Fichier Non Trouvé !");
        } catch (IOException e)
        {
            System.out.println("Erreur IO");
        }

    }

    public void writeCSVClient(String filePath ,String En_tete) {
        try {



            FileWriter fw = new FileWriter(filePath,true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println(En_tete);

            for (client objet : ListeOeuvre.getInstance().getInstanceClient()) {
                writer.write(En_tete + " ");
                writer.write(objet.getIdentifiant() + "/");
                writer.write(objet.getLogin() + "/");
                writer.write(objet.getMotDePasse() + "/");

                LocalDate date = LocalDate.now();
                String formattedDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
                writer.write(formattedDate + "/");

                LocalTime time = LocalTime.now();
                String formattedTime = time.format(DateTimeFormatter.ISO_LOCAL_TIME);
                writer.write(formattedTime);


                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur IO : " + e.getMessage());
        }
    }

    public void writerCSVadmin(String filePath,String Titre)
    {
        try {




            FileWriter fw = new FileWriter(filePath,true);
            BufferedWriter writer = new BufferedWriter(fw);



            for (Administrateur objet : ListeOeuvre.getInstance().getInstanceAdmin()) {
                writer.newLine();

                // Écrire les champs individuels séparés par "/"
                writer.write(Titre + " ");
                writer.write(objet.getIdentifiant() + "/");
                writer.write(objet.getLogin() + "/");
                writer.write(objet.getMotDePasse() + "/");

                LocalDate date = LocalDate.now();
                String formattedDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
                writer.write(formattedDate + "/");

                LocalTime time = LocalTime.now();
                String formattedTime = time.format(DateTimeFormatter.ISO_LOCAL_TIME);
                writer.write(formattedTime);

                writer.newLine();

            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur IO");
        }
    }




    public static void main(String[] args)
    {
        //ListeOeuvre.getInstance().writeCSVpersonne("Test.txt");
        ListeOeuvre.getInstance().ReaderCSVclient("Test.txt");
    }






}