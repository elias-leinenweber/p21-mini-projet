package dessinvectoriel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DessinTest2 {

    Dessin d;

    @BeforeEach
    void setUp() {
        d = new Dessin("La Joconde","Leonard de Vinci",200,200);
    }

    @Test
    public void testListerEtAjouterFigures1(){
        Rectangle r = new Rectangle(new Vecteur(0,0),10,5);

        d.ajouterFigure(r);
        Figure[] listFig = {r};

        assertArrayEquals(listFig,d.listerFigures());
    }

    @Test
    public void testListerEtAjouterFigures2(){
        Figure[] vide = {};
        Figure[] listFig = d.listerFigures();

        d.ajouterFigure(new Rectangle(new Vecteur(0,0),10,5));

        assertArrayEquals(vide,listFig);

    }
    

}