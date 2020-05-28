package dessinvectoriel.angleTests;

import dessinvectoriel.Angle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngleTest1 {

    Angle a;

    @BeforeEach
    void setUp() {
        a = Angle.degres(90);
    }

    @Test
    void getDegres() {
        assertEquals(90, a.getDegres(), 1);
    }

    @Test
    void getRadians() {
        assertEquals(Math.PI / 2, a.getRadians(), 1);
    }

    @Test
    void ajouterDegres() {
        a = a.ajouterDegres(90);
        assertEquals(180,a.getDegres(),1);
    }

    @Test
    void ajouterRadians() {
        a = a.ajouterRadians(Math.PI / 2);
        assertEquals(Math.PI , a.getRadians(),1);
    }

    @Test
    void ajouter() {
        a = a.ajouter(Angle.DROIT);
        assertEquals(180,a.getDegres(),1);
    }

    @Test
    void sin() {
        assertEquals(Math.sin(a.getRadians()), a.sin(), 1);
    }

    @Test
    void cos() {
        assertEquals(Math.cos(a.getRadians()), a.cos(), 1);
    }

    @Test
    void testToString() {
        assertEquals("37°", Angle.degres(37).toString());
        assertEquals("90°", Angle.radians(Math.PI / 2).toString());
        assertEquals("66.6°", Angle.degres(66.6).toString());
    }
}