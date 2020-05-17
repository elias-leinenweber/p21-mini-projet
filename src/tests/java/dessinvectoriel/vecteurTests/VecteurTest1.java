package dessinvectoriel.vecteurTests;

import dessinvectoriel.Vecteur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VecteurTest1 {

    Vecteur v;

    @BeforeEach
    void setUp() {
        v = new Vecteur(2,2);
    }

    @Test
    void getX() {
        assertEquals(2,v.getX());
    }

    @Test
    void getY() {
        assertEquals(2,v.getY());
    }

    @Test
    void ajouter() {
        Vecteur w = v.ajouter(new Vecteur(1,1));
        assertEquals(3,w.getX());
        assertEquals(3,w.getY());
    }

    @Test
    void oppose() {
        Vecteur w = v.oppose();
        assertEquals(-2,w.getX());
        assertEquals(-2,w.getY());
    }

    @Test
    void soustraire() {
        Vecteur w = v.soustraire(new Vecteur(1,1));
        assertEquals(1,w.getX());
        assertEquals(1,w.getY());
    }

    @Test
    void multiplier() {
        Vecteur w = v.multiplier(2);
        assertEquals(4,w.getX());
        assertEquals(4,w.getY());
    }

    @Test
    void longueur() {
        assertEquals(Math.sqrt(8),v.longueur());
    }

    @Test
    void orientation() {
        assertEquals(Math.atan2(2, 2),v.orientation().getRadians());
    }
}