package org.usfirst.frc.team4587.robot.commands.RearElevatorCommand;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.subsystems.RearElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
*
*/
public class MoveRearElevatorCommand extends Command {
	public boolean direction;
	static final boolean MOVE_UP = true;
	static final boolean MOVE_DOWN = false;

	public MoveRearElevatorCommand(boolean direction) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis)
		requires(Init.rB);
		this.direction = direction;	
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if(direction == MOVE_UP)
		{
			//Init.rB.setForkSolenoid(true);
			Init.rB.getPIDController().setPID(14,0, 0);
		   Init.rB.setElevatorPosition(RearElevatorSubsystem.POSITION_TOP);
		}
		else
		{
			//Init.rB.setForkSolenoid(false);
			Init.rB.getPIDController().setPID(5 ,0, 0);
		   Init.rB.setElevatorPosition(RearElevatorSubsystem.POSITION_BOTTOM);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Init.rB.setElevatorPosition(Init.rB.getPosition());
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}