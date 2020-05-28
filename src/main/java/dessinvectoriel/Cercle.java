package dessinvectoriel;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * La classe modifiable {@code Cercle}.
 * <p>
 * Une instance de {@code Cercle} représente une surface qui est un cercle.  Un
 * cercle est déterminé par la position de son centre et la mesure de son rayon.
 */
public class Cercle extends Surface {

    private double rayon;

    /**
     * Initialise un cercle avec la position et le rayon spécifié.
     * <p>
     * Les autres propriétés du cercle sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position du centre du
     *                 cercle
     * @param rayon la mesure du rayon du cercle
     * @throws IllegalArgumentException si le rayon donné est négatif
     */
    public Cercle(Vecteur position, double rayon)
    {
        this(position, rayon, getCouleurTraitParDefaut(),
            getEpaisseurTraitParDefaut(), getCouleurRemplissageParDefaut());
    }

    /**
     * Initialise un cercle avec les paramètres spécifiés.
     *
     * @param position un {@link Vecteur} indiquant la position du centre du
     *                 cercle
     * @param rayon la mesure du rayon du cercle
     * @param couleurTrait la couleur du trait
     * @param epaisseurTrait l'épaisseur du trait
     * @param couleurRemplissage la couleur de remplissage du cercle
     * @throws IllegalArgumentException si le rayon donné est négatif
     */
    public Cercle(Vecteur position, double rayon, Color couleurTrait,
                  int epaisseurTrait, Color couleurRemplissage)
    {
        super(position, getOrientationParDefaut(), couleurTrait, epaisseurTrait,
            couleurRemplissage);
        if (rayon < 0)
            throw new IllegalArgumentException("Rayon négatif : " + rayon);
        this.rayon = rayon;
    }

    /**
     * Renvoie la position du centre de ce cercle.
     *
     * @return un {@link Vecteur} indiquant la position du centre de ce cercle
     */
    public Vecteur getCentre()
    {
        return getPosition();
    }

    /**
     * Renvoie le rayon de ce cercle
     *
     * @return la mesure du rayon de ce cercle
     */
    public double getRayon()
    {
        return rayon;
    }

    /**
     * Renvoie le diamètre de ce cercle.
     * <p>
     * Le diamètre <i>d</i> d'un cercle de rayon <i>r</i> est donné par la
     * formule <i>d</i>&nbsp;=&nbsp;2<i>r</i>.
     *
     * @return la mesure du diamètre de ce cercle
     */
    public double getDiametre()
    {
        return 2 * rayon;
    }

    /**
     * Renvoie la surface de ce cercle.
     * <p>
     * La surface <i>s</i> d'un cercle de rayon <i>r</i> est donnée par la
     * formule <i>s</i> = <i>&pi;r</i><sup>2</sup>.
     *
     * @return la mesure de la surface de ce cercle
     */
    @Override
    public double surface()
    {
        return Math.PI * (rayon * rayon);
    }

    /**
     * Renvoie le périmètre de ce cercle.
     * <p>
     * La circonférence <i>p</p> d'un cercle de diamètre <i>d</i> est donnée par
     * la formule <i>p</i> = <i>&pi;d</i>.
     *
     * @return la mesure de la circonférence de ce cercle
     */
    @Override
    public double perimetre()
    {
        return Math.PI * getDiametre();
    }

    /**
     * Redimensionne ce cercle.
     * <p>
     * Le rayon du cercle est multiplié par le facteur spécifié.
     *
     * @param facteur le facteur multiplicatif de redimensionnement
     * @throws IllegalArgumentException si le facteur est négatif
     */
    @Override
    public void redimensionner(double facteur)
    {
        if (facteur < 0)
            throw new IllegalArgumentException("Facteur négatif : " + facteur);
        rayon *= facteur;
    }

    /**
     * Trace ce cercle sur le contexte graphique spécifié.
     *
     * @param g le contexte graphique sur lequel le cercle est tracé
     */
    @Override
    public void dessiner(Graphics2D g)
    {
        final int x = (int)(getPosition().getX() - rayon);
        final int y = (int)(getPosition().getY() - rayon);
        final int diametre = (int)getDiametre();

        if (initRemplissage(g))
            g.fillOval(x, y, diametre, diametre);
        if (initTrait(g))
            g.drawOval(x, y, diametre, diametre);
    }

    /**
     * Renvoie une copie de ce cercle.
     *
     * @return un cercle de mêmes position, rayon, épaisseur de trait, couleur
     *         de trait et couleur de remplissage
     */
    @Override
    public Cercle copier()
    {
        return new Cercle(getPosition(), rayon, getCouleurTrait(),
            getEpaisseurTrait(), getCouleurRemplissage());
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de ce
     * cercle.
     *
     * @return une chaîne de caractères indiquant position, rayon, épaisseur de
     *         trait, couleur de trait et couleur de remplissage de ce cercle
     */
    @Override
    public String toString()
    {
        return String.format(
            "Cercle(position: %s, rayon: %f, epaisseurTrait: %d, " +
            "couleurTrait: %s, couleurRemplissage: %s)",
            getPosition(), rayon, getEpaisseurTrait(), getCouleurTrait(),
            getCouleurRemplissage()
        );
    }
}
