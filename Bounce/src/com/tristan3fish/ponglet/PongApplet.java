package com.tristan3fish.ponglet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class PongApplet extends Applet implements Runnable {
	private Thread _ticker;
	private boolean _isRunning = false;
	private int gstate = GameStates.WAIT;
	
	private int pScore =0;
	private int gScore =0;
	private static final int MAX_SCORE = 10;
	
	private Rectangle table;
	//private Vector vBounds;
	private Ball ball;
	/*private VectorBall vBall;
	private VectorBall vBall2;
	private VectorBall vBall3;
	private VectorBall vBall4;*/
	private int width, height;
	private Image offscreenImage;
	private Graphics offscr;
	//private BallPit ballPit;
	private Paddle pPaddle;
	private Paddle gPaddle;
	private Font font;
	private FontMetrics fontMet;
	private int fontHeight;
	private Point player, game;
	
	public void init(){
		width = getSize().width;
		height = getSize().height;
		table = new Rectangle(width, height);
		pPaddle = new Paddle((int) (width / 2), height -6, 40, 3, Color.green);
		gPaddle = new Paddle((int) (width / 2), 3, 40, 3, Color.red);
		
		font = new Font( "TimesRoman", Font.PLAIN, 14);
		fontMet = getFontMetrics(font);
		fontHeight = fontMet.getAscent();
		player = new Point(width - width / 4, 5); 
		game = new Point(width / 4, 5);
		
		//vBounds = new Vector(2).set(0, width).set(1, height);
		
		// Initialize Ball position and velocity
		//ball = new Ball(width / 3f, height / 4f, 2.5f, 3f, 1f, 12, Color.blue);
		
		/*
		Vector x = new Vector(2).set(0, 5f).set(1, 7f);
		Vector dx = new Vector(2).set(0, 180f).set(1, 250f);
		vBall = new VectorBall(x, dx, 9, Color.red);
		Vector x2 = new Vector(2).set(0, 0f).set(1, 50f);
		Vector dx2 = new Vector(2).set(0, 50f).set(1, 0f);
		vBall2 = new VectorBall(x2, dx2, 45, Color.orange);
		Vector x3 = new Vector(2).set(0, 120f).set(1, 90f);
		Vector dx3 = new Vector(2).set(0, -40f).set(1, 0f);
		vBall3 = new VectorBall(x3, dx3, 20, Color.green);
		Vector x4 = new Vector(2).set(0, 100f).set(1, 7f);
		Vector dx4 = new Vector(2).set(0, 140f).set(1, 77f);
		vBall4 = new VectorBall(x4, dx4, 30, Color.blue);
		
		ballPit = new BallPit();
		ballPit.addBall(vBall);
		ballPit.addBall(vBall2);
		ballPit.addBall(vBall3);
		ballPit.addBall(vBall4);
		*/
	}
	
	public void paint (Graphics g) {
		if (offscr == null) {
			offscreenImage = createImage(width, height);
			offscr = offscreenImage.getGraphics();
		}
		
		// Draw checkerboard background
		int x2 = width >> 1;
		int y2 = height >> 1;
		offscr.setColor(Color.gray);
		offscr.fillRect(0, 0, x2, y2); 
		offscr.fillRect(x2, y2, width - x2, height - y2); 
		offscr.setColor(Color.white);
		offscr.fillRect(x2, 0, width - x2, height - y2); 
		offscr.fillRect(0, y2, x2, y2);
		
		ball.move(table);
		ball.draw(offscr);
		
		pPaddle.draw(offscr);
		gPaddle.draw(offscr);
		
		// Draw Scores
		offscr.setFont(font);
		centerText(offscr, game, Color.black, "game: "+ gScore); 
		centerText(offscr, player, Color.black, "player: "+ pScore);
		
		
		/*
		vBall.move(vBounds);
		vBall2.move(vBounds);
		vBall3.move(vBounds);
		vBall4.move(vBounds);		
		
		ballPit.collisionCheck();

		vBall.draw(offscr);
		vBall2.draw(offscr);
		vBall3.draw(offscr);
		vBall4.draw(offscr);
		*/

		
		g.drawImage(offscreenImage, 0, 0, this);
	}
	private void centerText (Graphics g, Point loc, Color clr, String str) {
		g.setColor(clr);
		g.drawString(str, loc.x -(fontMet.stringWidth(str) / 2), loc.y + fontHeight);
	}
	@Override
	public void update(Graphics g){
		paint(g);
	}
	
	@Override
	public boolean mouseEnter(Event evt, int x, int y) { 
		pPaddle.move(x, table);
		return true;
	}
	
	@Override
	public boolean mouseExit(Event evt, int x, int y) {
		return true;
	}
	
	@Override
	public boolean mouseMove (Event evt, int x, int y){
		pPaddle.move(x, table);
		return true;
	}

	@Override
	public void run() {
		int trackX = 0;
		int win_show = 0;
		while(_isRunning){
			switch (gstate) {
			case GameStates.WAIT: 
				//if (!mouse_in){
				//	delay = 20;
				//}else if ( delay < 0) {
					int ballSize = 12;
					// Serve the ball
					int sLoc = rndInt(table.width - ballSize) + (ballSize >> 1);
					//ball = new Ball(sLoc, -ballSize, rnd(5f) + 0,5f);
					ball = new Ball(sLoc, -ballSize, rnd(5f), rnd(5f), 1f, ballSize, Color.blue);
					gstate = GameStates.SERVE; 
					win_show = 100; 
				//}
				break;
			case GameStates.SERVE: 
				// Check for ball in position for player to hit
				gstate = pPaddle.checkReturn(ball, true, GameStates.SERVE, GameStates.RETURN, GameStates.PGUTTER);
				if (gstate == GameStates.RETURN){
					gPaddle = new Paddle((int) (trackX = width / 2), 3, 40, 3, Color.red);
				}
				break;
			case GameStates.RETURN: 
				// Implement our simple-minded computer opponent 
				if (Math.abs(gPaddle.x - ball.x) >= 1){
					gPaddle.move((int) (trackX += (gPaddle.x < ball.x ? 1.5f : -1.5f)), table);
				}
				// Check for ball in position for game to hit
				gstate = gPaddle.checkReturn(ball, false, GameStates.RETURN, GameStates.SERVE,GameStates.GGUTTER);
				ball.dy *= 1.003;
				ball.dx *= 1.0001;
				break;
			case GameStates.PGUTTER:
				// Wait for computer s scoring ball to move off table 
				if ((int) ball.y > (table.height + ball.radius)){
					gstate = GameStates.GSCORE;
				}
				break;
				//The code for GGUTTER iS nearly identical: 
			case GameStates.GGUTTER:
				// Wait for player s scoring ball to move off table 
				if ((int) ball.y < (table.y - ball.radius)){
					gstate = GameStates.PSCORE; 
				}
				break;
			case GameStates.PSCORE: 
				// Increment player s score and check if she has won
				gstate=(++pScore>= MAX_SCORE ? GameStates.PW0N : GameStates.WAIT);
				break;
			case GameStates.GSCORE: 
				// Increment computer s score and check if it has won 
				gstate = (++gScore >= MAX_SCORE ? GameStates.GWON : GameStates.WAIT);
				break;
			case GameStates.PW0N:
			case GameStates.GWON: 
				// Delay while we show who won 
				if ( win_show < 0) {
					gstate = GameStates.WAIT; 
					gScore = pScore = 0;
				}
				break;
			}
			repaint();
			
			try {
				Thread.sleep((long) (1000/getFramesPerSecond()));
				//System.out.println(new Date());
			} catch (InterruptedException e) { }
		}
	}
		
	public float rnd (float range) {
		return (float) (Math.random() * range);
	}
	
	public int rndInt (int range) {
		return (int) (Math.random() * range);
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
