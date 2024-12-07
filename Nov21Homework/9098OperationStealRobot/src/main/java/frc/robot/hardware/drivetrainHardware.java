package frc.robot.hardware;
import java.net.CacheRequest;
import frc.robot.hardware.drivetrainHardwareOI;
import com.revrobotics.CANSparkMax;
import com.revrobotics.REVLibError;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;


import edu.wpi.first.wpilibj.CAN;
import frc.robot.RobotMap;
public class drivetrainHardware implements drivetrainHardwareOI {
    private CANSparkMax leftFront;
    private CANSparkMax leftBack;
    private CANSparkMax rightFront;
    private CANSparkMax rightBack;
    private RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;

    public drivetrainHardware(){
        leftFront = new CANSparkMax(RobotMap.Drive_Left1_CAN_ID, MotorType.kBrushless);
        leftBack = new CANSparkMax(RobotMap.Drive_Left2_CAN_ID, MotorType.kBrushless);
        rightFront = new CANSparkMax(RobotMap.Drive_Right1_CAN_ID, MotorType.kBrushless);
        rightBack = new CANSparkMax(RobotMap.Drive_Right2_CAN_ID, MotorType.kBrushless);
        leftEncoder = leftBack.getEncoder();
        rightEncoder = rightBack.getEncoder();
    }

    @Override
    public void setLeftSidePower(double val){
        leftFront.set(val);
        leftBack.set(val);
    }

    @Override
    public void setRightSidePower(double val){
        rightFront.set(val);
        rightBack.set(val);
    }

    @Override
    public double getLeftEncoderPosition(){
        return leftEncoder.getPosition();
    }

     @Override
    public double getRightEncoderPosition(){
        return rightEncoder.getPosition();
    }

    @Override 
    public void resetEncoderPos(){
        REVLibError reset1 = leftEncoder.setPosition(0.);
        REVLibError reset2 = leftEncoder.setPosition(0.);
        
    }

}
