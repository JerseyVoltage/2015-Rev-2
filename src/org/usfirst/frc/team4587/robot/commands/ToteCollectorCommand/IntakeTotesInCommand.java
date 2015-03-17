package org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeTotesInCommand extends Command {

    public IntakeTotesInCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Init.cB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Init.cB.clawSet(false);
    	if (isFinished() == false) {
			Init.cB.setIntakeMotors(-.7);
			System.out.println("Intakes are intaking");
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Init.cB.correctTotes(0, -.8);
    }

    // Make this return true when this Cosmmand no longer needs to run execute()
    protected boolean isFinished() {
    	if (/*Init.cB.getSwitchR() == false */Init.cB.getSwitchL() == false) {
			return true;
		} else
			return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Init.cB.setIntakeMotors(0);
    	//Init.cB.clawSet(true);
    	System.out.println("End Collection");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}