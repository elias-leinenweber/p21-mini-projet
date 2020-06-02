package dessinvectoriel;

import java.awt.*;
import java.util.Objects;

/**
 * La classe abstraite modifiable {@code Figure}.
 * <p>
 * Les figures sont les éléments du dessin.  Chaque figure a une position, une
 * orientation et éventuellement des "dimensions".  Une figure peut être
 * déplacée, redimensionnée, copiée et dessinée.  Le tracé de la figure utilise
 * un trait dont l'épaisseur et la couleur peuvent être fixés.  L'épaisseur du
 * trait est un nombre de pixels.  Si ce nombre est négatif ou nul, le trait
 * n'est pas tracé.  La couleur du trait est donnée par un objet de la classe
 * {@link Color}.
 */
public abstract class Figure {

    private static Angle orientationParDefaut  = Angle.NUL;
    private static Color couleurTraitParDefaut = Color.BLACK;
    private static int epaisseurTraitParDefaut = 1;

    private Vecteur position;
    private Angle orientation;
    private Color couleurTrait;
    private int epaisseurTrait;

    /**
     * Initialise une figure avec la position spécifiée.
     * <p>
     * Les autres propriétés de la figure sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position de la figure
     */
    public Figure(Vecteur position)
    {
        this(position, orientationParDefaut);
    }

    /**
     * Initialise une figure avec la position et l'orientation spécifiées.
     * <p>
     * Les autres propriétés de la figure sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position de la figure
     * @param orientation un {@link Angle} indiquant l'orientation de la figure
     */
    public Figure(Vecteur position, Angle orientation)
    {
        this(position, orientation, couleurTraitParDefaut, epaisseurTraitParDefaut);
    }

    /**
     * Initialise une figure avec les paramètres spécifiés.
     *
     * @param position un {@link Vecteur} indiquant la position de la figure
     * @param orientation un {@link Angle} indiquant l'orientation de la figure
     * @param couleur un objet {@link Color} indiquant la couleur du trait
     * @param epaisseurTrait un entier indiquant l'épaisseur du trait en nombre
     *                       de pixels
     */
    public Figure(Vecteur position, Angle orientation, Color couleur,
                  int epaisseurTrait)
    {
        setPosition(position);
        setOrientation(orientation);
        setCouleurTrait(couleur);
        setEpaisseurTrait(epaisseurTrait);
    }

    /**
     * Renvoie l'orientation par défaut.
     * <p>
     * L'orientation par défaut est utilisée lorsqu'une figure est créée sans
     * préciser une valeur d'orientation.  Initialement sa valeur est
     * {@link Angle#NUL}.
     *
     * @return l'{@link Angle} utilisé comme orientation par défaut
     */
    public static Angle getOrientationParDefaut()
    {
        return orientationParDefaut;
    }

    /**
     * Modifie l'orientation par défaut.
     * <p>
     * L'orientation par défaut est utilisée lorsqu'une figure est créée sans
     * préciser une valeur d'orientation.  Initialement sa valeur est
     * {@link Angle#NUL}.
     *
     * @param orientationParDefaut un {@link Angle} indiquant la nouvelle
     *                             orientation par défaut
     */
    public static void setOrientationParDefaut(Angle orientationParDefaut)
    {
        Figure.orientationParDefaut = Objects.requireNonNull(orientationParDefaut);
    }

    /**
     * Renvoie la couleur du trait par défaut.
     * <p>
     * La couleur du trait par défaut est utilisée lorsqu'une figure est créée
     * sans préciser une valeur de couleur de trait.  Initialement sa valeur est
     * {@link Color#BLACK}.
     *
     * @return un objet {@link Color} indiquant la couleur utilisée par défaut
     *         pour tracer le trait d'une figure
     */
    public static Color getCouleurTraitParDefaut()
    {
        return couleurTraitParDefaut;
    }

    /**
     * Modifie la couleur du trait par défaut.
     * <p>
     * La couleur du trait par défaut est utilisée lorsqu'une figure est créée
     * sans préciser une valeur de couleur de trait.  Initialement sa valeur est
     * {@link Color#BLACK}.
     *
     * @param couleurTraitParDefaut un objet {@link Color} qui détermine la
     *                              nouvelle couleur à utiliser par défaut pour
     *                              tracer le trait d'une figure
     */
    public static void setCouleurTraitParDefaut(Color couleurTraitParDefaut)
    {
        Figure.couleurTraitParDefaut = Objects.requireNonNull(couleurTraitParDefaut);
    }

    /**
     * Renvoie l'épaisseur du trait par défaut.
     * <p>
     * L'épaisseur du trait par défaut est utilisée lorsqu'une figure est créée
     * sans préciser une valeur d'épaisseur de trait.  Initialement sa valeur
     * est de 1 pixel.
     *
     * @return le nombre de pixels utilisés par défaut pour tracer le trait de
     *         contour d'une figure
     */
    public static int getEpaisseurTraitParDefaut()
    {
        return epaisseurTraitParDefaut;
    }

    /**
     * Modifie l'épaisseur du trait par défaut.
     * <p>
     * L'épaisseur du trait par défaut est utilisée lorsqu'une figure est créée
     * sans préciser une valeur d'épaisseur de trait.  Initialement sa valeur
     * est de 1 pixel.
     *
     * @param epaisseurTraitParDefaut le nombre de pixels à utiliser par défaut
     *                                pour tracer le trait de contour d'une
     *                                figure
     */
    public static void setEpaisseurTraitParDefaut(int epaisseurTraitParDefaut)
    {
        Figure.epaisseurTraitParDefaut = epaisseurTraitParDefaut;
    }

    /**
     * Renvoie la position de cette figure.
     *
     * @return un {@link Vecteur} indiquant la position de cette figure
     */
    public Vecteur getPosition()
    {
        return position;
    }

    /**
     * Modifie la position de cette figure.
     *
     * @param position un {@link Vecteur} indiquant la nouvelle position de
     *                 cette figure
     */
    public void setPosition(Vecteur position)
    {
        this.position = Objects.requireNonNull(position);
    }

    /**
     * Renvoie l'orientation de cette figure.
     *
     * @return un {@link Angle} indiquant l'orientation de cette figure
     */
    public Angle getOrientation()
    {
        return orientation;
    }

    /**
     * Modifie l'orientation de cette figure.
     *
     * @param orientation un {@link Angle} indiquant la nouvelle orientation de
     *                    cette figure
     */
    public void setOrientation(Angle orientation)
    {
        this.orientation = Objects.requireNonNull(orientation);
    }

    /**
     * Renvoie la couleur du trait de cette figure.
     *
     * @return la couleur utilisée pour tracer le trait entourant cette figure
     */
    public Color getCouleurTrait()
    {
        return couleurTrait;
    }

    /**
     * Modifie la couleur du trait pour cette figure.
     *
     * @param couleur la nouvelle couleur à utiliser pour tracer le trait
     *                entourant cette figure
     */
    public void setCouleurTrait(Color couleur)
    {
        couleurTrait = couleur;
    }

    /**
     * Renvoie l'épaisseur du trait pour cette figure.
     *
     * @return le nombre de pixels utilisés pour tracer le trait entourant cette
     *         figure
     */
    public int getEpaisseurTrait()
    {
        return epaisseurTrait;
    }

    /**
     * Modifie l'épaisseur du trait pour cette figure.  Si l'épaisseur du trait
     * est négative ou nulle, aucun trait ne sera tracé.
     *
     * @param epaisseurTrait le nombre de pixels à utiliser pour tracer le trait
     *                       entourant cette figure
     */
    public void setEpaisseurTrait(int epaisseurTrait)
    {
        this.epaisseurTrait = epaisseurTrait;
    }

    /**
     * Trace cette figure sur le contexte graphique spécifié.
     *
     * @param g le contexte graphique sur lequel la figure est tracé
     */
    public abstract void dessiner(Graphics2D g);

    /**
     * Renvoie une copie de cette figure.
     *
     * @return une figure de mêmes position, orientation, dimension(s),
     *         épaisseur de trait et couleur de trait
     */
    public abstract Figure copier();

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de cette
     * figure.
     *
     * @return une chaîne de caractères indiquant position, orientation,
     *         dimension(s), épaisseur de trait et couleur de trait de cette
     *         figure
     */
    @Override
    public abstract String toString();

    /**
     * Déplace cette figure en la translatant.
     *
     * @param deltaX le déplacement à effectuer sur l'axe des abscisses
     * @param deltaY le déplacement à effectuer sur l'axe des ordonnées
     */
    public void deplacer(double deltaX, double deltaY)
    {
        if (deltaX != 0 || deltaY != 0)
            position = position.ajouter(new Vecteur(deltaX, deltaY));
    }

    /**
     * Tourne cette figure d'un angle donné.
     * <p>
     * La rotation de la figure se fait autour du point déterminant sa position.
     * L'angle spécifié est ajouté à l'orientation de la figure.  La position de
     * la figure reste identique.
     *
     * @param angle la mesure en degrés de l'angle indiquant la rotation à
     *              effectuer
     */
    public void tourner(double angle)
    {
        orientation = orientation.ajouterDegres(angle);
    }

    /**
     * Tourne cette figure d'un angle donné autour d'un point spécifié.
     *
     * @param centre un {@link Vecteur} indiquant les coordonnées du point
     *               autour duquel il faut effectuer la rotation
     * @param angle un {@link Angle} indiquant la mesure de la rotation à
     *              effectuer
     */
    public void tournerAutour(Vecteur centre, Angle angle)
    {
        final Vecteur translation = position.soustraire(centre);

        tourner(angle.getDegres());
        position = centre.ajouter(new Vecteur(
            translation.longueur(),
            translation.orientation().ajouter(angle)
        ));
    }

    /**
     * Redimensionne cette figure par le facteur spécifié.
     * <p>
     * Toutes les dimensions de cette figure sont multipliées par ce facteur.
     *
     * @param facteur le facteur multiplicatif de redimensionnement
     */
    public abstract void redimensionner(double facteur);

    /**
     * Initialise le traçage du trait.
     * <p>
     * Met éventuellement en place l'épaisseur et la couleur de trait dans le
     * contexte graphique.
     *
     * @param g le contexte graphique sur lequel la figure est tracée
     * @return la valeur booléenne {@code true} s'il faut tracer le trait (si
     *         l'épaisseur du trait est positive) ; {@code false} sinon
     * @see Graphics2D#setPaint
     * @see Graphics2D#setStroke
     */
    protected boolean initTrait(Graphics2D g)
    {
        final boolean init = couleurTrait != null && epaisseurTrait > 0;

        if (init) {
            g.setPaint(couleurTrait);
            g.setStroke(new BasicStroke(epaisseurTrait));
        }
        return init;
    }
}
