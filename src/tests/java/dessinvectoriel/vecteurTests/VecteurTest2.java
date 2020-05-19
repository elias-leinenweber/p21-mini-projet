package dessinvectoriel.vecteurTests;

import dessinvectoriel.Angle;
import dessinvectoriel.Vecteur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VecteurTest2 {

    @Test
    void testVecteur1(){
        try{
            new Vecteur(-2,Angle.degres(90));
            fail("Le constructeur accepte un rayon négatif.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour un rayon négatif.");
        }
    }

    @Test
    void testVecteur2(){
        try{
            new Vecteur(2,null);
            fail("Le constructeur accepte un angle null.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour un angle null.");
        }
    }

	@Test
	void testVecteur3()
	{
		Vecteur v = new Vecteur(1, Angle.DROIT);
		assertEquals(0.0, v.getX(), 1e-10);
		assertEquals(1.0, v.getY(), 1e-10);
		v = new Vecteur(0, Angle.NUL);
		assertEquals(0, v.getX());
		assertEquals(0, v.getY());
		v = new Vecteur(99999, Angle.degres(720));
		assertEquals(99999, v.getX());
		assertEquals(0, v.getY());
	}
}