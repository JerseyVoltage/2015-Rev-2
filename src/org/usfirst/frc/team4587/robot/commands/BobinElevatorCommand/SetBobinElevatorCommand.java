package org.usfirst.frc.team4587.robot.commands.BobinElevatorCommand;

import org.usfirst.frc.team4587.robot.Init;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetBobinElevatorCommand extends Command {
double setpoint;
    public SetBobinElevatorCommand(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Init.bB);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Init.bB.resetEncoder();
    	Init.bB.getPIDController().setPID(.3, 0, 0);
    	Init.bB.setOutputRange(-.4, 1);
    	Init.bB.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Init.bB.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Init.bB.setSetpoint(Init.bB.getPosition());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
