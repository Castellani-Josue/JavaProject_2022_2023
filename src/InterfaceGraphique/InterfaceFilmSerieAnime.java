package InterfaceGraphique;

import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceFilmSerieAnime extends JFrame
{
    private JTextField idTextField ;
    private String id;
    private JTextField TitreTextField;
    private String titre;
    private JTextField Date_SortieTextField;
    private JTextField descriptionTextField;
    private String description;
    private JTextField DureeTextField;
    private String duree;
    private JPanel PanelMain;
    private boolean Confirmer;
    private JLabel  descriptionLabel ,date_SortieLabel , dureeLabel,titreLabel,idLabel ,PegiLabel,catégorieLabel,ComboboxLabel;

    //Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    //idTextField = new JTextField(10);
    //titreTextField = new JTextField(20);
    //dureeTextField = new JTextField(10);
    //date_SortieTextField = new JTextField(10);
    //descriptionTextField = new JTextField(30);


    private JPanel PanelPegi;




    private JRadioButton Pegi10Button;
    private boolean pegi;
    private JRadioButton Pegi12Button;
    private JRadioButton Pegi16Button;
    private JRadioButton Pegi18Button;
    private JRadioButton GenreComédie;
    private JRadioButton GenreThriller;
    private JRadioButton GenreHorreur;
    private JRadioButton GenreAction;

    private boolean genre;
    private JLabel Editeur;
    private JTextField EditeurTextField;
    private JLabel AudioLabel;
    private JLabel SousTitreLabel;
    private JButton ButtonConfrimer;


    public InterfaceFilmSerieAnime()
    {
        setTitle("Ajouter Une Oeuvre");

        setContentPane(PanelMain);
        setLocationRelativeTo(null);
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);


        Confirmer = false;
        genre = false;
        pegi = false;
        ButtonConfrimer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                id = idTextField.getText();
                titre = TitreTextField.getText();
                description = descriptionTextField.getText();
                duree = DureeTextField.getText();

                if (Pegi10Button.isSelected())
                {

                    pegi = true;
                } else if (Pegi12Button.isSelected())
                {

                    pegi = true;
                } else if (Pegi16Button.isSelected())
                {

                    pegi = true;
                } else if (Pegi18Button.isSelected())
                {

                    pegi = true;
                } else
                {

                    pegi = false;
                }

                if(GenreComédie.isSelected())
                {
                    genre = true;
                } else if (GenreAction.isSelected())
                {
                    genre = true;
                } else if (GenreHorreur.isSelected())
                {
                    genre = true;
                } else if (GenreThriller.isSelected())
                {
                    genre = true;
                }
                else
                {
                    genre = false;
                }


                if (pegi && isValidId(id) && isValidTitre(titre) && genre && isValidDescription(description) && isValidDuree(duree)) {
                    Confirmer = true;
                    setVisible(false);
                } else
                {
                    System.out.println("Erreur(s) d'encodation");

                }


            }
        });
    }

    private boolean isValidId(String id)
    {

        return id != null && !id.isEmpty();
    }

    private boolean isValidTitre(String titre)
    {

        return titre != null && !titre.isEmpty();
    }

    private boolean isValidDescription(String description)
    {

        return description != null && !description.isEmpty();
    }

    private boolean isValidDuree(String duree)
    {

        return duree != null && !duree.isEmpty();
    }



    public static void main(String[] args)
    {

        InterfaceFilmSerieAnime frame = new InterfaceFilmSerieAnime();
        frame.setVisible(true);
    }


}
