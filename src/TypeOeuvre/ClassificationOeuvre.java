package TypeOeuvre;

import java.io.Serializable;

public class ClassificationOeuvre implements Serializable
{
    private int pegi;

    public ClassificationOeuvre()
    {
        pegi = -1;
    }
    public ClassificationOeuvre(int n)
    {
        pegi = n;
    }
    public int getNom()
    {
        return pegi;
    }
    public void setNom(int nom)
    {
        this.pegi = nom;
    }
    public static final ClassificationOeuvre ALL = new ClassificationOeuvre(0);
    public static final ClassificationOeuvre PEGI6 = new ClassificationOeuvre(6);
    public static final ClassificationOeuvre PEGI9 = new ClassificationOeuvre(9);
    public static final ClassificationOeuvre PEGI12 = new ClassificationOeuvre(12);
    public static final ClassificationOeuvre PEGI14 = new ClassificationOeuvre(14);
    public static final ClassificationOeuvre PEGI16 = new ClassificationOeuvre(16);
    public static final ClassificationOeuvre PEGI18 = new ClassificationOeuvre(18);

    @Override
    public String toString() {
        return "ClassificationOeuvre{" +
                "pegi=" + pegi +
                '}';
    }
}

