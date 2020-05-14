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
		longueur = extremite.soustraire(origine).longueur();
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
		Vecteur vecteurDirecteur;

		vecteurDirecteur = new Vecteur(getOrientation().cos(), getOrientation().sin());
		return getPosition().ajouter(vecteurDirecteur.multiplier(longueur));
	}

	@Override
	public void dessiner(Graphics2D g)
	{
		Vecteur extremite;

		if (g == null)
			throw new IllegalArgumentException("Contexte nul.");
		extremite = getExtremite();
		g.drawLine((int)getOrigine().getX(), (int)getOrigine().getY(), (int)extremite.getX(), (int)extremite.getY());
	}

	@Override
	public void redimensionner(double facteur)
	{
		longueur *= facteur;
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
		return "Origine : " + getOrigine() + "\n" +
		       "Extremité : " + getExtremite();
	}
}
