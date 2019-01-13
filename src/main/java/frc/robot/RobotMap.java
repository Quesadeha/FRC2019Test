/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class RobotMap {

  public static WPI_TalonSRX driveSystemfrontLeftMotor;
  public static WPI_TalonSRX driveSystemfrontRightMotor;
  public static WPI_TalonSRX driveSystembackLeftMotor;
  public static WPI_TalonSRX driveSystembackRightMotor;
  

  public static void init() {
    driveSystemfrontLeftMotor = new WPI_TalonSRX(4);
    driveSystemfrontLeftMotor.setInverted(false);
    LiveWindow.add(driveSystemfrontLeftMotor);
          
          
    driveSystemfrontRightMotor = new WPI_TalonSRX(5);
    driveSystemfrontRightMotor.setInverted(true);
    LiveWindow.add(driveSystemfrontRightMotor);
          
    driveSystembackLeftMotor = new WPI_TalonSRX(2);
    driveSystembackLeftMotor.setInverted(false);
    //driveSystembackLeftMotor.follow(driveSystemfrontLeftMotor);
    LiveWindow.add(driveSystembackLeftMotor);
          
    driveSystembackRightMotor = new WPI_TalonSRX(3);
    driveSystembackRightMotor.setInverted(true);
  }
  //driveSystembackRightMotor.follow(driveSystemfrontRightMotor);

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
