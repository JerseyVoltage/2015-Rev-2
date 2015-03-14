package org.usfirst.frc.team4587.robot.commands.LiftCommand;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.subsystems.CollectorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class liftDown extends Command {
	double power;
    public liftDown(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Init.eB);
    	this.power = power;
    			//requires(Init.cB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    /*	if(Init.eB.getPosition() <= .15 && CollectorSubsystem.CollectorIn == true )
    	{
    		Init.eB.setSetpoint(Init.eB.getPosition());
    	}*/
    	Init.eB.disable();
    	Init.eB.moveElevator(power);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*if(Init.eB.getPosition() <= .15 && CollectorSubsystem.CollectorIn == true )
    	{
    		Init.eB.setSetpoint(Init.eB.getPosition());
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Init.eB.setSetpoint(Init.eB.getPosition());
    	Init.eB.enable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}