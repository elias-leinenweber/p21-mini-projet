package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dessinvectoriel.Angle;

class AngleTest
{

    @BeforeEach
    void setUp() throws Exception
    {
    }

    @Test
    void testDegres()
    {
        double deg = 30;
        double rad = Math.PI / 6;
        Angle theta = Angle.degres(deg);
        assertEquals(deg, theta.getDegres(), 1e-10);
        assertEquals(rad , theta.getRadians(), 1e-10);
    }

    @Test
    void testRadians()
    {
        double deg = 30;
        double rad = Math.PI / 6;
        Angle theta = Angle.radians(rad);
        assertEquals(deg, theta.getDegres(), 1e-10);
        assertEquals(rad , theta.getRadians(), 1e-10);
    }

    @Test
    void testGetDegres()
    {
        assertEquals(0, Angle.NUL.getDegres());
        assertEquals(90, Angle.DROIT.getDegres());
        assertEquals(180, Angle.PLAT.getDegres());
    }

    @Test
    void testGetRadians()
    {
        assertEquals(0, Angle.NUL.getRadians());
        assertEquals(Math.PI / 2, Angle.DROIT.getRadians());
        assertEquals(Math.PI, Angle.PLAT.getRadians());
    }

    @Test
    void testAjouterDegres()
    {
        assertEquals(Angle.DROIT.getDegres(), Angle.NUL.ajouterDegres(90).getDegres());
        assertEquals(Angle.DROIT.getDegres(), Angle.PLAT.ajouterDegres(-90).getDegres());
        assertEquals(Angle.DROIT.getDegres(), Angle.DROIT.ajouterDegres(360).getDegres());
        assertEquals(Angle.DROIT.getDegres(), Angle.DROIT.ajouterDegres(-360).getDegres());
    }

    @Test
    void testAjouterRadians()
    {
        assertEquals(Angle.DROIT.getRadians(), Angle.NUL.ajouterRadians(Math.PI / 2).getRadians());
        assertEquals(Angle.DROIT.getRadians(), Angle.PLAT.ajouterRadians(-Math.PI / 2).getRadians());
        assertEquals(Angle.DROIT.getRadians(), Angle.DROIT.ajouterRadians(2*Math.PI).getRadians());
        assertEquals(Angle.DROIT.getRadians(), Angle.DROIT.ajouterRadians(-2*Math.PI).getRadians());
    }

    @Test
    void testAjouter()
    {
        assertEquals(Angle.DROIT.getRadians(), Angle.NUL.ajouter(Angle.DROIT).getRadians());
        assertEquals(Angle.PLAT.getRadians(), Angle.DROIT.ajouter(Angle.DROIT).getRadians());
        assertEquals(2*Math.PI-Angle.DROIT.getRadians(), Angle.PLAT.ajouter(Angle.DROIT).getRadians());
        assertEquals(Angle.NUL.getRadians(), Angle.PLAT.ajouter(Angle.PLAT).getRadians());
        assertEquals(Angle.DROIT.getRadians(), Angle.DROIT.ajouter(Angle.radians(-2*Math.PI)).getRadians());
    }

    @Test
    void testToString()
    {
        assertEquals("0.0°", Angle.NUL.toString());
        assertEquals("90.0°", Angle.DROIT.toString());
        assertEquals("180.0°", Angle.PLAT.toString());
    }

    @Test
    void testSin()
    {
        assertEquals(0, Angle.NUL.sin(), 1e-10);
        assertEquals(1, Angle.DROIT.sin(), 1e-10);
        assertEquals(0, Angle.PLAT.sin(), 1e-10);
        assertEquals(1.0/2, Angle.degres(30).sin(), 1e-10);
        assertEquals(Math.sqrt(3)/2, Angle.radians(Math.PI/3).sin(), 1e-10);
        assertEquals(Math.sqrt(2)/2, Angle.radians(Math.PI/4).sin(), 1e-10);
    }

    @Test
    void testCos()
    {
        assertEquals(1, Angle.NUL.cos(), 1e-10);
        assertEquals(0, Angle.DROIT.cos(), 1e-10);
        assertEquals(-1, Angle.PLAT.cos(), 1e-10);
        assertEquals(Math.sqrt(3)/2, Angle.degres(30).cos(), 1e-10);
        assertEquals(1.0/2, Angle.radians(Math.PI/3).cos(), 1e-10);
        assertEquals(Math.sqrt(2)/2, Angle.radians(Math.PI/4).cos(), 1e-10);
    }

    @Test
    void testAtan()
    {
        assertEquals(45, Angle.atan(5, 5).getDegres(), 1e-10);
        assertEquals(60, Angle.atan(1, Math.sqrt(3)).getDegres(), 1e-10);
        assertEquals(30, Angle.atan(1, Math.sqrt(3)/3).getDegres(), 1e-10);
    }

}
