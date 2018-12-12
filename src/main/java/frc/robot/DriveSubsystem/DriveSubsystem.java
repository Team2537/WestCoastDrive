/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.DriveSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.input.HumanInput;

public class DriveSubsystem extends Subsystem {
  private TalonSRX right0;
  private TalonSRX right1;
  private TalonSRX right2;
  private TalonSRX left0;
  private TalonSRX left1;
  private TalonSRX left2;
  public ControlMode controlMode = ControlMode.PercentOutput;

  public DriveSubsystem() {
    left0 = new TalonSRX(0);
    left1 = new TalonSRX(1);
    left2 = new TalonSRX(2);
    right0 = new TalonSRX(3);
    right1 = new TalonSRX(4);
    right2 = new TalonSRX(5);
  }

  /**
   * Sets all 3 left motors to the same speed
   */
  public void setLeftMotors(double speed) {
    left0.set(controlMode, speed);
    left1.set(controlMode, speed);
    left2.set(controlMode, speed);
  }

  /**
   * Sets all 3 right motors to the same speed
   */
  public void setRightMotors(double speed) {
    right0.set(controlMode, -speed);
    right1.set(controlMode, -speed);
    right2.set(controlMode, -speed);
    // reverse so both sides run in same direction
  }

  /**
   * Sets an individual motor to 30% speed for testing purposes
   * 
   * @param motor Index of the motor to be tested (0-5, left motors: 0-2, right
   *              motors: 3-5)
   */
  public void motorTest(int motor) {
    switch (motor) {
    case 0:
      left0.set(controlMode, .3);
      break;
    case 1:
      left1.set(controlMode, .3);
      break;
    case 2:
      left2.set(controlMode, .3);
      break;
    case 3:
      right0.set(controlMode, .3);
      break;
    case 4:
      right1.set(controlMode, .3);
      break;
    case 5:
      right2.set(controlMode, .3);
      break;
    default:
      System.out.println("Something went wrong");
    }
  }

  public double getLeftJoysick() {
    if (Math.abs(HumanInput.leftJoystick.getRawAxis(1)) > .1)
      return HumanInput.leftJoystick.getRawAxis(1) * -1; // reverse for front orientation
    return 0;
  }

  public double getRightJoysick() {
    if (Math.abs(HumanInput.rightJoystick.getRawAxis(1)) > .1)
      return HumanInput.rightJoystick.getRawAxis(1) * -1; // reverse for front orientation
    return 0;
  }

  @Override
  public void initDefaultCommand() {
    this.setDefaultCommand(new DriveCommand());
  }
}
