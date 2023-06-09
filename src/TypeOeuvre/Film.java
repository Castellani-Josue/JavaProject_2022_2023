package TypeOeuvre;

import java.io.Serializable;
import java.time.LocalDate;
import Interface.AUneCotation;
public class Film extends Oeuvre implements AUneCotation
{
    int coteFilm;
    private ClassificationOeuvre classificationFilm;
    private CategorieOeuvre categorieFilm;
    //constructor
    public Film()
    {
        super();
        coteFilm = 0;
    }
    public Film(String n , int t, int i, LocalDate d, String desc, String e, String a, String st, String o, int oe)
    {
        super(n, t, i, d, desc, e, a, st);
        setCotation(0);
        setCategorieFilm(o);
        setClassificationFilm(oe);
    }
    //getter et setter
    @Override
    public int getCotation()
    {
        return coteFilm;
    }
    public int getClassificationFilm()
    {
        return classificationFilm.getNom();
    }
    public String getCategorieFilm()
    {
        return categorieFilm.getNom();
    }
    @Override
    public void setCotation(int coteFilm)
    {
        this.coteFilm = coteFilm;
    }

    public void setClassificationFilm(int classification)
    {
        switch(classification)
        {
            case 0:
                classificationFilm = ClassificationOeuvre.ALL;
                break;
            case 6:
                classificationFilm = ClassificationOeuvre.PEGI6;
                break;
            case 9:
                classificationFilm = ClassificationOeuvre.PEGI9;
                break;
            case 12:
                classificationFilm = ClassificationOeuvre.PEGI12;
                break;
            case 14:
                classificationFilm = ClassificationOeuvre.PEGI14;
                break;
            case 16:
                classificationFilm = ClassificationOeuvre.PEGI16;
                break;
            case 18:
                classificationFilm = ClassificationOeuvre.PEGI18;
                break;
            default:
                System.out.println("Classification inexistante !");
                break;
        }
    }
    public void setCategorieFilm(String categorie)
    {
        switch(categorie)
        {
            case "Horreur":
                categorieFilm = CategorieOeuvre.HORREUR;
                break;
            case "Drame":
                categorieFilm = CategorieOeuvre.DRAME;
                break;
            case "Action":
                categorieFilm = CategorieOeuvre.ACTION;
                break;
            case "Aventure":
                categorieFilm = CategorieOeuvre.AVENTURE;
                break;
            case "Science-Fiction":
                categorieFilm = CategorieOeuvre.SCIENCEFICTION;
                break;
            default:
                System.out.println("Categorie inexistante !");
                break;
        }
    }

    @Override
    public String toString() {
        /*return "Film{" +
                "coteFilm=" + coteFilm +
                ", classificationFilm=" + getClassificationFilm() +
                ", categorieFilm='" + getCategorieFilm() + '\'' +
                ", nom='" + nom + '\'' +
                ", temps=" + temps +
                ", identifiant=" + identifiant +
                ", dateSortie=" + dateSortie +
                ", description='" + description + '\'' +
                ", audio=" + audio +
                ", sousTitre=" + sousTitre +
                ", editeur='" + editeur + '\'' +
                '}';*/

        return nom;


    }



    public static void main(String[] args)
    {
        LocalDate dateSortie = LocalDate.of(2022, 3, 15);
        Film film1 = new Film("Titre du film", 120, 123456, dateSortie, "Description du film", "Nom de l'éditeur", "Français", "Espagnol","Drame",9);
        System.out.println(film1.toString());
    }
}