package dessinvectoriel;

import java.awt.*;
import java.util.Arrays;

public class Rectangle extends Surface {
	private double	longueur;
	private double	largeur;


	public Rectangle(Vecteur position, double longueur, double largeur)
	{
		super(position);
		this.longueur = longueur;
		this.largeur = largeur;
	}

	public Rectangle(Vecteur position, Angle orientation, double longueur, double largeur)
	{
		super(position, orientation);
		this.longueur = longueur;
		this.largeur = largeur;
	}

	public Rectangle(Vecteur position, Angle orientation, double longueur, double largeur, Color couleurTrait, int epaisseurTrait, Color couleurRemplissage)
	{
		super(position, orientation, couleurTrait, epaisseurTrait, couleurRemplissage);
		this.longueur = longueur;
		this.largeur = largeur;
	}


	@Override
	public double surface()
	{
		return longueur * largeur;
	}

	@Override
	public double perimetre()
	{
		return 2 * (longueur + largeur);
	}

	public double getLongueur()
	{
		return longueur;
	}

	public double getLargeur()
	{
		return largeur;
	}

	public Vecteur[] getSommets()
	{
		Vecteur[] sommets;

		sommets = new Vecteur[4];
		sommets[0] = getPosition();
		sommets[1] = new Vecteur(getLongueur(), getOrientation());
		sommets[2] = new Vecteur(getLargeur(), getOrientation().ajouter(Angle.DROIT));
		sommets[3] = sommets[1].ajouter(sommets[2]);
		return sommets;
	}

	@Override
	public void dessiner(Graphics2D g)
	{
		Vecteur[] sommets;
		int[] xPoints, yPoints;

		sommets = getSommets();
		xPoints = Arrays.stream(sommets).map(Vecteur::getX).mapToInt(Double::intValue).toArray();
		yPoints = Arrays.stream(sommets).map(Vecteur::getY).mapToInt(Double::intValue).toArray();
		if (initTrait(g))
			g.drawPolygon(xPoints, yPoints, 4);
		if (initRemplissage(g))
			g.drawPolygon(xPoints, yPoints, 4);
	}

	public Rectangle copier()
	{
		return new Rectangle(getPosition(), getOrientation(), longueur, largeur,
		    getCouleurTrait(), getEpaisseurTrait(), getCouleurRemplissage());
	}

	@Override
	public void redimensionner(double facteur)
	{
		if (facteur < 0)
			throw new IllegalArgumentException("Facteur invalide.");
		longueur *= facteur;
		largeur *= facteur;
	}

	@Override
	public String toString()
	{
		// TODO implement
		return null;
	}
}
