package Utilisateur;

import javax.swing.*;
import javax.swing.JComboBox;

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

    private JComboBox<String> ChoixOeuvre;
    private JPanel PanelPegi;
    private JRadioButton Pegi10Button;
    private JRadioButton Pegi12Button;
    private JRadioButton Pegi16Button;
    private JRadioButton Pegi18Button;
    private JRadioButton GenreComédie;
    private JRadioButton GenreThriller;
    private JRadioButton GenreHorreur;
    private JRadioButton GenreAction;
    private JButton Buttonchoix;
    private JLabel ChoixLabel;
    private JButton ButtonIcon;
    private JLabel Editeur;
    private JTextField EditeurTextField;


    public InterfaceFilmSerieAnime()
    {
        initComponents();
        //PanelMain.remove(ChoixOeuvre);
        String[] ch = {"Film", "Série", "Animé","Trailer"};
        JComboBox<String> ChoixOeuvre = new JComboBox<String>(ch);

    }

    private void initComponents()
    {
        setTitle("Ajouter Une Oeuvre");
        setSize(400, 300);
        setContentPane(PanelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //ChoixOeuvre = new JComboBox<>();



        //ChoixOeuvre.setModel(new DefaultComboBoxModel<>(new String[] {"Item 1","Item 2","Item 3","Item 4"}));
        ChoixOeuvre.setModel(new DefaultComboBoxModel<>(new String[] {"Film", "Série", "Animé","Trailer"}));
        Buttonchoix.addActionListener(new java.awt.event.ActionListener()
        {public void actionPerformed(java.awt.event.ActionEvent evt){ButtonchoixActionPerformed(evt);}});


        pack();


    }

    private void ButtonchoixActionPerformed(java.awt.event.ActionEvent evt)
    {
        System.out.println("Choix : " + ChoixOeuvre.getSelectedItem());
    }

    public static void main(String[] args)
    {

        InterfaceFilmSerieAnime frame = new InterfaceFilmSerieAnime();
        frame.setVisible(true);
    }


}
