package dessinvectoriel;

import java.awt.*;

public class Cercle extends Surface {
	private double rayon;


	public Cercle(Vecteur position, double r)
	{
		super(position);
		rayon = r;
	}

	public Cercle(Vecteur position, double r, Color couleur, Integer epaisseurTrait, Color couleurRemplissage)
	{
		super(position, null, couleur, epaisseurTrait, couleurRemplissage);
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
