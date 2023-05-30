package InterfaceGraphique;

import Controleur.controleur;
import Utilisateur.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InterfaceConnection  extends JDialog
{
    private client cli;
    
        private String login;
        private String motDePasse;
        private boolean Confirmer;
    private JPanel Main;
    private JLabel LoginLabel;
    private JLabel InfoLabel;
    private JTextField Logintextfield;
    private JPasswordField mdpfield;
    private JButton ButtonConfirmer;
    private JLabel mdpLabel;
    private JLabel Iconlabel;

    public InterfaceConnection(JFrame parent,boolean modal,String titre)
        {
            super(parent,modal);
            setTitle(titre);
            setContentPane(Main);
            setLocationRelativeTo(null);
            pack();
            setModal(true);
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(1000,700);
            setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
            ImageIcon logoIcon = new ImageIcon("C:\\Users\\josue\\OneDrive\\Documents\\HEPL\\B2\\q2\\Java\\Labo\\netflix.png");
            setIconImage(logoIcon.getImage());

            Confirmer = false;
           /* ButtonConfirmer.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    login = Logintextfield.getText();
                    boolean isValidLogin = cli.isValidLogin(login);
                    motDePasse = new String(mdpfield.getPassword());
                    boolean isValidPassword = cli.isValidPassword(motDePasse);
                    Confirmer = true;
                    setVisible(false);

                    if (isValidLogin && isValidPassword) {
                        Confirmer = true;
                        setVisible(false);
                    } else {
                        //System.out.println("Erreur(s) d'encodation");
                        if (!isValidLogin && isValidPassword) {
                            JOptionPane.showMessageDialog(InterfaceConnection.this, "login incorrect", "Erreur d'authentification", JOptionPane.INFORMATION_MESSAGE, null);
                            setVisible(true);
                        } else if (!isValidPassword && isValidLogin) {
                            JOptionPane.showMessageDialog(InterfaceConnection.this, "Password incorrect", "Erreur d'authentification", JOptionPane.INFORMATION_MESSAGE, null);
                            setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(InterfaceConnection.this, "Login et password incorect", "Erreur d'authentification", JOptionPane.INFORMATION_MESSAGE, null);
                            setVisible(true);
                        }
                    }
                }
            });*/



        }

    /*public InterfaceConnection()
    {
        setContentPane(Main);
        setLocationRelativeTo(null);
        setModal(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,700);
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        Confirmer = false;
        ButtonConfirmer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                login = Logintextfield.getText();
                motDePasse = new String(mdpfield.getPassword());
                Confirmer = true;
                setVisible(false);
            }
        });




    }*/



    public static void main(String[] args)
        {
            InterfaceConnection interfaceConnection = new InterfaceConnection(null,true,"Entrée en session...");
            interfaceConnection.setVisible(true);
            if (interfaceConnection.isConfirmer())
            {
                System.out.println("Login = " + interfaceConnection.getLogin());
                System.out.println("Mot de passe = " + interfaceConnection.getMotDePasse());
            }
            interfaceConnection.dispose();
        }

        public JTextField getLogin()
        {
            return Logintextfield;
        }

        public JPasswordField getMotDePasse()
        {
            return mdpfield;
        }

        public boolean isConfirmer()
        {
            return Confirmer;
        }

    public void setControleur(controleur controleur1)
    {
        ButtonConfirmer.addActionListener(controleur1);



    }


}
