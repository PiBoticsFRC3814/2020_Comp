/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;

public class PiboticsDrive extends CommandBase {
  /**
   * Creates a new PiboticsDrive.
   */
  private final DriveTrain m_drivetrain;
  private final DoubleSupplier m_x;
  private final DoubleSupplier m_y;
  private final DoubleSupplier m_z;
  private final DoubleSupplier m_gyro;

  public PiboticsDrive(DoubleSupplier y, DoubleSupplier x, DoubleSupplier z, DoubleSupplier gyro, DriveTrain piboticsdrive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = piboticsdrive;
    m_x = x;
    m_y = y;
    m_z = z;
    m_gyro = gyro;
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x, y, z;
    if (m_x.getAsDouble() > Constants.deadzoneX || m_x.getAsDouble() < Constants.deadzoneX)
    {
      x = m_x.getAsDouble(); 

      if (x < 0.0)
      {
        x = x + Constants.deadzoneX;
      }
      if (x > 0.0)
      {
        x = x - Constants.deadzoneX;
      }

    }
    else x = 0.0;
    
    if (m_y.getAsDouble() > Constants.deadzoneY || m_y.getAsDouble() < Constants.deadzoneY)
    {
      y = m_y.getAsDouble(); 

      if (y < 0.0)
      {
        y = y + Constants.deadzoneY;
      }
      if (y > 0.0)
      {
        y = y - Constants.deadzoneY;
      }

    }
    else y = 0.0;

    if (m_z.getAsDouble() > Constants.deadzoneZ || m_z.getAsDouble() < Constants.deadzoneZ)
    {
      z = m_z.getAsDouble(); 

      if (z < 0.0)
      {
        z = z + Constants.deadzoneZ;
      }
      if (z > 0.0)
      {
        z = z - Constants.deadzoneZ;
      }

    }
    else z = 0.0;
    

    m_drivetrain.Drive(y, x, z, m_gyro.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
