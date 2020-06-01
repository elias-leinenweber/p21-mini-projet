package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import dessinvectoriel.Angle;
import dessinvectoriel.Figure;
import dessinvectoriel.Point;
import dessinvectoriel.Segment;
import dessinvectoriel.Vecteur;

class SegmentTest
{
    Segment s1 = new Segment(new Vecteur(10, 20), 100.0);
    Segment s2 = new Segment(new Vecteur(30, 40), new Vecteur(50, 60));
    Segment s3 = new Segment(new Vecteur(70, 80), Angle.degres(45), 10 * Math.sqrt(2));
    Segment s4 = new Segment(new Vecteur(90, 0), Angle.DROIT, 400.0, Color.BLUE, 3);

    @Test
    void testSegmentVecteurDouble()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), s1.getCouleurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), s1.getEpaisseurTrait());
        assertEquals(Figure.getOrientationParDefaut().getDegres(), s1.getOrientation().getDegres());
        assertEquals(10, s1.getPosition().getX());
        assertEquals(20, s1.getPosition().getY());
    }

    @Test
    void testSegmentVecteurVecteur()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), s2.getCouleurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), s2.getEpaisseurTrait());
        assertEquals(45, s2.getOrientation().getDegres());
        assertEquals(30, s2.getPosition().getX());
        assertEquals(40, s2.getPosition().getY());
    }

    @Test
    void testSegmentVecteurAngleDouble()
    {
        assertEquals(Figure.getCouleurTraitParDefaut(), s3.getCouleurTrait());
        assertEquals(Figure.getEpaisseurTraitParDefaut(), s3.getEpaisseurTrait());
        assertEquals(45, s3.getOrientation().getDegres());
        assertEquals(70, s3.getPosition().getX());
        assertEquals(80, s3.getPosition().getY());
    }

    @Test
    void testSegmentVecteurAngleDoubleColorInteger()
    {
        assertEquals(Color.BLUE, s4.getCouleurTrait());
        assertEquals(3, s4.getEpaisseurTrait());
        assertEquals(Math.PI/2, s4.getOrientation().getRadians());
        assertEquals(90, s4.getPosition().getX());
        assertEquals(0, s4.getPosition().getY());
    }

    @Test
    void testGetOrigine()
    {
        assertEquals(10, s1.getOrigine().getX());
        assertEquals(20, s1.getOrigine().getY());
        assertEquals(30, s2.getOrigine().getX());
        assertEquals(40, s2.getOrigine().getY());
        assertEquals(70, s3.getOrigine().getX());
        assertEquals(80, s3.getOrigine().getY());
        assertEquals(90, s4.getOrigine().getX());
        assertEquals( 0, s4.getOrigine().getY());
    }

    @Test
    void testGetExtremite()
    {
        assertEquals(100+s1.getOrigine().getX(), s1.getExtremite().getX());
        assertEquals(s1.getOrigine().getY(), s1.getExtremite().getY());
        assertEquals(50, s2.getExtremite().getX());
        assertEquals(60, s2.getExtremite().getY());
        assertEquals(s3.getOrigine().getX() + 10, s3.getExtremite().getX());
        assertEquals(s3.getOrigine().getY() + 10, s3.getExtremite().getY());
        assertEquals(90, s4.getExtremite().getX(), 1e-10);
        assertEquals(400, s4.getExtremite().getY(), 1e-10);
    }
    
    @Test
    void testRedimensionner()
    {
        s1.redimensionner(2);
        s2.redimensionner(3);
        s3.redimensionner(4);
        s4.redimensionner(5);
        testGetOrigine();
        assertEquals(2*100 + s1.getOrigine().getX(), s1.getExtremite().getX());
        assertEquals(s1.getOrigine().getY(), s1.getExtremite().getY());
        assertEquals(50 + 40, s2.getExtremite().getX());
        assertEquals(60 + 40, s2.getExtremite().getY());
        assertEquals(s3.getOrigine().getX() + 40, s3.getExtremite().getX());
        assertEquals(s3.getOrigine().getY() + 40, s3.getExtremite().getY());
        assertEquals(90, s4.getExtremite().getX(), 1e-10);
        assertEquals(2000, s4.getExtremite().getY(), 1e-10);
    }

    @Test
    void testCopier()
    {
        s1 = s1.copier();
        testSegmentVecteurDouble();
        s2 = s2.copier();
        testSegmentVecteurVecteur();
        s3 = s3.copier();
        testSegmentVecteurAngleDouble();
        s4 = s4.copier();
        testSegmentVecteurAngleDoubleColorInteger();
    }

}
