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
		int rayon, x, y;

		x = (int)getPosition().getX();
		y = (int)getPosition().getY();
		rayon = getEpaisseurTrait() / 2;
		if (initTrait(g))
			g.fillOval(x - rayon, y - rayon, getEpaisseurTrait(), getEpaisseurTrait());
	}

	@Override
	public void redimensionner(double facteur)
	{
	}

	@Override
	public Point copier()
	{
		return new Point(getPosition(), getCouleurTrait(), getEpaisseurTrait());
	}

	@Override
	public String toString()
	{
		return "Position : " + getPosition();
	}
}
