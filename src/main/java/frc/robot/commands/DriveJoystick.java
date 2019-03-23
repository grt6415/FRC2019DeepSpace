/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveJoystick extends Command {
  /* 
   * ***********************
   * G R T J A V A . C O M *
   * ***********************
   */
  public DriveJoystick() {
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // drive gyro ( y , x , reset , sag 90 , sol 90 , geri don 0 )
    Robot.drivetrain.DriveGyro(
      -Robot.oi.driver.getY(),
      Robot.oi.driver.getX(),
      Robot.oi.driver.getRawAxis(3),
      Robot.oi.driver.getRawAxis(2)
    );
    //Robot.drivetrain.Drive(-Robot.oi.driver.getY(), Robot.oi.driver.getX());
    Robot.drivetrain.setSpeed(Robot.oi.driver_hiz, Robot.oi.driver_yavas);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
