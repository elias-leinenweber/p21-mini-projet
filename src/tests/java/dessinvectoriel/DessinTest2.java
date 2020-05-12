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
    public void testListerEtAjouterFigures(){
        d.ajouterFigure(new Rectangle(new Vecteur(0,0),10,5));

        Figure[] listFig = {new Rectangle(new Vecteur(0,0),10,5)};
        assertEquals(listFig,d.listerFigures());
    }

    @Test
    public void testPaint(){
        
    }

}