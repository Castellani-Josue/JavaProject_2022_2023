package Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfaceCreate_Account extends JDialog
{


        private String login;
        private String motDePasse;
        private boolean Confirmer;

    private JTextField NomTextField;
    private JTextField PrenomTextField;
    private JLabel NomLabel;
    private JLabel PrenomLabel;
    private JPanel Main;
    private JLabel LoginLabel;
    private JPasswordField Mdpfield;
    private JTextField LoginTextfield;
    private JLabel MdpLabel;
    private JPanel InfoPanel;
    private JLabel InfoLabel;
    private JButton ButtonCreate;
    private JLabel TelLabel;
    private JTextField TeltextField;


        public InterfaceCreate_Account(JFrame parent, boolean modal,String titre)
        {
            super(parent,modal);
            setTitle(titre);
            setContentPane(Main);
            setLocationRelativeTo(null);
            pack();
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

            Confirmer = false;
            ButtonCreate.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    login = LoginTextfield.getText();
                    motDePasse = new String(Mdpfield.getPassword());
                    Confirmer = true;
                    setVisible(false);
                }
            });


        }

        public static void main(String[] args)
        {

            InterfaceCreate_Account interfaceCreate_Account = new InterfaceCreate_Account(null,true,"Session de connexion");
            interfaceCreate_Account.setVisible(true);
            if(interfaceCreate_Account.isConfirmer())
            {
                System.out.println("Login = " + interfaceCreate_Account.getLogin());
                System.out.println("Mot de passe = " + interfaceCreate_Account.getMotDePasse());
            }
            interfaceCreate_Account.dispose();
        }

        public String getLogin()
        {
            return login;
        }

        public String getMotDePasse()
        {
            return motDePasse;
        }

        public boolean isConfirmer()
        {
            return Confirmer;
        }


}

