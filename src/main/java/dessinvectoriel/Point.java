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
		int x = (int)getPosition().getX();
		int y = (int)getPosition().getY();
		g.drawLine(x, y, x, y);
	}

	@Override
	public void redimensionner(double facteur)
	{
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
		return "Position : " + getPosition();
	}
}
