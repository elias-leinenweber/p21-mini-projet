package dessinvectoriel;

import java.util.Objects;

public class Vecteur {
	private final double x;
	private final double y;


	public Vecteur(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vecteur(double rayon, Angle orientation)
	{
		Objects.requireNonNull(orientation);
		x = rayon * orientation.cos();
		y = rayon * orientation.sin();
	}


	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public Vecteur ajouter(Vecteur autre)
	{
		return new Vecteur(x + autre.x, y + autre.y);
	}

	public Vecteur oppose()
	{
		return new Vecteur(-x, -y);
	}

	public Vecteur soustraire(Vecteur autre)
	{
		return new Vecteur(x - autre.x, y - autre.y);
	}

	public Vecteur multiplier(double facteur)
	{
		return new Vecteur(facteur * x, facteur * y);
	}

	public double longueur()
	{
		return Math.sqrt(x * x + y * y);
	}

	public Angle orientation()
	{
		return Angle.atan(x, y);
	}

	@Override
	public String toString()
	{
		return String.format("(%f, %f)", x, y);
	}
}
