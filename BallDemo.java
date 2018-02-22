import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBalls)
    {
        int ground = 400;   // position of the ground line
        ArrayList<BouncingBall> ballsArray = new ArrayList<>(); //Balls ArrayList

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for (int i = 0; i < numBalls; i++){
            Random r = new Random();
            int rPosition = r.nextInt(100);
            int rRadio = r.nextInt(40)+10;
            Color color = null;
            color = color.getHSBColor(r.nextInt(255),r.nextInt(255),r.nextInt(255)); //Creates a color based on the HSB color model
            BouncingBall ball = new BouncingBall(rPosition, rPosition, rRadio, color, ground, myCanvas);
            ballsArray.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            for (BouncingBall actualBouncingBall : ballsArray){
                myCanvas.wait(30);      // small delay
                actualBouncingBall.move();
                // stop once ball has travelled a certain distance on x axis
                if(actualBouncingBall.getXPosition() >= 550) {
                    finished = true;
                }
            }

        }
    }
}
