package dessinvectoriel;

import java.awt.*;

public class Point extends Figure {
	public Point(Vecteur position)
	{
		super(position);
	}

	public Point(Vecteur position, Color couleur, int epaisseurTrait)
	{
		super(position, null, couleur, epaisseurTrait);
	}

	public Point(int x, int y)
	{
		this(new Vecteur(x, y));
	}


	public void dessiner(Graphics2D g)
	{
		// TODO implement
	}

	@Override
	public void redimensionner(double facteur)
	{
		// TODO implement
	}

	@Override
	public Figure copier()
	{
		// TODO implement
		return null;
	}

	@Override
	public String toString()
	{
		// TODO implement
		return null;
	}
}
