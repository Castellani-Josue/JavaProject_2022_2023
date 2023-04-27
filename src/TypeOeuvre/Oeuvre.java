package TypeOeuvre;
import Interface.AUnIdentifiant;

import java.time.LocalDate;
import java.util.ArrayList;

public class Oeuvre  implements AUnIdentifiant
{
    protected String nom;
    protected int temps;
    protected int identifiant;
    protected LocalDate dateSortie;
    protected String description;
    protected ArrayList<String> audio = new ArrayList<String>();
    protected ArrayList<String> sousTitre = new ArrayList<String>();
    protected String editeur;

    //constructor
    public Oeuvre()
    {
        nom ="inconnu";
        temps = 0;
        identifiant = 0;
        dateSortie = LocalDate.of(2000, 1, 1);
        description = "description vide";
        editeur = "editeur inconnu";
    }
    public Oeuvre(String n ,int t,int i, LocalDate d, String desc, String e, String a,String st)
    {
        setNom(n);
        setTemps(t);
        setIdentifiant(i);
        setDateSortie(d);
        setDescription(desc);
        setEditeur(e);
        audio.add(a);
        sousTitre.add(st);
    }

    //getter et setter
    public String getNom()
    {
        return nom;
    }
    public int getTemps()
    {
        return temps;
    }
    @Override
    public int getIdentifiant()
    {
        return identifiant;
    }
    public LocalDate getDateSortie()
    {
        return dateSortie;
    }
    public String getDescription()
    {
        return description;
    }
    public String getEditeur()
    {
        return editeur;
    }
    public void setNom(String n)
    {
        nom = n;
    }
    public void setTemps(int t)
    {
        temps = t;
    }
    @Override
    public void setIdentifiant(int i)
    {
        identifiant = i;
    }
    public void setDateSortie(LocalDate d)
    {
        dateSortie = d;
    }
    public void setDescription(String d)
    {
        description = d;
    }
    public void setEditeur(String e)
    {
        editeur = e;
    }
}
