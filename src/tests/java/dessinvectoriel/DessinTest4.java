package dessinvectoriel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DessinTest4 {

    Dessin d;

    @BeforeEach
    void setUp() {
        d = new Dessin("La Joconde","Leonard de Vinci",200,200);
    }

    @Test
    void testAjouterFigure() {

        try {
            d.ajouterFigure(null);
            fail("La méthode accepte une figure null.");
        }
        catch(IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour une figure null.");
        }
    }

    @Test
    void testSetAuteur1() {

        try {
            d.setAuteur(null);
            fail("La méthode accepte un argument null.");
        }
        catch(IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour un auteur null.");
        }
    }

    @Test
    void testSetAuteur2() {

        try {
            d.setAuteur("");
            fail("La méthode accepte un auteur vide.");
        }
        catch(IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour un auteur vide.");
        }
    }

    @Test
    void testSetTitre1() {

        try {
            d.setTitre(null);
            fail("La méthode accepte un argument null.");
        }
        catch(IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour un titre null.");
        }
    }

    @Test
    void testSetTitre2() {

        try {
            d.setTitre("");
            fail("La méthode accepte un titre vide.");
        }
        catch(IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour un titre vide.");
        }
    }

    @Test
    void testSetDateCreation1() {

        try
        {
            d.setDateCreation(null);
            fail("La méthode accepte une date de création null.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour une date de création null.");
        }
    }

    @Test
    void testSetDateCreation2() {

        try
        {
            d.setDateCreation(LocalDate.MAX);
            fail("La méthode accepte une date de création supérieure à la date courante.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour une date de création supérieure à la date courante.");
        }
    }

    @Test
    void testSetLargeur() {

        try
        {
            d.setLargeur(-100);
            fail("La méthode accepte une largeur négative.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour une largeur négative.");
        }

    }

    @Test
    void testSetHauteur() {

        try
        {
            d.setHauteur(-100);
            fail("La méthode accepte une hauteu négative.");
        }
        catch (IllegalArgumentException ex)
        {
            // OK
        }
        catch (Exception ex)
        {
            fail("La méthode lance " + ex + " pour une hauteur négative.");
        }
    }
}