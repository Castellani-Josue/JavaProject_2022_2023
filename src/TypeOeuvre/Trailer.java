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
    public Trailer(String n , int t, int i, LocalDate d, String desc, String e, CategorieOeuvre o, ClassificationOeuvre oe)
    {
        //super(n, t, i, d, desc, e);
        setCategorieTrailer(o);
        setClassificationTrailer(oe);
    }
    public ClassificationOeuvre getClassificationTrailer()
    {
        return classificationTrailer;
    }
    public CategorieOeuvre getCategorieTrailer()
    {
        return categorieTrailer;
    }
    public void setClassificationTrailer(ClassificationOeuvre classificationSerie)
    {
        if(classificationSerie.equals(ClassificationOeuvre.ALL) || classificationSerie.equals(ClassificationOeuvre.pegi6) || classificationSerie.equals(ClassificationOeuvre.pegi9) || classificationSerie.equals(ClassificationOeuvre.pegi12) || classificationSerie.equals(ClassificationOeuvre.pegi14) || classificationSerie.equals(ClassificationOeuvre.pegi16) || classificationSerie.equals(ClassificationOeuvre.pegi18))
            this.classificationTrailer = classificationSerie;
        else
            System.out.println("Classification inexistante !");
    }
    public void setCategorieTrailer(CategorieOeuvre categorieSerie)
    {
        if(categorieSerie.equals(CategorieOeuvre.CATEGORIE_AVENTURE) || categorieSerie.equals(CategorieOeuvre.CATEGORIE_ACTION) || categorieSerie.equals(CategorieOeuvre.CATEGORIE_DRAME) || categorieSerie.equals(CategorieOeuvre.CATEGORIE_HORREUR) || categorieSerie.equals(CategorieOeuvre.CATEGORIE_SCIENCEFICTION))
            this.categorieTrailer = categorieSerie;
        else
            System.out.println("Categorie invalide !");
    }
}
