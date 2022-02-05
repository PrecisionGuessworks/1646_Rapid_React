// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeSubsystem extends SubsystemBase {

  private IntakeSubsystem instance;

  private VictorSPX leftIntakeMotor, rightIntakeMotor;

  private IntakeSubsystem() {
    leftIntakeMotor = new VictorSPX(RobotMap.LEFT_INTAKE_MOTOR_ID);
    rightIntakeMotor = new VictorSPX(RobotMap.RIGHT_INTAKE_MOTOR_ID);

    rightIntakeMotor.setInverted(InvertType.InvertMotorOutput);
  }

  public IntakeSubsystem getInstance(){
    if (instance == null){
      instance = new IntakeSubsystem();
    }
    return instance;
  }

  public void setPower(double power){
    leftIntakeMotor.set(ControlMode.PercentOutput, power);
    rightIntakeMotor.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
  }
}
