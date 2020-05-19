package dessinvectoriel;

import java.awt.*;

public class Segment extends Figure {
	private double longueur;


	public Segment(Vecteur position, double longueur)
	{
		super(position);
		this.longueur = longueur;
	}

	public Segment(Vecteur origine, Vecteur extremite)
	{
		super(origine);
		if (extremite == null)
			throw new IllegalArgumentException("Extremité nulle.");
		Vecteur directeur = extremite.soustraire(origine);
		setOrientation(directeur.orientation());
		longueur = directeur.longueur();
	}

	public Segment(Vecteur position, Angle orientation, double longueur)
	{
		super(position, orientation);
		this.longueur = longueur;
	}

	public Segment(Vecteur position, Angle orientation, double longueur, Color couleur, int epaisseurTrait)
	{
		super(position, orientation, couleur, epaisseurTrait);
		this.longueur = longueur;
	}


	public Vecteur getOrigine()
	{
		return getPosition();
	}

	public Vecteur getExtremite()
	{
		return getOrigine().ajouter(new Vecteur(longueur, getOrientation()));
	}

	@Override
	public void dessiner(Graphics2D g)
	{
		Vecteur extremite;
		int x1, y1, x2, y2;

		x1 = (int)getOrigine().getX();
		y1 = (int)getOrigine().getY();
		extremite = getExtremite();
		x2 = (int)extremite.getX();
		y2 = (int)extremite.getY();
		if (initTrait(g))
			g.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void redimensionner(double facteur)
	{
		longueur *= facteur;
	}

	@Override
	public Segment copier()
	{
		return new Segment(getPosition(), getOrientation(), longueur, getCouleurTrait(), getEpaisseurTrait());
	}

	@Override
	public String toString()
	{
		return "Origine : " + getOrigine() + "\n" +
		       "Extremité : " + getExtremite();
	}
}
