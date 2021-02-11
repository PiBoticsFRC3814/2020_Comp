/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.Constants;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;




/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrain m_piboticsdrive = new DriveTrain();
  private final Shooter m_shooter = new Shooter();
  private final IntakeMaintain m_IntakeMaintain = new IntakeMaintain();
  private final Limelight m_LimeLight = new Limelight();
  private final ClimbMotor m_Climb = new ClimbMotor();
  private final BalanceMotor m_Balance = new BalanceMotor();
  private final ControlPanel m_ControlPanel = new ControlPanel();

  private final Joystick driverStick = new Joystick(Constants.oi_Driver);
  private final Joystick buttonStick = new Joystick(Constants.oi_Operator);

  private final CommandBase m_autonomousCommand = new Autonomous1(m_piboticsdrive,m_LimeLight,m_shooter,m_IntakeMaintain, gyro);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    m_piboticsdrive.setDefaultCommand(new PiboticsDrive(() -> driverStick.getY(), () -> driverStick.getX(), () -> driverStick.getZ(), () -> gyro.getAngle(), m_piboticsdrive));
    m_LimeLight.setDefaultCommand(new GetLimelight(m_LimeLight, gyro));
    m_ControlPanel.setDefaultCommand(new GrabColorData(m_ControlPanel));
    

    // Configure the button bindings
    configureButtonBindings();


  
    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //joystick buttons
    final JoystickButton LowerIntake = new JoystickButton(driverStick, 7);
    final JoystickButton UpperIntake = new JoystickButton(driverStick, 1);
    final JoystickButton AllIntake = new JoystickButton(driverStick, 8);
    final JoystickButton shooter = new JoystickButton(driverStick, 2);
    final JoystickButton LimelightMove =  new JoystickButton(driverStick, 10);
    final JoystickButton FarLimelight = new JoystickButton(driverStick, 9);
    final JoystickButton Position = new JoystickButton(driverStick, 11);
    final JoystickButton Rotation = new JoystickButton(driverStick, 12);
    final JoystickButton Outtake = new JoystickButton(driverStick, 5);

    final JoystickButton climbUp = new JoystickButton(buttonStick, 3);
    final JoystickButton climbDown = new JoystickButton(buttonStick, 1);
    final JoystickButton balanceLeft = new JoystickButton(buttonStick, 9);
    final JoystickButton balanceRight = new JoystickButton(buttonStick, 10);
    final JoystickButton ToggleLight = new JoystickButton(buttonStick, 4);




    /*final JoystickButton Intake = new JoystickButton(driverStick, 7);
    final JoystickButton shooter = new JoystickButton(driverStick, 2);
    final JoystickButton LimelightMove =  new JoystickButton(driverStick, 10);
    final JoystickButton autoIntake = new JoystickButton(driverStick, 6);
    final JoystickButton Position = new JoystickButton(driverStick, 11);
    final JoystickButton Rotation = new JoystickButton(driverStick, 12);
    //final JoystickButton gateTurn = new JoystickButton(driverStick, 9);
    final JoystickButton FarLimelight = new JoystickButton(driverStick, 9);


    //fightstick buttons
    final JoystickButton climbUp = new JoystickButton(buttonStick, 3);
    final JoystickButton climbDown = new JoystickButton(buttonStick, 1);
    final JoystickButton balanceLeft = new JoystickButton(buttonStick, 9);
    final JoystickButton balanceRight = new JoystickButton(buttonStick, 10);
    final JoystickButton ToggleLight = new JoystickButton(buttonStick, 4);
    final JoystickButton Outtake = new JoystickButton(buttonStick, 6);*/



    
    AllIntake.whenPressed(new AllIntakeOn(m_IntakeMaintain));
    AllIntake.whenReleased(new AllIntakeOff(m_IntakeMaintain));

    LowerIntake.whenPressed(new LowerIntakeOn(m_IntakeMaintain));
    LowerIntake.whenReleased(new LowerIntakeOff(m_IntakeMaintain));

    UpperIntake.whenPressed(new UpperIntakeOn(m_IntakeMaintain));
    UpperIntake.whenReleased(new UpperIntakeOff(m_IntakeMaintain));

    shooter.whenPressed(new Shoot(m_shooter));
    shooter.whenReleased(new StopShoot(m_shooter,m_LimeLight));

    climbUp.whenPressed(new ClimbUp(m_Climb));
    climbUp.whenReleased(new ClimbStop(m_Climb));
    climbDown.whenPressed(new ClimbDown(m_Climb));
    climbDown.whenReleased(new ClimbStop(m_Climb));

    balanceLeft.whenPressed(new BalanceLeft(m_Balance));
    balanceLeft.whenReleased(new StopBalance(m_Balance));
    balanceRight.whenPressed(new BalanceRight(m_Balance));
    balanceRight.whenReleased(new StopBalance(m_Balance));

    FarLimelight.whenPressed(new FarLimelight(m_piboticsdrive,m_LimeLight, gyro));
    FarLimelight.whenReleased(new GetLimelight(m_LimeLight, gyro));


    //Intake.whenPressed(new IntakeOn(m_IntakeMaintain));
    //Intake.whenReleased(new IntakeOff(m_IntakeMaintain));

    Outtake.whenPressed(new IntakeReverse(m_IntakeMaintain));
    Outtake.whenReleased(new UpperIntakeOff(m_IntakeMaintain));
    

    LimelightMove.whenPressed(new DriveLimelight(m_piboticsdrive,m_LimeLight, gyro));
    LimelightMove.whenReleased(new GetLimelight(m_LimeLight, gyro));

    //autoIntake.whenPressed(new NewIntakeOn(m_IntakeMaintain));
    //autoIntake.whenReleased(new NewIntakeOff(m_IntakeMaintain));

    Position.whenPressed(new PositionControl(m_ControlPanel));
    Position.whenReleased(new StopControlPanel(m_ControlPanel));
    Rotation.whenPressed(new RotationControl(m_ControlPanel));
    Rotation.whenReleased(new StopControlPanel(m_ControlPanel));

    ToggleLight.whenPressed(new ToggleLimelight(m_LimeLight));
    ToggleLight.whenReleased(new GetLimelight(m_LimeLight, gyro));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autonomousCommand;
  }
}
