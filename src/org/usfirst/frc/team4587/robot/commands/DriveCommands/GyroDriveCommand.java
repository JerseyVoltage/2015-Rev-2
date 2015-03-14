
package org.usfirst.frc.team4587.robot.commands.DriveCommands;

import org.usfirst.frc.team4587.robot.Init;
import org.usfirst.frc.team4587.robot.OI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroDriveCommand extends Command {

    public GyroDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Init.dB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Init.dB.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double move = OI.driveStick.getLeftJoystickY();
    	double rotate = OI.driveStick.getRightJoystickX();
    	Init.dB.holoDrive(move, rotate);
    	SmartDashboard.putNumber(" slow move", move);
		SmartDashboard.putNumber("slow rotate", rotate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
