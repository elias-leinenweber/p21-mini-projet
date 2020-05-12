package dessinvectoriel;

import java.awt.*;
import java.time.LocalDate;

/**
 * La classe {@code Dessin} ...
 */
public class Dessin extends Canvas {
	private Figure[] figures;
	private String auteur;
	private String titre;
	private LocalDate dateCreation;
	private int largeur;
	private int hauteur;

	/**
	 * Construit un objet {@code Dessin}.
	 *
	 * @param titre le titre du dessin
	 * @param auteur l'auteur du dessin
	 * @param dateCreation la date de création
	 * @param largeur la largeur du dessin
	 * @param hauteur la hauteur du dessin
	 */
	public Dessin(String titre, String auteur, LocalDate dateCreation, int largeur, int hauteur)
	{
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


	public void ajouterFigure(Figure f)
	{
		// TODO implement
	}

	public Figure[] listerFigures()
	{
		// TODO implement
		return null;
	}

	@Override
	public String toString()
	{
		return "Auteur : " + auteur + "\n" +
		       "Titre : " + titre + "\n" +
		       "Date de création : " + dateCreation + "\n" +
		       "Dimensions : " + largeur + "x" + hauteur;
	}

	@Override
	public void paint(Graphics g)
	{
		// TODO implement
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

	public void setAuteur(String auteur)
	{
		this.auteur = auteur;
	}

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
