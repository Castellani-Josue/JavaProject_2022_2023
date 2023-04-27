package Utilisateur;

import java.util.Objects;

public abstract class Personne
{

    protected String Nompersonne;
    protected   String  PrenomPersonne;
    protected String Login;
    protected String MotDePasse;

    public Personne()
    {
        Nompersonne = " ";
        PrenomPersonne = " ";
        Login = " ";
        MotDePasse = null;
    }
    public Personne(String nompersonne, String prenomPersonne , String  login , String motDePasse)
    {
        Nompersonne = nompersonne;
        PrenomPersonne = prenomPersonne;
        Login = login;
        MotDePasse = motDePasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne personne)) return false;
        return Objects.equals(getNompersonne(), personne.getNompersonne()) && Objects.equals(getPrenomPersonne(), personne.getPrenomPersonne()) && Objects.equals(getLogin(), personne.getLogin()) && Objects.equals(getMotDePasse(), personne.getMotDePasse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNompersonne(), getPrenomPersonne(), getLogin(), getMotDePasse());
    }

    public String getNompersonne()
    {
        return Nompersonne;
    }

    public void setNompersonne(String nompersonne)
    {
        Nompersonne = nompersonne;
    }

    public String getPrenomPersonne()
    {
        return PrenomPersonne;
    }

    public void setPrenomPersonne(String prenomPersonne)
    {
        PrenomPersonne = prenomPersonne;
    }

    public String getLogin()
    {
        return Login;
    }

    public void setLogin(String login)
    {
        Login = login;
    }

    public String getMotDePasse()
    {
        return MotDePasse;
    }

    public void setMotDePasse(String motDePasse)
    {
        MotDePasse = motDePasse;
    }

    // Methode abstraite qui pourra etre use dans les classes filles
    public abstract void affiche();


}
