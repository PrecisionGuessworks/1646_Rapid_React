// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PathFollowingState extends CommandBase {
  DrivetrainSubsystem drive = DrivetrainSubsystem.getInstance();
  Trajectory pathToFollow;
  Timer pathTimer;

  public PathFollowingState(Trajectory pathToFollow) {
    addRequirements(drive);
    this.pathToFollow = pathToFollow;
    pathTimer = new Timer();
  }



  
  @Override
  public void initialize() {
    pathTimer.start();
  }

  @Override
  public void execute() {
    double currentTime = pathTimer.get();
    Trajectory.State currentState = pathToFollow.sample(currentTime);

    double velocity = currentState.velocityMetersPerSecond;
    double angularVelocity = currentState.curvatureRadPerMeter * velocity;

    double acceleration = currentState.accelerationMetersPerSecondSq;
    double angularAcceleration = currentState.curvatureRadPerMeter * acceleration;

    double leftSpeed = velocity + angularVelocity;
    double rightSpeed = velocity - angularVelocity;

    double leftAccel = acceleration + angularAcceleration;
    double rightAccel = acceleration - angularAcceleration;
    drive.setSpeed(leftSpeed, rightSpeed, leftAccel, rightAccel);



  }


  @Override
  public boolean isFinished() {
    return pathTimer.hasElapsed(pathToFollow.getTotalTimeSeconds());
  }
}
