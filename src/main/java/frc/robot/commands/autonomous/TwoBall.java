// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.constants.Constants.ArmConstants.ArmPosition;
import frc.robot.subsystems.Arm.states.PositionArmState;
import frc.robot.subsystems.Drivetrain.states.DriveWithPower;
import frc.robot.subsystems.Intake.states.PullInState;
import frc.robot.subsystems.Intake.states.SpitOutState;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoBall extends SequentialCommandGroup {
  /** Creates a new TwoBall. */
  public TwoBall() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      race(
        new DriveWithPower(0.35, 0).withTimeout(2.0),
        new PullInState(),
        new PositionArmState(ArmPosition.LOW)
      ),
      new DriveWithPower(0, 0.35).withTimeout(1.2),
      new PositionArmState(ArmPosition.HIGH),
      new DriveWithPower(0.35, 0).withTimeout(5.0),
      new SpitOutState().withTimeout(5.0)
    );
  }
}
