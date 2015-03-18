package Utilities;

import edu.wpi.first.wpilibj.Joystick;

public class F310GamePad extends Joystick {

	public static final int leftStick_X = 0;
	public static final int leftStick_Y = 1;
	public static final int shoulderAxis_R = 2;
	public static final int shoulderAxis_L = 3;
	public static final int rightStick_X = 4;
	public static final int rightStick_Y = 5;
	public static final int dpadAxis = 6;

	// boolean buttons:
	public static final int button_A = 1;
	public static final int button_B = 2;
	public static final int button_X = 3;
	public static final int button_Y = 4;
	public static final int button_L_Shoulder = 5;
	public static final int button_R_Shoulder = 6;
	public static final int button_Back = 7;
	public static final int button_Start = 8;
	public static final int button_LeftStick = 9;
	public static final int button_RightStick = 10;

	public static final double deadZone = .1;
	int port;

	/**
	 * Creates a gamepad attached to the specified port on the driver station.
	 * 
	 * @param port
	 */
	public F310GamePad(int port) {
		super(port);
		this.port = port;
	}
	public double getAxis(int axis)
	{
		if(axis == leftStick_X)
		{
			return getLeftJoystickX();
		}
		else if(axis == leftStick_Y){
			return getLeftJoystickY();
		}
		else if(axis == rightStick_X){
			return getRightJoystickX();
		}
		else if(axis == rightStick_Y){
			return getRightJoystickY();
		}
		return axis;
	}
	public double getLeftJoystickX() {
		if (Math4587.withinThreshold(getRawAxis(leftStick_X), deadZone)){
			return 0.0;
		} else
			return this.getRawAxis(leftStick_X);
	}

	public double getLeftJoystickY() {
		if (Math4587.withinThreshold(getRawAxis(leftStick_Y), deadZone)){
			return 0.0;
		} else
			return this.getRawAxis(leftStick_Y);
			
	}
	public double getRightJoystickX() {
		if (Math4587.withinThreshold(getRawAxis(rightStick_X), deadZone)){
			return 0.0;
		} else
			return this.getRawAxis(rightStick_X);
	}

	public double getRightJoystickY() {
		if (Math4587.withinThreshold(getRawAxis(rightStick_Y), deadZone)){
			return 0.0;
		} else
			return this.getRawAxis(rightStick_Y);
	}

	public double getRightTrigger() {
		return this.getRawAxis(shoulderAxis_R);
	}

	public double getLeftTrigger() {
		return this.getRawAxis(shoulderAxis_L);
	}

	public double getOldTriggers() {
		return -getRightTrigger() + getLeftTrigger();
	}

	public boolean getButton(int button) {
		return this.getRawButton(button);
	}
	public double getDpad() {
		return this.getPOV();
	}

}
