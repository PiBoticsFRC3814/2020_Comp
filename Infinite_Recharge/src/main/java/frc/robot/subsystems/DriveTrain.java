/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.*;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private static final WPI_TalonSRX lf = new WPI_TalonSRX(Constants.lf);
  private static final WPI_TalonSRX lr = new WPI_TalonSRX(Constants.lr);
  private static final WPI_TalonSRX rf = new WPI_TalonSRX(Constants.rf);
  private static final WPI_TalonSRX rr = new WPI_TalonSRX(Constants.rr);


  private static final MecanumDrive piboticsdrive = new MecanumDrive(lf, lr, rf, rr);

  public DriveTrain() {
    lf.setInverted(false);
    lr.setInverted(false);
    rf.setInverted(false);
    rr.setInverted(false);
  }

  public void Drive(double y, double x, double z, double gyro) {
    piboticsdrive.driveCartesian(-x, y, z, gyro);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
