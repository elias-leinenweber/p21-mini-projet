package dessinvectoriel;

import java.time.LocalDate;

public class Dessin {
	private String auteur;
	private String titre;
	private LocalDate dateCreation;
	private int largeur;
	private int hauteur;

	public Dessin(String titre, String auteur, LocalDate dateCreation, int largeur, int hauteur)
	{
		this.titre = titre;
		this.auteur = auteur;
		this.dateCreation = dateCreation;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public Dessin(String titre, String auteur, int largeur, int hauteur)
	{
		this(titre, auteur, LocalDate.now(), largeur, hauteur);
	}
}
