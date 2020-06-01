package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dessinvectoriel.Angle;
import dessinvectoriel.Cercle;
import dessinvectoriel.Dessin;
import dessinvectoriel.Rectangle;
import dessinvectoriel.Segment;
import dessinvectoriel.Vecteur;

class DessinVectErreursTest
{
    Vecteur origine = new Vecteur(10, 20);
    @Test
    void test()
    {
        origine = new Vecteur(4, Angle.DROIT);
        fail(origine.toString() + " x = " + origine.getX() + " y = " + origine.getY());
    }
    @Test
    void testCercleRayonNegatif()
    {
        try
        {
            Cercle c = new Cercle(origine, -1);
            fail("Cercle de rayon négatif accepté : " + c);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Cercle c = new Cercle(origine, -1, Color.BLACK, 1, Color.BLUE);
            fail("Cercle de rayon négatif accepté : " + c);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    
    @Test
    void testCercleRayonNul()
    {
        // Le cercle de rayon 0 doit être accepté
        Cercle c = new Cercle(origine, 0);
        assertEquals(0, c.getRayon());
        c = new Cercle(origine, 0, Color.BLACK, 1, Color.BLUE);
        assertEquals(0, c.getRayon());
    }
    
    @Test
    void testDessinLargeurNegative()
    {
        try
        {
            Dessin d = new Dessin("auteur", "titre", -1, 10);
            fail("Dessin de largeur négative accepté : " + d);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        
        try
        {
            Dessin d = new Dessin("auteur", "titre", LocalDate.now(), -1, 10);
            fail("Dessin de largeur négative accepté : " + d);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    
    @Test
    void testDessinHauteurNegative()
    {
        try
        {
            Dessin d = new Dessin("auteur", "titre", 10, -1);
            fail("Dessin de hauteur négative accepté : " + d);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }

        try
        {
            Dessin d = new Dessin("auteur", "titre", LocalDate.now(), 10, -1);
            fail("Dessin de hauteur négative accepté : " + d);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }

    @Test
    void testDessinLargeurNulle()
    {
        // Un dessin de largeur 0 doit être accepté
        Dessin d = new Dessin("auteur", "titre", 0, 10);
        assertEquals(0, d.getLargeur());
        d = new Dessin("auteur", "titre", LocalDate.now(), 0, 10);
        assertEquals(0, d.getLargeur());
    }
    
    @Test
    void testDessinHauteurNulle()
    {
        // Un dessin de hauteur 0 doit être accepté
        Dessin d = new Dessin("auteur", "titre", 10, 0);
        assertEquals(0, d.getHauteur());
        d = new Dessin("auteur", "titre", LocalDate.now(), 10, 0);
        assertEquals(0, d.getHauteur());
    }
    
    @Test
    void testRectangleLongueurNegative()
    {
        try
        {
            Rectangle r = new Rectangle(origine, -1, 1);
            fail("Rectangle de longueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Rectangle r = new Rectangle(origine, Angle.NUL, -1, 1);
            fail("Rectangle de longueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Rectangle r = new Rectangle(origine, Angle.NUL, -1, 1, Color.BLACK, 3, Color.BLUE);
            fail("Rectangle de longueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    
    @Test
    void testRectangleLongueurNulle()
    {
        Rectangle r = new Rectangle(origine, 0, 0);
        assertEquals(0, r.getLongueur());
        r = new Rectangle(origine, Angle.NUL, 0, 0);
        assertEquals(0, r.getLongueur());
        r = new Rectangle(origine, Angle.NUL, 0, 0, Color.BLACK, 3, Color.BLUE);
        assertEquals(0, r.getLongueur());
    }
    

    @Test
    void testRectangleLargeurNegative()
    {
        try
        {
            Rectangle r = new Rectangle(origine, 1, -1);
            fail("Rectangle de largueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Rectangle r = new Rectangle(origine, Angle.NUL, 1, -1);
            fail("Rectangle de largueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Rectangle r = new Rectangle(origine, Angle.NUL, 1, -1, Color.BLACK, 3, Color.BLUE);
            fail("Rectangle de largueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    
    @Test
    void testRectangleLargeurNulle()
    {
        Rectangle r = new Rectangle(origine, 1, 0);
        assertEquals(0, r.getLargeur());
        r = new Rectangle(origine, Angle.NUL, 1, 0);
        assertEquals(0, r.getLargeur());
        r = new Rectangle(origine, Angle.NUL, 1, 0, Color.BLACK, 3, Color.BLUE);
        assertEquals(0, r.getLargeur());
    }
    
    @Test
    void testRectangleLongueurEtLargeurNegative()
    {
        try
        {
            Rectangle r = new Rectangle(origine, -1, -2);
            fail("Rectangle de longueur et largueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Rectangle r = new Rectangle(origine, Angle.NUL, -1, -2);
            fail("Rectangle de longueur et largueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Rectangle r = new Rectangle(origine, Angle.NUL, -1, -2, Color.BLACK, 3, Color.BLUE);
            fail("Rectangle de longueur et largueur négative accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    
    void testRectangleLongueurEtLargeurNulle()
    {
        Rectangle r = new Rectangle(origine, 0, 0);
        assertEquals(0, r.getLongueur());
        assertEquals(0, r.getLargeur());
        r = new Rectangle(origine, Angle.NUL, 0, 0);
        assertEquals(0, r.getLongueur());
        assertEquals(0, r.getLargeur());
        r = new Rectangle(origine, Angle.NUL, 0, 0, Color.BLACK, 3, Color.BLUE);
        assertEquals(0, r.getLargeur());
        assertEquals(0, r.getLongueur());
    }
    
    @Test
    void testRectangleLongueurInferieureALargeur()
    {
        try
        {
            Rectangle r = new Rectangle(origine, 10, 20);
            fail("Rectangle de longueur inférieure à la largueur accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Rectangle r = new Rectangle(origine, Angle.NUL, 10, 20);
            fail("Rectangle de longueur inférieure à la largueur accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Rectangle r = new Rectangle(origine, Angle.NUL, 10, 20, Color.BLACK, 3, Color.BLUE);
            fail("Rectangle de longueur inférieure à la largueur accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    
    @Test
    void testSegmentLongueurNegative()
    {
        try
        {
            Segment s = new Segment(origine, -1);
            fail("Segment de longueur négative accepté : " + s);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Segment s = new Segment(origine, Angle.NUL, -1);
            fail("Segment de longueur négative accepté : " + s);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
        try
        {
            Segment s = new Segment(origine, Angle.NUL, -1, Color.BLACK, 3);
            fail("Segment de longueur négative accepté : " + s);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    
    @Test
    void testSegmentLongueurNulle()
    {
        Segment s = new Segment(origine, 0);
        assertEquals(s.getOrigine().getX(), s.getExtremite().getX());
        assertEquals(s.getOrigine().getY(), s.getExtremite().getY());
        s = new Segment(origine, Angle.NUL, 0);
        assertEquals(s.getOrigine().getX(), s.getExtremite().getX());
        assertEquals(s.getOrigine().getY(), s.getExtremite().getY());
        s = new Segment(origine, Angle.NUL, 0, Color.BLACK, 3);
        assertEquals(s.getOrigine().getX(), s.getExtremite().getX());
        assertEquals(s.getOrigine().getY(), s.getExtremite().getY());
    }
    
    @Test
    void testRedimensionnerCercle()
    {
        try
        {
            Cercle c = new Cercle(origine, 10);
            c.redimensionner(-1);
            fail("Redimensionnement négatif accepté : " + c);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    @Test
    void testRedimensionnerSegment()
    {
        try
        {
            Segment s = new Segment(origine, 10);
            s.redimensionner(-1);
            fail("Redimensionnement négatif accepté : " + s);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
    @Test
    void testRedimensionnerRectangle()
    {
        try
        {
            Rectangle r = new Rectangle(origine, 20, 10);
            r.redimensionner(-1);
            fail("Redimensionnement négatif accepté : " + r);
        }
            catch (IllegalArgumentException ex)
            {
                // OK
            }
    }
}


