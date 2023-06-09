package TypeOeuvre;

import java.io.Serializable;
import java.time.LocalDate;
import Interface.AUneCotation;

public class Anime extends Oeuvre implements AUneCotation
{
    int coteAnime;
    private ClassificationOeuvre classificationAnime;
    private CategorieOeuvre categorieAnime;
    //constructor
    public Anime()
    {
        super();
        coteAnime = 0;
    }
    public Anime(String n , int t, int i, LocalDate d, String desc, String e, String a, String st , String o, int oe)
    {
        super(n, t, i, d, desc, e,a, st);
        setCotation(0);
        setCategorieAnime(o);
        setClassificationAnime(oe);
    }
    //getter et setter
    @Override
    public int getCotation()
    {
        return coteAnime;
    }
    public int getClassificationAnime()
    {
        return classificationAnime.getNom();
    }
    public String getCategorieAnime()
    {
        return categorieAnime.getNom();
    }
    @Override
    public void setCotation(int coteAnime)
    {
        this.coteAnime = coteAnime;
    }
    public void setClassificationAnime(int classification)
    {
        switch(classification)
        {
            case 0:
                classificationAnime = ClassificationOeuvre.ALL;
                break;
            case 6:
                classificationAnime = ClassificationOeuvre.PEGI6;
                break;
            case 9:
                classificationAnime = ClassificationOeuvre.PEGI9;
                break;
            case 12:
                classificationAnime = ClassificationOeuvre.PEGI12;
                break;
            case 14:
                classificationAnime = ClassificationOeuvre.PEGI14;
                break;
            case 16:
                classificationAnime = ClassificationOeuvre.PEGI16;
                break;
            case 18:
                classificationAnime = ClassificationOeuvre.PEGI18;
                break;
            default:
                System.out.println("Classification inexistante !");
                break;
        }
    }
    public void setCategorieAnime(String categorie)
    {
        switch(categorie)
        {
            case "Horreur":
                categorieAnime = CategorieOeuvre.HORREUR;
                break;
            case "Drame":
                categorieAnime = CategorieOeuvre.DRAME;
                break;
            case "Action":
                categorieAnime = CategorieOeuvre.ACTION;
                break;
            case "Aventure":
                categorieAnime = CategorieOeuvre.AVENTURE;
                break;
            case "Science-Fiction":
                categorieAnime = CategorieOeuvre.SCIENCEFICTION;
                break;
            default:
                System.out.println("Categorie inexistante !");
                break;
        }
    }

    @Override
    public String toString() {
        /*return "Anime{" +
                "coteAnime=" + coteAnime +
                ", classificationAnime=" + getClassificationAnime() +
                ", categorieAnime=" + getCategorieAnime() +
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
        Anime anime1 = new Anime("Titre du film", 120, 123456, dateSortie, "Description du film", "Nom de l'éditeur", "Allemand", "Arabe","Horreur", 0);
        System.out.println(anime1.toString());
    }
}