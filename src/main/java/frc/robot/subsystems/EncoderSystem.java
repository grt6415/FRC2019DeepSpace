/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.EncoderCommand;

public class EncoderSystem extends Subsystem {
  /* 
   * ***********************
   * G R T J A V A . C O M *
   * ***********************
   */
  Encoder asansorEncoder;
  Encoder angleEncoder;
  double enc_rate;
  double ang_rate;
  public EncoderSystem(){
    asansorEncoder = new Encoder(RobotMap.dAsansorEncoderA , RobotMap.dAsansorEncoderB);
    asansorEncoder.setReverseDirection(true);
    angleEncoder = new Encoder(RobotMap.dAngleEncoderA, RobotMap.dAngleEncoderB);
    angleEncoder.setReverseDirection(true);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new EncoderCommand());
  }
  public void insert(){
    enc_rate += asansorEncoder.getRate() / RobotMap.vUpperEncoderRate;
    ang_rate += angleEncoder.getRate() / RobotMap.vAngleEncoderRate;
    SmartDashboard.putNumber("Asansor Encoder", enc_rate);
    SmartDashboard.putNumber("Angle Encoder", ang_rate);
  }
  public int angGet(){
    return (int)ang_rate;
  }
  public void angReset(){
    angleEncoder.reset();
    ang_rate = 0;
  }
  public int get(){
    return (int)enc_rate;
  }
  public void reset(){
    asansorEncoder.reset();
    enc_rate = 0;
  }
}
