// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.hardware.*;
import frc.robot.subsystems.*;
import frc.robot.Oi.*;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String MIDDLE_AUTO = "Middle Auto";
  private static final String L_R_AUTO1 = "LEFT OR RIGHT Auto Choice 1";
  private static final String L_R_AUTO2 = "LEFT OR RIGHT Auto Choice 2";


  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  OperatorInterface oi;
  drivetrain drivetrain;
  articulatedArm arm;

  armHardwareOI armHardware;
  drivetrainHardwareOI drivetrainHardware;
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Middle Balance Auto", MIDDLE_AUTO);
    m_chooser.addOption("Shoot Preload, drive out", L_R_AUTO1);
    m_chooser.addOption("Shoot Preload, drive out, new cube, shoot load", L_R_AUTO2);
    SmartDashboard.putData("Auto choices", m_chooser);
    
    drivetrainHardware = new drivetrainHardware();
    armHardware = new armHardware();

    oi = new OperatorInterface();
    drivetrain = new drivetrain(drivetrainHardware);
    arm = new articulatedArm(armHardware);

    
    drivetrainHardware.resetEncoderPos();

 
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */

  private boolean isInAutoTime(long startTime) {
    long currentTime = System.currentTimeMillis();
    if (!isAutonomous()) return false;
    if ((currentTime - startTime) > 15000) return false;
    return true;
  }
  @Override
  public void robotPeriodic() {

    SmartDashboard.putNumber("Intake Encoder Pos:", arm.currentEncoderPosition());
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    m_autoSelected = m_chooser.getSelected();

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    drivetrain.ArcadeDrive(0, 0);
    arm.setOpenLoopArmPower(0);
    arm.setOpenLoopIntakePower(0);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    double forward = oi.getControllerDrive();
    double rotate = oi.getControllerRotate();
    drivetrain.ArcadeDrive(forward * 0.8, rotate * 0.8);


    if(oi.armOpenLoopButton()){
      arm.setOpenLoopArmPower(oi.controllerOpenLoopArm() * 0.2);
    } else if(oi.deployArticulatedIntake()){
      arm.setOpenLoopIntakePower(-1); // intake
    } 

    if(oi.intakeOpenLoopButton()){
      arm.setOpenLoopIntakePower(oi.controllerOpenLoopIntake() * 0.2);
    } else if(oi.deployArticulatedIntake()) {
      arm.articulatedArmMovement(-10); // go down and keep down
    } else {
      arm.articulatedArmMovement(-150); // go back up
    }

    if(oi.outtakeFirstTier()){
      arm.articulatedArmMovement(-30); // go not all the way down, but enough to roll cube into first tier
      arm.setOpenLoopArmPower(1); // shoot out
    } else if (oi.outtakeSecondTier()){
      arm.articulatedArmMovement(-90); // go halfway/some part down but enough to shoot into second tier
      arm.setOpenLoopArmPower(1); // shoot out
    }

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
