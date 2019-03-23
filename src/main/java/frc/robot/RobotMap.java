/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {  
  /* 
   * ***********************
   * G R T J A V A . C O M *
   * ***********************
   */

  // DIO
  public static int dAsansorEncoderA = 8;
  public static int dAsansorEncoderB = 9;
  public static int dAngleEncoderA = 0;
  public static int dAngleEncoderB = 1;
  public static int dLimit = 6;
  // PWM
  public static int pLeftMotor1 = 1;
  public static int pLeftMotor2 = 2;
  public static int pRightMotor1 = 3;
  public static int pRightMotor2 = 7;
  public static int pRedLine1 = 5;
  public static int pRedLine2 = 6;
  // CAN
  public static int cUpper = 0;
  public static int cAngle = 1;
  // SOLENOID
  public static int sPanelSinir = 3;
  public static int sPanel = 2;
  public static int sTop = 4;
  public static int sClimbFront = 1;
  public static int sClimbBack = 0;
  // USB
  public static int pDriveJoystick = 0;
  public static int pCoJoystick = 1;
  // SPEED
  public static double sDriveSpeed = 0.5;
  public static double sDriveDownSpeed = 0.3;
  public static double sDriveUpSpeed = 1;
  public static double sUpperUpSpeed = 1;
  public static double sUpperDownSpeed = -0.6;
  public static double sUpperLockSpeed = 0.05;
  public static double sUpperLimitUp = 0.7;
  public static double sUpperLimitDown = -0.35;
  public static double sAngleLockSpeed = 0.05;
  public static double sGetRedLine1 = 0.5; //1
  public static double sPushRedLine1 = -0.9; // -5
  public static double sGetRedLine2 = -0.5; // -1
  public static double sPushRedLine2 = 0.9; // 5
  public static double sStop = 0;
  // VALUE SENSORS
  public static double vUpperEncoderRate = 1000;
  public static double vAngleEncoderRate = 1000;
  // ENCODER LEVELS VALUE
  public static double eTop1e1 = 30;
  public static double eTop1e2 = 32;
  public static double eTop2e1 = 67;
  public static double eTop2e2 = 69;
  public static double eTop3e1 = 87;
  public static double eTop3e2 = 89;
  public static double ePanel1e1 = 13;
  public static double ePanel1e2 = 15;
  public static double ePanel2e1 = 52;
  public static double ePanel2e2 = 54;
  public static double ePanel3e1 = 86;
  public static double ePanel3e2 = 88;
}
