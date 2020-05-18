package dessinvectoriel;

import java.awt.*;

public abstract class Figure {
	private static Angle orientationParDefaut = Angle.NUL;
	private static Color couleurTraitParDefaut = Color.BLACK;
	private static int epaisseurTraitParDefaut = 1;

	private Vecteur position;
	private Angle orientation;
	private Color couleurTrait;
	private int epaisseurTrait;


	public Figure(Vecteur position, Angle orientation, Color couleur, int epaisseurTrait)
	{
		setPosition(position);
		setOrientation(orientation);
		setCouleurTrait(couleur);
		setEpaisseurTrait(epaisseurTrait);
	}

	public Figure(Vecteur position, Angle orientation)
	{
		this(position, orientation, couleurTraitParDefaut, epaisseurTraitParDefaut);
	}

	public Figure(Vecteur position)
	{
		this(position, orientationParDefaut);
	}


	public void setCouleurTrait(Color couleur)
	{
		if (couleur == null)
			throw new IllegalArgumentException("Couleur nulle.");
		couleurTrait = couleur;
	}

	public Color getCouleurTrait()
	{
		return couleurTrait;
	}

	public void setEpaisseurTrait(int epaisseurTrait)
	{
		if (epaisseurTrait < 0)
			throw new IllegalArgumentException("Épaisseur trait négative.");
		this.epaisseurTrait = epaisseurTrait;
	}

	public int getEpaisseurTrait()
	{
		return epaisseurTrait;
	}

	public void setPosition(Vecteur position)
	{
		if (position == null)
			throw new IllegalArgumentException("Position nulle.");
		this.position = position;
	}

	public Vecteur getPosition()
	{
		return position;
	}

	public void setOrientation(Angle orientation)
	{
		if (orientation == null)
			throw new IllegalArgumentException("Orientation nulle.");
		this.orientation = orientation;
	}

	public Angle getOrientation()
	{
		return orientation;
	}

	public abstract void dessiner(Graphics2D g);

	/**
	 * Renvoie une copie de la figure.
	 *
	 * @return une copie de la figure
	 */
	public abstract Figure copier();

	@Override
	public abstract String toString();

	/**
	 * Déplace la figure du vecteur de coordonnées ({@code deltaX}, {@code deltaY}).
	 *
	 * @param deltaX la translation à appliquer sur l'axe des abscisses
	 * @param deltaY la translation à appliquer sur l'axe des ordonnées
	 */
	public void deplacer(double deltaX, double deltaY)
	{
		position = position.ajouter(new Vecteur(deltaX, deltaY));
	}

	public void tourner(double angle)
	{
		orientation = orientation.ajouterRadians(angle);
	}

	public void tournerAutour(Vecteur centre, Angle angle)
	{
		Vecteur delta;
		double deltaX, deltaY;

		if (centre == null)
			throw new IllegalArgumentException("Centre nul.");
		if (angle == null)
			throw new IllegalArgumentException("Angle nul.");
		delta = centre.soustraire(position);
		deltaX = delta.getX();
		deltaY = delta.getY();
		deplacer(deltaX, deltaY);
		tourner(angle.getRadians());
		deplacer(-deltaX, -deltaY);
	}

	public abstract void redimensionner(double facteur);

	protected boolean initTrait(Graphics2D g)
	{
		if (g == null)
			throw new IllegalArgumentException("Contexte nul.");
		g.setStroke(new BasicStroke(epaisseurTrait));
		if (couleurTrait != null) {
			g.setPaint(couleurTrait);
			return true;
		}
		return false;
	}

	public static Angle getOrientationParDefaut()
	{
		return orientationParDefaut;
	}

	public static void setOrientationParDefaut(Angle orientationParDefaut)
	{
		if (orientationParDefaut == null)
			throw new IllegalArgumentException("Orientation par défaut nulle.");
		Figure.orientationParDefaut = orientationParDefaut;
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
		if (couleurTraitParDefaut == null)
			throw new IllegalArgumentException("Couleur trait par défaut nulle.");
		Figure.couleurTraitParDefaut = couleurTraitParDefaut;
	}
}
