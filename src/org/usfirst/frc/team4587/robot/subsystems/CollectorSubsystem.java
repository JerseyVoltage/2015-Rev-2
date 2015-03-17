package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CollectorSubsystem extends Subsystem {
	public static boolean CollectorIn;
	private  SpeedController collector1 = null, collector2 = null;
	private  DigitalInput limitSwitchL = null, limitSwitchR = null;
	private  Solenoid pneumaticClaw, sol1;
	
	public CollectorSubsystem() {
		System.out.println("Constructing Collector");
		collector1 = new Talon(RobotMap.MOTOR_INTAKE_L1);
		collector2 = new Talon(RobotMap.MOTOR_INTAKE_R1);
		pneumaticClaw = new Solenoid(RobotMap.TOTE_COLLECTION_SOLENOID);
		sol1 = new Solenoid(RobotMap.CLAW_SOLENOID_1);
		limitSwitchL = new DigitalInput(RobotMap.TOUCH_SENSOR_C1);
		//limitSwitchR = new DigitalInput(RobotMap.TOUCH_SENSOR_C2);
		//this.clawSet(false);
	}
	/**
	 * Positive to outtake, negative is to intake
	 * @param speed
	 */
	public void setIntakeMotors(double speed) {
		collector1.set(-speed);
		collector2.set(speed);
	}
	/**
	 * Set motors to different speeds
	 * @param speed1
	 * @param speed2
	 */
/*	public void correctTotes(double speed1, double speed2) {
		if (getSwitchL() == true && getSwitchR() == false) {
			collector1.set(speed1);
			collector2.set(-speed2);
		} else if (getSwitchR() == true && getSwitchL() == false) {
			collector1.set(speed2);
			collector2.set(-speed1);
		}
	}*/
	/**
	 * true = claw out; false = claw in
	 */
	public void clawSet(boolean mode) {
		pneumaticClaw.set(mode);
		sol1.set(!mode);
		CollectorSubsystem.CollectorIn = mode;
		
	}

	// Sensors
/*	public boolean getSwitchR() {
		return this.limitSwitchR.get();
	}*/

	public boolean getSwitchL() {
		return this.limitSwitchL.get();
	}
	public void displayIntake(){
		SmartDashboard.putBoolean("Switch Left L", getSwitchL());
		//SmartDashboard.putBoolean("Switch Left R", getSwitchR());
		SmartDashboard.putNumber("Intake value 1", collector1.get());
		SmartDashboard.putNumber("Intake Value 2", collector2.get());
		SmartDashboard.putBoolean("Claw State", pneumaticClaw.get());
	}
	public void initDefaultCommand(){}
}
