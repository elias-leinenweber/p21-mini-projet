package dessinvectoriel;

import java.awt.*;

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
		Vecteur longEdge, shortEdge;

		sommets = new Vecteur[4];
		longEdge = new Vecteur(getLongueur(), getOrientation());
		shortEdge = new Vecteur(getLargeur(), getOrientation().ajouter(Angle.degres(-90)));
		sommets[0] = getPosition();
		sommets[1] = sommets[0].ajouter(shortEdge);
		sommets[2] = sommets[0].ajouter(longEdge).ajouter(shortEdge);
		sommets[3] = sommets[0].ajouter(longEdge);
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
		if (initTrait(g))
			g.drawPolygon(xPoints, yPoints, 4);
		if (initRemplissage(g))
			g.fillPolygon(xPoints, yPoints, 4);
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
