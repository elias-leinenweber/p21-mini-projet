package dessinvectoriel;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * La classe modifiable {@code Point}.
 * <p>
 * Un objet de la classe {@code Point} est une figure qui se limite à un simple
 * point.
 */
public class Point extends Figure {

    /**
     * Initialise un point avec la position spécifiée.
     * <p>
     * Les autres propriétés du point sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position du point
     */
    public Point(Vecteur position)
    {
        super(position);
    }

    /**
     * Initialise un point avec la position, la couleur et l'épaisseur de trait
     * spécifiés.
     *
     * @param position un {@link Vecteur} indiquant la position de la figure
     * @param couleur un objet {@link Color} indiquant la couleur du trait
     * @param epaisseurTrait un entier indiquant l'épaisseur du trait en nombre
     *                       de pixels
     */
    public Point(Vecteur position, Color couleur, int epaisseurTrait)
    {
        super(position);
        setCouleurTrait(couleur);
        setEpaisseurTrait(epaisseurTrait);
    }

    /**
     * Initialise un point avec les coordonnées cartésiennes spécifiées.
     * <p>
     * Les autres propriétés du point sont initialisées par défaut.
     *
     * @param x la coordonnée x de la position du point
     * @param y la coordonnée y de la position du point
     */
    public Point(int x, int y)
    {
        super(new Vecteur(x, y));
    }

    /**
     * Trace ce point sur le contexte graphique spécifié.
     *
     * @param g le contexte graphique sur lequel le point est tracé
     */
    @Override
    public void dessiner(Graphics2D g)
    {
        int diametre, rayon, x, y;

        diametre = getEpaisseurTrait();
        rayon = diametre / 2;
        x = (int)getPosition().getX();
        y = (int)getPosition().getY();

        if (initTrait(g))
            g.fillOval(x - rayon, y - rayon, diametre, diametre);
    }

    /**
     * Redimensionne ce point par le facteur spécifié.
     * <p>
     * Cette opération n'a aucun effet sur le point.
     *
     * @param facteur le facteur multiplicatif de redimensionnement
     */
    @Override
    public void redimensionner(double facteur)
    {}

    /**
     * Renvoie une copie de ce point.
     *
     * @return un point de mêmes position, épaisseur de trait et couleur de
     *         trait
     */
    @Override
    public Point copier()
    {
        return new Point(getPosition(), getCouleurTrait(), getEpaisseurTrait());
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de ce
     * point.
     *
     * @return une chaîne de caractères indiquant position, épaisseur de trait
     *         et couleur de trait de ce point
     */
    @Override
    public String toString()
    {
        return String.format(
            "Point(position: %s, epaisseurTrait: %d, couleurTrait: %s)",
            getPosition(), getEpaisseurTrait(), getCouleurTrait()
        );
    }
}
