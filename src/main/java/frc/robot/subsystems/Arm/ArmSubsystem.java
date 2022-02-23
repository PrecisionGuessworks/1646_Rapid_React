// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.RobotMap;
import frc.robot.lib.TalonFXFactory;

public class ArmSubsystem extends SubsystemBase {

  private static ArmSubsystem instance;
  private TalonFX armMotor;

  private ArmSubsystem() {
    armMotor = TalonFXFactory.makeTalonFX(RobotMap.ARM_MOTOR_ID); 

    armMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);

    armMotor.setInverted(TalonFXInvertType.CounterClockwise);
    armMotor.setNeutralMode(NeutralMode.Brake);
  }

  public static ArmSubsystem getInstance(){
    if (instance == null){
      instance = new ArmSubsystem();
    }
    return instance;
  }

  public void setPower(double power){
    if (power > 0.0 && getPosition() > Constants.ArmConstants.UPPER_LIMIT){
      armMotor.set(ControlMode.PercentOutput, 0.0);
    }else if(power < 0.0 && getPosition() < Constants.ArmConstants.LOWER_LIMIT){
      armMotor.set(ControlMode.PercentOutput, 0.0);
    }else{
      armMotor.set(ControlMode.PercentOutput, power);
    }
    
  }

  public void setPosition(double position){
    armMotor.set(ControlMode.Position, position);
  }

  public double getPosition(){
    return armMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
