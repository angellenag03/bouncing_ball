package mx.unison;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BallAnimator implements Runnable {
    public static final int MAX_X = 640;
    public static final int MAX_Y = 480;
    public static final int SIGN = -1;

    public static final int DX = 10;
    public static final int DY = 10;
    private Ellipse2D.Double ball;

    private int ballX;
    private int ballY;

    public BallAnimator(Shape shape) {
        ball = ( Ellipse2D.Double) shape;
        ballX = 320;
        ballY = 240;
        ball.x = ballX ;
        ball.y = ballY;
    }

    @Override
    public void run() {
        int sY = 1;
        int sX = 1;

        while( true ) {

            if( ballY < 0 ) {
                sY = sY * SIGN;
            }

            if( ballX < 0 ) {
                sX = sX * SIGN;
            }
            if( ballY > (MAX_Y - 20) ) {
                sY = sY * SIGN;
            }

            if( ballX > (MAX_X - 20) ) {
                sX = sX * SIGN;
            }
            ballX = ballX + (DX * sX) ;
            ballY = ballY + (DY * sY);
            ball.x = ballX ;
            ball.y = ballY;
            try {
                Thread.sleep(150L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
