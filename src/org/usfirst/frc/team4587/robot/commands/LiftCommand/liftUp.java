package org.usfirst.frc.team4587.robot.commands.LiftCommand;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class liftUp extends Command {
	double power;
    public liftUp(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Init.eB);
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Init.eB.disable();
    	Init.eB.moveElevator(power);
    	System.out.println("Lift up");
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
    	Init.eB.setSetpoint(Init.eB.getPosition());
    	Init.eB.enable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}