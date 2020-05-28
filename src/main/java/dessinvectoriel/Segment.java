package dessinvectoriel;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * La classe modifiable {@code Segment}.
 * <p>
 * Un objet de la classe {@code Segment} est une figure qui est un segment de
 * droite.  Les segments ont une origine, une extrémité et une longueur.
 */
public class Segment extends Figure {

    private double longueur;

    /**
     * Initialise un segment avec la position et la longueur spécifiée.
     * <p>
     * Les autres propriétés du segment sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position de l'origine du
     *                 segment
     * @param longueur la mesure de la longueur du segment
     * @throws IllegalArgumentException si la longueur donnée est négative
     */
    public Segment(Vecteur position, double longueur)
    {
        this(position, getOrientationParDefaut(), longueur);
    }

    /**
     * Initialise un segment avec la position et la longueur spécifiée.
     * <p>
     * Les autres propriétés du segment sont initialisées par défaut.
     *
     * @param origine un {@link Vecteur} indiquant la position de l'origine du
     *                segment
     * @param extremite un {@link Vecteur} indiquant la position de l'extrémité
     *                  du segment
     */
    public Segment(Vecteur origine, Vecteur extremite)
    {
        super(origine);
        final Vecteur directeur = extremite.soustraire(origine);
        setOrientation(directeur.orientation());
        longueur = directeur.longueur();
    }

    /**
     * Initialise un segment avec la position, l'orientation et la longueur
     * spécifiées.
     * <p>
     * Les autres propriétés du segment sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position de l'origine du
     *                 segment
     * @param orientation un {@link Angle} indiquant l'orientation du segment
     * @param longueur la mesure de la longueur du segment
     * @throws IllegalArgumentException si la longueur donnée est négative
     */
    public Segment(Vecteur position, Angle orientation, double longueur)
    {
        this(position, orientation, longueur, getCouleurTraitParDefaut(),
            getEpaisseurTraitParDefaut());
    }

    /**
     * Initialise un segment avec les paramètres spécifiés.
     *
     * @param position un {@link Vecteur} indiquant la position de l'origine du
     *                 segment
     * @param orientation un {@link Angle} indiquant l'orientation du segment
     * @param longueur la mesure de la longueur du segment
     * @param couleurTrait la couleur du trait
     * @param epaisseurTrait l'épaisseur du trait
     * @throws IllegalArgumentException si la longueur donnée est négative
     */
    public Segment(Vecteur position, Angle orientation, double longueur,
                   Color couleurTrait, int epaisseurTrait)
    {
        super(position, orientation, couleurTrait, epaisseurTrait);
        if (longueur < 0)
            throw new IllegalArgumentException("Longueur négative : " + longueur);
        this.longueur = longueur;
    }

    /**
     * Renvoie la position de l'origine de ce segment.
     *
     * @return un {@link Vecteur} indiquant l'origine de ce segment
     */
    public Vecteur getOrigine()
    {
        return getPosition();
    }

    /**
     * Renvoie la position de l'extrémité de ce segment.
     *
     * @return un {@link Vecteur} indiquant l'extrémité de ce segment
     */
    public Vecteur getExtremite()
    {
        return getOrigine().ajouter(new Vecteur(longueur, getOrientation()));
    }

    /**
     * Trace ce segment sur le contexte graphique spécifié.
     *
     * @param g le contexte graphique sur lequel le segment est tracé
     */
    @Override
    public void dessiner(Graphics2D g)
    {
        if (initTrait(g)) {
            final Vecteur origine = getOrigine();
            final Vecteur extremite = getExtremite();

            g.drawLine(
                (int)origine.getX(), (int)origine.getY(),
                (int)extremite.getX(), (int)extremite.getY()
            );
        }
    }

    /**
     * Redimensionne ce segment.
     * <p>
     * La longueur du segment est multipliée par le facteur spécifié.
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
    }

    /**
     * Renvoie une copie de ce segment.
     *
     * @return un segment de mêmes position, orientation, longueur, épaisseur de
     *         trait et couleur de trait
     */
    @Override
    public Segment copier()
    {
        return new Segment(getPosition(), getOrientation(), longueur,
            getCouleurTrait(), getEpaisseurTrait());
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de ce
     * segment.
     *
     * @return une chaîne de caractères indiquant position, orientation,
     *         longueur, épaisseur de trait et couleur de trait de cet segment
     */
    @Override
    public String toString()
    {
        return String.format(
            "Segment(position: %s, orientation: %s, longueur: %f," +
            "epaisseurTrait: %d, couleurTrait: %s)",
            getPosition(), getOrientation(), longueur, getEpaisseurTrait(),
            getCouleurTrait()
        );
    }
}
