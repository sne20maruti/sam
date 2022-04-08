import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class FourBallsMoving extends PApplet {

    public static final int TOTAL_BALLS = 4;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int DIAMETER = 10;
    private static List<FourBallsMoving> MovingBalls = new ArrayList<>();
    private int directionX;
    private int directionY;
    private int speedOfBall;

    public FourBallsMoving() {
    }

    public FourBallsMoving(int index) {
        this.directionX = 0;
        this.directionY = index+1;
        this.speedOfBall = index+1;
    }

    public static void main(String[] args) {

        PApplet.main("FourBallsMoving",args);

        for(int i=0; i < TOTAL_BALLS;i++){
            FourBallsMoving ball = new FourBallsMoving(i);
            MovingBalls.add(ball);
        }
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void draw() {
        //super.draw();
        for (FourBallsMoving ball : MovingBalls){
            ballPositionUpdate(ball);
        }
    }

    private void ballPositionUpdate(FourBallsMoving ball) {
        ellipse(ball.directionX,((ball.directionY*HEIGHT)/5),DIAMETER,DIAMETER);
        ball.directionX += ball.speedOfBall;
    }
}