/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */

  private WPI_TalonSRX m_motor;
  public boolean shootable = false;
  public double tempSpeed = 0.85;

  public Shooter() {
     // initialize motor
     m_motor = new WPI_TalonSRX(Constants.shooterMotor);
 
   }
  public void WheelsOn(double speed) {
    //temporary stuff;
    //tempSpeed=SmartDashboard.getNumber("SetPoint", 0.0);
    
    //normal stuff
    //m_motor.set(-tempSpeed);
    m_motor.set(-speed);
    //SmartDashboard.putNumber("SetPoint", tempSpeed);
  }
  public void WheelsOff() {
    m_motor.set(0.0);
  }
  public boolean maxRPM() {
    return shootable;
    //returns if the RPM is at proper speed
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
