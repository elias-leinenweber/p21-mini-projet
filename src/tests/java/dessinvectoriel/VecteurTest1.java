package dessinvectoriel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VecteurTest1 {

    Vecteur v, nul;

    @BeforeEach
    void setUp() {
        v = new Vecteur(2,2);
        nul = new Vecteur(0, 0);
    }

    @Test
    void testGetX() {
        assertEquals(2,v.getX());
    }

    @Test
    void testGetY() {
        assertEquals(2,v.getY());
    }

    @Test
    void testAjouter() {
        Vecteur w = v.ajouter(new Vecteur(1,1));
        assertEquals(3,w.getX());
        assertEquals(3,w.getY());
    }

    @Test
    void testOppose() {
        Vecteur w = v.oppose();
        assertEquals(-2,w.getX());
        assertEquals(-2,w.getY());
    }

    @Test
    void testSoustraire() {
        Vecteur w = v.soustraire(new Vecteur(1,1));
        assertEquals(1,w.getX());
        assertEquals(1,w.getY());
    }

    @Test
    void testMultiplier() {
        Vecteur w = v.multiplier(2);
        assertEquals(4,w.getX());
        assertEquals(4,w.getY());
    }

    @Test
    void testLongueur() {
        assertEquals(Math.sqrt(8),v.longueur());
        assertEquals(0, nul.longueur());
    }

    @Test
    void testOrientation() {
        assertEquals(Math.atan2(2, 2),v.orientation().getRadians());
    }

    @Test
    void testToString(){
    	Locale.setDefault(Locale.FRENCH);
        assertEquals("(2,000000, 2,000000)",v.toString());
    }
}