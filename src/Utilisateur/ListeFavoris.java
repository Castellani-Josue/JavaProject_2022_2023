package  Utilisateur;

import Interface.AUnIdentifiant;

public class ListeFavoris implements AUnIdentifiant
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
