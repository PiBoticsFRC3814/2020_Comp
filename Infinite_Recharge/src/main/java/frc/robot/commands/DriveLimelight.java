/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.DriveTrain;

public class DriveLimelight extends CommandBase {
  /**
   * Creates a new LimeLight.
/** */
  Limelight m_LimeLight;
  DriveTrain m_PiboticsDrive;
  double xs, ys, zs;
  public DriveLimelight(DriveTrain piboticsdrive, Limelight LimeLight) {
    m_PiboticsDrive = piboticsdrive;
    m_LimeLight = LimeLight;
    addRequirements(m_PiboticsDrive);
    addRequirements(m_LimeLight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_LimeLight.getData();
    SmartDashboard.putBoolean("Target Acquired", m_LimeLight.isValidTarget());
    if (m_LimeLight.x > 1)
    {
      xs = -0.3;
    }
    else if (m_LimeLight.x < -1)
    {
      xs = 0.3;
    }
    else
    {
      xs = 0;
    }

    if (m_LimeLight.yaw > 2)
    {
      ys = 0.1;
    }
    else if (m_LimeLight.yaw < -2)
    {
      ys = -0.1;
    }
    else
    {
      ys = 0;
    }
    
    if (m_LimeLight.z < -20)
    {
      zs = -0.2;
    }
    else if (m_LimeLight.z > -22)
    {
      zs = 0.2;
    }
    else
    {
      zs = 0;
    }

    m_PiboticsDrive.Drive(zs, ys);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_LimeLight.isValidTarget())
    {
      return false;
    }
    else
    {
      return true;
    }
  }
}