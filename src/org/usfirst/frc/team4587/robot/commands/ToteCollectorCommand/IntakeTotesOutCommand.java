package org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeTotesOutCommand extends Command {

    public IntakeTotesOutCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Init.cB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Init.cB.setIntakeMotors(0.8);
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
    	Init.cB.setIntakeMotors(0.0);
    	System.out.println("End Collections");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}