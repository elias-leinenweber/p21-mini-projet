package dessinvectoriel;

/**
 * La classe non modifiable {@code Vecteur}.
 * <p>
 * Les vecteurs permettent de gérer les positions des figures.
 * <p>
 * Dans un repère cartésien, si l'on place l'origine d'un vecteur à l'origine du
 * repère, on obtient le point <i>P</i> qui est l'extrémité du vecteur.  Les
 * composantes du vecteur sont les coordonnées du point <i>P</i>.
 * <p>
 * Si le point <i>P</i> a les coordonnées
 * (<i>P<sub>x</sub></i>, <i>P<sub>y</sub></i>), les composantes du vecteur dont
 * <i>P</i> est l'extrémité sont <i>P<sub>x</sub></i> et <i>P<sub>y</sub></i>,
 * et on note le vecteur (<i>P<sub>x</sub></i>, <i>P<sub>y</sub></i>).
 */
public class Vecteur {
	private final double	x;
	private final double	y;


	/**
	 * Initialise ce nouveau vecteur avec des coordonnées cartésiennes.
	 *
	 * @param x la composante <i>x</i> du vecteur
	 * @param y la composante <i>y</i> du vecteur
	 */
	public Vecteur(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Initialise ce nouveau vecteur avec des coordonnées polaires.
	 * <p>
	 * Les formules de passage des coordonnées polaires (r, &theta;) d'un vecteur à
	 * ses coordonnées cartésiennes (x, y) sont :
	 * x = r cos &theta;, y = r sin &theta;.
	 *
	 * @param rayon la distance r de l'origine du repère à l'extrémité P du vecteur
	 * @param orientation l'angle &theta; de rotation du vecteur par rapport à l'axe
	 *                    des abscisses
	 */
	public Vecteur(double rayon, Angle orientation)
	{
		if (rayon < 0)
			throw new IllegalArgumentException("Rayon négatif.");
		if (orientation == null)
			throw new IllegalArgumentException("Orientation nulle.");
		x = rayon * orientation.cos();
		y = rayon * orientation.sin();
	}


	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	/**
	 * Ajoute un vecteur à ce vecteur.
	 * Renvoie un nouveau vecteur qui est la somme de ce vecteur et de l'autre
	 * vecteur spécifié.
	 * <p>
	 * Si ce vecteur a les composantes (P<sub>x</sub>, P<sub>y</sub>) et l'autre
	 * vecteur les composantes (Q<sub>x</sub>, Q<sub>y</sub>) le vecteur renvoyé
	 * aura les composantes (P<sub>x</sub>+Q<sub>x</sub>,
	 * P<sub>y</sub>+Q<sub>y</sub>).
	 *
	 * @param autre le vecteur à ajouter
	 * @return la somme des deux vecteurs
	 */
	public Vecteur ajouter(Vecteur autre)
	{
		if (autre == null)
			throw new IllegalArgumentException("Autre vecteur nul.");
		return new Vecteur(x + autre.x, y + autre.y);
	}

	public Vecteur oppose()
	{
		return new Vecteur(-x, -y);
	}

	public Vecteur soustraire(Vecteur autre)
	{
		if (autre == null)
			throw new IllegalArgumentException("Autre vecteur nul.");
		return ajouter(autre.oppose());
	}

	public Vecteur multiplier(double facteur)
	{
		return new Vecteur(facteur * x, facteur * y);
	}

	public double longueur()
	{
		return Math.sqrt(x * x + y * y);
	}

	public Angle orientation()
	{
		return Angle.atan(x, y);
	}

	/**
	 * Renvoie une chaîne de caractères représentant la valeur ce vecteur.
	 *
	 * @return une chaîne de la forme (P<sub>x</sub>, P<sub>y</sub>)
	 */
	@Override
	public String toString()
	{
		return String.format("(%f, %f)", x, y);
	}
}
