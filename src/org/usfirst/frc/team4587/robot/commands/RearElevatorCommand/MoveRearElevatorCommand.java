package org.usfirst.frc.team4587.robot.commands.RearElevatorCommand;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.OI;
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
		if (OI.manualOveride == true) {
			Init.rB.disable();
			Init.rB.setRearMotors(direction ? 1 : -1);
		} else {
			Init.rB.enable();
			if (direction == MoveRearElevatorCommand.MOVE_DOWN) {
				Init.rB.setOutputRange(-0.6, 0.6);
				Init.rB.getPIDController().setPID(0.1,	0, 0);
				Init.rB.setElevatorPosition(RearElevatorSubsystem.POSITION_BOTTOM);
			} else {
				Init.rB.setOutputRange(-1, 1);
				Init.rB.getPIDController().setPID(.3,0, 0);
				Init.rB.setElevatorPosition(RearElevatorSubsystem.POSITION_TOP);
				// Init.rB.setRearMotors(0);//hold pos
			}
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
		if(OI.manualOveride == true)
		{
			Init.rB.setRearMotors(0);
		}
		else
		{
			Init.rB.setElevatorPosition(Init.rB.getPosition());
		}
		// Init.rB.setElevatorPosition(Init.rB.getPosition());

		// }
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}