package com.dev.cubicbeizer;

public class CubicBeizer
{
	private double x1, x2, y1, y2;
	
	public CubicBeizer(double x1, double y1, double x2, double y2)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/*
	 * 	Constructor to be used for supplying ORDINATES only, not the abscissa.
	 */
	public CubicBeizer(double y1, double y2)
	{
		this(0.0, y1, 0.0, y2);
	}
	
	public double computeDelta(double t)
	{
		return Math.sqrt( Math.pow(computeX(t),2) + Math.pow(computeY(t),2) );
	}
	
	public double computeX(double t)
	{
		return compute(x1, x2, t);
	}
	
	public double computeY(double t)
	{
		return compute(y1, y2, t);
	}
	
	private double compute(double pt1, double pt2, double t)
	{
		double invT = 1.0 - t;
		return 3*invT*invT*t*pt1 + 3*invT*t*t*pt2 + t*t*t;
	}
	
	/*
	 * 	Getters and Setters
	 */

	public double getX1()
	{
		return x1;
	}

	public void setX1(double x1)
	{
		this.x1 = x1;
	}

	public double getX2()
	{
		return x2;
	}

	public void setX2(double x2)
	{
		this.x2 = x2;
	}

	public double getY1()
	{
		return y1;
	}

	public void setY1(double y1)
	{
		this.y1 = y1;
	}

	public double getY2()
	{
		return y2;
	}

	public void setY2(double y2)
	{
		this.y2 = y2;
	}	
}
