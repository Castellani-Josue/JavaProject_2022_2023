package Utilisateur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCreateAccount extends JDialog
{


    private String login;
    private String motDePasse;
    private boolean Confirmer;


    public InterfaceCreateAccount(java.awt.Frame parent, boolean modal)
    {
        super(parent,modal);
        initComponents();
    }

    private void initComponents()
    {
        setTitle("Création Compte");
        //setSize(500, 200);
        setContentPane(Main);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
        ButtonCreate = new javax.swing.JButton();

        Confirmer  = false;
        //ButtonCreate.setText("CONFIRMER");
        ButtonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                login = LoginTextfield.getText();
                motDePasse = Mdpfield.getText();
                Confirmer = true;
                setVisible(false);

            }
        });



    }

    public static void main(String[] args)
    {

        InterfaceCreateAccount jdialog = new InterfaceCreateAccount(null,true);
        jdialog.setVisible(true);
        if(jdialog.isConfirmer())
        {
            System.out.println("Login = " + jdialog.getLogin());
            System.out.println("Mot de passe = " + jdialog.getMotDePasse());
        }
        jdialog.dispose();
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
}


