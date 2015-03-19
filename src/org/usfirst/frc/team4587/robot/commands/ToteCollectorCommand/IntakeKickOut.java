package org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeKickOut extends Command {

    public IntakeKickOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Init.cB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Init.cB.differentSpeeds(.75, .75);// same direction to spit out totes
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
    	Init.cB.setIntakeMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
