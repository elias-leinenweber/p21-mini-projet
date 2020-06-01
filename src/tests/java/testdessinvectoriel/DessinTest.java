package testdessinvectoriel;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;


import dessinvectoriel.Cercle;
import dessinvectoriel.Dessin;
import dessinvectoriel.Figure;
import dessinvectoriel.Point;
import dessinvectoriel.Vecteur;

class DessinTest
{
    Dessin d1 = new Dessin("titre1", "auteur1", 100, 200);
    Dessin d2 = new Dessin("titre2", "auteur2", LocalDate.of(2000, 5, 24), 300, 400);

    @Test
    void testDessinStringStringIntInt()
    {
        assertEquals("titre1", d1.getTitre());
        assertEquals("auteur1", d1.getAuteur());
        assertEquals(100, d1.getLargeur());
        assertEquals(200, d1.getHauteur());
        assertEquals(LocalDate.now(), d1.getDateCreation());
    }

    @Test
    void testDessinStringStringLocalDateIntInt()
    {
        assertEquals("titre2", d2.getTitre());
        assertEquals("auteur2", d2.getAuteur());
        assertEquals(300, d2.getLargeur());
        assertEquals(400, d2.getHauteur());
        assertEquals(LocalDate.of(2000, 5, 24), d2.getDateCreation());
    }


    @Test
    void testGetAuteur()
    {
        assertEquals("auteur1", d1.getAuteur());
        assertEquals("auteur2", d2.getAuteur());
    }

    @Test
    void testSetAuteur()
    {
        d1.setAuteur("auteur3");
        assertEquals("auteur3", d1.getAuteur());
        d2.setAuteur("auteur4");
        assertEquals("auteur4", d2.getAuteur());
    }

    @Test
    void testGetTitre()
    {
        assertEquals("titre1", d1.getTitre());
        assertEquals("titre2", d2.getTitre());
   }

    @Test
    void testSetTitre()
    {
        d1.setTitre("titre3");
        assertEquals("titre3", d1.getTitre());
        d2.setTitre("titre4");
        assertEquals("titre4", d2.getTitre());
    }

    @Test
    void testGetDateCreation()
    {
        assertEquals(LocalDate.now(), d1.getDateCreation());
        assertEquals(LocalDate.of(2000, 5, 24), d2.getDateCreation());
    }

    @Test
    void testSetDateCreation()
    {
        d1.setDateCreation(d2.getDateCreation());
        assertEquals(d2.getDateCreation(), d1.getDateCreation());
        d2.setDateCreation(LocalDate.now());
        assertEquals(LocalDate.now(), d2.getDateCreation());
    }

    @Test
    void testGetLargeur()
    {
        assertEquals(100, d1.getLargeur());
        assertEquals(300, d2.getLargeur());
    }

    @Test
    void testSetLargeur()
    {
        d1.setLargeur(150);
        assertEquals(150, d1.getLargeur());
        d2.setLargeur(350);
        assertEquals(350, d2.getLargeur());
    }

    @Test
    void testGetHauteur()
    {
        assertEquals(200, d1.getHauteur());
        assertEquals(400, d2.getHauteur());
    }

    @Test
    void testSetHauteur()
    {
        d1.setHauteur(250);
        assertEquals(250, d1.getHauteur());
        d2.setHauteur(450);
        assertEquals(450, d2.getHauteur());
    }

    @Test
    void testAjouterFigure()
    {
        List<Figure> cf1 = d1.listerFigures();
        assertEquals(0, cf1.size());
        Figure f1 = new Point(0,0);
        d1.ajouterFigure(f1);
        cf1 = d1.listerFigures();
        assertEquals(1, cf1.size());
        assertSame(f1, cf1.get(0));
        
        Figure f2 = new Cercle(new Vecteur(0,0), 10);
        d1.ajouterFigure(f2);
        cf1 = d1.listerFigures();
        assertEquals(2, cf1.size());
        assertSame(f1, cf1.get(0));
        assertSame(f2, cf1.get(1));
        
        List<Figure> cf2 = d2.listerFigures();
        assertEquals(0, cf2.size());
        d2.ajouterFigure(f1);
        cf2 = d2.listerFigures();
        assertEquals(1, cf2.size());
        assertSame(f1, cf2.get(0));
        
        d2.ajouterFigure(f2);
        cf2 = d2.listerFigures();
        assertEquals(2, cf2.size());
        assertSame(f1, cf2.get(0));
        assertSame(f2, cf2.get(1));
    }

    @Test
    void testListerFigures()
    {
        List<Figure> cf1 = d1.listerFigures();
        assertEquals(0, cf1.size());
        List<Figure> cf2 = d2.listerFigures();
        assertEquals(0, cf2.size());
    }

}
