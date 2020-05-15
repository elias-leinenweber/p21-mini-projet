package dessinvectoriel;

import java.awt.*;

public class Point extends Figure {
	public Point(Vecteur position)
	{
		super(position);
	}

	public Point(Vecteur position, Color couleur, int epaisseurTrait)
	{
		super(position);
		setCouleurTrait(couleur);
		setEpaisseurTrait(epaisseurTrait);
	}

	public Point(int x, int y)
	{
		super(new Vecteur(x, y));
	}


	@Override
	public void dessiner(Graphics2D g)
	{
		int x, y;

		x = (int)getPosition().getX();
		y = (int)getPosition().getY();
		if (initTrait(g))
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
