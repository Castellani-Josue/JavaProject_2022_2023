package  Utilisateur;

import Interface.AUnIdentifiant;

import java.io.Serializable;

public class ListeFavoris implements AUnIdentifiant , Serializable
{
    protected int identifiantFilm;
    public ListeFavoris(int idFilm)
    {
        setIdentifiant(idFilm);
    }
    @Override
    public boolean getIdentifiant()
    {
        return true;
    }

    @Override
    public void setIdentifiant(int i)
    {
        identifiantFilm = i;
    }

    @Override
    public String toString() {
        return "ListeFavoris{" +
                "identifiantFilm=" + identifiantFilm +
                '}';
    }
}
