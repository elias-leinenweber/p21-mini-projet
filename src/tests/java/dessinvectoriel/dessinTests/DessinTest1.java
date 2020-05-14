package dessinvectoriel.dessinTests;

import static org.junit.jupiter.api.Assertions.*;

import dessinvectoriel.Dessin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DessinTest1 {

    Dessin d;

    @BeforeEach
    void setUp()
    {
        d = new Dessin("La Joconde","Leonard de Vinci",200,200);
    }

    @Test
    void testGetAuteur(){
        assertEquals("Leonard de Vinci",d.getAuteur());
    }

    @Test
    void testGetTitre(){
        assertEquals("La Joconde",d.getTitre());
    }

    @Test
    void testGetDateCreation(){
        assertEquals(LocalDate.now(),d.getDateCreation());
    }

    @Test
    void testGetLargeur(){
        assertEquals(200,d.getLargeur());
    }

    @Test
    void testGetHauteur(){
        assertEquals(200,d.getHauteur());
    }

    @Test
    void testToString(){
        assertEquals("Auteur : " + d.getAuteur() + "\n" +
                    "Titre : " + d.getTitre() + "\n" +
                    "Date de création : " + d.getDateCreation().toString() + "\n" +
                    "Dimensions : " + d.getLargeur() + "x" + d.getHauteur()+ "\n" +
                    "Figures : "+d.listerFigures().toString(),d.toString());
    }

    @Test
    void testSetAuteur(){
        d.setAuteur("El Chapo");
        assertEquals("El Chapo",d.getAuteur());
    }

    @Test
    void testSetTitre(){
        d.setTitre("ednocoJ aL");
        assertEquals("ednocoJ aL",d.getTitre());
    }

    @Test
    void testSetDateCreation(){
        d.setDateCreation(LocalDate.of(2000,1,1));
        assertEquals(LocalDate.of(2000,1,1),d.getDateCreation());
    }

    @Test
    void testSetLargeur(){
        d.setLargeur(300);
        assertEquals(300,d.getLargeur());
    }

    @Test
    void testSetHauteur(){
        d.setHauteur(300);
        assertEquals(300,d.getHauteur());
    }

}