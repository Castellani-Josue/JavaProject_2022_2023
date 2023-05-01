package TypeOeuvre;

import java.time.LocalDate;
import java.util.Objects;

public class Trailer extends Oeuvre
{
    private ClassificationOeuvre classificationTrailer;
    private CategorieOeuvre categorieTrailer;
    public Trailer()
    {
        super();
    }
    public Trailer(String n , int t, int i, LocalDate d, String desc, String e,String a, String st /*, CategorieOeuvre o, ClassificationOeuvre oe*/)
    {
        super(n, t, i, d, desc, e, a, st);
        //setCategorieTrailer(o);
        //setClassificationTrailer(oe);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trailer trailer)) return false;
        return Objects.equals(getClassificationTrailer(), trailer.getClassificationTrailer()) && Objects.equals(getCategorieTrailer(), trailer.getCategorieTrailer());
    }



    public static void main(String[] args)
    {
        LocalDate dateSortie = LocalDate.of(2022, 3, 15);
        Trailer trailer1 = new Trailer("Titre du film", 120, 123456, dateSortie, "Description du film", "Nom de l'éditeur", "Danois", "Polonais");
        System.out.println(trailer1.toString());
    }
}
