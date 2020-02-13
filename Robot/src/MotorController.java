import lejos.hardware.motor.Motor;
import lejos.hardware.motor.NXTRegulatedMotor;

public class MotorController implements Runnable {

    private static final int DEFAULT_SPEED = 800;
    private static int speed = DEFAULT_SPEED;
    private static State state = State.STOP;
    private static NXTRegulatedMotor rightMotor = Motor.A;
    private static NXTRegulatedMotor leftMotor = Motor.D;

    static void start(){
        state = State.FORWARD;
    }

    static void back(){
        state = State.BACK;
    }

    static void stop(){
        state = State.STOP;
    }

    static void left(){
        state = State.LEFT;
    }

    static void right(){
        state = State.RIGHT;
    }

    static void spin(){
        state = State.SPIN;
    }

    @Override
    public void run() {

        while(true){
            switch(state){
                case STOP:
                    rightMotor.stop(true);
                    leftMotor.stop(true);
                    break;
                case FORWARD:
                    rightMotor.setSpeed(speed);
                    rightMotor.forward();
                    leftMotor.setSpeed(speed);
                    leftMotor.forward();
                    break;
                case BACK:
                    rightMotor.backward();
                    rightMotor.setSpeed(speed);
                    leftMotor.backward();
                    leftMotor.setSpeed(speed);
                    break;
                case RIGHT:
                    rightMotor.setSpeed((int) (speed*0.25));
                    rightMotor.forward();
                    leftMotor.setSpeed(speed);
                    leftMotor.forward();
                    break;
                case LEFT:
                    rightMotor.setSpeed(speed);
                    rightMotor.forward();
                    leftMotor.setSpeed((int) (speed*0.25));
                    leftMotor.forward();
                    break;
                case SPIN:
                    rightMotor.setSpeed(speed);
                    rightMotor.forward();
                    leftMotor.backward();
                    leftMotor.setSpeed(speed);
            }
        }
    }

    enum State{
        STOP,
        FORWARD,
        BACK,
        RIGHT,
        LEFT,
        SPIN
    }
}
