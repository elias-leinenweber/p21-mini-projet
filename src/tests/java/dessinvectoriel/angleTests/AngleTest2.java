package dessinvectoriel.angleTests;

import dessinvectoriel.Angle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngleTest2 {

    @Test
    void testAjouter(){
        try
        {
            Angle.degres(90).ajouter(null);
            fail("La méthode accepte un angle null");
        }
        catch(IllegalArgumentException | NullPointerException ex)
        {
            // OK
        }
        catch(Exception ex){
            fail("La méthode lance "+ex+" pour un angle null.");
        }
    }
    

}