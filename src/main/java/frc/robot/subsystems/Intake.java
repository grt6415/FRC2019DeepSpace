/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeJoystick;

public class Intake extends Subsystem {
  /* 
   * ***********************
   * G R T J A V A . C O M *
   * ***********************
   */
  Spark RedLine1;
  Spark RedLine2;
  VictorSPX Angle;
  Solenoid panel_sinir_piston;
  Solenoid panel_piston;
  Solenoid top_piston;
  public Intake(){
    RedLine1 = new Spark(RobotMap.pRedLine1);
    RedLine2 = new Spark(RobotMap.pRedLine2);
    Angle = new VictorSPX(RobotMap.cAngle);
    panel_sinir_piston = new Solenoid(RobotMap.sPanelSinir);
    panel_piston = new Solenoid(RobotMap.sPanel);
    top_piston = new Solenoid(RobotMap.sTop);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeJoystick());
  }
  public void setTamponPanel(){
    if(panel_sinir_piston.get()){
      panel_sinir_piston.set(false);
    }else{
      panel_sinir_piston.set(true);
    }
  }
  public void setTop(){
    if(top_piston.get()){
      top_piston.set(false);
    }else{
      top_piston.set(true);
    }
  }
  public void setPanel(){
    if(panel_piston.get()){
      panel_piston.set(false);
    }else{
      panel_piston.set(true);
    }
  }
  public void setAngle(double value){
    if(value > 0.1 || value < -0.1){
      Angle.set(ControlMode.PercentOutput, -value);
    }else{
      Angle.set(ControlMode.PercentOutput, RobotMap.sAngleLockSpeed);
    }
    // fren gerekmez ise
    ///Angle.set(ControlMode.PercentOutput, value);
  }
  public void getBall(Button al,Button at){
    if(al.get()){
      RedLine1.set(RobotMap.sGetRedLine1);
      RedLine2.set(RobotMap.sGetRedLine2);
    }else if(at.get()){
      RedLine1.set(RobotMap.sPushRedLine1);
      RedLine2.set(RobotMap.sPushRedLine2);
    }else{
      RedLine1.set(RobotMap.sStop);
      RedLine2.set(RobotMap.sStop);
    }
  }
}
