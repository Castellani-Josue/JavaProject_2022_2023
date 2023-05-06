package TypeOeuvre;

public class CategorieOeuvre
{
    private String nom;

    public CategorieOeuvre()
    {
        nom = "PAS DE CATEGORIE";
    }
    public CategorieOeuvre(String n)
    {
        nom = n;
    }
    public String getNom()
    {
        return nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    public static final CategorieOeuvre HORREUR = new CategorieOeuvre("Horreur");
    public static final CategorieOeuvre ACTION = new CategorieOeuvre("Action");
    public static final CategorieOeuvre SCIENCEFICTION = new CategorieOeuvre("Science-Fiction");
    public static final CategorieOeuvre AVENTURE = new CategorieOeuvre("Aventure");
    public static final CategorieOeuvre DRAME = new CategorieOeuvre("Drame");

    @Override
    public String toString() {
        return "CategorieOeuvre{" +
                "nom='" + nom + '\'' +
                '}';
    }
}