// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;

public class DriveWithPower extends CommandBase {
  DrivetrainSubsystem drive = DrivetrainSubsystem.getInstance();
  double throttle, curvature;

  public DriveWithPower() {
    new DriveWithPower(0.0, 0.0);
  }

  public DriveWithPower(double throttle, double curvature){
    addRequirements(drive);
    this.throttle = throttle;
    this.curvature = curvature;
  }

  @Override
  public void initialize() {
    drive.curvatureDrive(-0.35, 0);
  }

}
