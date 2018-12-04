/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.DriveSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class WCDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX rightOne;
  private TalonSRX rightTwo;
  private TalonSRX rightThree;
  private TalonSRX leftOne;
  private TalonSRX leftTwo;
  private TalonSRX leftThree;
  public ControlMode controlMode = ControlMode.PercentOutput;

  public WCDriveSubsystem(){
    rightOne = new TalonSRX(0);
    rightTwo = new TalonSRX(1);
    rightThree = new TalonSRX(2);
    leftOne = new TalonSRX(3);
    leftTwo = new TalonSRX(4);
    leftThree = new TalonSRX(5);

  }

  public void setLeftMotors(double speed) {
    leftOne.set(controlMode, speed);
    leftTwo.set(controlMode, speed);
    leftThree.set(controlMode, speed);
  }

  public void setRightMotors(double speed) {
    rightOne.set(controlMode, speed);
    rightTwo.set(controlMode, speed);
    rightThree.set(controlMode, speed);
  }
  

  @Override
  public void initDefaultCommand() {
    this.setDefaultCommand(new DriveCommand());
  }
}
