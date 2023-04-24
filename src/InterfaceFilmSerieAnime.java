import javax.swing.*;

public class InterfaceFilmSerieAnime extends javax.swing.JFrame
{
    private JTextField idTextField,titreTextField, dureeTextField, date_SortieTextField, descriptionTextField;
    private JPanel PanelMain;
    private JCheckBox pegi12CheckBox,pegi16CheckBox,pegi18CheckBox,actionCheckBox,dramaCheckBox,comedieCheckBox,thrillerCheckBox;
    private JLabel GenreLabel , PegiLabel , descriptionLabel ,date_SortieLabel , dureeLabel,titreLabel,idLabel;
    private JComboBox<String> ChoixOeuvre;

    public InterfaceFilmSerieAnime()
    {
        initComponents();
    }

    private void initComponents()
    {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ajouter UN Film");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        ChoixOeuvre = new JComboBox<>(new String[]{"Film", "Série", "Animé"});
    }

    private static void main(String[] args)
    {
        InterfaceFilmSerieAnime dlm = new InterfaceFilmSerieAnime();
        dlm.setVisible(true);
    }




}
