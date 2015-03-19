package org.usfirst.frc.team4587.robot.commands.DriveCommands;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveUntilBumperCommand extends Command {
double dist;
boolean isdone;
    public driveUntilBumperCommand(double dist) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Init.dB);
    	this.dist = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Init.dB.setDriveMotor(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Init.cB.getSwitchL())
    	{
    		isdone = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isdone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Init.dB.setDriveMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
