/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.cmdDriveXbox;

//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class driveSystem extends Subsystem {
  private final WPI_TalonSRX frontLeftMotor = RobotMap.driveSystemfrontLeftMotor;
  private final WPI_TalonSRX frontRightMotor = RobotMap.driveSystemfrontRightMotor;
  private final WPI_TalonSRX backLeftMotor = RobotMap.driveSystembackLeftMotor;
  private final WPI_TalonSRX backRightMotor = RobotMap.driveSystembackRightMotor;
  double deadZone = 0.15; 

  boolean invert = false;

  public void tankDriveXbox() {
    double left = - Robot.oi.xboxDriver.getRawAxis(1);
    double right = - Robot.oi.xboxDriver.getRawAxis(4);
    double straightTolerance = 0.5;
    if(Math.abs(left - right) <= straightTolerance){
      left = right = (left + right) / 2.0;
    }
    if(invert){
      // Invert signal
      left = - left;
      right = - right;
    }
    if(Math.abs(right)<deadZone){
        right = 0.0;
      }
      if(Math.abs(left)<deadZone) {
        left = 0.0;
      }
    Robot.driveSystem.frontRightMotor.set(right);
    frontLeftMotor.set(left);
    frontRightMotor.set(right);
      backRightMotor.set(right);
      backLeftMotor.set(left);
  }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      setDefaultCommand(new cmdDriveXbox());
    }
}