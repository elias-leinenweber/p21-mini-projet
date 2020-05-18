package testdessinvectoriel;

import dessinvectoriel.*;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class DessinVectTest2 implements Runnable
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new DessinVectTest2());
    }

    @Override public void run()
    {
        int width = 500;
        int height = 500;

        Dessin dessin = new Dessin("dessin1", "SCR", width, height);
        construire(dessin);
        JFrame f = new JFrame(dessin.toString());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(dessin);
        f.pack();
        f.setVisible(true);
    }
    
    private static void construire(Dessin d)
    {
        Vecteur p = new Vecteur(250, 250);
/**/
        Cercle c1 = new Cercle(p, 100);
        c1.redimensionner(1.2);
        c1.setEpaisseurTrait(0);
        c1.setCouleurRemplissage(Color.GREEN.darker());
        d.ajouterFigure(c1);      
        
        Cercle c2 = new Cercle(p, 100);
        c2.setCouleurTrait(Color.BLACK);
        c2.setEpaisseurTrait(15);
        c2.setCouleurRemplissage(Color.BLUE);
        d.ajouterFigure(c2);
/**/
        Point p1 = new Point(0, 0);
        p1.deplacer(200, 200);
        p1.setCouleurTrait(Color.YELLOW);
        p1.setEpaisseurTrait(10);
        d.ajouterFigure(p1);
/**/
        Segment diam1 = new Segment(p.ajouter(new Vecteur(0, -c2.getRayon())), Angle.DROIT, c2.getDiametre());
        diam1.setCouleurTrait(Color.BLACK);
        diam1.setEpaisseurTrait(2);
        d.ajouterFigure(diam1);

        Segment diam2 = new Segment(p.ajouter(new Vecteur(-c2.getRayon(), 0)), c2.getDiametre());
        diam2.setCouleurTrait(Color.BLACK);
        diam2.setEpaisseurTrait(2);
        d.ajouterFigure(diam2);
        
        Segment rayon1 = new Segment(c2.getCentre(), Angle.degres(60), c2.getRayon());
        rayon1.setCouleurTrait(Color.GREEN);
        rayon1.setEpaisseurTrait(1);
        d.ajouterFigure(rayon1);
        
        Segment rayon2 = rayon1.copier();
        rayon2.tourner(160);
        rayon2.setCouleurTrait(Color.RED);
        rayon2.setEpaisseurTrait(1);
        d.ajouterFigure(rayon2);

        Rectangle r1 = new Rectangle(new Vecteur(400, 400), 120, 60);
        r1.setCouleurTrait(Color.RED);
        r1.setEpaisseurTrait(5);
        r1.setCouleurRemplissage(Color.ORANGE);
        r1.deplacer(-100, -50);
        d.ajouterFigure(r1);

        Vecteur[] r1ex = r1.getSommets();
        for (int i = 0; i < r1ex.length; i++)
        {
            Vecteur ext = r1ex[i];
            Point pex = new Point(ext);
            if (i % 2 == 0)
                pex.setCouleurTrait(Color.BLUE);
            else
                pex.setCouleurTrait(Color.GREEN);
                
            pex.setEpaisseurTrait(10);
            d.ajouterFigure(pex);
        }
        
        Segment diagonale1 = new Segment(r1ex[0], r1ex[2]);
        diagonale1.setCouleurTrait(Color.BLUE);
        diagonale1.setEpaisseurTrait(1);
        d.ajouterFigure(diagonale1);

        Segment diagonale2 = new Segment(r1ex[1], r1ex[3]);
        diagonale2.setCouleurTrait(Color.GREEN);
        diagonale2.setEpaisseurTrait(1);
        d.ajouterFigure(diagonale2);

        Segment cote1 = new Segment(r1ex[0], r1ex[1]);
        cote1.setCouleurTrait(Color.BLUE);
        cote1.setEpaisseurTrait(1);
        d.ajouterFigure(cote1);

        Segment cote2 = new Segment(r1ex[1], r1ex[2]);
        cote2.setCouleurTrait(Color.GREEN);
        cote2.setEpaisseurTrait(1);
        d.ajouterFigure(cote2);

        Rectangle r2 = new Rectangle(new Vecteur(400, 400), 120, 60);
        r2.setOrientation(Angle.degres(-15));
        r2.setCouleurTrait(Color.RED);
        r2.setEpaisseurTrait(5);
        r2.setCouleurRemplissage(Color.YELLOW);
        r2.redimensionner(1.5);
        r2.deplacer(-350, -330);
        d.ajouterFigure(r2);

        Rectangle r3 = r2.copier();
        r3.setPosition(new Vecteur(50, 70));
        r3.setCouleurTrait(Color.BLUE);
        r3.setEpaisseurTrait(1);
        r3.setCouleurRemplissage(null);
        r3.redimensionner(0.5);
        
        d.ajouterFigure(r3);
        
        Vecteur[] r2ex = r2.getSommets();
        Segment diag3 = new Segment(r2ex[0], r2ex[2]);
        diag3.redimensionner(1.5);
        diag3.setEpaisseurTrait(1);
        d.ajouterFigure(diag3);
        
        Segment diag4 = new Segment(r2ex[1], r2ex[3]);
        diag4.redimensionner(0.5);
        diag4.setEpaisseurTrait(1);
        d.ajouterFigure(diag4);
        
        Rectangle r4 = r1.copier();
        r4.tournerAutour(c1.getPosition(), Angle.degres(300));
        r4.setEpaisseurTrait(0);
        d.ajouterFigure(r4);
        
        Point pex = new Point(r4.getPosition());
        pex.setCouleurTrait(Color.BLUE);
        pex.setEpaisseurTrait(10);
        d.ajouterFigure(pex);

/**/        
    }
}
