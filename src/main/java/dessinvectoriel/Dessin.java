package dessinvectoriel;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La classe {@code Dessin} étend la classe {@link Canvas} afin d'y
 * ajouter des métadonnées telles que l'auteur, le titre, la date de
 * création et les dimensions, ainsi qu'une collection de figures.
 *
 * @see Figure
 */
public class Dessin extends Canvas {
	private final ArrayList<Figure> figures;
	private String auteur, titre;
	private LocalDate dateCreation;
	private int largeur, hauteur;


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
	 * Ajoute une {@link Figure} à la liste des figures du dessin.
	 *
	 * @param f la {@link Figure} à ajouter
	 */
	public void ajouterFigure(Figure f)
	{
		if (f == null)
			throw new IllegalArgumentException("Figure nulle.");
		figures.add(f);
	}

	/**
	 * Retourne un tableau contenant toutes les figures du dessin.
	 *
	 * @return la liste des figures
	 * @since 11
	 */
	public Figure[] listerFigures()
	{
		// ATTENTION Syntaxe compatible uniquement avec Java 11 et plus.
		return figures.toArray(Figure[]::new);
	}

	/**
	 * Retourne une chaîne de caractères contenant l'ensemble des
	 * attributs du dessin.
	 *
	 * @return une représentation en chaîne du dessin
	 */
	@Override
	public String toString()
	{
		return "Auteur : " + auteur + "\n" +
		       "Titre : " + titre + "\n" +
		       "Date de création : " + dateCreation + "\n" +
		       "Dimensions : " + largeur + "x" + hauteur + "\n" +
		       "Figures : " + figures;
	}

	/**
	 * Peint le dessin en appelant la méthode {@link Figure#dessiner}
	 * sur chaque figure du dessin.
	 *
	 * @param g le contexte {@link Graphics} spécifié
	 */
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2d;

		if (g == null)
			throw new IllegalArgumentException("Contexte nul.");
		g2d = (Graphics2D)g;
		for (Figure f : figures)
			f.dessiner(g2d);
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
	 * Remplace la hauteur actuelle du dessin.
	 *
	 * @param hauteur la nouvelle hauteur
	 */
	public void setHauteur(int hauteur)
	{
		if (hauteur < 0)
			throw new IllegalArgumentException("Hauteur invalide.");
		this.hauteur = hauteur;
	}
}
