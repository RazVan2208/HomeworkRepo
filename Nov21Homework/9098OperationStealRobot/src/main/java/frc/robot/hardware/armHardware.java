package frc.robot.hardware;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVLibError;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;

public class armHardware implements armHardwareOI{
    
    private CANSparkMax intakeTop;
    private CANSparkMax intakeBottom;
    private CANSparkMax articulatedArm;

    private RelativeEncoder intakeBottomEncoder;
    private Encoder intakeTopEncoder;
    private Encoder articulatedArmEncoder;

    public armHardware(){
        intakeTop = new CANSparkMax(RobotMap.Intake_Top_CAN_ID, MotorType.kBrushed);
        intakeBottom = new CANSparkMax(RobotMap.Intake_Bottom_CAN_ID, MotorType.kBrushless);
        articulatedArm = new CANSparkMax(RobotMap.Intake_Arm_CAN_ID, MotorType.kBrushed);
        intakeBottomEncoder = intakeBottom.getEncoder();
        intakeTopEncoder = new Encoder(0,1, false, Encoder.EncodingType.k4X);
        articulatedArmEncoder = new Encoder(2,3, false, Encoder.EncodingType.k4X);

    }

    @Override
    public void setBottomIntakePower(double val){
        intakeBottom.set(val);
    }

    @Override
    public void setTopIntakePower(double val){
        intakeTop.set(val);
    }

    @Override
    public void setOpenLoopArmPower(double val){
        articulatedArm.set(val);
    }

    @Override
    public double getIntakeBottomEncoderPos(){
        return intakeBottomEncoder.getPosition();
    }

    @Override
    public double getIntakeTopEncoderPos(){
        return intakeTopEncoder.getRaw();
    }

    @Override
    public double getArmEncoderPos(){
        return articulatedArmEncoder.getRaw();
    }

     @Override
    public void resetEncoderPos(){
        REVLibError reset1 = intakeBottomEncoder.setPosition(0.);
        intakeTopEncoder.reset();
        articulatedArmEncoder.reset();
    }

    
}
