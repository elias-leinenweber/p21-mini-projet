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

}