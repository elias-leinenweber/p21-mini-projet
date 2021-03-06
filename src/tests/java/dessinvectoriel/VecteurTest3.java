package dessinvectoriel;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        catch (NullPointerException | IllegalArgumentException ex)
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
        catch (NullPointerException | IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour un vecteur null.");
        }
    }
}