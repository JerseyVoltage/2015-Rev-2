package Utilities;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Credit: BitBucketsFRC4183
 */
public class Dpad extends Trigger {
    private HatDir hatDir;
    private F310GamePad stick;

    public enum HatDir {
        UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT
    }

    public Dpad(F310GamePad joystick, HatDir dir){
        hatDir = dir;
        stick = joystick;
    }

    @Override
    public boolean get() {
        switch(hatDir){
            case UP:
                if(stick.getPOV() == 0){
                    return true;
                }
                break;
            case UP_RIGHT:
                if(stick.getPOV() == 45){
                    return true;
                    
                }
                break;
            case RIGHT:
                if(stick.getPOV() == 90){
                    return true;
                }
                break;
            case DOWN_RIGHT:
                if(stick.getPOV() == 135){
                    return true;
                }
                break;
            case DOWN:
                if(stick.getPOV() == 180){
                    return true;
                }
                break;
            case DOWN_LEFT:
                if(stick.getPOV() == 225){
                    return true;
                }
                break;
            case LEFT:
                if(stick.getPOV() == 270){
                    return true;
                }
                break;
            case UP_LEFT:
                if(stick.getPOV() == 315){
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }
}