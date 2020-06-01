package dessinvectoriel;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class DessinTest3 {


    @Test
    void testDessinDate1(){
        try
        {
            new Dessin("","De Vinci", LocalDate.now(),200,200);
            fail("Le constructeur accepte un titre vide.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour un titre vide.");
        }
    }

    @Test
    void testDessinDate2(){
        try
        {
            new Dessin("La Joconde","", LocalDate.now(),200,200);
            fail("Le constructeur accepte un auteur vide.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour un auteur vide.");
        }
    }

    @Test
    void testDessinDate3(){
        try
        {
            new Dessin("La Joconde","De Vinci", null,200,200);
            fail("Le constructeur accepte une date de création null.");
        }
        catch (NullPointerException | IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour une date de création null.");
        }
    }

    @Test
    void testDessinDate4(){
        try
        {
            new Dessin("","De Vinci", LocalDate.now(),200,200);
            fail("Le constructeur accepte un titre vide.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour un titre vide.");
        }
    }

    @Test
    void testDessinDate5(){
        try
        {
            new Dessin("La Joconde","", LocalDate.now(),200,200);
            fail("Le constructeur accepte un auteur vide.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour un auteur vide.");
        }
    }

    @Test
    void testDessinDate6(){
        try
        {
            new Dessin("La Joconde","De Vinci", LocalDate.MAX,200,200);
            fail("Le constructeur accepte une date de création supérieure à la date courante.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour une date de création supérieure à la date courante.");
        }
    }

    @Test
    void testDessinDate7(){
        try
        {
            new Dessin("La Joconde","De Vinci", LocalDate.now(),-100,200);
            fail("Le constructeur accepte largeur négative.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour une largeur négative.");
        }
    }

    @Test
    void testDessinDate8(){
        try
        {
            new Dessin("La Joconde","De Vinci", LocalDate.now(),200,-100);
            fail("Le constructeur accepte hauteur négative.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("Le constructeur lance " + ex + " pour une hauteur négative.");
        }
    }

}