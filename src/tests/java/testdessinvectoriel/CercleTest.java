package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import dessinvectoriel.Cercle;
import dessinvectoriel.Figure;
import dessinvectoriel.Surface;
import dessinvectoriel.Vecteur;

class CercleTest
{
    Cercle c1 = new Cercle(new Vecteur(10, 20), 100.0);
    Cercle c2 = new Cercle(new Vecteur(30, 40), 200.0, Color.BLUE, 3, Color.GREEN);

    @Test
    void testCercleVecteurDouble()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), c1.getCouleurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), c1.getEpaisseurTrait());
        assertEquals(Figure.getOrientationParDefaut().getDegres(), c1.getOrientation().getDegres());
        assertEquals(Surface.getCouleurRemplissageParDefaut(), c1.getCouleurRemplissage());
        assertEquals(10, c1.getPosition().getX());
        assertEquals(20, c1.getPosition().getY());
    }

    @Test
    void testCercleVecteurDoubleColorIntColor()
    {
        assertEquals(Color.BLUE, c2.getCouleurTrait());
        assertEquals(3, c2.getEpaisseurTrait());
        assertEquals(Figure.getOrientationParDefaut().getDegres(), c2.getOrientation().getDegres());
        assertEquals(Color.GREEN, c2.getCouleurRemplissage());
        assertEquals(30, c2.getPosition().getX());
        assertEquals(40, c2.getPosition().getY());
    }

    @Test
    void testSurface()
    {
        assertEquals(Math.PI* c1.getRayon()*c1.getRayon(), c1.surface(), 1e-10);
        assertEquals(Math.PI* c2.getRayon()*c2.getRayon(), c2.surface(), 1e-10);
    }

    @Test
    void testPerimetre()
    {
        assertEquals(2 * Math.PI * c1.getRayon(), c1.perimetre(), 1e-10);
        assertEquals(Math.PI * c2.getDiametre(), c2.perimetre(), 1e-10);
    }

    @Test
    void testGetCentre()
    {
        assertEquals(c1.getPosition().getX(), c1.getCentre().getX());
        assertEquals(c1.getPosition().getY(), c1.getCentre().getY());
        assertEquals(c2.getPosition().getX(), c2.getCentre().getX());
        assertEquals(c2.getPosition().getY(), c2.getCentre().getY());
    }

    @Test
    void testGetRayon()
    {
        assertEquals(100, c1.getRayon());
        assertEquals(200, c2.getRayon());
    }

    @Test
    void testGetDiametre()
    {
        assertEquals(2 * c1.getRayon(), c1.getDiametre());
        assertEquals(2 * c2.getRayon(), c2.getDiametre());
    }
    
    @Test
    void testRedimensionner()
    {
        c1.redimensionner(2);
        testCercleVecteurDouble();
        assertEquals(2 * 100, c1.getRayon());
        c2.redimensionner(3);
        testCercleVecteurDoubleColorIntColor();
        assertEquals(3 * 200, c2.getRayon());
        
    }


    @Test
    void testCopier()
    {
        c1 = c1.copier();
        testCercleVecteurDouble();
        c2 = c2.copier();
        testCercleVecteurDoubleColorIntColor();
        testGetRayon();
    }

}
