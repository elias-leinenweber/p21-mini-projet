package dessinvectoriel;

public class Angle {
	public static final Angle NUL	= Angle.degres(0);
	public static final Angle DROIT	= Angle.degres(90);
	public static final Angle PLAT	= Angle.degres(180);

	private final double mesure;


	private Angle(double rad)
	{
		mesure = rad % (2 * Math.PI);
	}


	public static Angle degres(double deg)
	{
		return new Angle(Math.toRadians(deg));
	}

	public static Angle radians(double rad)
	{
		return new Angle(rad);
	}

	public double getDegres()
	{
		return Math.toDegrees(mesure);
	}

	public double getRadians()
	{
		return mesure;
	}

	public Angle ajouterDegres(double deg)
	{
		return degres(getDegres() + deg);
	}

	public Angle ajouterRadians(double rad)
	{
		return radians(getRadians() + rad);
	}

	public Angle ajouter(Angle theta)
	{
		return ajouterRadians(theta.mesure);
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
