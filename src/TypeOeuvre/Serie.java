package TypeOeuvre;

import java.io.Serializable;
import java.time.LocalDate;
import Interface.AUneCotation;
public class Serie extends Oeuvre implements AUneCotation
{
    int coteSerie;
    private ClassificationOeuvre classificationSerie;
    private CategorieOeuvre categorieSerie;
    //constructor
    public Serie()
    {
        super();
        coteSerie = 0;
    }
    public Serie(String n , int t, int i, LocalDate d, String desc, String e, String a, String st, String o, int oe)
    {
        super(n, t, i, d, desc, e, a, st);
        setCotation(0);
        setCategorieSerie(o);
        setClassificationSerie(oe);
    }
    //getter et setter
    @Override
    public int getCotation()
    {
        return coteSerie;
    }
    public int getClassificationSerie()
    {
        return classificationSerie.getNom();
    }
    public String getCategorieSerie()
    {
        return categorieSerie.getNom();
    }
    @Override
    public void setCotation(int coteSerie)
    {
        this.coteSerie = coteSerie;
    }
    public void setClassificationSerie(int classification)
    {
        switch(classification)
        {
            case 0:
                classificationSerie = ClassificationOeuvre.ALL;
                break;
            case 6:
                classificationSerie = ClassificationOeuvre.PEGI6;
                break;
            case 9:
                classificationSerie = ClassificationOeuvre.PEGI9;
                break;
            case 12:
                classificationSerie = ClassificationOeuvre.PEGI12;
                break;
            case 14:
                classificationSerie = ClassificationOeuvre.PEGI14;
                break;
            case 16:
                classificationSerie = ClassificationOeuvre.PEGI16;
                break;
            case 18:
                classificationSerie = ClassificationOeuvre.PEGI18;
                break;
            default:
                System.out.println("Classification inexistante !");
                break;
        }
    }
    public void setCategorieSerie(String categorie)
    {
        switch(categorie)
        {
            case "Horreur":
                categorieSerie = CategorieOeuvre.HORREUR;
                break;
            case "Drame":
                categorieSerie = CategorieOeuvre.DRAME;
                break;
            case "Action":
                categorieSerie = CategorieOeuvre.ACTION;
                break;
            case "Aventure":
                categorieSerie = CategorieOeuvre.AVENTURE;
                break;
            case "Science-Fiction":
                categorieSerie = CategorieOeuvre.SCIENCEFICTION;
                break;
            default:
                System.out.println("Categorie inexistante !");
                break;
        }
    }

    @Override
    public String toString() {
        /*return "TypeOeuvre.Serie{" +
                "coteSerie=" + coteSerie +
                ", classificationSerie=" + getClassificationSerie() +
                ", categorieSerie=" + getCategorieSerie() +
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
        Serie serie1 = new Serie("Titre du film", 120, 123456, dateSortie, "Description du film", "Nom de l'éditeur", "Anglais", "Japonais","Science-Fiction",18);
        System.out.println(serie1.toString());
    }
}
