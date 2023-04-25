import javax.swing.*;

public class InterfaceCreateAccount extends JFrame
{
    private JTextField NomTextField;
    private JTextField PrenomTextField;
    private JLabel NomLabel;
    private JLabel PrenomLabel;
    private JPanel Main;
    private JLabel LoginLabel;
    private JPasswordField Mdpfield;
    private JTextField MdpTextField;
    private JLabel MdpLabel;
    private JPanel InfoPanel;
    private JLabel InfoLabel;
    private JButton ButtonCreate;
    private JLabel TelLabel;
    private JTextField TeltextField;


    public InterfaceCreateAccount()
    {
        initComponents();
    }

    private void initComponents()
    {
        setTitle("Ajouter Une Oeuvre");
        setSize(500, 200);
        setContentPane(Main);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {

        InterfaceCreateAccount frame = new InterfaceCreateAccount();
        frame.setVisible(true);
    }
}
