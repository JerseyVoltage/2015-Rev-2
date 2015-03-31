package org.usfirst.frc.team4587.robot.commands.Autonomous;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.commands.BobinElevatorCommand.SetBobinElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftBobin extends CommandGroup {
     
    public  LiftBobin() {
    	this.addSequential(new SetBobinElevatorCommand(Init.bB.Up_Pos) );
    /*	this.addSequential(new pickUpTote());// pick up
    	this.addParallel(new encoderDrive(7,3,1));// drive to second tote intake position
    	this.addParallel(new CloseClaw());
    	this.addSequential(new IntakeKickOut(), 0.6);// kick can out of the way
    	///////////////////////////////////////////////////////////////////
    	this.addParallel(new CloseClaw());
    	this.addSequential(new IntakeTotesInCommand());
    	this.addSequential(new OpenClaw());
    	this.addSequential(new pickUpTote());
    	//////////////////
    	this.addParallel(new encoderDrive(7,3,1));// drive to third tote intake position
    	this.addParallel(new CloseClaw());
    	this.addSequential(new IntakeKickOut(), 0.6);// kick can out of the way
    	//////////////////
    	this.addParallel(new CloseClaw());
    	this.addSequential(new IntakeTotesInCommand());
    	this.addSequential(new OpenClaw());
    	this.addSequential(new SetToteElevator(0.168));
    	
    	/////////////////////////
    	this.addSequential(new turnGyro(45));
    	this.addSequential(new encoderDrive(3,2,1));
    	
    	this.addSequential(new encoderDrive(-3,2,1));*/

    	
    }
}
