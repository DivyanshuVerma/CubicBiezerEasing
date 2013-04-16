package com.dev.cubicbeizer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MyLabel extends JLabel
{
	DefaultCategoryDataset dataset;
	JFreeChart chart;
	
	public MyLabel(DefaultCategoryDataset dt)
	{
		super("Chart");
		dataset = dt;
		chart = ChartFactory.createAreaChart("Cubic Beizer Plot","Time", "Progression", dataset, PlotOrientation.VERTICAL, true,true, false);
	}
	
	public DefaultCategoryDataset getDataset()
	{
		return dataset;
	}
	
	public void setDataset(DefaultCategoryDataset dataset)
	{
		this.dataset = dataset;
		chart = ChartFactory.createAreaChart("Cubic Beizer Plot","Time", "Progression", dataset, PlotOrientation.VERTICAL, true,true, false);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		chart.draw((Graphics2D) g, new Rectangle(0,0, getWidth(), getHeight()));
	}
}