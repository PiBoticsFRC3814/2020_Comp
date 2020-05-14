/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class IntakeMaintain extends SubsystemBase {
  /**
   * Creates a new IntakeBalls.
   */
  WPI_TalonSRX frontIndex;
  WPI_TalonSRX rearIndex;
  WPI_TalonSRX mecanumIntake;
  WPI_TalonSRX mecanumBackIntake;
  WPI_TalonSRX liftIntake;

  DigitalInput lowerIntake;
  DigitalInput upperIntake;

  public IntakeMaintain() {
    frontIndex = new WPI_TalonSRX(Constants.frontIntake);
    rearIndex = new WPI_TalonSRX(Constants.rearIntake);
    mecanumIntake = new WPI_TalonSRX(Constants.mecanumIntake);
    mecanumBackIntake = new WPI_TalonSRX(Constants.mecanumBackIntake);
    liftIntake = new WPI_TalonSRX(Constants.liftIntake);

    lowerIntake = new DigitalInput(Constants.lowerInput);
    upperIntake = new DigitalInput(Constants.upperInput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeOn(){
    rearIndex.set(-Constants.ballIntakeSpeed);
    frontIndex.set(Constants.ballIntakeSpeed);
  }

  public void intakeOff(){
    rearIndex.set(0.0);
    frontIndex.set(0.0);
    mecanumIntake.set(0.0);
    mecanumBackIntake.set(0.0);
  }
  public void intakeReverse(){
    rearIndex.set(Constants.ballIntakeSpeed/2);
    frontIndex.set(-Constants.ballIntakeSpeed/2);
    mecanumBackIntake.set(-Constants.mecanumIntakeSpeed/2);
  }
  
  public void autoIntake(){
    if (!upperIntake.get())
    {
      mecanumIntake.set(Constants.mecanumIntakeSpeed);
      mecanumIntake.set(Constants.mecanumIntakeSpeed);
      if (!lowerIntake.get())
      {
        intakeOn();
      }
      else
      {
        intakeOff();
      }
    }
    else 
    {
      intakeOff();
    }
  }

  public void intakeDown(){
    liftIntake.set(-Constants.liftIntakeSpeed);
  }

  public void intakeUp(){
    liftIntake.set(Constants.liftIntakeSpeed);
  }
}
