// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain.states.DriveWithPower;
import frc.robot.subsystems.Intake.states.SpitOutState;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ScoreAndDriveBackwards extends SequentialCommandGroup {
  /** Creates a new ScoreAndDriveBackwards. */
  public ScoreAndDriveBackwards() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new SpitOutState().withTimeout(0.5),
      new DriveWithPower(-0.35, 0.0).withTimeout(1.5)

    );
  }
}
