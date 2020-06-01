package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import dessinvectoriel.Angle;
import dessinvectoriel.Figure;
import dessinvectoriel.Rectangle;
import dessinvectoriel.Vecteur;

class FigureSetDefautTest
{

    @Test
    void testSetCouleurTraitParDefaut()
    {
        Figure.setCouleurTraitParDefaut(Color.RED);
        assertEquals(Color.RED, Figure.getCouleurTraitParDefaut());
        assertEquals(Color.RED, new Rectangle(new Vecteur(0,0), 40, 30).getCouleurTrait());
        assertEquals(Color.RED, new Rectangle(new Vecteur(0,0), Angle.DROIT, 40, 30).getCouleurTrait());
    }

    @Test
    void testSetOrientationParDefaut()
    {
        Figure.setOrientationParDefaut(Angle.DROIT);
        assertEquals(90, Figure.getOrientationParDefaut().getDegres());
        assertEquals(90, new Rectangle(new Vecteur(0,0), 40, 30).getOrientation().getDegres());
    }

    @Test
    void testSetEpaisseurTraitParDefaut()
    {
        Figure.setEpaisseurTraitParDefaut(3);
        assertEquals(3, Figure.getEpaisseurTraitParDefaut());
        assertEquals(3, new Rectangle(new Vecteur(0,0), 40, 30).getEpaisseurTrait());
        assertEquals(3, new Rectangle(new Vecteur(0,0), Angle.DROIT, 40, 30).getEpaisseurTrait());
    }
}
