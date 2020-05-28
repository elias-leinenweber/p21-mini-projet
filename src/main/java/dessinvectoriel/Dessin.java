package dessinvectoriel;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * La classe modifiable {@code Dessin}.
 * <p>
 * Une instance de la classe {@code Dessin} correspond à une feuille de dessin.
 * Les dimensions de la feuille (largeur et hauteur) sont données en nombre de
 * pixels.  Un dessin est composé de figures.  On peut donner un titre à un
 * dessin et mémoriser sa date de création et son auteur.
 */
public class Dessin extends Canvas {

    private final ArrayList<Figure> figures;

    private String titre;
    private String auteur;
    private LocalDate dateCreation;
    private int largeur;
    private int hauteur;

    /**
     * Initialise ce nouveau dessin avec les paramètres spécifiés.
     *
     * @param titre une chaîne indiquant le titre de ce dessin
     * @param auteur une chaîne indiquant l'auteur de ce dessin
     * @param dateCreation un objet {@link LocalDate} indiquant la date de
     *                     création de ce dessin
     * @param largeur un entier indiquant la largeur de ce dessin en nombre de
     *                pixels
     * @param hauteur un entier indiquant la hauteur de ce dessin en nombre de
     *                pixels
     * @throws IllegalArgumentException si la hauteur ou la largeur est négative
     */
    public Dessin(String titre, String auteur, LocalDate dateCreation,
                  int largeur, int hauteur)
    {
        setSize(largeur, hauteur);
        figures = new ArrayList<>();
        setTitre(titre);
        setAuteur(auteur);
        setDateCreation(dateCreation);
        setLargeur(largeur);
        setHauteur(hauteur);
    }

    /**
     * Initialise ce nouveau dessin avec les paramètres spécifiés et une date de
     * création qui est la date du jour.
     *
     * @param titre une chaîne indiquant le titre de ce dessin
     * @param auteur une chaîne indiquant l'auteur de ce dessin
     * @param largeur un entier indiquant la largeur de ce dessin en nombre de
     *                pixels
     * @param hauteur un entier indiquant la hauteur de ce dessin en nombre de
     *                pixels
     * @throws IllegalArgumentException si la hauteur ou la largeur est négative
     */
    public Dessin(String titre, String auteur, int largeur, int hauteur)
    {
        this(titre, auteur, LocalDate.now(), largeur, hauteur);
    }

    /**
     * Retourne le nom de l'auteur de ce dessin.
     *
     * @return une chaîne contenant l'auteur de ce dessin
     */
    public String getAuteur()
    {
        return auteur;
    }

    /**
     * Modifie le nom de l'auteur du dessin.
     *
     * @param auteur une chaîne indiquant le nom à donner pour l'auteur de ce
     *               dessin
     * @throws IllegalArgumentException si le nom de l'auteur est vide
     */
    public void setAuteur(String auteur)
    {
        if (Objects.requireNonNull(auteur).isBlank())
            throw new IllegalArgumentException("Nom de l'auteur vide");
        this.auteur = auteur;
    }

    /**
     * Renvoie le titre de ce dessin.
     *
     * @return une chaîne contenant le titre de ce dessin
     */
    public String getTitre()
    {
        return titre;
    }

    /**
     * Modifie le titre de ce dessin.
     *
     * @param titre une chaîne indiquant le titre à donner au dessin
     * @throws IllegalArgumentException si le titre est vide
     */
    public void setTitre(String titre)
    {
        if (Objects.requireNonNull(titre).isBlank())
            throw new IllegalArgumentException("Titre vide");
        this.titre = titre;
    }

    /**
     * Renvoie la date de création de ce dessin.
     *
     * @return un objet de la classe {@link LocalDate} indiquant la date de
     *         création de ce dessin
     */
    public LocalDate getDateCreation()
    {
        return dateCreation;
    }

    /**
     * Modifie la date de création de ce dessin.
     *
     * @param dateCreation un objet de la classe {@link LocalDate} indiquant la
     *                     date de création à donner à ce dessin
     * @throws IllegalArgumentException si la date de création est postérieure à
     *                                  la date du jour
     */
    public void setDateCreation(LocalDate dateCreation)
    {
        if (Objects.requireNonNull(dateCreation).isAfter(LocalDate.now()))
            throw new IllegalArgumentException(
                "Date de création postérieure à la date du jour : " +
                dateCreation
            );
        this.dateCreation = dateCreation;
    }

    /**
     * Renvoie la largeur de ce dessin
     *
     * @return un entier indiquant la largeur de ce dessin en nombre de pixels
     */
    public int getLargeur()
    {
        return largeur;
    }

    /**
     * Modifie la largeur de ce dessin.
     *
     * @param largeur un entier indiquant la largeur à donner à ce dessin en
     *                nombre de pixels
     * @throws IllegalArgumentException si la nouvelle largeur est négative
     */
    public void setLargeur(int largeur)
    {
        if (largeur < 0)
            throw new IllegalArgumentException("Largeur négative : " + largeur);
        this.largeur = largeur;
    }

    /**
     * Renvoie la hauteur de ce dessin.
     *
     * @return un entier indiquant la hauteur de ce dessin en nombre de pixels
     */
    public int getHauteur()
    {
        return hauteur;
    }

    /**
     * Modifie la hauteur de ce dessin.
     *
     * @param hauteur un entier indiquant la hauteur à donner à ce dessin en
     *                nombre de pixels
     * @throws IllegalArgumentException si la nouvelle hauteur est négative
     */
    public void setHauteur(int hauteur)
    {
        if (hauteur < 0)
            throw new IllegalArgumentException("Hauteur négative : " + hauteur);
        this.hauteur = hauteur;
    }

    /**
     * Ajoute une figure à ce dessin.  La figure est placée à la fin de la liste
     * des figures de ce dessin et sera dessinée après toutes celles qui la
     * précèdent.
     *
     * @param f la figure à ajouter à ce dessin
     */
    public void ajouterFigure(Figure f)
    {
        figures.add(Objects.requireNonNull(f));
    }

    /**
     * Renvoie la liste des figures de ce dessin.
     *
     * @return la suite des figures de ce dessin dans l'ordre de leur affichage
     */
    public Collection<Figure> listerFigures()
    {
        return new ArrayList<>(figures);
    }

    /**
     * Dessine les figures de ce dessin sur le contexte graphique.  Les figures
     * sont dessinées dans l'ordre dans lequel elles apparaissent dans la liste
     * des figures.  Cette méthode est appelée automatiquement par Swing lorsque
     * le dessin est placé dans une {@link javax.swing.JFrame}.
     *
     * @param g le contexte graphique sur lequel le dessin apparait
     */
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;

        for (Figure f : figures)
            f.dessiner(g2d);
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de ce
     * dessin.
     *
     * @return une chaîne de caractères donnant toutes les informations
     *         concernant ce dessin
     */
    @Override
    public String toString()
    {
        return String.format("%s par %s (%s)", titre, auteur, dateCreation);
    }
}
