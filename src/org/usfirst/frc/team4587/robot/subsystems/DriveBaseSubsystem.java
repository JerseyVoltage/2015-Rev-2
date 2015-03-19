package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.RobotMap;
import org.usfirst.frc.team4587.robot.commands.DriveCommands.GyroDriveCommand;

import Utilities.Math4587;
import Utilities.PID;

import com.kauailabs.nav6.frc.IMU;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveBaseSubsystem extends Subsystem {
	// Drivetrain motors
	SpeedController leftDrive, rightDrive;
	RobotDrive mDrive;
	private boolean PIDGyro;
	private double minLimit, maxLimit;
	// Gyro Instantiation
	private SerialPort gyroSerial;
	private IMU Gyro;
	// Encoders
	private Encoder encoderRight, encoderLeft;
	// PID Controllers
	public PID GyroPID, EncoderPID;
	// Thread EncoderThread, GyroThread;

	// Gyro PID Gains
	private final double Kp_Gyro = .05;
	private final double Ki_Gyro = 0;
	private final double Kd_Gyro = 0;

	// Encoder PID Gains
	private final double Kp_Enc = .5;
	private final double Ki_Enc = .25;
	private final double Kd_Enc = 0;

	public DriveBaseSubsystem() {
		leftDrive = new Victor(RobotMap.MOTOR_DRIVE_L1);
		rightDrive = new Victor(RobotMap.MOTOR_DRIVE_R1);
		minLimit = -1;
		maxLimit = 1;
		System.out.println("Constructing");
		mDrive = new RobotDrive(leftDrive,rightDrive);
		gyroSerial = new SerialPort(57600, Port.kMXP);
		Gyro = new IMU(gyroSerial);
		// Encoder Instantiation
		encoderLeft = new Encoder(RobotMap.ENCODER_SENSOR_L_A,
				RobotMap.ENCODER_SENSOR_L_B);
		encoderRight = new Encoder(RobotMap.ENCODER_SENSOR_R_A,
				RobotMap.ENCODER_SENSOR_R_B);
		// PID
		GyroPID = new PID(Kp_Gyro, Ki_Gyro, Kd_Gyro);
		GyroPID.setPosition(0);// set position to zero for drive straight
								// function
		GyroPID.setTolerance(2);
		EncoderPID = new PID(Kp_Enc, Ki_Enc, Kd_Enc);
		this.PIDGyro = true;
		// EncoderThread = new Thread(EncoderPID);
	}

	// Movement
	public void holoDrive(double move, double rotate) {
		this.GyroPID.SensorInput(Gyro.getYaw());

		if (PIDGyro) {
			if (rotate == 0.0 && move != 0.0) {
				// Enables the PID controller if it is not already
				if (!GyroPID.isEnabled()) {
					GyroPID.resetPID();
					this.resetGyro();
					GyroPID.enable();
					resetGyro();
				}
				// Sets the forward move speed to the move parameter
				mDrive.arcadeDrive(this.motorlimiter(move), GyroPID.Output(),
						true);
				// moveSpeed = move;
			} else {
				// Disables the PID controller if it enabled so the drivetrain
				// can
				// move freely
				if (GyroPID.isEnabled()) {
					GyroPID.resetPID();
				}
				mDrive.arcadeDrive(this.motorlimiter(move), rotate, true);
			}
		} else {
			// Disables the PID controller if it enabled so the drivetrain can
			// move freely
			if (GyroPID.isEnabled()) {
				GyroPID.resetPID();
			}
			mDrive.arcadeDrive(this.motorlimiter(move), rotate, true);
		}
	}

	public double motorlimiter(double move) {
		return Math4587.limit(move, this.minLimit, this.maxLimit);
	}

	public void setMotorLimit(double min, double max) {
		this.maxLimit = max;
		this.minLimit = min;
	}

	public boolean setPIDGyro(boolean set) {
		this.PIDGyro = set;
		return set;
	}

	/**
	 * Find out how Gyro yaw works
	 * 
	 * @param angle
	 */
	public void turnGyro(double angle) {
		this.GyroPID.SensorInput(getGyro());
		this.GyroPID.setPID(2, 0, 0);
		this.GyroPID.setTolerance(2);
		this.GyroPID.setPosition(angle);
		mDrive.arcadeDrive(0, GyroPID.Output());

	}

	public void driveEnc(double dist) {
		this.EncoderPID.SensorInput(this.getInchesTravelled());
		this.EncoderPID.setTolerance(.2);
		this.EncoderPID.setPosition(dist);
		//this.EncoderPID.setMotorLimit(-.5, .7);
		// this.EncoderPID.enable();
		// EncoderThread.start();
		mDrive.arcadeDrive(-EncoderPID.Output(), 0);
	}
	public void setDriveMotor(double power)
	{
		mDrive.arcadeDrive(power, 0);
	}
	// Get PID
	public PID getGyroPID() {
		return GyroPID;
	}

	public PID getEncPID() {
		return this.EncoderPID;
	}

	// Sensors
	public IMU getGyroIMU() {
		return Gyro;
	}

	public double getGyro() {
		return Gyro.getYaw();
	}

	public void resetGyro() {
		Gyro.zeroYaw();
	}

	public void resetEncoders() {
		this.encoderLeft.reset();
		this.encoderRight.reset();
	}

	public double getInchesTravelled() {
		return Math
				.abs(Math4587.distanceTravelled_Inches((encoderLeft.get() + encoderRight
						.get()) / 2));
	}

	// Display
	public void display() {
		SmartDashboard.putBoolean("Isconnected", Gyro.isConnected());
		SmartDashboard.putBoolean("IsCalibrating", Gyro.isCalibrating());
		SmartDashboard.putNumber("Yaw", Gyro.getYaw());
		SmartDashboard.putNumber("Pitch", Gyro.getPitch());
		SmartDashboard.putNumber("Roll", Gyro.getRoll());
		SmartDashboard.putNumber("Compass", Gyro.getCompassHeading());
		// Encoder
		SmartDashboard.putNumber("Distance Inches", this.getInchesTravelled());
		SmartDashboard.putBoolean("encoder enable", EncoderPID.isEnabled());
		SmartDashboard.putNumber("Motor Output Encoder", EncoderPID.Output());
		SmartDashboard.putBoolean("Encoder On targert",
				this.EncoderPID.onTarget());
		SmartDashboard.putNumber("Encoder Motor Output", EncoderPID.Output());
		SmartDashboard.putNumber("Encoder SEt position",
				EncoderPID.getDesiredPosition());
		SmartDashboard.putNumber(
				"Encoder Error",
				EncoderPID.getDesiredPosition()
						- EncoderPID.getCurrentPosition());
		// Gyro
		SmartDashboard.putBoolean("Gyro PID Enabled?", GyroPID.isEnabled());
		SmartDashboard.putNumber("Gyro Error", GyroPID.getDesiredPosition()
				- GyroPID.getCurrentPosition());
		SmartDashboard.putNumber("Gyro Motor Ouput", GyroPID.Output());
		SmartDashboard.putBoolean("Gyro on target", GyroPID.onTarget());
		SmartDashboard.putBoolean("Gyro Drive", this.PIDGyro);
		SmartDashboard.putNumber("Timer", Init.timer.get());
		// drive toggle
		SmartDashboard.putNumber("max value", this.maxLimit);
		// System.out.println(pider);
		/*
		 * System.out.println("Encoder 1" + this.encoderLeft.get());
		 * System.out.println("Encoer 2" + this.encoderRight.get());
		 */
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new GyroDriveCommand());
	}
}
