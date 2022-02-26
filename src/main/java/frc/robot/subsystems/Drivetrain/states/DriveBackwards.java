// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;

public class DriveBackwards extends CommandBase {
  DrivetrainSubsystem drive = DrivetrainSubsystem.getInstance();
  public DriveBackwards() {
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    drive.curvatureDrive(0.5, 0);
  }

}
