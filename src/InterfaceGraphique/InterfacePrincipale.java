package InterfaceGraphique;

import ComposantInterfaceGraphique.MonTreeModele;

import javax.swing.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacePrincipale extends JFrame
{
    private JPanel mainPanel;
    private JList Serie;
    private JList Anime;
    private JList Trailer;
    private JList Film;
    private JTree arbre;
    private JPanel PanelTree;
    private JPanel PanelList;
    private JScrollPane ScrollList;



    public InterfacePrincipale()
    {
        setSize(800,600);
        //mainPanel = new JPanel();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        //PanelTree = new JPanel();
        //ScrollList = new JScrollPane();

        //mainPanel.add(PanelTree);
        //mainPanel.add(ScrollList);

        JMenuBar jMenuBar1 = new JMenuBar();
        setJMenuBar(jMenuBar1);
        JMenu jMenu1 = new JMenu();
        JMenu jMenu2 = new JMenu();
        JMenu jMenu3 = new JMenu();
        JMenuItem jMenuItem1 = new JMenuItem();
        JMenuItem jMenuItem2 = new JMenuItem();
        JMenuItem jMenuItem3 = new JMenuItem();
        JMenuItem jMenuItem4 = new JMenuItem();
        JMenuItem jMenuItem5 = new JMenuItem();
        JMenuItem jMenuItem6 = new JMenuItem();
        JMenuItem jMenuItem7 = new JMenuItem();
        JMenuItem jMenuItem8 = new JMenuItem();

        jMenu1.setText("Connexion");
        jMenu2.setText("Ajouter");
        jMenu3.setText("Favoris");
        jMenuItem1.setText("Se connecter");
        jMenuItem2.setText("Se déconnecter");
        jMenuItem3.setText("Reset mot de passe");
        jMenuItem4.setText("Film");
        jMenuItem5.setText("Série");
        jMenuItem6.setText("Anime");
        jMenuItem7.setText("Trailer");
        jMenuItem8.setText("Créer un compte");

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenu1.add(jMenuItem1);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem2);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem8);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenu2.addSeparator();
        jMenu2.add(jMenuItem5);
        jMenu2.addSeparator();
        jMenu2.add(jMenuItem6);
        jMenu2.addSeparator();
        jMenu2.add(jMenuItem7);

        jMenuBar1.setBackground(new Color(184, 29, 36));

        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Chercher");
        DefaultMutableTreeNode film = new DefaultMutableTreeNode("Film");
        DefaultMutableTreeNode serie = new DefaultMutableTreeNode("Serie");
        DefaultMutableTreeNode anime = new DefaultMutableTreeNode("Anime");
        DefaultMutableTreeNode trailer = new DefaultMutableTreeNode("Trailer");

        DefaultMutableTreeNode[] nodes = {film, serie, anime, trailer};
        for (DefaultMutableTreeNode node : nodes)
        {
            DefaultMutableTreeNode pegi = new DefaultMutableTreeNode("Pegi");
            DefaultMutableTreeNode pegiall = new DefaultMutableTreeNode("Pour tous");
            DefaultMutableTreeNode pegi6 = new DefaultMutableTreeNode("6+");
            DefaultMutableTreeNode pegi9 = new DefaultMutableTreeNode("9+");
            DefaultMutableTreeNode pegi12 = new DefaultMutableTreeNode("12+");
            DefaultMutableTreeNode pegi14 = new DefaultMutableTreeNode("14+");
            DefaultMutableTreeNode pegi16 = new DefaultMutableTreeNode("16+");
            DefaultMutableTreeNode pegi18 = new DefaultMutableTreeNode("18+");
            DefaultMutableTreeNode categorie = new DefaultMutableTreeNode("Catégorie");
            DefaultMutableTreeNode horreur = new DefaultMutableTreeNode("Horreur");
            DefaultMutableTreeNode SF = new DefaultMutableTreeNode("Science-Fiction");
            DefaultMutableTreeNode aventure = new DefaultMutableTreeNode("Aventure");
            DefaultMutableTreeNode drame = new DefaultMutableTreeNode("Drame");
            DefaultMutableTreeNode action = new DefaultMutableTreeNode("Action");

            pegi.add(pegiall);
            pegi.add(pegi6);
            pegi.add(pegi9);
            pegi.add(pegi12);
            pegi.add(pegi14);
            pegi.add(pegi16);
            pegi.add(pegi18);

            categorie.add(horreur);
            categorie.add(SF);
            categorie.add(aventure);
            categorie.add(drame);
            categorie.add(action);

            node.add(pegi);
            node.add(categorie);
        }

        racine.add(film);
        racine.add(serie);
        racine.add(anime);
        racine.add(trailer);

        MonTreeModele test = new MonTreeModele(racine);
        arbre.setModel(test);
        //arbre = new JTree(racine);
        //PanelTree.add(racine);
        /*PanelList = new JPanel();
        ScrollList.setViewportView(PanelList);
        TypeOeuvre.Serie = new JList();
        TypeOeuvre.Anime = new JList();
        TypeOeuvre.Film = new JList();
        TypeOeuvre.Trailer = new JList();

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Élément 1");
        model.addElement("Élément 2");
        model.addElement("Élément 3");

        DefaultListModel<String> model1 = new DefaultListModel<>();
        model1.addElement("Élément 1");
        model1.addElement("Élément 2");
        model1.addElement("Élément 3");

        DefaultListModel<String> model2 = new DefaultListModel<>();
        model2.addElement("Élément 1");
        model2.addElement("Élément 2");
        model2.addElement("Élément 3");

        DefaultListModel<String> model3 = new DefaultListModel<>();
        model3.addElement("Élément 1");
        model3.addElement("Élément 2");
        model3.addElement("Élément 3");

        JList<String> TypeOeuvre.Film = new JList<>(model);
        JList<String> TypeOeuvre.Serie = new JList<>(model1);
        JList<String> TypeOeuvre.Anime = new JList<>(model2);
        JList<String> TypeOeuvre.Trailer = new JList<>(model3);

        PanelList.add(TypeOeuvre.Serie);
        PanelList.add(TypeOeuvre.Anime);
        PanelList.add(TypeOeuvre.Film);
        PanelList.add(TypeOeuvre.Trailer);*/


        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                InterfaceConnection fenetre = new InterfaceConnection();
                fenetre.setVisible(true);

            }
        });

        jMenuItem8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                InterfaceCreate_Account fenetre2 = new InterfaceCreate_Account();
                fenetre2.setVisible(true);
            }
        });

        jMenuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceFilmSerieAnime film = new InterfaceFilmSerieAnime();
                film.setVisible(true);
            }
        });

        jMenuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceFilmSerieAnime serie = new InterfaceFilmSerieAnime();
                serie.setVisible(true);
            }
        });

        jMenuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceFilmSerieAnime anime = new InterfaceFilmSerieAnime();
                anime.setVisible(true);
            }
        });




    }
    public static void main(String[] args)
    {
        InterfacePrincipale dlm = new InterfacePrincipale();
        dlm.setVisible(true);

    }

}
