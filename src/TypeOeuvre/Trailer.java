package TypeOeuvre;

import java.time.LocalDate;

public class Trailer extends Oeuvre
{
    private ClassificationOeuvre classificationTrailer;
    private CategorieOeuvre categorieTrailer;
    public Trailer()
    {
        super();
    }
    public Trailer(String n , int t, int i, LocalDate d, String desc, String e,String a, String st , String o, int oe)
    {
        super(n, t, i, d, desc, e, a, st);
        setCategorieTrailer(o);
        setClassificationTrailer(oe);
    }
    public int getClassificationTrailer()
    {
        return classificationTrailer.getNom();
    }
    public String getCategorieTrailer()
    {
        return categorieTrailer.getNom();
    }
    public void setClassificationTrailer(int classification)
    {
        switch(classification)
        {
            case 0:
                classificationTrailer = ClassificationOeuvre.ALL;
                break;
            case 6:
                classificationTrailer = ClassificationOeuvre.PEGI6;
                break;
            case 9:
                classificationTrailer = ClassificationOeuvre.PEGI9;
                break;
            case 12:
                classificationTrailer = ClassificationOeuvre.PEGI12;
                break;
            case 14:
                classificationTrailer = ClassificationOeuvre.PEGI14;
                break;
            case 16:
                classificationTrailer = ClassificationOeuvre.PEGI16;
                break;
            case 18:
                classificationTrailer = ClassificationOeuvre.PEGI18;
                break;
            default:
                System.out.println("Classification inexistante !");
                break;
        }
    }
    public void setCategorieTrailer(String categorie)
    {
        switch(categorie)
        {
            case "Horreur":
                categorieTrailer = CategorieOeuvre.HORREUR;
                break;
            case "Drame":
                categorieTrailer = CategorieOeuvre.DRAME;
                break;
            case "Action":
                categorieTrailer = CategorieOeuvre.ACTION;
                break;
            case "Aventure":
                categorieTrailer = CategorieOeuvre.AVENTURE;
                break;
            case "Science-Fiction":
                categorieTrailer = CategorieOeuvre.SCIENCEFICTION;
                break;
            default:
                System.out.println("Categorie inexistante !");
                break;
        }
    }

    @Override
    public String toString() {
        /*return "Trailer{" +
                "classificationTrailer=" + getClassificationTrailer() +
                ", categorieTrailer=" + getCategorieTrailer() +
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
        Trailer trailer1 = new Trailer("Titre du film", 120, 123456, dateSortie, "Description du film", "Nom de l'éditeur", "Danois", "Polonais","Aventure",14);
        System.out.println(trailer1.toString());
    }
}