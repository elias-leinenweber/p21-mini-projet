package dessinvectoriel;

import java.awt.*;

public class Cercle extends Surface {
	private double rayon;


	public Cercle(Vecteur position, double r)
	{
		this(position, r, getCouleurTraitParDefaut(), getEpaisseurTraitParDefaut(), getCouleurRemplissageParDefaut());
	}

	public Cercle(Vecteur position, double r, Color couleur, int epaisseurTrait, Color couleurRemplissage)
	{
		super(position, getOrientationParDefaut(), couleur, epaisseurTrait, couleurRemplissage);
		rayon = r;
	}


	public Vecteur getCentre()
	{
		return getPosition();
	}

	public double getRayon()
	{
		return rayon;
	}

	public double getDiametre()
	{
		return 2 * rayon;
	}

	@Override
	public double surface()
	{
		return Math.PI * (rayon * rayon);
	}

	@Override
	public double perimetre()
	{
		return 2 * Math.PI * rayon;
	}

	@Override
	public void redimensionner(double facteur)
	{
		rayon *= facteur;
	}

	@Override
	public void dessiner(Graphics2D g)
	{
		int diametre, x, y;

		x = (int)getPosition().getX();
		y = (int)getPosition().getY();
		diametre = (int)getDiametre();
		if (initTrait(g))
			g.drawOval(x, y, diametre, diametre);
		if (initRemplissage(g))
			g.fillOval(x, y, diametre, diametre);
	}

	@Override
	public Figure copier()
	{
		return new Cercle(getPosition(), rayon, getCouleurTrait(), getEpaisseurTrait(), getCouleurRemplissage());
	}

	@Override
	public String toString()
	{
		// TODO implement
		return null;
	}
}
