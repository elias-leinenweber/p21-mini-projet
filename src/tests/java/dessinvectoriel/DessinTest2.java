package dessinvectoriel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Collection<Figure> listFig = new ArrayList<Figure>();
        listFig.add(r);

        assertEquals(listFig, d.listerFigures());
    }

    @Test
    public void testListerEtAjouterFigures2(){
        Collection<Figure> vide = new ArrayList<>();
        Collection<Figure> listFig = d.listerFigures();

        d.ajouterFigure(new Rectangle(new Vecteur(0,0),10,5));

        assertEquals(vide, listFig);

    }
    

}