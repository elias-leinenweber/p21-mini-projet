package dessinvectoriel;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La classe {@code Dessin} étend la classe {@link Canvas} afin d'y
 * ajouter des métadonnées telles que l'auteur, le titre, la date de
 * création et les dimensions, ainsi qu'une collection de
 * {@link Figure}.
 */
public class Dessin extends Canvas {
	private final ArrayList<Figure> figures;
	private String auteur;
	private String titre;
	private LocalDate dateCreation;
	private int largeur;
	private int hauteur;


	/**
	 * Construit un nouvel objet {@code Dessin}.
	 *
	 * @param titre le titre du dessin
	 * @param auteur l'auteur du dessin
	 * @param dateCreation la date de création
	 * @param largeur la largeur du dessin
	 * @param hauteur la hauteur du dessin
	 */
	public Dessin(String titre, String auteur, LocalDate dateCreation, int largeur, int hauteur)
	{
		figures = new ArrayList<>();
		this.titre = titre;
		this.auteur = auteur;
		this.dateCreation = dateCreation;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	/**
	 *
	 * @param titre
	 * @param auteur
	 * @param largeur
	 * @param hauteur
	 */
	public Dessin(String titre, String auteur, int largeur, int hauteur)
	{
		this(titre, auteur, LocalDate.now(), largeur, hauteur);
	}


	/**
	 * Ajoute une {@link Figure} à la liste des figures du {@code Dessin}.
	 * @param f la {@link Figure} à ajouter.
	 */
	public void ajouterFigure(Figure f)
	{
		figures.add(f);
	}

	/**
	 * Retourne un tableau des figures.
	 * @return
	 */
	public Figure[] listerFigures()
	{
		return figures.toArray(Figure[]::new);
	}

	/**
	 * Retourne une représentation en chaîne
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Auteur : " + auteur + "\n" +
		       "Titre : " + titre + "\n" +
		       "Date de création : " + dateCreation + "\n" +
		       "Dimensions : " + largeur + "x" + hauteur;
	}

	/**
	 * Peint le dessin.
	 * @param g le contexte {@link Graphics} spécifié
	 */
	@Override
	public void paint(Graphics g)
	{
		// TODO implement
	}

	/**
	 * Retourne l'auteur du dessin.
	 * @return l'auteur du dessin.
	 */
	public String getAuteur()
	{
		return auteur;
	}

	/**
	 * Remplace l'auteur du dessin.
	 * @param auteur
	 */
	public void setAuteur(String auteur)
	{
		this.auteur = auteur;
	}

	/**
	 * Retourne le titre du dessin.
	 * @return le titre du dessin.
	 */
	public String getTitre()
	{
		return titre;
	}

	public void setTitre(String titre)
	{
		this.titre = titre;
	}

	public LocalDate getDateCreation()
	{
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation)
	{
		this.dateCreation = dateCreation;
	}

	public int getLargeur()
	{
		return largeur;
	}

	public void setLargeur(int largeur)
	{
		this.largeur = largeur;
	}

	public int getHauteur()
	{
		return hauteur;
	}

	public void setHauteur(int hauteur)
	{
		this.hauteur = hauteur;
	}
}
