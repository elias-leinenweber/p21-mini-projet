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
    void testAngleDegres(){
        assertDoubleEquals(Math.PI, Angle.degres(180).getRadians());
    }

    @Test
    void testAngleRadians(){
        assertDoubleEquals(180,Angle.radians(Math.PI).getDegres());
    }

    @Test
    void testAngleAtan(){
        assertDoubleEquals(90,Angle.atan(0,1).getDegres());
    }

    @Test
    void testGetDegres() {
        assertDoubleEquals(90, a.getDegres());
    }

    @Test
    void testGetRadians() {
        assertDoubleEquals(Math.PI / 2, a.getRadians());
    }

    @Test
    void testAjouterDegres() {
        a = a.ajouterDegres(90);
        assertDoubleEquals(180, a.getDegres());
    }

    @Test
    void testAjouterRadians() {
        a = a.ajouterRadians(Math.PI / 2);
        assertDoubleEquals(Math.PI, a.getRadians());
    }

    @Test
    void testAjouter() {
        a = a.ajouter(Angle.DROIT);
        assertDoubleEquals(180, a.getDegres());
    }

    @Test
    void testSin() {
        assertDoubleEquals(Math.sin(a.getRadians()), a.sin());
    }

    @Test
    void testCos() {
        assertDoubleEquals(Math.cos(a.getRadians()), a.cos());
    }

    @Test
    void testToString() {
        assertEquals("37°", Angle.degres(37).toString());
        assertEquals("90°", Angle.radians(Math.PI / 2).toString());
        assertEquals("66,6°", Angle.degres(66.6).toString());
    }

    @Test
    void testAngleNul(){
        assertDoubleEquals(Angle.NUL.getDegres(), 0);
    }

    @Test
    void AngleDroit(){
        assertDoubleEquals(Angle.DROIT.getDegres(), 90);
    }

    @Test
    void AnglePlat(){
        assertDoubleEquals(Angle.PLAT.getDegres(), 180);
    }

    private void assertDoubleEquals(double expected, double actual)
    {
        assertEquals(expected, actual, Math.ulp(expected));
    }
}