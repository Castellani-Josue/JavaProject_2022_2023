package TypeOeuvre;
public abstract class CategorieOeuvre
{
    static public final String CATEGORIE_HORREUR;
    static public final String CATEGORIE_DRAME;
    static public final String CATEGORIE_AVENTURE;
    static public final String CATEGORIE_SCIENCEFICTION;
    static public final String CATEGORIE_ACTION;

    //d'autre thème à rajouter


    static
    {
        CATEGORIE_HORREUR = "Horreur";
        CATEGORIE_DRAME = "Drame";
        CATEGORIE_AVENTURE = "Aventure";
        CATEGORIE_SCIENCEFICTION = "Science-Fiction";
        CATEGORIE_ACTION = "Action";
    }

    /*public static boolean estChampValide(String champ) {
        switch (champ) {
            case CATEGORIE_HORREUR:
            case CATEGORIE_DRAME:
            case CATEGORIE_AVENTURE:
            case CATEGORIE_SCIENCEFICTION:
            case CATEGORIE_ACTION:
                return true;
            default:
                return false;
        }
    }*/

}
