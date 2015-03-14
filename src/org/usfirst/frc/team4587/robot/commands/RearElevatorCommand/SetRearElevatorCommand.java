package org.usfirst.frc.team4587.robot.commands.RearElevatorCommand;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetRearElevatorCommand extends Command {
	private double position;
	
	public SetRearElevatorCommand(double p) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis)
		position = p;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
		Init.rB.setElevatorPosition(position);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
	     return Init.rB.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {	
	     end();
	}
}