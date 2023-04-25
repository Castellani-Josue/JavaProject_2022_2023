
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {


        System.out.println("\n");
       Utilisateur.client client1 =  new Utilisateur.client("Castellani", "Josue", "Sparkwillo", "Jcast05","0479/044211" ,"Horreur" );
       client1.affiche();
       client1.ResetMotDePasse();



        System.out.println("\n");
       Utilisateur.Administrateur administrateur1 = new Utilisateur.Administrateur("Dupont","Fabrice","FabDup08","Corinne14");
       administrateur1.affiche();

        //InterfaceFilmSerieAnime frame = new InterfaceFilmSerieAnime();
        //frame.setVisible(true);

    }
}

