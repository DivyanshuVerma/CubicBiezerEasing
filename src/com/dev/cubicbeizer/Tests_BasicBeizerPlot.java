package com.dev.cubicbeizer;

import java.awt.Frame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * Result obtained from this test:
 * 		When using a cubic beizer for animation, it is best to use the Y -axis for progression.
 * 		In reality only ordinates of the points supplied to the constructor are used.
 */

public class Tests_BasicBeizerPlot
{
	static CubicBeizer cb;
	static double step;
	
	public static void main(String[] args)
	{
		cb = new CubicBeizer(0.0, 0.75, 0.15, 1);
		step = 0.04;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		plotY(dataset);
		//plotX(dataset);
		//plotDelta(dataset);
		
		JFreeChart chart = ChartFactory.createAreaChart("Cubic Beizer Plot","Time", "Progression", dataset, PlotOrientation.VERTICAL, true,true, false);
		
		ChartFrame frame1=new ChartFrame("3D Bar Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(600,600);
		frame1.setState(Frame.MAXIMIZED_BOTH);
	}
	
	public static void plotY(DefaultCategoryDataset dataset)
	{
		for(double t=0.0; t<=1.0; t+=step)
			dataset.setValue(cb.computeY(t), "computeY", String.valueOf(t));
	}
	
	public static void plotX(DefaultCategoryDataset dataset)
	{
		for(double t=0.0; t<=1.0; t+=step)
			dataset.setValue(cb.computeX(t), "computeX", String.valueOf(t));
	}
	
	public static void plotDelta(DefaultCategoryDataset dataset)
	{
		for(double t=0.0; t<=1.0; t+=step)
			dataset.setValue(cb.computeDelta(t), "computeDelta", String.valueOf(t));
	}
}
