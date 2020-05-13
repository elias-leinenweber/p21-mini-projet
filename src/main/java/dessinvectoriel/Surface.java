package dessinvectoriel;

import java.awt.*;
import java.util.Objects;

public abstract class Surface extends Figure {
	private static Color couleurRemplissageParDefaut = null;
	private Color couleurRemplissage;


	public Surface(Vecteur position)
	{
		super(position);
	}

	public Surface(Vecteur position, Angle orientation)
	{
		super(position, orientation);
	}

	public Surface(Vecteur position, Angle orientation, Color couleurTrait, Integer epaisseurTrait, Color couleurRemplissage)
	{
		super(position, orientation, couleurTrait, epaisseurTrait);
		Objects.requireNonNull(couleurRemplissage);
		this.couleurRemplissage = couleurRemplissage;
	}


	public void setCouleurRemplissage(Color couleurRemplissage)
	{
		Objects.requireNonNull(couleurRemplissage);
		this.couleurRemplissage = couleurRemplissage;
	}

	public Color getCouleurRemplissage()
	{
		return couleurRemplissage;
	}

	public abstract double surface();

	public abstract double perimetre();

	protected boolean initRemplissage(Graphics2D g)
	{
		// TODO implement
		return false;
	}

	public static Color getCouleurRemplissageParDefaut()
	{
		return couleurRemplissageParDefaut;
	}

	public static void setCouleurRemplissageParDefaut(Color couleurRemplissageParDefaut)
	{
		Objects.requireNonNull(couleurRemplissageParDefaut);
		Surface.couleurRemplissageParDefaut = couleurRemplissageParDefaut;
	}
}
