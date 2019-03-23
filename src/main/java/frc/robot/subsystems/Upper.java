/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.UpperJoystick;

public class Upper extends Subsystem {
  /* 
   * ***********************
   * G R T J A V A . C O M *
   * ***********************
   */
  VictorSPX asansor;
  DigitalInput limit;
  int rate;
  public Upper(){
    asansor = new VictorSPX(RobotMap.cUpper);
    limit = new DigitalInput(RobotMap.dLimit);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new UpperJoystick());
  }
  boolean top1 = false;
  boolean top2 = false;
  boolean top3 = false;
  boolean gear1 = false;
  boolean gear2 = false;
  boolean gear3 = false;
  boolean dur = false;
  double ivme = 0.4;
  public void setUpper(Button up, Button down, Button kBall,Button kGear,POVButton kLv1,POVButton kLv2, POVButton kLv3){
    SmartDashboard.putBoolean("Limit",limit.get());
    rate = Robot.encodersystem.get();
    if(limit.get()){
      Robot.encodersystem.reset();
      rate = Robot.encodersystem.get();
    }
    if(up.get()){
      dur = false;
      if(rate >= 90){
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperLimitUp);
      }else{
        ivme = ivme + 0.01;
        if(ivme >= 1){
          asansor.set(ControlMode.PercentOutput, 1);
        }else{
          asansor.set(ControlMode.PercentOutput, ivme);
        }
      }
    }else if(down.get()){
      dur = false;
      if(limit.get() || rate < 6){
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperLimitDown);
      }else{
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperDownSpeed);
      }
    }else if(kBall.get() && kLv1.get()){
      // encoder active
      top1 = true;
      dur = false;
    }else if(kBall.get() && kLv2.get()){
      top2 = true;
      dur = false;
    }else if(kBall.get() && kLv3.get()){
      top3 = true;
      dur = false;
    }else if(kGear.get() && kLv1.get()){
      gear1 = true;
      dur = false;
    }else if(kGear.get() && kLv2.get()){
      gear2 = true;
      dur = false;
    }else if(kGear.get() && kLv3.get()){
      gear3 = true;
      dur = false;
    }else{
      ivme = 0.4;
    }
    if(!down.get() && !up.get() && !top1 && !top2 && !top3 && !gear1 && !gear2 && !gear3){
      dur = true;
    }
    if(top1){
      if(rate >= RobotMap.eTop1e1 && rate < RobotMap.eTop1e2){
        top1 = false;
        dur = true;
      }else if(rate >= RobotMap.eTop1e2){
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperDownSpeed);
      }else{
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperUpSpeed);
      }
    }else if(top2){
      if(rate >= RobotMap.eTop2e1 && rate < RobotMap.eTop2e2){
        top2 = false;
        dur = true;
      }else if(rate >= RobotMap.eTop2e2){
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperDownSpeed);
      }else{
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperUpSpeed);
      }
    }else if(top3){
      if(rate >= RobotMap.eTop3e1 && rate < RobotMap.eTop3e2){
        top3 = false;
        dur = true;
      }else if(rate >= RobotMap.eTop3e2){
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperDownSpeed);
      }else{
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperUpSpeed);
      }
    }else if(gear1){
      if(rate >= RobotMap.ePanel1e1 && rate < RobotMap.ePanel1e2){
        gear1 = false;
        dur = true;
      }else if(rate >= RobotMap.ePanel1e2){
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperDownSpeed);
      }else{
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperUpSpeed);
      }
    }else if(gear2){
      if(rate >= RobotMap.ePanel2e1 && rate < RobotMap.ePanel2e2){
        gear2 = false;
        dur = true;
      }else if(rate >= RobotMap.ePanel2e2){
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperDownSpeed);
      }else{
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperUpSpeed);
      }
    }else if(gear3){
      if(rate >= RobotMap.ePanel3e1 && rate < RobotMap.ePanel3e2){
        gear3 = false;
        dur = true;
      }else if(rate >= RobotMap.ePanel3e2){
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperDownSpeed);
      }else{
        asansor.set(ControlMode.PercentOutput, RobotMap.sUpperUpSpeed);
      }
    }
    if(dur == true){
      asansor.set(ControlMode.PercentOutput, RobotMap.sUpperLockSpeed);
    }
  }
}
