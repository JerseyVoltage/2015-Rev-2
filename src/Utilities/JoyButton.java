package Utilities;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoyButton extends Button{
private JoyDir joyDir;
private F310GamePad stick;
private int axis;
	public enum JoyDir{ 
	DOWN,UP;
	}
	
	/**
	 * Uses Joystick as  a button input.
	 * @param joystick
	 * @param direction
	 * @param axis
	 */
	public JoyButton(F310GamePad joystick, JoyDir direction, int axis)
	{
		joyDir = direction;
		stick = joystick;
		this.axis = axis;
	}
	@Override
	public boolean get() {
		switch(joyDir){
		case UP:
			if(stick.getAxis(axis) <=-.5){
				return true;
			}
			break;
		case DOWN:
			if(stick.getAxis(axis) >= .5){
				return true;
			}
			break;
		}
		return false;
	}
}