// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants.ArmConstants.ArmPosition;
import frc.robot.subsystems.Arm.ArmSubsystem;

public class PositionArmState extends CommandBase {
  ArmSubsystem arm = ArmSubsystem.getInstance();
  ArmPosition position;


  public PositionArmState(ArmPosition position) {
    addRequirements(arm);
    this.position = position;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (position == ArmPosition.HIGH){
      arm.setPower(0.4); 
    } else if (position == ArmPosition.LOW){
      arm.setPower(-0.25);
    }
    

  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
