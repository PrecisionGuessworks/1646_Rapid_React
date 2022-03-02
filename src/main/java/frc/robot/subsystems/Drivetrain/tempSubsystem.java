// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class tempSubsystem extends SubsystemBase {
  
  private TalonFX leaderMotor, followerMotor;

  public tempSubsystem() {
    leaderMotor = new TalonFX(42);
    followerMotor = new TalonFX(87);

    followerMotor.set(ControlMode.Follower, leaderMotor.getDeviceID());
    followerMotor.setInverted(TalonFXInvertType.FollowMaster);
  }

  public void setPower(double power){
    leaderMotor.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
