package CompareMethod;
import Singleton.*;
import TypeOeuvre.*;
import java.util.Comparator;

public class MultiTypeComparator implements Comparator<Object> {
    @Override
    public int compare(Object objet1, Object objet2) {
        if (objet1 instanceof Anime && objet2 instanceof Anime) {
            Anime anime1 = (Anime) objet1;
            Anime anime2 = (Anime) objet2;

            boolean isHorreur1 = anime1.getNom().equals("Horreur");
            boolean isHorreur2 = anime2.getNom().equals("Horreur");

            if (isHorreur1 && !isHorreur2) {
                return -1;
            } else if (!isHorreur1 && isHorreur2) {
                return 1;
            } else {
                return anime1.getNom().compareTo(anime2.getNom());
            }
        }
        else if(objet1 instanceof Film && objet2 instanceof Film)
        {
            Film film1 = (Film) objet1;
            Film film2 = (Film) objet2;

            boolean isHorreur1 = film1.getNom().equals("Horreur");
            boolean isHorreur2 = film2.getNom().equals("Horreur");

            if (isHorreur1 && !isHorreur2) {
                return -1;
            } else if (!isHorreur1 && isHorreur2) {
                return 1;
            } else {
                return film1.getNom().compareTo(film2.getNom());
            }
        }
        else if(objet1 instanceof Serie && objet2 instanceof Serie)
        {
            Serie Serie1 = (Serie) objet1;
            Serie Serie2 = (Serie) objet2;

            boolean isHorreur1 = Serie1.getNom().equals("Horreur");
            boolean isHorreur2 = Serie2.getNom().equals("Horreur");

            if (isHorreur1 && !isHorreur2) {
                return -1;
            } else if (!isHorreur1 && isHorreur2) {
                return 1;
            } else {
                return Serie1.getNom().compareTo(Serie2.getNom());
            }
        }
        else if(objet1 instanceof Trailer && objet2 instanceof Trailer)
        {
            Trailer Trailer1 = (Trailer) objet1;
            Trailer Trailer2 = (Trailer) objet2;

            boolean isHorreur1 = Trailer1.getNom().equals("Horreur");
            boolean isHorreur2 = Trailer2.getNom().equals("Horreur");

            if (isHorreur1 && !isHorreur2) {
                return -1;
            } else if (!isHorreur1 && isHorreur2) {
                return 1;
            } else {
                return Trailer1.getNom().compareTo(Trailer2.getNom());
            }
        }
        else {
            return 0;
        }
    }
}
