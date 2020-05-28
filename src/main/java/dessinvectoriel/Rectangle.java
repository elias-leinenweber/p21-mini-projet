package dessinvectoriel;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * La classe modifiable {@code Rectangle}.
 * <p>
 * Une instance de {@code Rectangle} représente une surface qui est un
 * rectangle.  Le rectangle est déterminé par la position de son coin supérieur
 * gauche et la dimension des ses 2 côtés.
 */
public class Rectangle extends Surface {

    private double longueur;
    private double largeur;

    /**
     * Initialise un rectangle avec la position, la longueur et la largeur
     * spécifiées.
     * <p>
     * Les autres propriétés du rectangle sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position du coin
     *                 supérieur gauche du rectangle
     * @param longueur la mesure de la longueur du rectangle
     * @param largeur la mesure de la largeur du rectangle
     * @throws IllegalArgumentException si la longueur est inférieure à la
     *                                  largeur
     */
    public Rectangle(Vecteur position, double longueur, double largeur)
    {
        this(position, getOrientationParDefaut(), longueur, largeur);
    }

    /**
     * Initialise un rectangle avec la position, l'orientation, la longueur et
     * la largeur spécifiées.
     * <p>
     * Les autres propriétés du rectangle sont initialisés par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position du coin
     *                 supérieur gauche du rectangle
     * @param orientation un {@link Angle} indiquant l'orientation du rectangle
     * @param longueur la mesure de la longueur du rectangle
     * @param largeur la mesure de la largeur du rectangle
     * @throws IllegalArgumentException si la longueur est inférieure à la
     *                                  largeur
     */
    public Rectangle(Vecteur position, Angle orientation, double longueur,
                     double largeur)
    {
        this(position, orientation, longueur, largeur,
            getCouleurTraitParDefaut(), getEpaisseurTraitParDefaut(),
            getCouleurRemplissageParDefaut());
    }

    /**
     * Initialise un rectangle avec les paramètres spécifiés.
     *
     * @param position un {@link Vecteur} indiquant la position du coin
     *                 supérieur gauche du rectangle
     * @param orientation un {@link Angle} indiquant l'orientation du rectangle
     * @param longueur la mesure de la longueur du rectangle
     * @param largeur la mesure de la largeur du rectangle
     * @param couleurTrait la couleur du trait
     * @param epaisseurTrait l'épaisseur du trait
     * @param couleurRemplissage la couleur de remplissage du rectangle
     * @throws IllegalArgumentException si la longueur est inférieure à la
     *                                  largeur
     */
    public Rectangle(Vecteur position, Angle orientation, double longueur,
                     double largeur, Color couleurTrait, int epaisseurTrait,
                     Color couleurRemplissage)
    {
        super(position, orientation, couleurTrait, epaisseurTrait,
            couleurRemplissage);
        if (longueur < largeur)
            throw new IllegalArgumentException(
                "Longueur inférieure à largeur : " + longueur
            );
        this.longueur = longueur;
        this.largeur = largeur;
    }

    /**
     * Renvoie la surface de ce rectangle.
     * <p>
     * La surface <i>s</i> d'un rectangle de longueur <i>L</i> et de largeur
     * <i>l</i> est donné par la formule
     * <i>s</i>&nbsp;=&nbsp;<i>L</i>&sdot;<i>l</i>.
     *
     * @return la mesure de la surface de ce rectangle
     */
    @Override
    public double surface()
    {
        return longueur * largeur;
    }

    /**
     * Renvoie le périmètre de ce rectangle.
     * <p>
     * Le périmètre <i>p</i> d'un rectangle de longueur <i>L</i> et de largeur
     * <i>l</i> est donné par la formule
     * <i>p</i>&nbsp;=&nbsp;2(<i>L</i>&nbsp;+&nbsp;<i>l</i>).
     *
     * @return la mesure du périmètre de ce rectangle
     */
    @Override
    public double perimetre()
    {
        return 2 * (longueur + largeur);
    }

    /**
     * Renvoie la longueur de ce rectangle.
     *
     * @return la mesure de la longueur de ce rectangle
     */
    public double getLongueur()
    {
        return longueur;
    }

    /**
     * Renvoie la largeur de ce rectangle.
     *
     * @return la mesure de la largeur de ce rectangle
     */
    public double getLargeur()
    {
        return largeur;
    }
    
    /**
     * Renvoie les sommets de ce rectangle.
     *
     * @return un tableau de 4 vecteurs indiquant les 4 sommets de ce rectangle
     */
    public Vecteur[] getSommets()
    {
        Vecteur[] sommets;
        Vecteur coteLong, coteCourt;

        sommets = new Vecteur[4];
        coteLong = new Vecteur(longueur, getOrientation());
        coteCourt = new Vecteur(largeur, getOrientation().ajouter(Angle.DROIT));

        sommets[0] = getPosition();
        sommets[1] = sommets[0].ajouter(coteLong);
        sommets[2] = sommets[1].ajouter(coteCourt);
        sommets[3] = sommets[0].ajouter(coteCourt);
        return sommets;
    }

    /**
     * Trace ce rectangle sur le contexte graphique spécifié.
     *
     * @param g le contexte graphique sur lequel le rectangle est tracé
     */
    @Override
    public void dessiner(Graphics2D g)
    {
        final int nPoints = 4;
        final int[] xPoints = new int[nPoints];
        final int[] yPoints = new int[nPoints];
        final Vecteur[] sommets = getSommets();

        for (int i = 0; i < nPoints; ++i) {
            xPoints[i] = (int)sommets[i].getX();
            yPoints[i] = (int)sommets[i].getY();
        }
        if (initRemplissage(g))
            g.fillPolygon(xPoints, yPoints, nPoints);
        if (initTrait(g))
            g.drawPolygon(xPoints, yPoints, nPoints);
    }

    /**
     * Renvoie une copie de ce rectangle.
     *
     * @return un rectangle de mêmes position, orientation, longueur, largeur,
     *         épaisseur de trait, couleur de trait et couleur de remplissage
     */
    public Rectangle copier()
    {
        return new Rectangle(getPosition(), getOrientation(), longueur, largeur,
            getCouleurTrait(), getEpaisseurTrait(), getCouleurRemplissage());
    }

    /**
     * Redimensionne ce rectangle.
     * <p>
     * La longueur et la largeur du rectangle sont multipliées par le facteur
     * spécifié.
     *
     * @param facteur le facteur multiplicatif de redimensionnement
     * @throws IllegalArgumentException si le facteur est négatif
     */
    @Override
    public void redimensionner(double facteur)
    {
        if (facteur < 0)
            throw new IllegalArgumentException("Facteur négatif : " + facteur);
        longueur *= facteur;
        largeur *= facteur;
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de ce
     * rectangle.
     *
     * @return une chaîne de caractères indiquant position, orientation,
     *         longueur, largeur, épaisseur de trait, couleur de trait et
     *         couleur de remplissage de ce rectangle
     */
    @Override
    public String toString()
    {
        return String.format(
            "Rectangle(position: %s, orientation: %s, longueur: %f, " +
            "largeur: %f, epaisseurTrait: %d, couleurTrait: %s, " +
            "couleurRemplissage: %s)",
            getPosition(), getOrientation(), longueur, largeur,
            getEpaisseurTrait(), getCouleurTrait(), getCouleurRemplissage()
        );
    }
}
