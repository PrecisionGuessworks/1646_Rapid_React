// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain;

import javax.swing.plaf.synth.SynthCheckBoxMenuItemUI;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;
import frc.robot.lib.PIDConfig;
import frc.robot.lib.TalonFXFactory;

public class DrivetrainSubsystem extends SubsystemBase {
  
  private TalonFX frontRightMotor, topRightMotor, backRightMotor;
  private TalonFX frontLeftMotor, topLeftMotor, backLeftMotor; 

  private static DrivetrainSubsystem instance;

  private DrivetrainSubsystem() {
    frontLeftMotor = TalonFXFactory.makeTalonFX(RobotMap.FRONT_LEFT_MOTOR_ID, TalonFXInvertType.CounterClockwise, new PIDConfig(0.0, 0.0, 0.0, 0.0));
    topLeftMotor = TalonFXFactory.makeFollowerTalonFX(RobotMap.TOP_LEFT_MOTOR_ID, frontLeftMotor);
    backLeftMotor = TalonFXFactory.makeFollowerTalonFX(RobotMap.BACK_LEFT_MOTOR_ID, frontLeftMotor);

    frontRightMotor = TalonFXFactory.makeTalonFX(RobotMap.FRONT_RIGHT_MOTOR_ID, TalonFXInvertType.Clockwise, new PIDConfig(0.0, 0.0, 0.0, 0.0));
    topRightMotor = TalonFXFactory.makeFollowerTalonFX(RobotMap.TOP_RIGHT_MOTOR_ID, frontRightMotor);
    backRightMotor = TalonFXFactory.makeFollowerTalonFX(RobotMap.BACK_RIGHT_MOTOR_ID, frontRightMotor);
  }

  public static synchronized DrivetrainSubsystem getInstance(){
    if (instance == null){
      instance = new DrivetrainSubsystem();
    }
    return instance;
  }

  public void setPower(double leftPower, double rightPower){
    frontLeftMotor.set(TalonFXControlMode.PercentOutput, leftPower);
    frontRightMotor.set(TalonFXControlMode.PercentOutput, rightPower);
  }

  public void curvatureDrive(double throttle, double rotation){
    boolean quickTurn = true;
    if (throttle > 0.15){
      quickTurn = false;
    }
    //Note: Even though the variable is called wheel speed, this is actually for wheel powers
    WheelSpeeds wheelSpeed = DifferentialDrive.curvatureDriveIK(throttle, rotation, quickTurn);
    setPower(wheelSpeed.left, wheelSpeed.right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
