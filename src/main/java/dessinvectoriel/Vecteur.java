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
 * (<i>P<sub>x</sub></i>,&nbsp;<i>P<sub>y</sub></i>),
 * les composantes du vecteur dont <i>P</i> est l'extrémité sont
 * <i>P<sub>x</sub></i> et <i>P<sub>y</sub></i>,
 * et on note le vecteur
 * (<i>P<sub>x</sub></i>,&nbsp;<i>P<sub>y</sub></i>).
 */
public class Vecteur {

    private final double x;
    private final double y;

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
     * Les formules de passage des coordonnées polaires
     * (<i>r</i>,&nbsp;<i>&theta;</i>) d'un vecteur à ses coordonnées
     * cartésiennes (<i>x</i>,&nbsp;<i>y</i>) sont :
     * <i>x</i>&nbsp;=&nbsp;<i>r</i>&sdot;cos&nbsp;<i>&theta;</i>,
     * <i>y</i>&nbsp;=&nbsp;<i>r</i>&sdot;sin&nbsp;<i>&theta;</i>.
     *
     * @param rayon la distance <i>r</i> de l'origine du repère à l'extrémité
     *              <i>P</i> du vecteur
     * @param orientation l'angle <i>&theta;</i> de rotation du vecteur par
     *                    rapport à l'axe des abscisses
     * @throws IllegalArgumentException si le rayon est négatif
     */
    public Vecteur(double rayon, Angle orientation)
    {
        if (rayon < 0)
            throw new IllegalArgumentException("Rayon négatif : " + rayon);
        // TODO Objects#requireNonNull
        if (orientation == null)
            throw new IllegalArgumentException("Orientation nulle.");
        x = rayon * orientation.cos();
        y = rayon * orientation.sin();
    }

    /**
     * Renvoie la composante en <i>x</i> de ce vecteur.
     *
     * @return la coordonnée cartésienne sur l'axe des abscisses ou l'abscisse
     *         de l'extrémité <i>P</i> de ce vecteur
     */
    public double getX()
    {
        return x;
    }

    /**
     * Renvoie la composante en <i>y</i> de ce vecteur.
     *
     * @return la coordonnée cartésienne sur l'axe des ordonnées ou l'ordonnée
     *         de l'extrémité <i>P</i> de ce vecteur
     */
    public double getY()
    {
        return y;
    }

    /**
     * Ajoute un vecteur à ce vecteur.  Renvoie un nouveau vecteur qui est la
     * somme de ce vecteur et de l'autre vecteur spécifié.
     * <p>
     * Si ce vecteur a les composantes
     * (<i>P<sub>x</sub></i>,&nbsp;<i>P<sub>y</sub></i>)
     * et l'autre vecteur les composantes
     * (<i>Q<sub>x</sub></i>, <i>Q<sub>y</sub></i>),
     * le vecteur renvoyé aura les composantes
     * (<i>P<sub>x</sub></i>&nbsp;+&nbsp;<i>Q<sub>x</sub></i>,&nbsp;
     * <i>P<sub>y</sub></i>&nbsp;+&nbsp;<i>Q<sub>y</sub></i>).
     *
     * @param autre le vecteur à ajouter
     * @return la somme des deux vecteurs
     */
    public Vecteur ajouter(Vecteur autre)
    {
        // TODO Objects#requireNonNull
        if (autre == null)
            throw new IllegalArgumentException("Autre vecteur nul.");
        return new Vecteur(x + autre.x, y + autre.y);
    }

    /**
     * Renvoie un nouveau vecteur qui est l'opposé de ce vecteur.
     * <p>
     * Si ce vecteur a les composantes
     * (<i>P<sub>x</sub></i>,&nbsp;<i>P<sub>y</sub></i>),
     * le vecteur renvoyé aura les composantes
     * (-<i>P<sub>x</sub></i>,&nbsp;-<i>P<sub>y</sub></i>).
     *
     * @return le vecteur opposé de ce vecteur
     */
    public Vecteur oppose()
    {
        return new Vecteur(-x, -y);
    }

    /**
     * Soustrait un vecteur à ce vecteur.  Renvoie un nouveau vecteur qui est la
     * différence entre ce vecteur et un autre vecteur spécifié.
     * <p>
     * Si ce vecteur a les composantes
     * (<i>P<sub>x</sub></i>,&nbsp;<i>P<sub>y</sub></i>)
     * et l'autre vecteur les composantes
     * (<i>Q<sub>x</sub></i>, <i>Q<sub>y</sub></i>),
     * le vecteur renvoyé aura les composantes
     * (<i>P<sub>x</sub></i>&nbsp;-&nbsp;<i>Q<sub>x</sub></i>,&nbsp;
     * <i>P<sub>y</sub></i>&nbsp;-&nbsp;<i>Q<sub>y</sub></i>).
     *
     * @param autre le vecteur à soustraire
     * @return la différence entre les deux vecteurs
     */
    public Vecteur soustraire(Vecteur autre)
    {
        // TODO Objects#requireNonNull
        if (autre == null)
            throw new IllegalArgumentException("Autre vecteur nul.");
        return ajouter(autre.oppose());
    }

    /**
     * Multiplie par un scalaire.  Calcule et renvoie la multiplication entre ce
     * vecteur et un facteur scalaire spécifié.
     * <p>
     * Si ce vecteur a les composantes
     * (<i>P<sub>x</sub></i>,&nbsp;<i>P<sub>y</sub></i>)
     * et le facteur scalaire est <i>&alpha;</i>
     * le vecteur renvoyé aura les composantes
     * (<i>&alpha;P<sub>x</sub></i>,&nbsp;<i>&alpha;P<sub>y</sub></i>).
     *
     * @param facteur le scalaire à multiplier au vecteur
     * @return ce vecteur multiplié par le scalaire facteur
     */
    public Vecteur multiplier(double facteur)
    {
        return new Vecteur(facteur * x, facteur * y);
    }

    /**
     * Calcule et renvoie la longueur ou norme de ce vecteur.
     * <p>
     * La norme d'un vecteur de composantes
     * (<i>P<sub>x</sub></i>,&nbsp;<i>P<sub>y</sub></i>)
     * est donné par la formule
     * &radic;(<i>P<sub>x</sub></i><sup>2</sup>&nbsp;+&nbsp;
     * <i>P<sub>y</sub></i><sup>2</sup>).
     *
     * @return la longueur de ce vecteur
     */
    public double longueur()
    {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Renvoie l'orientation de ce vecteur.
     *
     * @return l'angle que fait ce vecteur avec l'axe des abscisses
     * @see Angle#atan
     */
    public Angle orientation()
    {
        return Angle.atan(x, y);
    }

    /**
     * Renvoie une chaîne de caractères représentant la valeur de ce vecteur.
     *
     * @return une chaîne de la forme
     *         (<i>P<sub>x</sub></i>,&nbsp;<i>P<sub>y</sub></i>)
     */
    @Override
    public String toString()
    {
        return String.format("(%f, %f)", x, y);
    }
}
