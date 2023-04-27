package InterfaceGraphique;

import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;

public class InterfaceFilmSerieAnime extends JFrame
{
    private JTextField idTextField ;
    private JTextField TitreTextField;
    private JTextField Date_SortieTextField;
    private JTextField descriptionTextField;
    private JTextField DureeTextField;
    private JPanel PanelMain;
    private JLabel  descriptionLabel ,date_SortieLabel , dureeLabel,titreLabel,idLabel ,PegiLabel,catégorieLabel,ComboboxLabel;

    //Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    //idTextField = new JTextField(10);
    //titreTextField = new JTextField(20);
    //dureeTextField = new JTextField(10);
    //date_SortieTextField = new JTextField(10);
    //descriptionTextField = new JTextField(30);


    private JPanel PanelPegi;
    private JRadioButton Pegi10Button;
    private JRadioButton Pegi12Button;
    private JRadioButton Pegi16Button;
    private JRadioButton Pegi18Button;
    private JRadioButton GenreComédie;
    private JRadioButton GenreThriller;
    private JRadioButton GenreHorreur;
    private JRadioButton GenreAction;
    private JLabel Editeur;
    private JTextField EditeurTextField;
    private JLabel AudioLabel;
    private JLabel SousTitreLabel;
    private JButton ButtonConfrimer;


    public InterfaceFilmSerieAnime()
    {
        initComponents();

    }

    private void initComponents() {
        setTitle("Ajouter Une Oeuvre");

        setContentPane(PanelMain);
        setLocationRelativeTo(null);
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        //ChoixOeuvre = new JComboBox<>();



    }



    public static void main(String[] args)
    {

        InterfaceFilmSerieAnime frame = new InterfaceFilmSerieAnime();
        frame.setVisible(true);
    }


}
