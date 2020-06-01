package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import dessinvectoriel.Angle;
import dessinvectoriel.Figure;
import dessinvectoriel.Rectangle;
import dessinvectoriel.Surface;
import dessinvectoriel.Vecteur;

class RectangleTest
{
    Rectangle r1 = new Rectangle(new Vecteur(10, 20), 200.0, 100.0);
    Rectangle r2 = new Rectangle(new Vecteur(30, 40), Angle.DROIT, 400.0, 300.0);
    Rectangle r3 = new Rectangle(new Vecteur(50, 60), Angle.degres(45), 200*Math.sqrt(2), 100*Math.sqrt(2), Color.BLUE, 3, Color.GREEN);
    @Test
    void testRectangleVecteurDoubleDouble()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), r1.getCouleurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), r1.getEpaisseurTrait());
        assertEquals(Figure.getOrientationParDefaut().getDegres(), r1.getOrientation().getDegres());
        assertEquals(Surface.getCouleurRemplissageParDefaut(), r1.getCouleurRemplissage());
        assertEquals(10, r1.getPosition().getX());
        assertEquals(20, r1.getPosition().getY());
    }

    @Test
    void testRectangleVecteurAngleDoubleDouble()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), r2.getCouleurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), r2.getEpaisseurTrait());
        assertEquals(90, r2.getOrientation().getDegres());
        assertEquals(Surface.getCouleurRemplissageParDefaut(), r2.getCouleurRemplissage());
        assertEquals(30, r2.getPosition().getX());
        assertEquals(40, r2.getPosition().getY());
    }

    @Test
    void testRectangleVecteurAngleDoubleDoubleColorIntColor()
    {
        assertEquals(Color.BLUE, r3.getCouleurTrait());
        assertEquals(3, r3.getEpaisseurTrait());
        assertEquals(45, r3.getOrientation().getDegres());
        assertEquals(Color.GREEN, r3.getCouleurRemplissage());
        assertEquals(50, r3.getPosition().getX());
        assertEquals(60, r3.getPosition().getY());
    }

    @Test
    void testSurface()
    {
        assertEquals(r1.getLongueur()*r1.getLargeur(), r1.surface(), 1e-10);
        assertEquals(r2.getLongueur()*r2.getLargeur(), r2.surface(), 1e-10);
        assertEquals(r3.getLongueur()*r3.getLargeur(), r3.surface(), 1e-10);
    }

    @Test
    void testPerimetre()
    {
        assertEquals(2 * (r1.getLongueur()+ r1.getLargeur()), r1.perimetre(), 1e-10);
        assertEquals(2 * (r2.getLongueur()+ r2.getLargeur()), r2.perimetre(), 1e-10);
        assertEquals(2 * (r3.getLongueur()+ r3.getLargeur()), r3.perimetre(), 1e-10);
    }


    @Test
    void testGetLongueur()
    {
        assertEquals(200, r1.getLongueur());
        assertEquals(400, r2.getLongueur());
        assertEquals(200*Math.sqrt(2), r3.getLongueur());
    }

    @Test
    void testGetLargeur()
    {
        assertEquals(100, r1.getLargeur());
        assertEquals(300, r2.getLargeur());
        assertEquals(100*Math.sqrt(2), r3.getLargeur());
    }

    @Test
    void testGetSommets()
    {
        Vecteur[] sr1 = r1.getSommets();
        assertEquals(r1.getPosition().getX(), sr1[0].getX(), 1e-10);
        assertEquals(r1.getPosition().getY(), sr1[0].getY(), 1e-10);
        assertEquals(r1.getPosition().getX() + r1.getLongueur(), sr1[1].getX(), 1e-10);
        assertEquals(r1.getPosition().getY(), sr1[1].getY(), 1e-10);
        assertEquals(r1.getPosition().getX() + r1.getLongueur(), sr1[2].getX(), 1e-10);
        assertEquals(r1.getPosition().getY() + r1.getLargeur(), sr1[2].getY(), 1e-10);
        assertEquals(r1.getPosition().getX(), sr1[3].getX(), 1e-10);
        assertEquals(r1.getPosition().getY() + r1.getLargeur(), sr1[3].getY(), 1e-10);
        
        Vecteur[] sr2 = r2.getSommets();
        assertEquals(r2.getPosition().getX(), sr2[0].getX(), 1e-10);
        assertEquals(r2.getPosition().getY(), sr2[0].getY(), 1e-10);
        assertEquals(r2.getPosition().getX(), sr2[1].getX(), 1e-10);
        assertEquals(r2.getPosition().getY() + r2.getLongueur(), sr2[1].getY(), 1e-10);
        assertEquals(r2.getPosition().getX() - r2.getLargeur(), sr2[2].getX(), 1e-10);
        assertEquals(r2.getPosition().getY() + r2.getLongueur(), sr2[2].getY(), 1e-10);
        assertEquals(r2.getPosition().getX() - r2.getLargeur(), sr2[3].getX(), 1e-10);
        assertEquals(r2.getPosition().getY(), sr2[3].getY(), 1e-10);

        
        Vecteur[] sr3 = r3.getSommets();
        assertEquals(r3.getPosition().getX(), sr3[0].getX(), 1e-10);
        assertEquals(r3.getPosition().getY(), sr3[0].getY(), 1e-10);
        assertEquals(r3.getPosition().getX() + 200, sr3[1].getX(), 1e-10);
        assertEquals(r3.getPosition().getY() + 200, sr3[1].getY(), 1e-10);
        assertEquals(sr3[1].getX() - 100, sr3[2].getX(), 1e-10);
        assertEquals(sr3[1].getY() + 100, sr3[2].getY(), 1e-10);
        assertEquals(sr3[2].getX() - 200, sr3[3].getX(), 1e-10);
        assertEquals(sr3[2].getY() - 200, sr3[3].getY(), 1e-10);

    }
    
    @Test
    void testRedimensionner()
    {
        r1.redimensionner(2);
        testRectangleVecteurDoubleDouble();
        assertEquals(2 * 200, r1.getLongueur());
        assertEquals(2 * 100, r1.getLargeur());
        
        r2.redimensionner(3);
        testRectangleVecteurAngleDoubleDouble();
        assertEquals(3 * 400, r2.getLongueur());
        assertEquals(3 * 300, r2.getLargeur());

        r3.redimensionner(4);
        testRectangleVecteurAngleDoubleDoubleColorIntColor();
        assertEquals(4 * 200*Math.sqrt(2), r3.getLongueur());
        assertEquals(4 * 100*Math.sqrt(2), r3.getLargeur());

    }


    @Test
    void testCopier()
    {
        r1 = r1.copier();
        r2 = r2.copier();
        r3 = r3.copier();
        testRectangleVecteurDoubleDouble();
        testRectangleVecteurAngleDoubleDouble();
        testRectangleVecteurAngleDoubleDoubleColorIntColor();
        testGetLongueur();
        testGetLargeur();
    }
    

 

}
