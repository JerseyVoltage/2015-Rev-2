package org.usfirst.frc.team4587.robot.commands.BobinElevatorCommand;

import org.usfirst.frc.team4587.robot.subsystems.BobinElevatorSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class IncrementToteBobinCommand extends CommandGroup {
    
    public  IncrementToteBobinCommand() {
    	this.addSequential(new SetBobinElevatorCommand(BobinElevatorSubsystem.Down_Pos));
    	this.addSequential(new WaitCommand(.2)); 
    	this.addSequential(new SetBobinElevatorCommand(BobinElevatorSubsystem.Up_Pos));
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
