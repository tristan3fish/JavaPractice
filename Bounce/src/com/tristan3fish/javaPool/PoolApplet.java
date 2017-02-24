package com.tristan3fish.javaPool;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class PoolApplet extends Applet implements Runnable{
	private Thread _ticker;
	private int height;
	private int width;
	private boolean _isRunning;
	private Rectangle boundary;
	private Image offscreenImage;
	private Graphics offscr;
	ArrayList<Ball> balls;

	public void init(){
		_isRunning = false;
		width = getSize().width;
		height = getSize().height;
		boundary = new Rectangle(width, height);
		
		
		double startX = (width/2);
		double startY = height*2/3-18;
		
		balls = new ArrayList<Ball>();
		balls.add(new Ball(width/2,40-6,12,new Color(240,240,240)));
		Vec2D v =new Vec2D();
		v.setVec(0f, 2f);
		balls.get(0).vel= v;
		
		
		balls.add(new Ball((int)startX,(int)startY,12,new Color(255,100,100)));
		
		int f = (int) Math.sqrt(12*12-6*6);
		balls.add(new Ball((int)(startX-6),(int)(startY+f),12,new Color(255,100,100)));
		balls.add(new Ball((int)(startX+6),(int)(startY+f),12,new Color(240,220,0)));
		
		balls.add(new Ball((int)startX-12,(int)startY+2*f,12,new Color(240,220,0)));
		balls.add(new Ball((int)startX,(int)(startY+2*f),12,new Color(0,0,0)));
		balls.add(new Ball((int)startX+12,(int)startY+2*f,12,new Color(255,100,100)));
		
		balls.add(new Ball((int)(startX-18),(int)(startY+3*f),12,new Color(255,100,100)));
		balls.add(new Ball((int)(startX-6),(int)(startY+3*f),12,new Color(240,220,0)));
		balls.add(new Ball((int)(startX+6),(int)(startY+3*f),12,new Color(255,100,100)));
		balls.add(new Ball((int)(startX+18),(int)(startY+3*f),12,new Color(240,220,0)));
		
		balls.add(new Ball((int)(startX-24),(int)(startY+4*f),12,new Color(240,220,0)));
		balls.add(new Ball((int)(startX-12),(int)(startY+4*f),12,new Color(255,100,100)));
		balls.add(new Ball((int)(startX-0),(int)(startY+4*f),12,new Color(240,220,0)));
		balls.add(new Ball((int)(startX+12),(int)(startY+4*f),12,new Color(255,100,100)));
		balls.add(new Ball((int)(startX+24),(int)(startY+4*f),12,new Color(240,220,0)));
		
	}
	
	@Override
	public void update(Graphics g){
		if (offscr == null) {
			offscreenImage = createImage(width, height);
			offscr = offscreenImage.getGraphics();
		}

		offscr.setColor(new Color(80,220,0));
		offscr.fillRect(0, 0, height, width); 
		
		
		
		for (int i = 1; i < balls.size(); i++){
			for (int j = 0; j < i; j++){
				float t = balls.get(i).pathIntercept(balls.get(j));

				//System.out.println("["+i+","+j+"]:"+t);
				if(t<2){
					//int k = 1;
				}
				if(t <0 & t>-1){
					balls.get(i).moveToTime(t);
					balls.get(j).moveToTime(t);
					balls.get(i).collide(balls.get(j));
				}
			}
			
		}
		//System.out.println("");
		
		//float t = balls.get(2).pathIntercept(balls.get(1));
		//System.out.println(t);
		
		for(Ball b: balls){
			b.move(boundary);
			//float e = b.edgeIntercept(boundary);
			//b.bounce(e);
			//System.out.println(e);
			b.draw(offscr);
		}

		//System.out.println(t);
		
		g.drawImage(offscreenImage, 0, 0, this);
	}
	
	@Override
	public void run() {
		while(_isRunning){
			repaint();
			try {
				Thread.sleep((long) (1000/getFramesPerSecond()));
			} catch (InterruptedException e) { }
		}
	}
	
	public synchronized void start () {
		if (_ticker == null || !_ticker.isAlive()) {
			_isRunning = true;
			_ticker = new Thread(this); 
			_ticker.setPriority(Thread.MIN_PRIORITY + 1); 
			_ticker.start();
		}
	}
	
	public synchronized void stop () {
		_isRunning = false;
	}
	
	public static double getFramesPerSecond(){
		return 30f;
	}
}
