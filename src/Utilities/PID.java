package Utilities;
public class PID{
	private double Upper_Limit = 1;
	private double Lower_Limit = -1;
	private boolean enable;

	private double tolerance;
	private double outputDrive;
	private double error;
	private double pidLastError;
	private double desiredPosition;
	// private double outputMotor;
	private double Kp, Ki, Kd;
	private double P_Val, I_Val, D_Val;
	private double SensorVal;
	
	double Motor_Val;
	
	 public PID()
	    {
	        this(0.0, 0.0, 0.0);
	    }
	/**
	 * Constructor
	 * 
	 * @param p
	 * @param i
	 * @param d
	 */
	public PID(double p, double i, double d) {
		Kp = p;
		Ki = i;
		Kd = d;
		Motor_Val = 0;
	}

	public void setPID(double p, double i, double d) {
		Kp = p;
		Ki = i;
		Kd = d;
	}

	/**
	 * Output of motor max and min
	 * 
	 * @param lowerlimit
	 * @param higherLimit
	 */
	
	public void setMotorLimit(double lowerlimit, double higherLimit) {
		this.Lower_Limit = lowerlimit;
		this.Upper_Limit = higherLimit;
	}

	/**
	 * Set the setPoint
	 * 
	 * @param position
	 */
	public void setPosition(double position) {
		this.desiredPosition = position;
	}

	/**
	 * Get the Setpoint
	 * 
	 * @return
	 */
	public double getDesiredPosition() {
		return desiredPosition;
	}

	/**
	 * Sensor input
	 * 
	 * @param sensor
	 */
	public void SensorInput(double sensor) {

		this.SensorVal = sensor;
	}

	/**
	 * Get current value of sensor
	 * 
	 * @return
	 */
	public double getCurrentPosition() {
		return SensorVal;
	}

	/**
	 * This calculates PID
	 * 
	 * @return PID output
	 */
	private double Compute() {
		/*Kp = SmartDashboard.getNumber("Kp Encoder");
		Ki = SmartDashboard.getNumber("Ki Encoder");
		Kd = SmartDashboard.getNumber("Kd Encoder");*/
		error = Math.abs(getDesiredPosition() - SensorVal);// make sure abs works
		P_Val = error;
		I_Val = Math4587.limit(I_Val, Lower_Limit, Upper_Limit);
		I_Val += (error); // maybe times ki
		D_Val = error - pidLastError;// D calc
		pidLastError = error;	
		outputDrive = P_Val * Kp + I_Val * Ki + D_Val * Kd;
		if (getCurrentPosition() < getDesiredPosition() - tolerance)
			return Math4587.limit(outputDrive, Lower_Limit, Upper_Limit);
		else if (getCurrentPosition() > getDesiredPosition() + tolerance)
			return -Math4587.limit(outputDrive, Lower_Limit, Upper_Limit);
		else
			return 0;
	}

	public boolean isEnabled() {
		return this.enable;
	}

	public void disable() {
		System.out.println("disabling");
		this.enable = false;
	}
	public void enable(){
		System.out.println("Enabling");
		this.enable = true;
	}
	/**
	 * Allow use to enable and disable PID. Use this for the Motor output... For
	 * example: exampleMotor.set(Output())
	 * 
	 * @param Enable
	 * @return Output of Motor
	 */
	public double Output() {
		double Motor_Val = enable ? Compute() : 0;
		return Motor_Val;
	}
	/**
	 * Let the user know if the PID controller is in the tolerance range
	 * 
	 * @return
	 */
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}

	/**
	 * For Debugging...
	 * 
	 * @return
	 */
	public boolean onTarget() {
		return Math4587.withinThreshold(Math.abs(this.desiredPosition - SensorVal), tolerance);
	}
	public void resetPID() {
		disable();
		error = 0;
		this.pidLastError = 0;
		outputDrive = 0;
	}

	
}