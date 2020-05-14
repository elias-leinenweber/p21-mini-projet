package dessinvectoriel;

import java.awt.*;
import java.util.Objects;

public abstract class Figure {
	private static int epaisseurTraitParDefaut = 1;
	private static Color couleurTraitParDefaut = Color.BLACK;

	private Vecteur position;
	private Angle orientation;
	private Color couleurTrait;


	public Figure(Vecteur position, Angle orientation, Color couleur, int epaisseurTrait)
	{
		this(position, orientation);
		Objects.requireNonNull(couleur);
		couleurTrait = couleur;
		setEpaisseurTrait(epaisseurTrait);
	}

	public Figure(Vecteur position, Angle orientation)
	{
		this(position);
		Objects.requireNonNull(orientation);
		this.orientation = orientation;
	}

	public Figure(Vecteur position)
	{
		Objects.requireNonNull(position);
		this.position = position;
	}


	public void setCouleurTrait(Color couleur)
	{
		Objects.requireNonNull(couleur);
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
		Objects.requireNonNull(position);
		this.position = position;
	}

	public Vecteur getPosition()
	{
		return position;
	}

	public void setOrientation(Angle orientation)
	{
		Objects.requireNonNull(orientation);
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
		position = position.ajouter(new Vecteur(deltaX, deltaY));
	}

	public void tourner(double angle)
	{
		orientation = orientation.ajouter(Angle.radians(angle));
	}

	public void tournerAutour(Vecteur centre, Angle angle)
	{
		Objects.requireNonNull(centre);
		Objects.requireNonNull(angle);
		Vecteur delta = centre.soustraire(position);
		double deltaX = delta.getX();
		double deltaY = delta.getY();
		deplacer(deltaX, deltaY);
		tourner(angle.getRadians());
		deplacer(-deltaX, -deltaY);
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
