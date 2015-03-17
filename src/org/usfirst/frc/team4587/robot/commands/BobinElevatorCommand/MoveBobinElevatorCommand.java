package org.usfirst.frc.team4587.robot.commands.BobinElevatorCommand;

import org.usfirst.frc.team4587.robot.Init;
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
    	this.dir = dir;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(dir == MOVE_UP)
		{
			//Init.rB.setForkSolenoid(true);
			//Init.rB.getPIDController().setPID(14,0, 0);
    		//Init.bB.setOutputRange(1, 1);
    		//Init.bB.getPIDController().setPID(.5, 0, 0);
    		//Init.bB.setSetpoint(BobinElevatorSubsystem.Up_Pos);
    		Init.bB.setMotor(1);
		}
		else if(dir == MOVE_DOWN)
		{
			Init.bB.setMotor(-1);
			//Init.rB.setForkSolenoid(false);
			//Init.bB.setOutputRange(1, 1);
    		/*Init.bB.getPIDController().setPID(.5, 0, 0);
			Init.bB.setSetpoint(BobinElevatorSubsystem.Down_Pos);*/
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Init.bB.checkandReset();
    	/*if(Init.bB.getLimit() == false){
			Init.bB.resetEncoder();
		}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Init.bB.setSetpoint(Init.bB.getPosition());// hold current position.
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
