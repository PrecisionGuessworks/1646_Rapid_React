// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.lib.Controllers;

public class manualArmState extends CommandBase {
  
  public ArmSubsystem arm;

  public manualArmState(ArmSubsystem arm) {
    this.arm = arm;
    addRequirements(arm);
  }

  @Override
  public void execute() {
    double power = 0.3 * Controllers.getOperatorController().getRawAxis(Controllers.PS4_Controller.Axis.LEFT_STICK_Y);
    //The motor initially stalls when rising, so I'm giving it extra power to raise up at the point in time
    if (power > 0.0 && arm.getPosition() < 10000){
      power *= 3;
    }
    arm.setPower(power);
  }

}
