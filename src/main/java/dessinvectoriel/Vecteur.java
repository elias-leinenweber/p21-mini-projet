package dessinvectoriel;

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
		// TODO implement
		return null;
	}

	public Vecteur oppose()
	{
		// TODO implement
		return null;
	}

	public Vecteur soustraire(Vecteur autre)
	{
		// TODO implement
		return null;
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
		// TODO implement
		return null;
	}

	@Override
	public String toString()
	{
		// TODO implement
		return null;
	}
}
