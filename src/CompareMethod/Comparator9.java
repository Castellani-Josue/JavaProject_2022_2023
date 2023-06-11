package CompareMethod;
import TypeOeuvre.*;
import java.util.Comparator;

public class Comparator9 implements Comparator<Object> {
    @Override
    public int compare(Object objet1, Object objet2) {
        if (objet1 instanceof Anime && objet2 instanceof Anime) {
            Anime anime1 = (Anime) objet1;
            Anime anime2 = (Anime) objet2;

            boolean isNine1 = anime1.getClassificationAnime() == 9;
            boolean isNine2 = anime2.getClassificationAnime() == 9;

            if (isNine1 && !isNine2) {
                return -1;
            } else if (!isNine1 && isNine2) {
                return 1;
            } else {
                return anime1.getNom().compareTo(anime2.getNom());
            }
        }
        else if(objet1 instanceof Film && objet2 instanceof Film)
        {
            Film film1 = (Film) objet1;
            Film film2 = (Film) objet2;

            boolean isNine1 = film1.getClassificationFilm() == 9;
            boolean isNine2 = film2.getClassificationFilm() == 9;

            if (isNine1 && !isNine2) {
                return -1;
            } else if (!isNine1 && isNine2) {
                return 1;
            } else {
                return film1.getNom().compareTo(film2.getNom());
            }
        }
        else if(objet1 instanceof Serie && objet2 instanceof Serie)
        {
            Serie Serie1 = (Serie) objet1;
            Serie Serie2 = (Serie) objet2;

            boolean isNine1 = Serie1.getClassificationSerie() == 9;
            boolean isNine2 = Serie2.getClassificationSerie() == 9;

            if (isNine1 && !isNine2) {
                return -1;
            } else if (!isNine1 && isNine2) {
                return 1;
            } else {
                return Serie1.getNom().compareTo(Serie2.getNom());
            }
        }
        else if(objet1 instanceof Trailer && objet2 instanceof Trailer)
        {
            Trailer Trailer1 = (Trailer) objet1;
            Trailer Trailer2 = (Trailer) objet2;

            boolean isNine1 = Trailer1.getClassificationTrailer() == 9;
            boolean isNine2 = Trailer2.getClassificationTrailer() == 9;

            if (isNine1 && !isNine2) {
                return -1;
            } else if (!isNine1 && isNine2) {
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