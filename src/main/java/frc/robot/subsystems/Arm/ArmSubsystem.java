// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.lib.TalonFXFactory;

public class ArmSubsystem extends SubsystemBase {

  private static ArmSubsystem instance;
  private TalonFX armMotor;

  private ArmSubsystem() {
    armMotor = TalonFXFactory.makeTalonFX(20); 
  }

  public static ArmSubsystem getInstance(){
    if (instance == null){
      instance = new ArmSubsystem();
    }
    return instance;
  }

  public void setPower(double power){
    armMotor.set(ControlMode.PercentOutput, power);
  }

  public void setPosition(double position){
    armMotor.set(ControlMode.Position, position);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
