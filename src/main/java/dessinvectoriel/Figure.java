package dessinvectoriel;

import java.awt.*;

public abstract class Figure {
	private Vecteur position;
	private Angle orientation;
	private Color couleurTrait;
	private int epaisseurTrait;

	public Figure(Vecteur position, Angle orientation, Color couleur, int epaisseurTrait){
		// TODO implement
	}

	public Figure(Vecteur position, Angle orientation){
		// TODO implement
	}

	public Figure(Vecteur position){
		// TODO implement
	}

	public void setEpaisseurTrait(Integer epaisseurTrait)
	{
		// TODO implement
	}

	public void deplacer(double deltaX, double deltaY)
	{
		// TODO implement
	}

	public abstract void redimensionner(double facteur);
}
