package InterfaceGraphique;

import Controleur.controleur;

import javax.swing.*;
import java.awt.*;

public class InterfaceFavoris extends JDialog {
    private JList ListFavoris;
    private JPanel panel1;

    public InterfaceFavoris(JFrame parent, boolean modal, String titre)
    {
        super(parent, modal);
        setTitle(titre);
        setContentPane(panel1);
        setLocationRelativeTo(null);
        pack();
        setModal(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
    }

    public void setControleur(controleur controleur1)
    {
        ListFavoris.addListSelectionListener(controleur1);
    }

    public JList getListeFavoris(){return ListFavoris;}
}
