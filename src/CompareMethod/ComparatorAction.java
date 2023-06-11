package CompareMethod;
import TypeOeuvre.*;
import java.util.Comparator;

public class ComparatorAction implements Comparator<Object> {
    @Override
    public int compare(Object objet1, Object objet2) {
        if (objet1 instanceof Anime && objet2 instanceof Anime) {
            Anime anime1 = (Anime) objet1;
            Anime anime2 = (Anime) objet2;

            boolean isAction1 = anime1.getCategorieAnime().equals("Action");
            boolean isAction2 = anime2.getCategorieAnime().equals("Action");

            if (isAction1 && !isAction2) {
                return -1;
            } else if (!isAction1 && isAction2) {
                return 1;
            } else {
                return anime1.getNom().compareTo(anime2.getNom());
            }
        }
        else if(objet1 instanceof Film && objet2 instanceof Film)
        {
            Film film1 = (Film) objet1;
            Film film2 = (Film) objet2;

            boolean isAction1 = film1.getCategorieFilm().equals("Action");
            boolean isAction2 = film2.getCategorieFilm().equals("Action");

            if (isAction1 && !isAction2) {
                return -1;
            } else if (!isAction1 && isAction2) {
                return 1;
            } else {
                return film1.getNom().compareTo(film2.getNom());
            }
        }
        else if(objet1 instanceof Serie && objet2 instanceof Serie)
        {
            Serie Serie1 = (Serie) objet1;
            Serie Serie2 = (Serie) objet2;

            boolean isAction1 = Serie1.getCategorieSerie().equals("Action");
            boolean isAction2 = Serie2.getCategorieSerie().equals("Action");

            if (isAction1 && !isAction2) {
                return -1;
            } else if (!isAction1 && isAction2) {
                return 1;
            } else {
                return Serie1.getNom().compareTo(Serie2.getNom());
            }
        }
        else if(objet1 instanceof Trailer && objet2 instanceof Trailer)
        {
            Trailer Trailer1 = (Trailer) objet1;
            Trailer Trailer2 = (Trailer) objet2;

            boolean isAction1 = Trailer1.getCategorieTrailer().equals("Action");
            boolean isAction2 = Trailer2.getCategorieTrailer().equals("Action");

            if (isAction1 && !isAction2) {
                return -1;
            } else if (!isAction1 && isAction2) {
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