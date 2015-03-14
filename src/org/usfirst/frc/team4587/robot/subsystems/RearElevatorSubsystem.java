package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RearElevatorSubsystem extends PIDSubsystem {
	public static final double POSITION_BOTTOM  = 0.0;
	public static final double POSITION_TOP     = 1.0;
	public static final double POSITION_6_STACK = 0.8;

	private static final boolean MOTOR_IS_REVERSED = false;
	private static final double Kp = 50.0;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;

	private SpeedController motorLift;
	private Potentiometer pospot;
	//private DigitalInput downLimit, upLimit;
	private Solenoid forkSolenoid;
	private double lastOutput = 0.0;

	public void display() {
		SmartDashboard.putNumber("Rear Elevator Pot", this.getPot());
		SmartDashboard.putNumber("Rear Elevator Setpoint", this.getSetpoint());
		SmartDashboard.putBoolean("Rear Elevator Fork", this.getForkSolenoid());
		SmartDashboard.putNumber("Rear Elevator Last Output", this.lastOutput);
		SmartDashboard.putBoolean("Rear Elevator onTarget", this.onTarget());
		SmartDashboard.putBoolean("Rear Elevator Is Enable?", this.getPIDController().isEnable());
	}
	
    // Initialize your subsystem here
    public RearElevatorSubsystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Rear Elevator", Kp, Ki, Kd);

    	//downLimit = new DigitalInput(1 /*RobotMap.TOUCH_SENSOR_CD*/);
    	//upLimit = new DigitalInput(2 /*RobotMap.TOUCHSENSOR_CU*/);
    	motorLift = new Talon(RobotMap.MOTOR_LIFT_C1);
    	pospot = new AnalogPotentiometer(RobotMap.POT_SENSOR_REARLIFT);
    	forkSolenoid = new Solenoid(RobotMap.CAN_COLLECTION_SOLENOID);
    	this.setSetpoint(getPot());
    	this.setAbsoluteTolerance(.002);
    	enable();
    }
    
    public void initDefaultCommand(){
        // Set the default command for a subsystem here.
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return getPot();
    }

    public void setElevatorPosition(double p) {
    	setSetpoint(p);
    }

    public double getPot() {
	return pospot.get();
    }
    
    protected void usePIDOutput(double output) {
    	if(MOTOR_IS_REVERSED)
    	{
    		output = -output;
    	}
    	else
    	{
    		motorLift.pidWrite(output);
    		lastOutput = output;
    	}
    }

    public void StopMotors() {
	motorLift.set(0);
    }
    public void setForkSolenoid(boolean x) {
    	forkSolenoid.set(x);
    }
    public boolean getForkSolenoid() {
	return forkSolenoid.get();    
    }
}