package org.usfirst.frc.team4587.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// ///////////////////////////--PWMS--/////////////////////////////////////////////////////
	/*
	 * Motors Left side Drive
	 */
	public static final int MOTOR_DRIVE_L1 = 0;
	/*
	 * Motors Right Side
	 */
	public static final int MOTOR_DRIVE_R1 = 1;
	/*
	 * Elevator Motors for Can
	 */
	public static final int MOTOR_LIFT_C1 = 2;
	/*
	 * Bobin Lift
	 */
	public static final int MOTOR_LIFT_B1 = 4;
	/*
	 * Intake Motors
	 */
	public static final int MOTOR_INTAKE_L1 = 5;
	public static final int MOTOR_INTAKE_R1 = 6;
	/*
	 * Elevator Motors for totes
	 */
	public static final int MOTOR_LIFT_TL1 = 7;
	//public static final int MOTOR_LIFT_TR1 = 8;

	/*
	 * Motor to deploy totes
	 */
	//public static final int MOTOR_DEPLOY_TOTES = 9;
	// ////////////////////////////////--Solenoids--/////////////////////////////////////////
	/*
	 * Fork Pneumatic
	 */
	public static final int CAN_COLLECTION_SOLENOID = 1;
	/*
	 * Collector Pneumatics for totes
	 */
	public static final int TOTE_COLLECTION_SOLENOID = 4;
	//public static final int BRAKE_CAN_ELEVATOR = 2;
	/*
	 * Pneumatic Shifter for Drivetrain
	 */
/*	public static final int SHIFTER_SOLENOID_L1 = 3;
	public static final int SHIFTER_SOLENOID_R1 = 4;*/
	
	/*
	 * Claw Pneumatics for Can Colection
	 */
	public static final int CLAW_SOLENOID_1 = 5;
	/*
	 * Solenoid for Shifters
	 */
	// //////////////////////////////////--Relays--//////////////////////////////////////////

	/*
	 * Relay the Lights, LED is plugged into
	 */
	public static final int LIGHT_RELAY = 2;
	/*
	 * Relay the Compressor is plugged into
	 */
	public static final int COMPRESSOR_RELAY = 4;

	// /////////////////////////////////--DIO--///////////////////////////////////////////////////
	/*
	 * Touch Sensors for Totes collection
	 */
	public static final int TOUCH_SENSOR_C1 = 0; // tote collection
	/*
	 * Bobin Limit siwtch
	 */
	public static final int TOUCH_SENSOR_B1 = 1; 
	/*
	 * Encoders for Drive Wheels Two ports: a,b
	 */
	public static final int ENCODER_SENSOR_R_A = 4;
	public static final int ENCODER_SENSOR_R_B = 5;
	// LEFT SIDE
	public static final int ENCODER_SENSOR_L_A = 6;
	public static final int ENCODER_SENSOR_L_B = 7;
	/*
	 * BOBIN SENSOR FOR ELEVATORd
	 * */
	public static final int ENCODER_SENSOR_BOBIN_A = 8; //BOBIN Encoder SENSOR
	public static final int ENCODER_SENSOR_BOBIN_B = 9;
	
	// //////////////////////////////////--Analog--///////////////////////////////
	/*
	 * Pot... so we can measure how high we are.... hehe
	 */
	public static final int POT_SENSOR_LIFT = 1;
	public static final int POT_SENSOR_REARLIFT = 0;
	/*
	 * Gyro
	 */
	public static final int Gyro = 2;
	// //////////////////////////////////--Controls--/////////////////////////////////////////
	/**
	 * The port the right joystick is plugged into.
	 */
	public static final int JOY_RIGHT_PORT = 0;
	/**
	 * The port the left joystick is plugged into.
	 */
	public static final int JOY_LEFT_PORT = 1;
}
