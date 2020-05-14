package dessinvectoriel;

import java.awt.*;

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
		setCouleurRemplissage(couleurRemplissage);
	}


	public void setCouleurRemplissage(Color couleurRemplissage)
	{
		if (couleurRemplissage == null)
			throw new IllegalArgumentException("Couleur remplissage nulle.");
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
		if (couleurRemplissageParDefaut == null)
			throw new IllegalArgumentException("Couleur remplissage par défaut nulle.");
		Surface.couleurRemplissageParDefaut = couleurRemplissageParDefaut;
	}
}
