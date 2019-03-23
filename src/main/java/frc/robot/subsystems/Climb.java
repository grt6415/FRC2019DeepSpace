/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbWithJoystick;

/**
 * Add your docs here.
 */
public class Climb extends Subsystem {
  Solenoid climbFront;
  Solenoid climbBack;
  public Climb(){
    climbFront = new Solenoid(RobotMap.sClimbFront);
    climbBack = new Solenoid(RobotMap.sClimbBack);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ClimbWithJoystick());
  }
  public void ClimbActive(Button climbFront, Button climbBack){
    if(climbFront.get()){
      this.climbFront.set(true);
    }else{
      this.climbFront.set(false);
    }
    if(climbBack.get()){
      this.climbBack.set(true);
    }else{
      this.climbBack.set(false);
    }
  }
}
