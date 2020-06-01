package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dessinvectoriel.Angle;
import dessinvectoriel.Figure;
import dessinvectoriel.Rectangle;
import dessinvectoriel.Vecteur;

class FigureTest
{
    Figure f1 = new Rectangle(new Vecteur(10, 20), 40, 30);
    Figure f2 = new Rectangle(new Vecteur(30, 40), Angle.DROIT, 40, 30);
    Figure f3 = new Rectangle(new Vecteur(50, 60), Angle.degres(45), 40, 30, Color.RED, 2, Color.GREEN);
        
    @Test
    void testSetCouleurTrait()
    {
        Color c = Color.YELLOW;
        f1.setCouleurTrait(c);
        assertEquals(c, f1.getCouleurTrait());
    }

    @Test
    void testGetCouleurTrait()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), f1.getCouleurTrait());
        assertEquals(Figure.getCouleurTraitParDefaut(), f2.getCouleurTrait());
        assertEquals(Color.RED, f3.getCouleurTrait());
    }

    @Test
    void testSetEpaisseurTrait()
    {
        f1.setEpaisseurTrait(0);
        assertEquals(0, f1.getEpaisseurTrait());
        f2.setEpaisseurTrait(-1);
        assertEquals(-1, f2.getEpaisseurTrait());
        f3.setEpaisseurTrait(10);
        assertEquals(10, f3.getEpaisseurTrait());
    }

    @Test
    void testGetEpaisseurTrait()
    {
        assertEquals(Figure.getEpaisseurTraitParDefaut(), f1.getEpaisseurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), f2.getEpaisseurTrait());
        assertEquals(2, f3.getEpaisseurTrait());
    }

    @Test
    void testSetPosition()
    {
        f1.setPosition(f2.getPosition());
        assertEquals(30, f1.getPosition().getX());
        assertEquals(40, f1.getPosition().getY());
        f2.setPosition(f3.getPosition());
        assertEquals(50, f2.getPosition().getX());
        assertEquals(60, f2.getPosition().getY());
        f3.setPosition(new Vecteur(10, 20));
        assertEquals(10, f3.getPosition().getX());
        assertEquals(20, f3.getPosition().getY());
    }

    @Test
    void testGetPosition()
    {
        assertEquals(10, f1.getPosition().getX());
        assertEquals(20, f1.getPosition().getY());
        assertEquals(30, f2.getPosition().getX());
        assertEquals(40, f2.getPosition().getY());
        assertEquals(50, f3.getPosition().getX());
        assertEquals(60, f3.getPosition().getY());
    }

    @Test
    void testSetOrientation()
    {
        f1.setOrientation(Angle.DROIT);
        assertEquals(Angle.DROIT.getDegres(), f1.getOrientation().getDegres());
    }

    @Test
    void testGetOrientation()
    {
        assertEquals(Figure.getOrientationParDefaut().getDegres(), f1.getOrientation().getDegres());
        assertEquals(Angle.DROIT.getDegres(), f2.getOrientation().getDegres());
        assertEquals(Math.PI/4, f3.getOrientation().getRadians());
    }

    @Test
    void testDeplacer()
    {
        Vecteur v1 = f1.getPosition();
        f1.deplacer(10, 20);
        assertEquals(v1.getX() + 10, f1.getPosition().getX());
        assertEquals(v1.getY() + 20, f1.getPosition().getY());
    }

    @Test
    void testTourner()
    {
        Angle alpha = f1.getOrientation();
        f1.tourner(20);
        assertEquals(alpha.ajouterDegres(20).getDegres(), f1.getOrientation().getDegres());
    }

    @Test
    void testTournerAutour()
    {
        f1.setPosition(new Vecteur(0, 100));
        Angle alpha = f1.getOrientation();
        f1.tournerAutour(new Vecteur(0, 0), Angle.DROIT);
        assertEquals(alpha.ajouter(Angle.DROIT).getDegres(), f1.getOrientation().getDegres());
        assertEquals(-100, f1.getPosition().getX(), 1e-10);
        assertEquals(0, f1.getPosition().getY(), 1e-10);
    }

    @Test
    void testGetOrientationParDefaut()
    {
        assertEquals(0, Figure.getOrientationParDefaut().getDegres());
    }


    @Test
    void testGetEpaisseurTraitParDefaut()
    {
        assertEquals(1, Figure.getEpaisseurTraitParDefaut());
    }

    @Test
    void testGetCouleurTraitParDefaut()
    {
        assertEquals(Color.BLACK, Figure.getCouleurTraitParDefaut());
    }


}
