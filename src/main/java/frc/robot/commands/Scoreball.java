// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.constants.Constants.ArmConstants.ArmPosition;
import frc.robot.subsystems.Arm.states.PositionArmState;
import frc.robot.subsystems.Intake.states.SpitOutState;


public class Scoreball extends SequentialCommandGroup {

  public Scoreball() {
    addCommands(
      new PositionArmState(ArmPosition.HIGH).withTimeout(2), 
      new SpitOutState().withTimeout(1),
      new PositionArmState(ArmPosition.LOW)
    );
  }
}
