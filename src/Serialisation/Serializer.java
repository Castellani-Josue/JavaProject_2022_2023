package Serialisation;

import Singleton.ListeOeuvre;

import java.io.*;

public class Serializer
{

    //Ces méthodes prennent en paramètre le chemin du fichier dans lequel sérialiser/désérialiser l'objet.
    public static void serializeObjectOeuvre(ListeOeuvre object, String filePath) {
        try {

            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(object);
            fileOut.flush();
            System.out.println("L'objet a été sérialisé avec succès.");

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Fichier Non Trouvé !! ");
        }
        catch (IOException e) //signifie qu'une erreur d'entrée/sortie s'est produite
        {
            System.out.println("Erreur IO");
        }
    }

    public static Object deserializeObjectOeuvre(String filePath) {
        try {

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object object = objectIn.readObject();
            System.out.println("obj Oeuvre" + object);
            ListeOeuvre listeOeuvre = (ListeOeuvre)object;
            System.out.println("L'objet a été désérialisé avec succès.");
            return listeOeuvre;

        }
        catch (FileNotFoundException e) {
            System.out.println("Fichier Non Trouvé !! ");
        } catch (IOException e) //signifie qu'une erreur d'entrée/sortie s'est produite
        {
            System.out.println("Erreur IO");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur ! Classe non trouvee...");
        }


        return null;
    }



    public static void serializeObjectPersonne(ListeOeuvre object, String filePath) {
        try {

            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(object);
            fileOut.flush();

            System.out.println("L'objet client a été sérialisé avec succès.");

        } catch (FileNotFoundException e) {
            System.out.println("Fichier Non Trouvé !");
        } catch (IOException e) {
            System.out.println("Erreur IO");
        }
    }


    public static Object deserializeObjectPersonne(String filePath) {
        try {

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object object = objectIn.readObject();
            System.out.println("obj Personne" + object);
            ListeOeuvre listeOeuvre = (ListeOeuvre)object;

            System.out.println("L'objet Personne a été désérialisé avec succès.");
            return listeOeuvre;

        } catch (FileNotFoundException e) {
            System.out.println("Fichier Non Trouvé !");
        } catch (IOException e) {
            System.out.println("Erreur IO");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur ! Classe non trouvée...");
        }

        return null;
    }



}
