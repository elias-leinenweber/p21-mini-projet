package dessinvectoriel;

import java.awt.*;

public abstract class Surface extends Figure {
	private static Color couleurRemplissageParDefaut = null;

	private Color couleurRemplissage;


	public Surface(Vecteur position)
	{
		super(position);
		setCouleurRemplissage(couleurRemplissageParDefaut);
	}

	public Surface(Vecteur position, Angle orientation)
	{
		super(position, orientation);
		setCouleurRemplissage(couleurRemplissageParDefaut);
	}

	public Surface(Vecteur position, Angle orientation, Color couleurTrait, int epaisseurTrait, Color couleurRemplissage)
	{
		super(position, orientation, couleurTrait, epaisseurTrait);
		setCouleurRemplissage(couleurRemplissage);
	}


	public void setCouleurRemplissage(Color couleurRemplissage)
	{
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
		if (g == null)
			throw new IllegalArgumentException("Contexte nul.");
		if (couleurRemplissage != null) {
			g.setPaint(couleurRemplissage);
			return true;
		}
		return false;
	}

	public static Color getCouleurRemplissageParDefaut()
	{
		return couleurRemplissageParDefaut;
	}

	public static void setCouleurRemplissageParDefaut(Color couleurRemplissageParDefaut)
	{
		Surface.couleurRemplissageParDefaut = couleurRemplissageParDefaut;
	}
}
