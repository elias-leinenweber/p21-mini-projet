package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dessinvectoriel.Angle;
import dessinvectoriel.Vecteur;

class VecteurTest
{
    private Vecteur v;

    @BeforeEach
    void setUp() throws Exception
    {
        v = new Vecteur(3.0, 4.0);
    }

    @Test
    void testVecteurDoubleAngle()
    {
        Vecteur w = new Vecteur(v.longueur(), v.orientation());
        assertEquals(v.getX(), w.getX(), 1e-10);
        assertEquals(v.getY(), w.getY(), 1e-10);
    }

    @Test
    void testGetX()
    {
        assertEquals(3, v.getX());
    }

    @Test
    void testGetY()
    {
        assertEquals(4, v.getY());
    }

    @Test
    void testAjouter()
    {
        Vecteur w = v.ajouter(v);
        assertEquals(v.getX()+v.getX(), w.getX());
        assertEquals(v.getY()+v.getY(), w.getY());
    }

    @Test
    void testOppose()
    {
        Vecteur w = v.oppose();
        assertEquals(-v.getX(), w.getX());
        assertEquals(-v.getY(), w.getY());
    }

    @Test
    void testSoustraire()
    {
        Vecteur w = v.soustraire(v);
        assertEquals(0, w.getX());
        assertEquals(0, w.getY());
    }

    @Test
    void testMultiplier()
    {
        double k = 3;
        Vecteur w = v.multiplier(3);
        assertEquals(k * v.getX(), w.getX());
        assertEquals(k * v.getY(), w.getY());
    }

    @Test
    void testLongueur()
    {
        assertEquals(5, v.longueur());
    }

    @Test
    void testOrientation()
    {
        assertEquals(Math.atan2(4, 3), v.orientation().getRadians());
    }

}
