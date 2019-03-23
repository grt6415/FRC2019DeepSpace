/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoPanel extends CommandGroup {
  /**
   * Add your docs here.
   */
  public AutoPanel() {
    addSequential(new AutoRotate(0.1,0));   // 90 dereceye don
    addSequential(new AutoDrive(2,1));    // rampadan in duz
    addSequential(new AutoRotate(1.5,4));   // 45 don
    addSequential(new AutoDrive(1.1,1));  // duz git rokete
    addSequential(new Zaman(1));          // 1 saniye panel yapistir
    addSequential(new AutoDrive(0.5,2));  // geri cik roketten
    addSequential(new AutoRotate(1.5,2));   // 90 dereceye don
    addSequential(new AutoRotate(0,0)); // sifirla gyro
    addSequential(new AutoRotate(1.5,4));   // 45 dereceye don
    addSequential(new AutoDrive(1,1));  // duvara git
    addSequential(new AutoRotate(0.1,0)); // sifirla gyro
    addSequential(new AutoRotate(1.5,4));   // humana 45 don
    addSequential(new AutoDrive(1,1));  // duz git rokete
    addSequential(new AutoDrive(1,1));  // duz git rokete
  }
}
