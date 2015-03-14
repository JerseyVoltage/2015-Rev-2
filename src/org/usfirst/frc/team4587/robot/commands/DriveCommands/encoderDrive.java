package org.usfirst.frc.team4587.robot.commands.DriveCommands;

import org.usfirst.frc.team4587.robot.Init;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class encoderDrive extends Command {
	double dist;
	double time;
	boolean isdone;//cooler
	double maxOutput;
	public encoderDrive(double dist, double time, double maxOutput) {
		requires(Init.dB);
		this.dist = dist;
		this.time = time;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Init.dB.EncoderPID.SensorInput(Init.dB.getInchesTravelled());
		Init.dB.resetEncoders();
		Init.dB.getEncPID().resetPID();
		Init.dB.getEncPID().enable();
		Init.timer.reset();
		Init.timer.start();
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		if(!isFinished()){
			Init.dB.EncoderPID.setMotorLimit(-maxOutput, maxOutput);// check
			Init.dB.driveEnc(dist);
		}
			
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Init.dB.getEncPID().onTarget() || Init.timer.get() >= time;

	}

	// Called once after isFinished returns true
	protected void end() {
		Init.timer.stop();
		
		Init.dB.getEncPID().disable();
		System.out.println("End Encoder");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}