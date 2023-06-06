package InterfaceGraphique;


import Controleur.controleur;
import Utilisateur.client;

import javax.swing.*;
import java.awt.*;


public class InterfaceCreate_Account extends JDialog
{



    private client cli;


        private String login;
        private String motDePasse;

        private String Telephone;

        private String Nompersonne;

        private String PrenomPersonne;
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
    private JLabel LogoLabel;
    private JTextField idtextfield;
    private JLabel IdLabel;
    private JRadioButton GenreSCIENCEFICTION;
    private JRadioButton GenreDrame;
    private JRadioButton GenreAction;
    private JRadioButton GenreHorreur;
    private JRadioButton GenreAventure;
    private JLabel Preferencelabel;


    public InterfaceCreate_Account(JFrame parent, boolean modal,String titre)
        {
            super(parent,modal);
            setTitle(titre);
            setContentPane(Main);
            setLocationRelativeTo(null);
            setModal(true);
            pack();
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(1200,700);
            setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
            ImageIcon logoIcon = new ImageIcon("C:\\Users\\josue\\OneDrive\\Documents\\HEPL\\B2\\q2\\Java\\Labo\\netflix.png");
            setIconImage(logoIcon.getImage());

            cli = new client();
            Confirmer = false;
            /*ButtonCreate.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    login = LoginTextfield.getText();
                    boolean isValidLogin = cli.isValidLogin(login);
                    motDePasse = new String(Mdpfield.getPassword());
                    boolean isValidPassword = cli.isValidPassword(motDePasse);
                    Nompersonne = NomTextField.getText();
                    PrenomPersonne = PrenomTextField.getText();
                    Telephone = TeltextField.getText();
                    boolean isValidTelephone = cli.isValidTelephone(Telephone);


                    Confirmer = true;                    setVisible(false);

                    if (isValidLogin && isValidPassword && isValidTelephone) {
                        Confirmer = true;

                        setVisible(false);
                    } else
                    {
                        //System.out.println("Erreur(s) d'encodation");
                        if(!isValidLogin && isValidPassword ) {
                            JOptionPane.showMessageDialog(InterfaceCreate_Account.this, "login incorrect", "Erreur(s) d'encodation", JOptionPane.INFORMATION_MESSAGE,null);
                            setVisible(true);
                        } else if (!isValidPassword && isValidLogin)
                        {
                            JOptionPane.showMessageDialog(InterfaceCreate_Account.this, "Password incorrect", "Erreur(s) d'encodation", JOptionPane.INFORMATION_MESSAGE,null);
                            setVisible(true);
                        } else if (!isValidTelephone)
                        {
                            JOptionPane.showMessageDialog(InterfaceCreate_Account.this, "N° telephone incorrect", "Erreur(s) d'encodation", JOptionPane.INFORMATION_MESSAGE,null);
                        } else
                        {
                            JOptionPane.showMessageDialog(InterfaceCreate_Account.this, "Login et password incorect", "Erreur(s) d'encodation", JOptionPane.INFORMATION_MESSAGE,null);
                            setVisible(true);
                        }


                    }
                }
            });*/



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

        public JTextField getLogin()
        {
            return LoginTextfield;
        }

        public JPasswordField getMotDePasse()
        {
            return Mdpfield;
        }

        public JTextField getTelephone()
    {
        return TeltextField;
    }
         public JTextField getNompersonne()
    {
        return NomTextField;
    }

        public JTextField getPrenomPersonne()
    {
        return PrenomTextField;
    }

    public JRadioButton getGenreSF(){return GenreSCIENCEFICTION;}
    public JRadioButton getGenreHorreur(){return GenreHorreur;}
    public JRadioButton getGenreDrame(){return GenreDrame;}
    public JRadioButton getGenreAction(){return GenreAction;}

    public JRadioButton getGenreAventure(){return GenreAventure;}


        public boolean isConfirmer()
        {
            return Confirmer;
        }



    public JButton getButtonCreate() {
        return ButtonCreate;
    }

    public void setControleur(controleur controleur1)
    {
        ButtonCreate.addActionListener(controleur1);


    }
}

