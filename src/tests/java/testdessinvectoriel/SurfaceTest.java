package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import dessinvectoriel.Angle;
import dessinvectoriel.Figure;
import dessinvectoriel.Rectangle;
import dessinvectoriel.Surface;
import dessinvectoriel.Vecteur;

class SurfaceTest
{
    Surface f1 = new Rectangle(new Vecteur(10, 20), 40, 30);
    Surface f2 = new Rectangle(new Vecteur(30, 40), Angle.DROIT, 40, 30);
    Surface f3 = new Rectangle(new Vecteur(50, 60), Angle.degres(45), 40, 30, Color.RED, 2, Color.GREEN);


    @Test
    void testSetCouleurRemplissage()
    {
        Color c = Color.YELLOW;
        f1.setCouleurRemplissage(c);
        assertEquals(c, f1.getCouleurRemplissage());
    }

    @Test
    void testGetCouleurRemplissage()
    {
        assertEquals(Surface.getCouleurRemplissageParDefaut(), f1.getCouleurRemplissage());
        assertEquals(Surface.getCouleurRemplissageParDefaut(), f2.getCouleurRemplissage());
        assertEquals(Color.GREEN, f3.getCouleurRemplissage());
    }

    @Test
    void testGetCouleurRemplissageParDefaut()
    {
        assertNull(Surface.getCouleurRemplissageParDefaut());
    }
    
    @Test
    void testSetCouleurRemplissageParDefaut()
    {
        Color couleurRemplissageParDefaut = Surface.getCouleurRemplissageParDefaut();
        Surface.setCouleurRemplissageParDefaut(Color.YELLOW);
        assertEquals(Color.YELLOW, Surface.getCouleurRemplissageParDefaut());
        assertEquals(Color.YELLOW, new Rectangle(new Vecteur(0,0), 40, 30).getCouleurRemplissage());
        assertEquals(Color.YELLOW, new Rectangle(new Vecteur(0,0), Angle.DROIT, 40, 30).getCouleurRemplissage());
        Surface.setCouleurRemplissageParDefaut(null);
        assertNull(Surface.getCouleurRemplissageParDefaut());
    }

}
