package org.usfirst.frc.team4587.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThreeToteAuto1 extends CommandGroup {
     
    public  ThreeToteAuto1() {
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
