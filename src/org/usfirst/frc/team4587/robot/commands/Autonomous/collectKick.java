package org.usfirst.frc.team4587.robot.commands.Autonomous;

import org.usfirst.frc.team4587.robot.commands.DriveCommands.encoderDrive;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.IntakeTotesInCommand;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class collectKick extends CommandGroup {
    
    public  collectKick() {
    	/*this.addSequential(new OpenClaw());
    	this.addParallel(new encoderDrive(15,5,1));
    	
    	this.addParallel(new IntakeTotesInCommand());  */  	//this.addParallel(new );
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
