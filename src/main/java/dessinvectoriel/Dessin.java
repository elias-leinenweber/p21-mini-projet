package dessinvectoriel;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * La classe {@code Dessin} étend la classe {@link Canvas} afin d'y
 * ajouter des métadonnées telles que l'auteur, le titre, la date de
 * création et les dimensions, ainsi qu'une collection de figures.
 *
 * @see Figure
 */
public class Dessin extends Canvas {
	private String			titre;
	private String			auteur;
	private LocalDate		dateCreation;
	private int			largeur;
	private int			hauteur;
	private final ArrayList<Figure>	figures;


	/**
	 * Construit un nouvel objet {@code Dessin}.
	 *
	 * @param titre le titre du dessin
	 * @param auteur l'auteur du dessin
	 * @param dateCreation la date de création du dessin
	 * @param largeur la largeur du dessin
	 * @param hauteur la hauteur du dessin
	 */
	public Dessin(String titre, String auteur, LocalDate dateCreation, int largeur, int hauteur)
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
	 * Construit un nouvel objet {@code Dessin} ayant la date du
	 * jour comme date de création.
	 *
	 * @param titre le titre du dessin
	 * @param auteur l'auteur du dessin
	 * @param largeur la largeur du dessin
	 * @param hauteur la hauteur du dessin
	 */
	public Dessin(String titre, String auteur, int largeur, int hauteur)
	{
		this(titre, auteur, LocalDate.now(), largeur, hauteur);
	}


	/**
	 * Retourne l'auteur du dessin.
	 *
	 * @return l'auteur du dessin
	 */
	public String getAuteur()
	{
		return auteur;
	}

	/**
	 * Remplace l'auteur du dessin.
	 *
	 * @param auteur le nouvel auteur
	 */
	public void setAuteur(String auteur)
	{
		if (auteur == null || auteur.isBlank())
			throw new IllegalArgumentException("Auteur nul ou vide.");
		this.auteur = auteur;
	}

	/**
	 * Retourne le titre du dessin.
	 *
	 * @return le titre du dessin
	 */
	public String getTitre()
	{
		return titre;
	}

	/**
	 * Remplace le titre du dessin.
	 *
	 * @param titre le nouveau titre
	 */
	public void setTitre(String titre)
	{
		if (titre == null || titre.isBlank())
			throw new IllegalArgumentException("Titre nul ou vide.");
		this.titre = titre;
	}

	/**
	 * Retourne la date de création du dessin.
	 *
	 * @return la date de création du dessin
	 */
	public LocalDate getDateCreation()
	{
		return dateCreation;
	}

	/**
	 * Remplace la date de création actuelle du dessin.
	 *
	 * @param dateCreation la nouvelle date de création
	 */
	public void setDateCreation(LocalDate dateCreation)
	{
		if (dateCreation == null || dateCreation.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("Date nulle ou invalide.");
		this.dateCreation = dateCreation;
	}

	/**
	 * Retourne la largeur du dessin.
	 *
	 * @return la largeur du dessin
	 */
	public int getLargeur()
	{
		return largeur;
	}

	/**
	 * Remplace la largeur actuelle du dessin.
	 *
	 * @param largeur la nouvelle largeur
	 */
	public void setLargeur(int largeur)
	{
		if (largeur < 0)
			throw new IllegalArgumentException("Largeur invalide.");
		this.largeur = largeur;
	}

	/**
	 * Retourne la hauteur du dessin.
	 *
	 * @return la hauteur du dessin
	 */
	public int getHauteur()
	{
		return hauteur;
	}

	/**
	 * Modifie la hauteur de ce dessin.
	 *
	 * @param hauteur un entier indiquant la hauteur à donner à ce dessin en nombre
	 *                de pixels
	 * @throws IllegalArgumentException si la nouvelle hauteur est négative
	 */
	public void setHauteur(int hauteur)
	{
		if (hauteur < 0)
			throw new IllegalArgumentException("Hauteur négative : " +
			    hauteur);
		this.hauteur = hauteur;
	}

	/**
	 * Ajoute une figure à ce dessin. La figure est placée à la fin de la liste des
	 * figures de ce dessin et sera dessinée après toutes celles qui la précèdent.
	 *
	 * @param f la figure à ajouter à ce dessin
	 */
	public void ajouterFigure(Figure f)
	{
		if (f == null)
			throw new IllegalArgumentException("Figure nulle.");
		figures.add(f);
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
	 * Renvoie une représentation sous forme de chaîne de caractères de ce dessin.
	 *
	 * @return une chaîne de caractères donnant toutes les informations concernant
	 *         ce dessin
	 */
	@Override
	public String toString()
	{
		return String.format("%s par %s (%s)", titre, auteur, dateCreation);
	}

	/**
	 * Dessine les figures de ce dessin sur le contexte graphique.  Les figures sont
	 * dessinées dans l'ordre dans lequel elles apparaissent dans la liste des
	 * figures.  Cette méthode est appelée automatiquement par Swing lorsque le
	 * dessin est placé dans une {@link javax.swing.JFrame}.
	 *
	 * @param g le contexte graphique sur lequel le dessin apparait
	 */
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2d;

		g2d = (Graphics2D)g;
		for (Figure f : figures)
			f.dessiner(g2d);
	}
}
