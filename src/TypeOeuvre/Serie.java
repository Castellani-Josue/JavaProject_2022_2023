package TypeOeuvre;
import Interface.AUneCotation;


import java.time.LocalDate;

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
    public Serie(String n , int t, int i, LocalDate d, String desc, String e, String a, String st /*CategorieOeuvre o, ClassificationOeuvre oe*/)
    {
        super(n, t, i, d, desc, e, a, st);
        setCotation(0);
        //setCategorieSerie(o);
        //setClassificationSerie(oe);
    }
    //getter et setter
    @Override
    public int getCotation()
    {
        return coteSerie;
    }
    public ClassificationOeuvre getClassificationSerie()
    {
        return classificationSerie;
    }
    public CategorieOeuvre getCategorieSerie()
    {
        return categorieSerie;
    }
    @Override
    public void setCotation(int coteSerie)
    {
        this.coteSerie = coteSerie;
    }
    public void setClassificationSerie(ClassificationOeuvre classificationSerie)
    {
        if(classificationSerie.equals(ClassificationOeuvre.ALL) || classificationSerie.equals(ClassificationOeuvre.pegi6) || classificationSerie.equals(ClassificationOeuvre.pegi9) || classificationSerie.equals(ClassificationOeuvre.pegi12) || classificationSerie.equals(ClassificationOeuvre.pegi14) || classificationSerie.equals(ClassificationOeuvre.pegi16) || classificationSerie.equals(ClassificationOeuvre.pegi18))
            this.classificationSerie = classificationSerie;
        else
            System.out.println("Classification inexistante !");
    }
    public void setCategorieSerie(CategorieOeuvre categorieSerie)
    {
        if(categorieSerie.equals(CategorieOeuvre.CATEGORIE_AVENTURE) || categorieSerie.equals(CategorieOeuvre.CATEGORIE_ACTION) || categorieSerie.equals(CategorieOeuvre.CATEGORIE_DRAME) || categorieSerie.equals(CategorieOeuvre.CATEGORIE_HORREUR) || categorieSerie.equals(CategorieOeuvre.CATEGORIE_SCIENCEFICTION))
            this.categorieSerie = categorieSerie;
        else
            System.out.println("Categorie invalide !");
    }

    @Override
    public String toString() {
        return "TypeOeuvre.Serie{" +
                "coteSerie=" + coteSerie +
                ", classificationSerie=" + classificationSerie +
                ", categorieSerie=" + categorieSerie +
                ", nom='" + nom + '\'' +
                ", temps=" + temps +
                ", identifiant=" + identifiant +
                ", dateSortie=" + dateSortie +
                ", description='" + description + '\'' +
                ", audio=" + audio +
                ", sousTitre=" + sousTitre +
                ", editeur='" + editeur + '\'' +
                '}';
    }
}
