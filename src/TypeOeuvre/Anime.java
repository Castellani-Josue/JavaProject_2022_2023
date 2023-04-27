package TypeOeuvre;

import Interface.AUneCotation;
import java.time.LocalDate;


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
    public Anime(String n , int t, int i, LocalDate d, String desc, String e, CategorieOeuvre o, ClassificationOeuvre oe)
    {
        //super(n, t, i, d, desc, e);
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
    public ClassificationOeuvre getClassificationAnime()
    {
        return classificationAnime;
    }
    public CategorieOeuvre getCategorieAnime()
    {
        return categorieAnime;
    }
    @Override
    public void setCotation(int coteAnime)
    {
        this.coteAnime = coteAnime;
    }
    public void setClassificationAnime(ClassificationOeuvre classificationAnime)
    {
        if(classificationAnime.equals(ClassificationOeuvre.ALL) || classificationAnime.equals(ClassificationOeuvre.pegi6) || classificationAnime.equals(ClassificationOeuvre.pegi9) || classificationAnime.equals(ClassificationOeuvre.pegi12) || classificationAnime.equals(ClassificationOeuvre.pegi14) || classificationAnime.equals(ClassificationOeuvre.pegi16) || classificationAnime.equals(ClassificationOeuvre.pegi18))
            this.classificationAnime = classificationAnime;
        else
            System.out.println("Classification inexistante !");
    }
    public void setCategorieAnime(CategorieOeuvre categorieAnime)
    {
        if(categorieAnime.equals(CategorieOeuvre.CATEGORIE_AVENTURE) || categorieAnime.equals(CategorieOeuvre.CATEGORIE_ACTION) || categorieAnime.equals(CategorieOeuvre.CATEGORIE_DRAME) || categorieAnime.equals(CategorieOeuvre.CATEGORIE_HORREUR) || categorieAnime.equals(CategorieOeuvre.CATEGORIE_SCIENCEFICTION))
            this.categorieAnime = categorieAnime;
        else
            System.out.println("Categorie invalide !");
    }

    @Override
    public String toString() {
        return "TypeOeuvre.Anime{" +
                "coteAnime=" + coteAnime +
                ", classificationAnime=" + classificationAnime +
                ", categorieAnime=" + categorieAnime +
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
