package org.usfirst.frc.team4587.robot.commands.LiftCommand;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.subsystems.CollectorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetToteElevator extends Command {
	double p;
    public SetToteElevator(double p) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.p = p;
    	requires(Init.eB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {	
    	Init.eB.setSetpoint(p);
    	Init.eB.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    /*	if(Init.eB.getPosition() <= .15 && CollectorSubsystem.CollectorIn == true )
    	{
    		Init.eB.setSetpoint(Init.eB.getPosition());
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Init.eB.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Init.eB.setSetpoint(Init.eB.getPosition());
    	System.out.println("end Lift");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}