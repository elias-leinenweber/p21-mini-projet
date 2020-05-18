package dessinvectoriel.vecteurTests;

import dessinvectoriel.Angle;
import dessinvectoriel.Vecteur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VecteurTest3 {

    Vecteur v;

    @BeforeEach
    void setUp() {
        v = new Vecteur(2,2);
    }

    @Test
    void testAjouter(){
        try{
            v.ajouter(null);
            fail("La méthode accepte un vecteur null.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour un vecteur null.");
        }
    }

    @Test
    void testSoustraire(){
        try{
            v.soustraire(null);
            fail("La méthode accepte un vecteur null.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour un vecteur null.");
        }
    }
}