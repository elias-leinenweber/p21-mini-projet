package testdessinvectoriel;

import dessinvectoriel.*;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Albers implements Runnable
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Albers());
    }

    @Override
    public void run()
    {
        int width = 500;
        int height = 500;
        Dessin f = new Dessin("Study for Homage to the Square", "Albers", width, height);
        construireAlbers(f);
        JFrame jf = new JFrame(f.toString());
        jf.add(f);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();

        jf.setVisible(true);
    }

    private static void construireAlbers(Dessin f)
    {
        Color[] couleurs =
        {
            new Color(250, 150, 12),
            new Color(174, 82, 7),
            new Color(159, 73, 14),
            new Color(151, 33, 23)
        };

        Rectangle c1 = new Rectangle(new Vecteur(110, 110), 282, 282);
        c1.setCouleurRemplissage(couleurs[0]);
        c1.setEpaisseurTrait(0);
        f.ajouterFigure(c1);

        double deltaX = c1.getLargeur()/10;
        double deltaY = c1.getLargeur()/7;
        double j = couleurs.length;
        for (int i = 1; i < couleurs.length; i++)
        {
            c1 = c1.copier();
            c1.deplacer(deltaX, deltaY);
            c1.redimensionner(j/(j+1));
            c1.setCouleurRemplissage(couleurs[i]);
            f.ajouterFigure(c1);
            j--;
        }
    }
}
