package com.dev.cubicbeizer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.data.category.DefaultCategoryDataset;

public class Tests_AdvancedBeizerPlot extends JFrame
{
	MyLabel ml;
	DefaultCategoryDataset dataset;
	
	CubicBeizer cb;
	double step;
	double slideWidth;
	double frameRate;
	double timeSpan;
	boolean ploty;
	
	JLabel jl1, jl2, jl3, jl4, block, jl5, jl6, jl7;
	Timer tx;
	
	Tests_AdvancedBeizerPlot()
	{
		super("Cubic Beizer Demo");
		setSize(1366,718);
		setLayout(null);
		
		cb = new CubicBeizer(0.0, 0.75, 0.15, 1);
		step = 0.04;
		slideWidth = 100; // to move the block
		frameRate = 60.0; // in fps
		timeSpan = 500; //in ms
		
		ploty = true;
		dataset = new DefaultCategoryDataset();
		plotY(dataset);
		
		ml = new MyLabel(dataset);
		ml.setBounds(5, 5, 700, 700);
		ml.setOpaque(true);
		add(ml);
		
		JSlider js1 = new JSlider(0,100);
		js1.setBounds(900,50,400,50);
		add(js1);
		
		JSlider js2 = new JSlider(0,100);
		js2.setBounds(900,100,400,50);
		add(js2);
		
		JSlider js3 = new JSlider(0,100);
		js3.setBounds(900,150,400,50);
		add(js3);
		
		JSlider js4 = new JSlider(0,100);
		js4.setBounds(900,200,400,50);
		add(js4);
		
		JSlider js5 = new JSlider(0,500);
		js5.setBounds(900,250,400,50);
		add(js5);
		
		JSlider js6 = new JSlider(0,2000);
		js6.setBounds(900,300,400,50);
		add(js6);
		
		JSlider js7 = new JSlider(0,70);
		js7.setBounds(900,350,400,50);
		add(js7);
		
		jl1 = new JLabel();
		jl1.setBounds(800,50,100,50);
		jl1.setOpaque(true);
		add(jl1);
		
		jl2 = new JLabel();
		jl2.setBounds(800,100,100,50);
		jl2.setOpaque(true);
		add(jl2);
		
		jl3 = new JLabel();
		jl3.setBounds(800,150,100,50);
		jl3.setOpaque(true);
		add(jl3);
		
		jl4 = new JLabel();
		jl4.setBounds(800,200,100,50);
		jl4.setOpaque(true);
		add(jl4);
		
		jl5 = new JLabel();
		jl5.setBounds(800,250,100,50);
		jl5.setOpaque(true);
		add(jl5);
		
		jl6 = new JLabel();
		jl6.setBounds(800,300,100,50);
		jl6.setOpaque(true);
		add(jl6);
		
		jl7 = new JLabel();
		jl7.setBounds(800,350,100,50);
		jl7.setOpaque(true);
		add(jl7);
		
		js1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				    JSlider s = (JSlider)e.getSource();
				    cb.setX1(s.getValue()/100.0);
				    jl1.setText("X1:   " + String.valueOf(s.getValue()/100.0));
				    dataset.clear();
					if(ploty)
						plotY(dataset);
					else
						plotX(dataset);
					ml.setDataset(dataset);
			}
		});
		
		js2.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				    JSlider s = (JSlider)e.getSource();
				    cb.setY1(s.getValue()/100.0);	
				    jl2.setText("Y1:   " + String.valueOf(s.getValue()/100.0));
				    dataset.clear();
					if(ploty)
						plotY(dataset);
					else
						plotX(dataset);
					ml.setDataset(dataset);
			}
		});
		
		js3.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				    JSlider s = (JSlider)e.getSource();
				    cb.setX2(s.getValue()/100.0);
				    jl3.setText("X2:   " + String.valueOf(s.getValue()/100.0));
				    dataset.clear();
					if(ploty)
						plotY(dataset);
					else
						plotX(dataset);
					ml.setDataset(dataset);
			}
		});
		
		js4.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				    JSlider s = (JSlider)e.getSource();
				    cb.setY2(s.getValue()/100.0);
				    jl4.setText("Y2:   " + String.valueOf(s.getValue()/100.0));
				    dataset.clear();
					if(ploty)
						plotY(dataset);
					else
						plotX(dataset);
					ml.setDataset(dataset);
			}
		});
		
		js5.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				JSlider s = (JSlider)e.getSource();
				jl5.setText("Slide Width:  " + String.valueOf(s.getValue()));
				slideWidth = s.getValue();
			}
		});
		
		js6.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				JSlider s = (JSlider)e.getSource();
				jl6.setText("Time:  " + String.valueOf(s.getValue()));
				timeSpan = s.getValue();
			}
		});
		
		js7.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				JSlider s = (JSlider)e.getSource();
				jl7.setText("Frame Rate:  " + String.valueOf(s.getValue()));
				frameRate = s.getValue();
			}
		});
		
		js1.setValue(0);
		js2.setValue(75);
		js3.setValue(15);
		js4.setValue(100);
		
		js5.setValue(100);
		js6.setValue(1001);
		js7.setValue(60);
		
		block = new JLabel();
		block.setBounds(800,570,90,90);
		block.setOpaque(true);
		block.setBackground(Color.red);
		add(block);
		
		JButton jb1 = new JButton("Plot X");
		jb1.setBounds(800,420,90,50);
		add(jb1);
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dataset.clear();
				ploty = false;
				plotX(dataset);
				ml.setDataset(dataset);
			}
		});
		
		JButton jb2 = new JButton("Plot Y");
		jb2.setBounds(900,420,90,50);
		add(jb2);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dataset.clear();
				ploty = true;
				plotY(dataset);
				ml.setDataset(dataset);
			}
		});
		
		JButton jb3 = new JButton("Start");
		jb3.setBounds(1000,420,90,50);
		add(jb3);
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(tx!=null)
					tx.stop();
				tx = new Timer(100, new ActionListener() {
					
					double tm = 0.0;
					int initx = 800;
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if(tm<=1)
						{
							if(ploty)
								block.setLocation((int) (initx + slideWidth*cb.computeY(tm)), block.getY());
							else
								block.setLocation((int) (initx + slideWidth*cb.computeX(tm)), block.getY());
							tm+=(1/frameRate)*(1000/timeSpan);
						}
						else
							tx.stop();
					}
				});
				tx.setDelay((int) (1/frameRate*1000));
				tx.setRepeats(true);
				tx.start();
			}
		});
		
		JButton jb4 = new JButton("Reset");
		jb4.setBounds(1100,420,90,50);
		add(jb4);
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				block.setBounds(800,600,90,90);
			}
		});
		
		JLabel jl = new JLabel("Animation Block:");
		jl.setBounds(800, 500, 100, 50);
		add(jl);
		
		setVisible(true);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void plotX(DefaultCategoryDataset dataset)
	{
		for(double t=0.0; t<=1.0; t+=step)
			dataset.setValue(cb.computeX(t), "computeX", String.valueOf(t));
	}
	
	public void plotY(DefaultCategoryDataset dataset)
	{
		for(double t=0.0; t<=1.0; t+=step)
			dataset.setValue(cb.computeY(t), "computeY", String.valueOf(t));
	}

	public static void main(String[] args)
	{
		new Tests_AdvancedBeizerPlot();
	}
}
