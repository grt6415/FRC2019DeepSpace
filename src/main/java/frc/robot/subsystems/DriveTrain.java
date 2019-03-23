/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveJoystick;
import edu.wpi.first.wpilibj.SPI;

public class DriveTrain extends Subsystem implements PIDOutput {
  /* 
   * ***********************
   * G R T J A V A . C O M *
   * ***********************
   */
  Spark left1;
  Spark left2;
  Spark right1;
  Spark right2;

  SpeedControllerGroup left;
  SpeedControllerGroup right;

  DifferentialDrive drive;

  AHRS ahrs;
  PIDController turnController;
  double rotateToAngleRate;

  boolean mactype;
  static final double kP = 0.1; // 0.1
  static final double kI = 0.00;
  static final double kD = 0.2; // 0.2
  static final double kF = 0.03; // 0.03
  static final double kToleranceDegrees = 0.01f; // 0.01

  public DriveTrain(){
    left1 = new Spark(RobotMap.pLeftMotor1);
    left2 = new Spark(RobotMap.pLeftMotor2);
    right1 = new Spark(RobotMap.pRightMotor1);
    right2 = new Spark(RobotMap.pRightMotor2);

    left = new SpeedControllerGroup(left1, left2);
    right = new SpeedControllerGroup(right1, right2);

    drive = new DifferentialDrive(left, right);
    
    drive.setSafetyEnabled(false);

    ahrs = new AHRS(SPI.Port.kMXP);
    turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
    turnController.setInputRange(-180.0f,  180.0f);
    turnController.setOutputRange(-1.0, 1.0);
    turnController.setAbsoluteTolerance(kToleranceDegrees);
    turnController.setContinuous(true);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveJoystick());
  }
  public void AutoRotate(int type){
    boolean rotateToAngle = false;
    if(type == 0){
      ahrs.reset();
    }else if (type == 1) {
      turnController.setSetpoint(0.0f);
      rotateToAngle = true;
    }else if (type == 2) {
        turnController.setSetpoint(90.0f);
        rotateToAngle = true;
    }else if (type == 3) {
        turnController.setSetpoint(-90.0f);
        rotateToAngle = true;
    }else if (type == 4) {
      turnController.setSetpoint(45.0f);
      rotateToAngle = true;
    }else if (type == 5) {
      turnController.setSetpoint(-45.0f);
      rotateToAngle = true;
    }
    double currentRotationRate;
    if (rotateToAngle) {
        turnController.enable();
        currentRotationRate = rotateToAngleRate;
    } else {
        turnController.disable();
        currentRotationRate = 0;
    }
    drive.arcadeDrive(0, currentRotationRate);
  }
  public void AutoDrive(int type, double speed){
    if(type == 1){
      drive.arcadeDrive(speed, 0);
    }else if(type == 2){
      drive.arcadeDrive(-speed, 0);
    }else{
      drive.arcadeDrive(0, 0);
    }
  }
  boolean reset = false;
  public void DriveGyro(double y, double x,double doksan,double tersdoksan){
    SmartDashboard.putNumber("Gyros", ahrs.getAngle());
    boolean rotateToAngle = false;
    if(doksan > 0) {
      if(!reset){
        ahrs.reset();
        reset = true;
      }
      turnController.setSetpoint(90.0f);
      rotateToAngle = true;
    }else if (tersdoksan > 0) {
      if(!reset){
        ahrs.reset();
        reset = true;
      }
      turnController.setSetpoint(-90.0f);
      rotateToAngle = true;
    }else{
      reset = false;
    }
    double currentRotationRate;
    if (rotateToAngle) {
        turnController.enable();
        currentRotationRate = rotateToAngleRate;
    } else {
        turnController.disable();
        currentRotationRate = x;
    }
    drive.arcadeDrive(y, currentRotationRate);
  }
  public void Drive(double y, double x){
    drive.arcadeDrive(y, x);
  }
  public void setSpeed(Button up,Button down){
    mactype = DriverStation.getInstance().isAutonomous();
    // teleop
    
    if(up.get()){
      drive.setMaxOutput(RobotMap.sDriveUpSpeed);
    }else if(down.get()){
      drive.setMaxOutput(RobotMap.sDriveDownSpeed);
    }else{
      drive.setMaxOutput(RobotMap.sDriveSpeed);
    }
  }

  @Override
  public void pidWrite(double output) {
    rotateToAngleRate = output;
  }
}
