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
        assertDoubleEquals(90, a.getDegres());
    }

    @Test
    void getRadians() {
        assertDoubleEquals(Math.PI / 2, a.getRadians());
    }

    @Test
    void ajouterDegres() {
        a = a.ajouterDegres(90);
        assertDoubleEquals(180, a.getDegres());
    }

    @Test
    void ajouterRadians() {
        a = a.ajouterRadians(Math.PI / 2);
        assertDoubleEquals(Math.PI, a.getRadians());
    }

    @Test
    void ajouter() {
        a = a.ajouter(Angle.DROIT);
        assertDoubleEquals(180, a.getDegres());
    }

    @Test
    void sin() {
        assertDoubleEquals(Math.sin(a.getRadians()), a.sin());
    }

    @Test
    void cos() {
        assertDoubleEquals(Math.cos(a.getRadians()), a.cos());
    }

    @Test
    void testToString() {
        assertEquals("37°", Angle.degres(37).toString());
        assertEquals("90°", Angle.radians(Math.PI / 2).toString());
        assertEquals("66.6°", Angle.degres(66.6).toString());
    }

    private void assertDoubleEquals(double expected, double actual)
    {
        assertEquals(expected, actual, Math.ulp(expected));
    }
}