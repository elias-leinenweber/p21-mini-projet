package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import dessinvectoriel.Figure;
import dessinvectoriel.Point;
import dessinvectoriel.Vecteur;

class PointTest
{
    Point p1 = new Point(10.0, 20.0);
    Point p2 = new Point(new Vecteur(30, 40));
    Point p3 = new Point(new Vecteur(50, 60), Color.BLUE, 3);

    @Test
    void testPointDoubleDouble()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), p1.getCouleurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), p1.getEpaisseurTrait());
        assertEquals(Figure.getOrientationParDefaut().getDegres(), p1.getOrientation().getDegres());
        assertEquals(10, p1.getPosition().getX());
        assertEquals(20, p1.getPosition().getY());
    }

    @Test
    void testPointVecteur()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), p2.getCouleurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), p2.getEpaisseurTrait());
        assertEquals(Figure.getOrientationParDefaut().getDegres(), p2.getOrientation().getDegres());
        assertEquals(30, p2.getPosition().getX());
        assertEquals(40, p2.getPosition().getY());
    }

    @Test
    void testPointVecteurColorInt()
    {
        assertEquals(Color.BLUE, p3.getCouleurTrait());
        assertEquals(3, p3.getEpaisseurTrait());
        assertEquals(Figure.getOrientationParDefaut().getDegres(), p2.getOrientation().getDegres());
        assertEquals(50, p3.getPosition().getX());
        assertEquals(60, p3.getPosition().getY());
    }


    @Test
    void testRedimensionner()
    {
        p1.redimensionner(2);
        testPointDoubleDouble();
        p2.redimensionner(3);
        testPointVecteur();
        p3.redimensionner(-3);
        testPointVecteurColorInt();
    }

    @Test
    void testCopier()
    {
        p1 = p1.copier();
        p2 = p2.copier();
        p3 = p3.copier();
        testPointDoubleDouble();
        testPointVecteur();
        testPointVecteurColorInt();
    }

}
