package org.usfirst.frc.team4587.robot;

import org.usfirst.frc.team4587.robot.subsystems.BobinElevatorSubsystem;
import org.usfirst.frc.team4587.robot.subsystems.CollectorSubsystem;
import org.usfirst.frc.team4587.robot.subsystems.DriveBaseSubsystem;
import org.usfirst.frc.team4587.robot.subsystems.RearElevatorSubsystem;
import org.usfirst.frc.team4587.robot.subsystems.ToteElevatorSubsystem;

import edu.wpi.first.wpilibj.Timer;

//import Utilities.PID;

public class Init {
	public static Timer timer = new Timer();
	public static DriveBaseSubsystem dB = new DriveBaseSubsystem();
	public static CollectorSubsystem cB = new CollectorSubsystem();
	public static ToteElevatorSubsystem eB = null;//new ToteElevatorSubsystem();
	public static RearElevatorSubsystem rB = new RearElevatorSubsystem();
	public static BobinElevatorSubsystem bB = new BobinElevatorSubsystem();
	//public static OI oi = new OI();
	
	//Commands
	//public static final GyroDriveCommand gDrive = new GyroDriveCommand();
	
	public static void init()
	{ 	
		System.out.println("init");
	}
}
