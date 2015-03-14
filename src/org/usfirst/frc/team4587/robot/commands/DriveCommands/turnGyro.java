package org.usfirst.frc.team4587.robot.commands.DriveCommands;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class turnGyro extends Command {

    public turnGyro() {
        // Use requires() here to declare subsystem dependencies
        requires(Init.dB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Init.dB.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Init.dB.turnGyro(45);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Init.dB.getGyroPID().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Init.dB.getGyroPID().onTarget();
    	System.out.println("End Gyro turn");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
