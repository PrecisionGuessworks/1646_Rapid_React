// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class IntakeSubsystem extends SubsystemBase {

  private static IntakeSubsystem instance;

  private VictorSPX intakeMotor;

  private IntakeSubsystem() {
    intakeMotor = new VictorSPX(RobotMap.INTAKE_MOTOR_ID);
    
  }

  public static IntakeSubsystem getInstance(){
    if (instance == null){
      instance = new IntakeSubsystem();
    }
    return instance;
  }

  public void setPower(double power){
    intakeMotor.set(ControlMode.PercentOutput, power);

  }

  @Override
  public void periodic() {
  }
}
