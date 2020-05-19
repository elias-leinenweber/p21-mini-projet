package dessinvectoriel;

import java.awt.*;

public class Rectangle extends Surface {
	private double	longueur;
	private double	largeur;


	public Rectangle(Vecteur position, double longueur, double largeur)
	{
		this(position, getOrientationParDefaut(), longueur, largeur);
	}

	public Rectangle(Vecteur position, Angle orientation, double longueur, double largeur)
	{
		this(position, orientation, longueur, largeur,
		    getCouleurTraitParDefaut(), getEpaisseurTraitParDefaut(),
		    getCouleurRemplissageParDefaut());
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
		Vecteur longEdge, shortEdge;

		sommets = new Vecteur[4];
		longEdge = new Vecteur(longueur, getOrientation());
		shortEdge = new Vecteur(largeur, getOrientation().ajouter(Angle.DROIT));
		sommets[0] = getPosition();
		sommets[1] = sommets[0].ajouter(longEdge);
		sommets[2] = sommets[1].ajouter(shortEdge);
		sommets[3] = sommets[0].ajouter(shortEdge);
		return sommets;
	}

	@Override
	public void dessiner(Graphics2D g)
	{
		Vecteur[] sommets;
		int[] xPoints, yPoints;

		sommets = getSommets();
		xPoints = new int[4];
		yPoints = new int[4];
		for (int i = 0; i < 4; ++i) {
			xPoints[i] = (int)sommets[i].getX();
			yPoints[i] = (int)sommets[i].getY();
		}
		if (initRemplissage(g))
			g.fillPolygon(xPoints, yPoints, 4);
		if (initTrait(g))
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
