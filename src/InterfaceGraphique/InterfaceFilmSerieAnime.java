package InterfaceGraphique;

import Controleur.controleur;
import Singleton.ListeOeuvre;
import TypeOeuvre.Film;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InterfaceFilmSerieAnime extends JDialog
{
    private JTextField idTextField ;

    private JTextField TitreTextField;

    private JTextField Date_SortieTextField;

    private JTextField descriptionTextField;

    private JTextField DureeTextField;

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
    private  int Pegi;
    private JRadioButton Pegi12Button;
    private JRadioButton Pegi16Button;
    private JRadioButton Pegi18Button;
    private JRadioButton GenreComédie;
    private JRadioButton GenreThriller;
    private JRadioButton GenreHorreur;
    private JRadioButton GenreAction;

    private boolean genre;
    private  String Genre;
    private JLabel Editeur;
    private JTextField EditeurTextField;

    private JLabel AudioLabel;

    private JLabel SousTitreLabel;
    private JButton ButtonConfrimer;
    private JTextField SousTitreTextField;

    private JTextField AudioTextField;


    public InterfaceFilmSerieAnime(JFrame parent, boolean modal,String titre)
    {

        super(parent,modal);
        setTitle(titre);
        setContentPane(PanelMain);
        setLocationRelativeTo(null);
        setModal(true);
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        ImageIcon logoIcon = new ImageIcon("C:\\Users\\josue\\OneDrive\\Documents\\HEPL\\B2\\q2\\Java\\Labo\\netflix.png");
        setIconImage(logoIcon.getImage());

        //Confirmer = false;
        //genre = false;
        //Pegi = 0;
        /*ButtonConfrimer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {*/
                /*int id = Integer.parseInt(idTextField.getText());
                String Titre = TitreTextField.getText();
                String description = descriptionTextField.getText();
                int duree = Integer.parseInt(DureeTextField.getText());
                String editeur = EditeurTextField.getText();
                String audio = AudioTextField.getText();
                String  Soustitre = SousTitreTextField.getText();
                String dateSaisie = Date_SortieTextField.getText();
                LocalDate date = LocalDate.parse(dateSaisie, DateTimeFormatter.ISO_LOCAL_DATE);*/

                /*if (Pegi10Button.isSelected())
                {


                    Pegi = 1;
                } else if (Pegi12Button.isSelected())
                {


                    Pegi = 1;
                } else if (Pegi16Button.isSelected())
                {


                    Pegi = 1;
                } else if (Pegi18Button.isSelected())
                {


                    Pegi = 1;
                } else
                {


                    Pegi = 0;
                }

                if(GenreComédie.isSelected())
                {
                    genre = true;
                    Genre  = String.valueOf(genre);
                } else if (GenreAction.isSelected())
                {
                    genre = true;
                    Genre  = String.valueOf(genre);
                } else if (GenreHorreur.isSelected())
                {
                    genre = true;
                    Genre  = String.valueOf(genre);
                } else if (GenreThriller.isSelected())
                {
                    //genre = true;
                    Genre  = String.valueOf(genre);
                }
                else
                {
                    //genre = false;
                    Genre  = String.valueOf(false);
                }*/


                /*if (isValidId(String.valueOf(id)) && isValidTitre(Titre)&& isValidDescription(description) && isValidDuree(String.valueOf(duree))) {
                    Confirmer = true;


                        //Film film = new Film(Titre,duree,id,date,description,editeur,audio,Soustitre,Genre,Pegi);
                        //ListeOeuvre.getInstance().ajouterFilm(film);

                    setVisible(false);
                } else
                {
                    System.out.println("Erreur(s) d'encodation");

                }*/


           // }
       //});
    }


    public boolean isValidId(String id)
    {

        return id != null && !id.isEmpty();
    }

    public boolean isValidTitre(String titre)
    {

        return titre != null && !titre.isEmpty();
    }

    public boolean isValidDescription(String description)
    {

        return description != null && !description.isEmpty();
    }

    public boolean isValidDuree(String duree)
    {

        return duree != null && !duree.isEmpty();
    }

    public JTextField getId() {
        return idTextField;
    }

   public JRadioButton getPegi10Button() {
        return Pegi10Button;
    }

    public JRadioButton getPegi12Button() {
        return Pegi12Button;
    }

    public JRadioButton getPegi16Button() {
        return Pegi16Button;
    }

    public JRadioButton getPegi18Button() {
        return Pegi18Button;
    }

       public JTextField getTitre() {
        return TitreTextField;
    }

    public JTextField getSoustitre()
    {
        return  SousTitreTextField;
    }

    public JTextField getDuree()
    {
        return  DureeTextField;
    }

   public JTextField getDescription()
    {
        return  descriptionTextField;
    }

    public JTextField getDate() {
        return Date_SortieTextField;
    }

    public JRadioButton getGenreComedie(){return GenreComédie;}
    public JRadioButton getGenreHorreur(){return GenreHorreur;}
    public JRadioButton getGenreThriller(){return GenreThriller;}
    public JRadioButton getGenreAction(){return GenreAction;}


   public JTextField getAudio() {
        return AudioTextField;
    }

   public JTextField getEditeur() {
        return EditeurTextField;
    }

    public boolean isConfirmerFSA()
    {
        return Confirmer;
    }

    public static void main(String[] args)
    {

        InterfaceFilmSerieAnime frame = new InterfaceFilmSerieAnime(null,true,"zzzzz");
        frame.setVisible(true);
    }


    public void setControleur(controleur controleur1)
    {
        ButtonConfrimer.addActionListener(controleur1);
        this.addWindowListener(controleur1);


    }

}
