package org.usfirst.frc.team4587.robot.commands.DriveCommands;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class togglePIDGyro extends Command {

    public togglePIDGyro() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Init.dB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Init.dB.setPIDGyro(true);
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
    	Init.dB.setPIDGyro(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
