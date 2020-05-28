package dessinvectoriel;

import java.text.DecimalFormat;

/**
 * La classe non modifiable {@code Angle}.
 * <p>
 * Les angles peuvent être fabriqués avec des mesures exprimées en degrés et en
 * radians par l'intermédiaire des méthodes {@link #degres} et {@link #radians}.
 * Il est aussi possible de créer un angle par ajout d'une valeur en degrés ou
 * en radians à un angle existant avec {@link #ajouterDegres} et
 * {@link #ajouterRadians}.  L'opération {@link #ajouter} calcule la somme des
 * 2 angles.  Toutes ces opérations construisent un nouvel objet et ne modifient
 * pas l'objet courant.
 * <p>
 * Les fonctions trigonométriques {@link #sin}, {@link #cos} et {@link #atan}
 * sont déléguées aux fonctions correspondantes de {@link java.lang.Math}.
 */
public class Angle {

    /** l'angle nul 0° */
    public static final Angle NUL = Angle.degres(0);

    /** l'angle droit 90° */
    public static final Angle DROIT = Angle.degres(90);

    /** l'angle plat 180° */
    public static final Angle PLAT = Angle.degres(180);

    /** la mesure de l'angle en radians */
    private final double mesure;

    private Angle(double rad)
    {
        mesure = rad % (2 * Math.PI);
    }

    /**
     * Fabrique et renvoie un angle dont la mesure est donnée en degrés.
     *
     * @param deg la mesure de l'angle en degrés
     * @return l'angle fabriqué
     * @see java.lang.Math#toRadians
     */
    public static Angle degres(double deg)
    {
        return new Angle(Math.toRadians(deg));
    }

    /**
     * Fabrique et renvoie un angle dont la mesure est donnée en radians.
     *
     * @param rad la mesure de l'angle en radians
     * @return l'angle fabriqué
     */
    public static Angle radians(double rad)
    {
        return new Angle(rad);
    }

    /**
     * Renvoie l'angle de la coordonnée polaire pour un point spécifié.
     *
     * @param dX coordonnée cartésienne en <i>x</i> du point
     * @param dY coordonnée cartésienne en <i>y</i> du point
     * @return l'angle de la coordonnée polaire du point
     *         ({@code dX},&nbsp;{@code dY})
     * @see java.lang.Math#atan2
     */
    public static Angle atan(double dX, double dY)
    {
        return new Angle(Math.atan2(dY, dX));
    }

    /**
     * Renvoie la mesure de cet angle en degrés.
     *
     * @return la mesure en degrés de cet angle
     * @see java.lang.Math#toDegrees
     */
    public double getDegres()
    {
        return Math.toDegrees(mesure);
    }

    /**
     * Renvoie la mesure de cet angle en radians.
     *
     * @return la mesure en radians de cet angle
     */
    public double getRadians()
    {
        return mesure;
    }

    /**
     * Ajoute des degrés à la mesure de cet angle.
     *
     * @param deg les degrés à ajouter à la mesure de cet angle
     * @return un nouvel angle dont la mesure est celle de cet angle augmenté de
     *         {@code deg}
     */
    public Angle ajouterDegres(double deg)
    {
        return degres(getDegres() + deg);
    }

    /**
     * Ajoute des radians à la mesure de cet angle.
     *
     * @param rad les radians à ajouter à la mesure de cet angle
     * @return un nouvel angle dont la mesure est celle de cet angle augmenté de
     *         {@code rad}
     */
    public Angle ajouterRadians(double rad)
    {
        return radians(getRadians() + rad);
    }

    /**
     * Ajoute un angle à cet angle.  Construit et renvoie un angle dont la
     * mesure est la somme des mesures des 2 angles.
     *
     * @param theta l'angle à ajouter
     * @return un nouvel angle dont la mesure est la somme de la mesure de cet
     *         angle et de l'angle {@code theta} spécifié
     */
    public Angle ajouter(Angle theta)
    {
        return ajouterRadians(theta.mesure);
    }

    /**
     * Renvoie la valeur de la fonction trigonométrique sinus pour cet angle.
     *
     * @return le sinus de cet angle
     * @see java.lang.Math#sin
     */
    public double sin()
    {
        return Math.sin(mesure);
    }

    /**
     * Renvoie la valeur de la fonction trigonométrique cosinus pour cet angle.
     *
     * @return le cosinus de cet angle
     * @see java.lang.Math#cos
     */
    public double cos()
    {
        return Math.cos(mesure);
    }

    /**
     * Renvoie une chaîne qui contient la mesure en degrés de cet angle.
     *
     * @return une chaine de la forme {@code 37°} pour un angle de mesure
     *         37 degrés
     */
    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat();

        df.setMinimumFractionDigits(0);
        return df.format(getDegres()) + "°";
    }
}
