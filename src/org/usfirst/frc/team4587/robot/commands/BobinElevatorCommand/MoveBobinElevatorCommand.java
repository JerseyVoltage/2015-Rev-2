package org.usfirst.frc.team4587.robot.commands.BobinElevatorCommand;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.OI;
import org.usfirst.frc.team4587.robot.subsystems.BobinElevatorSubsystem;
import org.usfirst.frc.team4587.robot.subsystems.RearElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveBobinElevatorCommand extends Command {
double power;
public boolean dir;
static final boolean MOVE_UP = true;
static final boolean MOVE_DOWN = false;
    public MoveBobinElevatorCommand( boolean dir) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Init.bB);
    	
    	System.out.println("Move Bobin Constructor");
    	
    	this.dir = dir;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(OI.manualOveride == true)
    	{
    		Init.bB.disable();
    		Init.bB.setMotor(dir?-1:1);
    	}
    	else{
    		Init.bB.enable();
    	if(dir == MOVE_UP)
		{
			//Init.rB.setForkSolenoid(true);
			//Init.bB.getPIDController().setPID(.2,0, 0);
    		Init.bB.getPIDController().setPID(.3, 0, 0);
    		Init.bB.setOutputRange(-1, 1);
    		Init.bB.setSetpoint(Init.bB.Up_Pos);
    		//Init.bB.setMotor(-1);
		}
    	else if(dir == MOVE_DOWN)
		{
			//Init.bB.disable();
    		Init.bB.getPIDController().setPID(.2, 0, 0);
    		System.out.println("Bobin down");
    		Init.bB.setOutputRange(-1, 1);
    		Init.bB.setSetpoint(-10);
		}
    	}
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
    	//Init.bB.setSetpoint(Init.bB.getPosition());// hold current position.
    	//Init.bB.enable();
    	if(OI.manualOveride == false){
    	Init.bB.setOutputRange(-1, 1);
    	Init.bB.setSetpoint(Init.bB.getPosition());
    	}
    	else
    		Init.bB.setMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
