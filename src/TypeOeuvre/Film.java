package TypeOeuvre;

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
    public Film(String n , int t, int i, LocalDate d, String desc, String e, String a, String st/*, CategorieOeuvre o, ClassificationOeuvre oe*/)
    {
        super(n, t, i, d, desc, e, a, st);
        setCotation(0);
        //setCategorieFilm(o);
        //setClassificationFilm(oe);
    }
    //getter et setter
    @Override
    public int getCotation()
    {
        return coteFilm;
    }
    public ClassificationOeuvre getClassificationFilm()
    {
        return classificationFilm;
    }
    public CategorieOeuvre getCategorieFilm()
    {
        return categorieFilm;
    }
    @Override
    public void setCotation(int coteFilm)
    {
        this.coteFilm = coteFilm;
    }

    public void setClassificationFilm(ClassificationOeuvre classificationFilm)
    {
        if(classificationFilm.equals(ClassificationOeuvre.ALL) || classificationFilm.equals(ClassificationOeuvre.pegi6) || classificationFilm.equals(ClassificationOeuvre.pegi9) || classificationFilm.equals(ClassificationOeuvre.pegi12) || classificationFilm.equals(ClassificationOeuvre.pegi14) || classificationFilm.equals(ClassificationOeuvre.pegi16) || classificationFilm.equals(ClassificationOeuvre.pegi18))
            this.classificationFilm = classificationFilm;
        else
            System.out.println("Classification inexistante !");
    }
    public void setCategorieFilm(CategorieOeuvre categorieFilm)
    {
        if(categorieFilm.equals(CategorieOeuvre.CATEGORIE_AVENTURE) || categorieFilm.equals(CategorieOeuvre.CATEGORIE_ACTION) || categorieFilm.equals(CategorieOeuvre.CATEGORIE_DRAME) || categorieFilm.equals(CategorieOeuvre.CATEGORIE_HORREUR) || categorieFilm.equals(CategorieOeuvre.CATEGORIE_SCIENCEFICTION))
            this.categorieFilm = categorieFilm;
        else
            System.out.println("Categorie invalide !");
    }

    @Override
    public String toString() {
        return "Film{" +
                "coteFilm=" + coteFilm +
                ", classificationFilm=" + classificationFilm +
                ", categorieFilm='" + categorieFilm + '\'' +
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

    public static void main(String[] args)
    {
        LocalDate dateSortie = LocalDate.of(2022, 3, 15);
        Film film1 = new Film("Titre du film", 120, 123456, dateSortie, "Description du film", "Nom de l'éditeur", "Français", "Espagnol");
        System.out.println(film1.toString());
    }
}
