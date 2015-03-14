package org.usfirst.frc.team4587.robot;

import org.usfirst.frc.team4587.robot.commands.DriveCommands.encoderDrive;
import org.usfirst.frc.team4587.robot.commands.DriveCommands.togglePIDGyro;
import org.usfirst.frc.team4587.robot.commands.DriveCommands.toggleSpeed;
import org.usfirst.frc.team4587.robot.commands.LiftCommand.SetToteElevator;
import org.usfirst.frc.team4587.robot.commands.LiftCommand.liftDown;
import org.usfirst.frc.team4587.robot.commands.LiftCommand.liftUp;
import org.usfirst.frc.team4587.robot.commands.RearElevatorCommand.MoveRearElevatorCommand;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.IntakeTotesInCommand;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.IntakeTotesOutCommand;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.ToggleSolenoids;
import org.usfirst.frc.team4587.robot.subsystems.ToteElevatorSubsystem;

import Utilities.F310GamePad;
import Utilities.JoyButton;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Controllers
	public static F310GamePad driveStick = new F310GamePad(RobotMap.JOY_LEFT_PORT);
	public static F310GamePad operatorStick = new F310GamePad(RobotMap.JOY_RIGHT_PORT);
	public static final Button Encoder = new JoystickButton(driveStick,F310GamePad.button_Back);
	public static final Button Outake = new JoystickButton(driveStick,F310GamePad.button_L_Shoulder);
	public static final Button Intake = new JoystickButton(driveStick, F310GamePad.button_R_Shoulder);
	public static final Button toggle_dB_PID = new JoystickButton(driveStick,F310GamePad.button_B);
	public static final Button toggle_dB_Speed = new JoystickButton(driveStick, F310GamePad.button_A);
	public static final Button toggle_cB_Solenoid = new JoystickButton(driveStick, F310GamePad.button_Y);
	// Operator Control
	public static final JoyButton liftUp = new JoyButton(operatorStick,JoyButton.JoyDir.UP, F310GamePad.rightStick_Y);
	public static final JoyButton liftDown = new JoyButton(operatorStick, JoyButton.JoyDir.DOWN, F310GamePad.rightStick_Y);
	public static final Button Position0 = new JoystickButton(operatorStick, F310GamePad.button_Start);
	public static final Button Position1 = new JoystickButton(operatorStick,F310GamePad.button_A);
	public static final Button Position2 = new JoystickButton(operatorStick, F310GamePad.button_B);
	public static final Button Position3 = new JoystickButton(operatorStick, F310GamePad.button_Y);
	public static final Button Position4 = new JoystickButton(operatorStick, F310GamePad.button_X);
	//
	public static final Button rearLiftUp = new JoystickButton(operatorStick, F310GamePad.button_R_Shoulder);
	public static final Button rearLiftDown = new JoystickButton(operatorStick, F310GamePad.button_L_Shoulder);
	public OI() {
		Outake.whileHeld(new IntakeTotesInCommand());
		Intake.whileHeld(new IntakeTotesOutCommand());
		liftUp.whileHeld(new liftUp(1));
		liftDown.whileHeld(new liftDown(-1));
		Position0.whenPressed(new SetToteElevator(ToteElevatorSubsystem.FLOOR));
		Position1.whenPressed(new SetToteElevator(ToteElevatorSubsystem.ONE_TOTE));
		Position2.whenPressed(new SetToteElevator(ToteElevatorSubsystem.TWO_TOTE));
		Position3.whenPressed(new SetToteElevator(ToteElevatorSubsystem.THREE_TOTE));
		Position4.whenPressed(new SetToteElevator(ToteElevatorSubsystem.FOUR_TOTE));
		Encoder.whenPressed(new encoderDrive(10,.7,.5));
		toggle_dB_PID.toggleWhenPressed(new togglePIDGyro());
		toggle_dB_Speed.toggleWhenPressed(new toggleSpeed());
		toggle_cB_Solenoid.toggleWhenPressed(new ToggleSolenoids());
		rearLiftUp.whileHeld(new MoveRearElevatorCommand(true));
		rearLiftDown.whileHeld(new MoveRearElevatorCommand(false));
		System.out.println("OI");
	}
}
