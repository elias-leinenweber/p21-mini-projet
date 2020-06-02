package dessinvectoriel;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * La classe abstraite modifiable {@code Surface}.
 * <p>
 * Les surfaces sont des figures qui peuvent être remplies avec des couleurs.
 * Les surfaces ont une aire (ou surface) et un périmètre.
 */
public abstract class Surface extends Figure {

    private static Color couleurRemplissageParDefaut = null;

    private Color couleurRemplissage;

    /**
     * Initialise une surface avec la position spécifiée.
     * <p>
     * Les autres propriétés de la surface sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position de la surface
     */
    public Surface(Vecteur position)
    {
        super(position);
        couleurRemplissage = couleurRemplissageParDefaut;
    }

    /**
     * Initialise une surface avec la position et l'orientation spécifiées.
     * <p>
     * Les autres propriétés de la surface sont initialisées par défaut.
     *
     * @param position un {@link Vecteur} indiquant la position de la
     *                 surface
     * @param orientation un {@link Angle} indiquant l'orientation de la
     *                    surface
     */
    public Surface(Vecteur position, Angle orientation)
    {
        super(position, orientation);
        couleurRemplissage = couleurRemplissageParDefaut;
    }

    /**
     * Initialise une surface avec les paramètres spécifiés.
     *
     * @param position un {@link Vecteur} indiquant la position de la surface
     * @param orientation un {@link Angle} indiquant l'orientation de la surface
     * @param couleurTrait un objet {@link Color} indiquant la couleur du trait
     * @param epaisseurTrait un entier indiquant l'épaisseur du trait en nombre
     *                       de pixels
     * @param couleurRemplissage un objet {@link Color} indiquant la couleur de
     *                           remplissage
     */
    public Surface(Vecteur position, Angle orientation, Color couleurTrait,
                   int epaisseurTrait, Color couleurRemplissage)
    {
        super(position, orientation, couleurTrait, epaisseurTrait);
        this.couleurRemplissage = couleurRemplissage;
    }

    /**
     * Renvoie la couleur de remplissage par défaut.
     * <p>
     * La couleur de remplissage par défaut est utilisée lorsqu'une surface est
     * créée sans préciser une valeur de couleur de remplissage.  Initialement,
     * la couleur de remplissage par défaut est la référence {@code null} et par
     * défaut les surfaces ne sont pas remplies et sont donc transparentes.
     *
     * @return un objet {@link Color} qui indique la couleur utilisée par défaut
     *         pour remplir une surface
     */
    public static Color getCouleurRemplissageParDefaut()
    {
        return couleurRemplissageParDefaut;
    }

    /**
     * Modifie la couleur de remplissage par défaut.
     * <p>
     * La couleur de remplissage par défaut est utilisée lorsqu'une surface est
     * créée sans préciser une valeur de couleur de remplissage.  Initialement,
     * la couleur de remplissage par défaut est la référence {@code null} et par
     * défaut les surfaces ne sont pas remplies et sont donc transparentes.
     *
     * @param couleurRemplissageParDefaut un objet {@link Color} qui indique la
     *                                    nouvelle couleur à utiliser par défaut
     *                                    pour remplir une surface
     */
    public static void setCouleurRemplissageParDefaut(Color couleurRemplissageParDefaut)
    {
        Surface.couleurRemplissageParDefaut = couleurRemplissageParDefaut;
    }

    /**
     * Renvoie la couleur de remplissage de cette surface.
     * <p>
     * Si la couleur renvoyée est la référence {@code null}, la surface n'est
     * pas remplie et reste transparente.
     *
     * @return un objet {@link Color} indiquant la couleur de remplissage ou la
     *         référence {@code null} si la surface est transparente
     */
    public Color getCouleurRemplissage()
    {
        return couleurRemplissage;
    }

    /**
     * Modifie la couleur de remplissage de cette surface.
     * <p>
     * Si la couleur spécifiée est la référence {@code null}, la surface n'est
     * pas remplie et reste transparente.
     *
     * @param couleurRemplissage un objet {@link Color} indiquant la nouvelle
     *                           couleur de remplissage ou la référence
     *                           {@code null} s'il ne faut pas remplir la
     *                           surface
     */
    public void setCouleurRemplissage(Color couleurRemplissage)
    {
        this.couleurRemplissage = couleurRemplissage;
    }

    /**
     * Renvoie la surface ou l'aire de cette surface.
     *
     * @return un réel ayant pour valeur l'aire de cette surface
     */
    public abstract double surface();

    /**
     * Renvoie le périmètre de cette surface
     *
     * @return un réel ayant pour valeur le périmètre de la surface
     */
    public abstract double perimetre();

    /**
     * Initialise le remplissage de la surface.  Met éventuellement en place la
     * couleur de remplissage dans le contexte graphique.
     *
     * @param g le contexte graphique sur lequel la surface est tracée
     * @return la valeur booléenne {@code true} s'il faut remplir la surface (si
     *         la couleur de remplissage n'est pas la référence {@code null}) ;
     *         {@code false} sinon
     * @see Graphics2D#setPaint
     */
    protected boolean initRemplissage(Graphics2D g)
    {
        final boolean init = couleurRemplissage != null;

        if (init)
            g.setPaint(couleurRemplissage);
        return init;
    }
}
