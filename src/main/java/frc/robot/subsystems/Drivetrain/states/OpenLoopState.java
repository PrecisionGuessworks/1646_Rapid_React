// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.lib.Controllers;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;

public class OpenLoopState extends CommandBase {

  DrivetrainSubsystem drive;

  public OpenLoopState(DrivetrainSubsystem drive) {
    this.drive = drive;
    addRequirements(drive);
  }

  @Override
  public void execute() {
    double throttle = Controllers.getDriverController().getRawAxis(Controllers.PS4_Controller.Axis.LEFT_STICK_Y);
    double rotation = Controllers.getDriverController().getRawAxis(Controllers.PS4_Controller.Axis.RIGHT_STICK_X);
    drive.curvatureDrive(throttle, rotation);
  }
}
