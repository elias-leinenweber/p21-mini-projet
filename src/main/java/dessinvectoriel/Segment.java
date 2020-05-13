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
		Vecteur vecteurDirecteur = new Vecteur(getOrientation().cos(), getOrientation().sin());
		return getPosition().ajouter(vecteurDirecteur.multiplier(longueur));
	}

	@Override
	public void dessiner(Graphics2D g)
	{
		// TODO implement
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
		// TODO implement
		return null;
	}
}
