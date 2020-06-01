package dessinvectoriel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AngleTest1 {

    Angle a, a1;
    double rad1, rad2;

    @BeforeEach
    void setUp() {
        a = Angle.degres(90);
        rad1 = 1.23456789;
        a1 = Angle.radians(rad1);
    }

    @Test
    void testConstructeur()
    {
        assertEquals(rad1, Angle.radians(rad1 + 1234 * Math.PI).getRadians(), 1e-10);
        assertEquals(rad1, Angle.radians(rad1 - 5678 * Math.PI).getRadians(), 1e-10);
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
        assertDoubleEquals(7 * Math.PI / 4, Angle.atan(1, -1).getRadians());
    }

    @Test
    void testGetDegres() {
        assertDoubleEquals(90, a.getDegres());
        assertDoubleEquals(rad1, Angle.degres(a1.getDegres()).getRadians());
    }

    @Test
    void testGetRadians() {
        assertDoubleEquals(Math.PI / 2, a.getRadians());
    }

    @Test
    void testAjouterDegres() {
        a = a.ajouterDegres(90);
        assertDoubleEquals(180, a.getDegres());
        assertDoubleEquals(40, a.ajouterDegres(220).getDegres());
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
        Locale.setDefault(Locale.ENGLISH);
        assertEquals("37.0°", Angle.degres(37).toString());
        assertEquals("90.0°", Angle.radians(Math.PI / 2).toString());
        assertEquals("66.6°", Angle.degres(66.6).toString());
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