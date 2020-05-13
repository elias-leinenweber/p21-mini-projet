package dessinvectoriel;

public class Angle {
	public static final Angle NUL = Angle.degres(0);
	public static final Angle DROIT = Angle.degres(90);
	public static final Angle PLAT = Angle.degres(180);

	private final double mesure;


	public Angle(double rad)
	{
		mesure = rad % (2 * Math.PI);
	}


	public static Angle degres(double deg)
	{
		// TODO implement
		return null;
	}

	public static Angle radians(double rad)
	{
		return new Angle(rad);
	}

	public double getDegres()
	{
		// TODO implement
		return 0.0;
	}

	public double getRadians()
	{
		// TODO implement
		return 0.0;
	}

	public Angle ajouterDegres(double deg)
	{
		// TODO implement
		return null;
	}

	public Angle ajouterRadians(double rad)
	{
		// TODO implement
		return null;
	}

	public Angle ajouter(Angle theta)
	{
		// TODO implement
		return null;
	}

	public double sin()
	{
		return Math.sin(mesure);
	}

	public double cos()
	{
		return Math.cos(mesure);
	}

	public static Angle atan(double dX, double dY)
	{
		return new Angle(Math.atan2(dY, dX));
	}

	@Override
	public String toString()
	{
		return Double.toString(mesure);
	}
}
