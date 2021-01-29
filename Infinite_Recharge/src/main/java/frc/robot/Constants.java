/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
//talon IDs
    public static final int frontIntake = 10;
    public static final int rearIntake = 11;
    public static final int mecanumIntake = 12;
    public static final int mecanumBackIntake = 14;
    public static final int liftIntake = 13;
    public static final int cMotor = 40;
    public static final int bMotor = 41;
    public static final int leftDrive = 1;
    public static final int blMotor = 50;
    public static final int rightDrive = 2;
    public static final int ControlPanelMotor = 30;
    public static final int shooterMotor = 60;
//Digital Input IDs
    public static final int lowerInput = 1;
    public static final int upperInput = 2;

//pneumatic IDs
    public static final int PCM1 = 0;
    public static final int frontExtend = 0;
    public static final int frontRetract = 1;
    public static final int rearExtend = 2;
    public static final int rearRetract = 3;

//motor Speeds
    public static final double ballIntakeSpeed = 0.75;
    public static final double mecanumIntakeSpeed = 0.75;
    public static final double liftIntakeSpeed = 0.5;
    public static final double upSpeed = 1.0;
    public static final double downSpeed = -1.0;
    public static final double leftSpeed = 1;
    public static final double rightSpeed = -1;
    public static final double gateSpeed = 0.1;
    public static final double gateReverse = -0.1;
    public static final double shooterSpeed = 0.85;

//Controller IDs
    public static final int oi_Driver = 0;
    public static final int oi_Operator = 2;
//Limelight Constants
    public static final double lHeight = 35.5;
    public static final double tHeight = 90;
    public static final double llAngle = 18;

    //short firing range
    public static final double shortLowest = 107;
    public static final double shortFarthest = 127;
    //far firing range
    public static final double farLowest = 184;
    public static final double farFarthest = 204;
}
