package org.usfirst.frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends CommandBase {
	double howLong;
	int autoLoopCounter = 0;
    public DriveStraight(double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	this.howLong = seconds;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
   	SmartDashboard.putString("Active Command", "Drive Straight");
   	gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.driveRobot(1, 0, 0, gyro.getAngle());
    	autoLoopCounter++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(autoLoopCounter > howLong) {
    	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}