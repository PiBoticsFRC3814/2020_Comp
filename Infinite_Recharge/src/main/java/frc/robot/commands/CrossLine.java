/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Timer;

public class CrossLine extends CommandBase {
  
  public Timer Timeguy; 
  private final DriveTrain m_crossline;

  /**
   * Creates a new CrossLine.
   */
  public CrossLine(DriveTrain m_drivetrain) {
    Timeguy = new Timer();
    m_crossline = m_drivetrain;
    addRequirements(m_crossline);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Timeguy.reset();
    Timeguy.start();
    m_crossline.Drive(0.0, 0.0, false);
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_crossline.Drive(-0.4, 0.0, false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_crossline.Drive(0.0, 0.0, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Timeguy.get() > 1.5){
    m_crossline.Drive(0.0, 0.0, false);
    return true;
    }else{
      return false;
    }
  }
}
