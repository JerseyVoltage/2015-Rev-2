package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.OI;
import org.usfirst.frc.team4587.robot.RobotMap;

import Utilities.Math4587;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BobinElevatorSubsystem extends PIDSubsystem {
	private Encoder BobinEncoder;
	private SpeedController bobinLift;
	private double lastOutput;
	private DigitalInput lowerLimit;
	public static final double Up_Pos = 38;
	public static final double Down_Pos = 3; // constants
	//double enc_val;
	public BobinElevatorSubsystem() {
		super("Bobin Elevator", 0.5, 0, 0);
		//this.getPIDController().setContinuous();
		this.setAbsoluteTolerance(2);
		
		bobinLift = new Victor(RobotMap.MOTOR_LIFT_B1);
		BobinEncoder = new Encoder(RobotMap.ENCODER_SENSOR_BOBIN_A,
				RobotMap.ENCODER_SENSOR_BOBIN_B);
		lowerLimit = new DigitalInput(RobotMap.TOUCH_SENSOR_B1);
		this.resetEncoder();
		//this.setSetpoint(this.getPosition());
		this.enable();	
		//this.setMotor(0);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stubss
		if(this.getLimit() == false)
		{
			this.resetEncoder();
		}
		return getEncoder();
	}

	@Override
	protected void usePIDOutput(double output) {
		if(Init.bB.getLimit() == false && output < 0)
		{
			Init.bB.setSetpoint(Init.bB.getPosition());
			output = 0;
		}
		if(output < -0.8)
		{
			output = -.8;
		}
		lastOutput = -output;
		setMotor(-output);
	}

	public void setMotor(double speed) {
		this.bobinLift.set(speed);
		//System.out.println("Motor BObin set" + speed);
	}

	public double getEncoder() {
		return Math4587.distanceTravelled_Inches(this.BobinEncoder.get());
	}

	public void resetEncoder() {
		BobinEncoder.reset();
	}
	/**
	 * Get lower limit for bobin elevator.++
	 * @return
	 */
	public boolean getLimit()
	{
		return this.lowerLimit.get();
	}
	public void display()
	{
		SmartDashboard.putNumber("Bobin Motor Value", this.bobinLift.get());
		SmartDashboard.putBoolean("Bobin PID is Enabled?", this.getPIDController().isEnable());
		SmartDashboard.putNumber("BObin setpoint", this.getSetpoint());
		SmartDashboard.putNumber("BObin Encoder Value(Inches)", getEncoder());
		SmartDashboard.putBoolean("Bobin Limit", getLimit());
		SmartDashboard.putNumber("OUT PID", this.lastOutput);
		SmartDashboard.putNumber("Joystick Value", OI.operatorStick.getLeftJoystickY());
	}
}
