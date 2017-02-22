package com.tristan3fish.holeInOne;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class HoleInOneApplet extends Applet implements Runnable {
	private Thread _ticker;
	private int height;
	private int width;
	private boolean _isRunning;
	private Rectangle boundary;
	private Image offscreenImage;
	private Graphics offscr;
	private Ball ball;
	private Hole hole;
	private int BALLSIZE = 9;
	private Point putt;
	private boolean select;
	
	public boolean mouseDown (Event evt, int x, int y){
		if (ball.sunk){
			ball = new Ball(x, y, BALLSIZE);
			repaint();
		}
		if (!ball.moving() && (select = ball.touches(x, y))) {
			putt = new Point(x, y); 
			repaint();
		}
		return true;
	}
	
	public boolean mouseUp (Event evt, int x, int y) {
		if (select){
			ball.putt(putt); 
			repaint();
		}			
		select = false; 
		return true;
	}
	
	public boolean mouseDrag (Event evt, int x, int y){
		if (select){
			putt = new Point(x, y);
			//System.out.println("["+x+","+y+"]");
			repaint();
		}
		return true;
	}
	
	public void init(){
		_isRunning = false;
		width = getSize().width;
		height = getSize().height;
		boundary = new Rectangle(width, height);
		
		ball = new Ball(20,22,BALLSIZE);
		ball.vel.setVec(2.33f,2.47f);
		hole = new Hole(width*3/4, height*3/4, 19);
	}
	
	public void paint (Graphics g) {
		if (offscr == null) {
			offscreenImage = createImage(width, height);
			offscr = offscreenImage.getGraphics();
		}

		offscr.setColor(new Color(100,200,0));
		offscr.fillRect(0, 0, height, width); 
		offscr.setColor(Color.green);
		offscr.fillOval(5, 5, width-10, height-10);
		
		hole.influence(ball);
		ball.move(boundary, .0272f);
		hole.draw(offscr);
		ball.draw(offscr);
		
		if (select){
			offscr.setColor(Color.black);
			offscr.drawLine((int) ball.x, (int) ball.y, (int) putt.x, (int) putt.y);
		}
		
		g.drawImage(offscreenImage, 0, 0, this);
	}
	
	@Override
	public void update(Graphics g){
		paint(g);
	}
	
	@Override
	public void run() {
		while(_isRunning){
			repaint();
			try {
				Thread.sleep((long) (1000/getFramesPerSecond()));
				//System.out.println(new Date());
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
		return 60f;
	}
}
