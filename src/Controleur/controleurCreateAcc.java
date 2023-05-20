package Controleur;

import InterfaceGraphique.InterfaceCreate_Account;
import Utilisateur.client;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.*;
import java.awt.event.ActionEvent;
public class controleurCreateAcc
{

   /* private InterfaceCreate_Account fenetreCreate;
    private client cli;
    private boolean Confirmer;

    public controleurCreateAcc(InterfaceCreate_Account fenetreCreate)
    {
        this.fenetreCreate = fenetreCreate;
        this.fenetreCreate.setControleurCreateAcc(this);
    }



    //@Override
    public void actionPerformed(ActionEvent e) {
        //cli = new client();
        //Confirmer=false;
        if (e.getSource() == fenetreCreate.getButtonCreate()) {
            String login = fenetreCreate.getLoginTextfield().getText();
            String motDePasse = new String(fenetreCreate.getMdpfield().getPassword());

            boolean isValidLogin = client.isValidLogin(login);
            boolean isValidPassword = client.isValidPassword(motDePasse);

            if (isValidLogin && isValidPassword) {
                // lorsque le login et le mot de passe sont valides
                System.out.println("Login et mot de passe valides");
            } else {
                // lorsque le login et/ou le mot de passe sont invalides
                System.out.println("Erreur(s) d'encodage");
            }
        }
    }


    public void windowClosing(WindowEvent we) { System.exit(0); }

    public void windowOpened(WindowEvent we) {}
    public void windowClosed(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent we) {}*/
}
