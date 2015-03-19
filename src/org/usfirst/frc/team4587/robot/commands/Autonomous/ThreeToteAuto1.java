package org.usfirst.frc.team4587.robot.commands.Autonomous;

import org.usfirst.frc.team4587.robot.commands.DriveCommands.encoderDrive;
import org.usfirst.frc.team4587.robot.commands.DriveCommands.turnGyro;
import org.usfirst.frc.team4587.robot.commands.LiftCommand.SetToteElevator;
import org.usfirst.frc.team4587.robot.commands.LiftCommand.pickUpTote;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.CloseClaw;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.IntakeKickOut;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.IntakeTotesInCommand;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThreeToteAuto1 extends CommandGroup {
     
    public  ThreeToteAuto1() {
    	this.addSequential(new pickUpTote());// pick up
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
    	
    	this.addSequential(new encoderDrive(-3,2,1));

    	
    	//this.addParallel(new encoderDrive());
    	
 	/*this.addParallel(new CloseClaw());// close claw and collect
    	this.addSequential(new IntakeTotesInCommand(-.8));// collect
    	
    	this.addSequential(new PickUp());// Pick up one tote
    	this.addSequential(new WaitCommand(.5));*/
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
