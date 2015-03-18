package org.usfirst.frc.team4587.robot;

import org.usfirst.frc.team4587.robot.commands.BobinElevatorCommand.IncrementToteBobinCommand;
import org.usfirst.frc.team4587.robot.commands.BobinElevatorCommand.MoveBobinElevatorCommand;
import org.usfirst.frc.team4587.robot.commands.BobinElevatorCommand.SetBobinElevatorCommand;
import org.usfirst.frc.team4587.robot.commands.DriveCommands.encoderDrive;
import org.usfirst.frc.team4587.robot.commands.DriveCommands.togglePIDGyro;
import org.usfirst.frc.team4587.robot.commands.DriveCommands.toggleSpeed;
import org.usfirst.frc.team4587.robot.commands.LiftCommand.SetToteElevator;
import org.usfirst.frc.team4587.robot.commands.LiftCommand.liftTote;
import org.usfirst.frc.team4587.robot.commands.LiftCommand.pickUpTote;
import org.usfirst.frc.team4587.robot.commands.RearElevatorCommand.MoveRearElevatorCommand;
import org.usfirst.frc.team4587.robot.commands.RearElevatorCommand.SetForkPositionCommand;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.IntakeTotesInCommand;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.IntakeTotesOutCommand;
import org.usfirst.frc.team4587.robot.commands.ToteCollectorCommand.ToggleSolenoids;
import org.usfirst.frc.team4587.robot.subsystems.ToteElevatorSubsystem;

import Utilities.Dpad;
import Utilities.Dpad.HatDir;
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
	/*
	 * Driver Controls
	 */
	public static F310GamePad driveStick = new F310GamePad(RobotMap.JOY_LEFT_PORT);
	public static F310GamePad operatorStick = new F310GamePad(RobotMap.JOY_RIGHT_PORT);
	public static final Button Encoder = new JoystickButton(driveStick,F310GamePad.button_Back);
	public static final  Dpad toggle_dB_PID = new Dpad(driveStick,HatDir.DOWN);
	public static final  Dpad toggle_dB_Speed = new Dpad(driveStick,HatDir.UP);
	/*
	 * Collection Button Assignment
	 */
	public static final Button toggle_cB_Solenoid = new JoystickButton(driveStick, F310GamePad.button_Y);
	public static final Button Outake = new JoystickButton(driveStick,F310GamePad.button_L_Shoulder);
	public static final Button Intake = new JoystickButton(driveStick, F310GamePad.button_R_Shoulder);
	/*
	 * Rear Lift Assignment
	 */
	public static final Button rearLiftUp = new JoystickButton(driveStick, F310GamePad.button_B);
	public static final Button rearLiftDown = new JoystickButton(driveStick, F310GamePad.button_A);
	public static final Button toggleCAN_Fork = new JoystickButton(driveStick, F310GamePad.button_X);
	
	// Operator Control
	/*
	 * Tote Lift Assignment
	 */
	
	public static final JoyButton liftUp = new JoyButton(operatorStick,JoyButton.JoyDir.UP, F310GamePad.rightStick_Y);
	public static final JoyButton liftDown = new JoyButton(operatorStick, JoyButton.JoyDir.DOWN, F310GamePad.rightStick_Y);
	public static final Button Position0 = new JoystickButton(operatorStick, F310GamePad.button_Start);
	public static final Button Position1 = new JoystickButton(operatorStick,F310GamePad.button_A);
	public static final Button Position2 = new JoystickButton(operatorStick, F310GamePad.button_B);
	public static final Button Position3 = new JoystickButton(operatorStick, F310GamePad.button_Y);
	public static final Button Position4 = new JoystickButton(operatorStick, F310GamePad.button_X);
	public static final Button pickupTote = new JoystickButton(operatorStick, F310GamePad.button_Back);
	/*
	 * Bobin Lift Button Assignment
	 */
	public static final JoyButton bobinDown = new JoyButton(operatorStick,JoyButton.JoyDir.DOWN, F310GamePad.leftStick_Y);
	public static final JoyButton bobinUp = new JoyButton(operatorStick, JoyButton.JoyDir.UP, F310GamePad.leftStick_Y);
	public static final Dpad pickUp = new Dpad(operatorStick,HatDir.DOWN);
	public static final Dpad neutralState = new Dpad(operatorStick, HatDir.UP);
	public OI() {
		/*
		 * Collection
		 */
		Outake.whileHeld(new IntakeTotesInCommand());
		Intake.whileHeld(new IntakeTotesOutCommand());
		toggle_cB_Solenoid.toggleWhenPressed(new ToggleSolenoids ());
		/*
		 * Tote Elevator
		 */
		liftUp.whileHeld(new liftTote(true));
		liftDown.whileHeld(new liftTote(false));
		/*
		 * Driving
		 */
		toggle_dB_PID.toggleWhenActive(new togglePIDGyro());
		toggle_dB_Speed.toggleWhenActive(new toggleSpeed());
		Encoder.whenPressed(new encoderDrive(10,0.7,0.5));
		/*
		 * Rear Elevator
		 */
		toggleCAN_Fork.toggleWhenPressed(new SetForkPositionCommand(true));
		rearLiftUp.whileHeld(new MoveRearElevatorCommand(true));
		rearLiftDown.whileHeld(new MoveRearElevatorCommand(false));
		
		/*
		 * Operator Controls
		 */
		
		/*
		 * Tote Elevator Presets
		 */
		Position0.whenPressed(new SetToteElevator(ToteElevatorSubsystem.FLOOR));
		Position1.whenPressed(new SetToteElevator(ToteElevatorSubsystem.ONE_TOTE));
		Position2.whenPressed(new SetToteElevator(ToteElevatorSubsystem.TWO_TOTE));
		Position3.whenPressed(new SetToteElevator(ToteElevatorSubsystem.THREE_TOTE));
		Position4.whenPressed(new SetToteElevator(ToteElevatorSubsystem.FOUR_TOTE));
		pickupTote.whenPressed(new pickUpTote());
		
		/*
		 * Bobin Lift
		 */
		bobinUp.whileHeld(new MoveBobinElevatorCommand(true));
		bobinDown.whileHeld(new MoveBobinElevatorCommand( false));
		pickUp.whenActive(new IncrementToteBobinCommand());
		neutralState.whenActive(new SetBobinElevatorCommand(1.7));
		System.out.println("OI");
	}
}
