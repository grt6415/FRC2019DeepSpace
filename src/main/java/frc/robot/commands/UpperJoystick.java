/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class UpperJoystick extends Command {
  /* 
   * ***********************
   * G R T J A V A . C O M *
   * ***********************
   */
  public UpperJoystick() {
    requires(Robot.upper);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.upper.setUpper(
      Robot.oi.asansor_up,
      Robot.oi.asansor_down,
      Robot.oi.kBall,
      Robot.oi.KGear,
      Robot.oi.kLv1,
      Robot.oi.kLv2,
      Robot.oi.kLv3
    );
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
