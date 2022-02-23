// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import frc.robot.commands.ExampleCommand;
import frc.robot.lib.Controllers;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.subsystems.Arm.states.IdleArmState;
import frc.robot.subsystems.Arm.states.manualArmState;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;
import frc.robot.subsystems.Drivetrain.states.OpenLoopState;
import frc.robot.subsystems.Intake.IntakeSubsystem;
import frc.robot.subsystems.Intake.states.IdleState;
import frc.robot.subsystems.Intake.states.PullInState;
import frc.robot.subsystems.Intake.states.SpitOutState;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private DrivetrainSubsystem drive;
  private IntakeSubsystem intake;
  private ArmSubsystem arm;


  public RobotContainer() {
    initilizeSubsystems();
    setAllDefaultCommands();
    configureButtonBindings();
  }

  public void initilizeSubsystems(){
    drive = DrivetrainSubsystem.getInstance();
    intake = IntakeSubsystem.getInstance();
    arm = ArmSubsystem.getInstance();
  }

  public void setAllDefaultCommands(){
    setDefaultCommand(drive, new OpenLoopState());
    setDefaultCommand(intake, new IdleState(intake));
    setDefaultCommand(arm, new manualArmState());
  }

  public void setDefaultCommand(Subsystem subsystem, Command defaultCommand){
    CommandScheduler.getInstance().setDefaultCommand(subsystem, defaultCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Joystick op_joystick = Controllers.getOperatorController();

    new JoystickButton(op_joystick, Controllers.PS4_Controller.Button.X).whileHeld(new PullInState(intake));
    new JoystickButton(op_joystick, Controllers.PS4_Controller.Button.TRIANGLE).whileHeld(new SpitOutState(intake));
  }

 
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
