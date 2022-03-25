// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain;

import javax.swing.plaf.synth.SynthCheckBoxMenuItemUI;

import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;
import frc.robot.constants.Constants.DriveConstants;
import frc.robot.lib.PIDConfig;
import frc.robot.lib.TalonFXFactory;

public class DrivetrainSubsystem extends SubsystemBase {
  
  private TalonFX frontRightMotor, topRightMotor, backRightMotor;
  private TalonFX frontLeftMotor, topLeftMotor, backLeftMotor; 
  private SlewRateLimiter throtteLimiter;

  private static DrivetrainSubsystem instance;

  private DrivetrainSubsystem() {
    frontLeftMotor = TalonFXFactory.makeTalonFX(RobotMap.FRONT_LEFT_MOTOR_ID, TalonFXInvertType.CounterClockwise, new PIDConfig(0.51, 0.0, 0.3, 0.0));
    topLeftMotor = TalonFXFactory.makeFollowerTalonFX(RobotMap.TOP_LEFT_MOTOR_ID, frontLeftMotor);
    backLeftMotor = TalonFXFactory.makeFollowerTalonFX(RobotMap.BACK_LEFT_MOTOR_ID, frontLeftMotor);

    frontRightMotor = TalonFXFactory.makeTalonFX(RobotMap.FRONT_RIGHT_MOTOR_ID, TalonFXInvertType.Clockwise, new PIDConfig(0.51, 0.0, 0.3, 0.0));
    topRightMotor = TalonFXFactory.makeFollowerTalonFX(RobotMap.TOP_RIGHT_MOTOR_ID, frontRightMotor);
    backRightMotor = TalonFXFactory.makeFollowerTalonFX(RobotMap.BACK_RIGHT_MOTOR_ID, frontRightMotor);

    throtteLimiter = new SlewRateLimiter(DriveConstants.defaultSlewRate);
  }

  public static synchronized DrivetrainSubsystem getInstance(){
    if (instance == null){
      instance = new DrivetrainSubsystem();
    }
    return instance;
  }

  public void curvatureDriveWithSlewRateLimiting(double throttle, double curvature){
    double limitedThrottle = throtteLimiter.calculate(throttle);
    curvatureDrive(limitedThrottle, curvature);
  }

  public void curvatureDrive(double throttle, double curvature){
    boolean quickTurn = true;
    //We do the multiplication because we need different turning constants for 
    //quickturn verse not, but didn't have time to restructure the entire code to accont
    //for it.
    //curvature = curvature * 0.6;
    if (Math.abs(throttle) > 0.15){
      quickTurn = false;
      //curvature = curvature / 0.6;
    }
    //Note: Even though the variable is called wheel speed, this is actually for wheel powers
    WheelSpeeds wheelSpeed = DifferentialDrive.curvatureDriveIK(throttle, curvature, quickTurn);
    setPower(wheelSpeed.left, wheelSpeed.right);
  }

  public void setPower(double leftPower, double rightPower){
    frontLeftMotor.set(TalonFXControlMode.PercentOutput, leftPower);
    frontRightMotor.set(TalonFXControlMode.PercentOutput, rightPower);
  }

  public void setSpeed(double leftSpeed, double rightSpeed, double leftAccel, double rightAccel){
    frontLeftMotor.set(TalonFXControlMode.Velocity, leftSpeed * DriveConstants.feetToEncoderCounts, DemandType.ArbitraryFeedForward, DriveConstants.DRIVE_MOTOR_FEEDFOWARD.calculate(leftSpeed, leftAccel));
    frontRightMotor.set(TalonFXControlMode.Velocity, rightSpeed * DriveConstants.feetToEncoderCounts, DemandType.ArbitraryFeedForward, DriveConstants.DRIVE_MOTOR_FEEDFOWARD.calculate(rightSpeed, rightAccel));
    SmartDashboard.putNumber("Left Speed Error", leftSpeed - frontLeftMotor.getSelectedSensorVelocity()/DriveConstants.feetToEncoderCounts);
    SmartDashboard.putNumber("Right Speed Error", rightSpeed - frontRightMotor.getSelectedSensorVelocity()/DriveConstants.feetToEncoderCounts);

  }

  public void setNeutralMode(NeutralMode neutralMode){
    frontLeftMotor.setNeutralMode(neutralMode);
    frontRightMotor.setNeutralMode(neutralMode);
    backLeftMotor.setNeutralMode(neutralMode);
    backRightMotor.setNeutralMode(neutralMode);
    topLeftMotor.setNeutralMode(neutralMode);
    topRightMotor.setNeutralMode(neutralMode);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
