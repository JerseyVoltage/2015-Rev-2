package org.usfirst.frc.team4587.robot.commands.RearElevatorCommand;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

/**
 *
 */
public class SetForkPositionCommand extends Command {
	public boolean position;
	static final boolean FORK_UP = true;
	static final boolean FORK_DOWN = false;

	public SetForkPositionCommand(boolean position) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis)
		this.position = position;	
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		   Init.rB.setForkSolenoid(position);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//return true;
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Init.rB.setForkSolenoid(!position);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}