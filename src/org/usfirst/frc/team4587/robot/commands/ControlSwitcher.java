package org.usfirst.frc.team4587.robot.commands;

import org.usfirst.frc.team4587.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlSwitcher extends Command {
boolean controlType;
    public ControlSwitcher() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		OI.manualOveride = true;
    		System.out.println("Set Control type to:" + OI.manualOveride);
   
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
    	OI.manualOveride = false;
    	System.out.println("Set Control type to:" + OI.manualOveride);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
