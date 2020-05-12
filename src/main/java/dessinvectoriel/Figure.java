package dessinvectoriel;

import java.awt.*;

public abstract class Figure {
	private static int epaisseurTraitParDefaut = 1;
	private static Color couleurTraitParDefaut = Color.BLACK;

	private Vecteur position;
	private Angle orientation;
	private Color couleurTrait;


	public Figure(Vecteur position, Angle orientation, Color couleur, int epaisseurTrait)
	{
		// TODO implement
	}

	public Figure(Vecteur position, Angle orientation)
	{
		// TODO implement
	}

	public Figure(Vecteur position)
	{
		// TODO implement
	}


	public void setCouleurTrait(Color couleur)
	{
		couleurTrait = couleur;
	}

	public Color getCouleurTrait()
	{
		return couleurTrait;
	}

	public void setEpaisseurTrait(Integer epaisseurTrait)
	{
		// TODO implement
	}

	public Integer getEpaisseurTrait()
	{
		// TODO implement
		return null;
	}

	public void setPosition(Vecteur position)
	{
		this.position = position;
	}

	public Vecteur getPosition()
	{
		return position;
	}

	public void setOrientation(Angle orientation)
	{
		this.orientation = orientation;
	}

	public Angle getOrientation()
	{
		return orientation;
	}

	public abstract void dessiner(Graphics2D g);

	public abstract Figure copier();

	public abstract String toString();

	public void deplacer(double deltaX, double deltaY)
	{
		// TODO implement
	}

	public void tourner(double angle)
	{
		// TODO implement
	}

	public void tournerAutour(Vecteur centre, Angle angle)
	{
		// TODO implement
	}

	public abstract void redimensionner(double facteur);

	protected boolean initTrait(Graphics2D g)
	{
		// TODO implement
		return false;
	}

	public static Angle getOrientationParDefaut()
	{
		// TODO implement
		return null;
	}

	public static void setOrientationParDefaut()
	{
		// TODO implement
	}

	public static int getEpaisseurTraitParDefaut()
	{
		return epaisseurTraitParDefaut;
	}

	public static void setEpaisseurTraitParDefaut(int epaisseurTraitParDefaut)
	{
		Figure.epaisseurTraitParDefaut = epaisseurTraitParDefaut;
	}

	public static Color getCouleurTraitParDefaut()
	{
		return couleurTraitParDefaut;
	}

	public static void setCouleurTraitParDefaut(Color couleurTraitParDefaut)
	{
		Figure.couleurTraitParDefaut = couleurTraitParDefaut;
	}
}
