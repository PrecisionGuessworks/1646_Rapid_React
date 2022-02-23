// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants.IntakeConstants;
import frc.robot.subsystems.Intake.IntakeSubsystem;

public class SpitOutState extends CommandBase {
  
  private IntakeSubsystem intake;

  public SpitOutState(IntakeSubsystem intake) {
    this.intake = intake;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
    intake.setPower(IntakeConstants.SPIT_OUT_POWER);
  }
}
