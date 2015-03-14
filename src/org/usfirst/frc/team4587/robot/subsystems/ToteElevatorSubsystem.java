package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToteElevatorSubsystem extends PIDSubsystem {
	private double output;
	Potentiometer pot;
	SpeedController motorLift;
	Solenoid pistonBrake;
	// Sensors
	DigitalInput downLimit, upLimit;
	Potentiometer pospot;
	private static final double Kp = 15; // was 15
	private static final double Ki = 0;
	private static final double Kd = 0;
	// lift const
	public static final double FLOOR = 0;
	public static final double inbetween = .1;
	public static final double NEAR_FLOOR = .2;
	public static final double ONE_TOTE = .33;
	public static final double TWO_TOTE = .4;
	public static final double THREE_TOTE = .5;
	public static final double FOUR_TOTE = .55;
	//public static final double FIVE_TOTE = .45;

	public ToteElevatorSubsystem() {
		super("Elevator", Kp, Ki, Kd);
		this.setAbsoluteTolerance(.002);
		this.getPIDController().setContinuous(false);
		//
		this.motorLift = new Talon(RobotMap.MOTOR_LIFT_TL1);
		downLimit = new DigitalInput(RobotMap.TOUCH_SENSOR_TD);
		upLimit = new DigitalInput(RobotMap.TOUCH_SENSOR_TU);
		pospot = new AnalogPotentiometer(RobotMap.POT_SENSOR_LIFT, 1, 0); // pot
		// this.elevatorTotePID.setPosition(getAdjustedPot());
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return pospot.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		this.output = output;
		this.motorLift.set(output);
	}
	
	public double getPot(){
		return pospot.get();
	}
	

	public void display() {
		SmartDashboard.putNumber("POT SET Value", this.getSetpoint());
		SmartDashboard.putNumber("Current POT Value", pospot.get());
		SmartDashboard.putBoolean("On Target Can", this.onTarget());
		SmartDashboard.putNumber("PID Output Can",this.output);
		SmartDashboard.putBoolean("Elevator PID Enabled", this.getPIDController().isEnable());
		SmartDashboard.putNumber("Elevator Power", this.motorLift.get());
		// System.out.println(this.elevatorTotePID.getDesiredPosition());
	}

	public boolean getDownLimit() {
		return downLimit.get();
	}

	public boolean getUpLimit() {
		return upLimit.get();
	}

	public void moveElevator(double power) {
		motorLift.set(power);
	}

	public void StopMotors() {
		motorLift.set(0);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		
	}


}
