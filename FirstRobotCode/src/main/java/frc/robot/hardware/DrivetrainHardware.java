package frc.robot.hardware;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SPI;

public class DrivetrainHardware implements IDrivetrainHardware{
    private CANSparkMax left1;
    private CANSparkMax left2;
    private CANSparkMax right1;
    private CANSparkMax right2;
    private RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;
    private AHRS gyro;

    public DrivetrainHardware() {
        left1 = new CANSparkMax(3, MotorType.kBrushless);
        left2 = new CANSparkMax(4, MotorType.kBrushless);
        right1 = new CANSparkMax(1, MotorType.kBrushless);
        right2 = new CANSparkMax(2, MotorType.kBrushless);
        leftEncoder = left1.getEncoder();
        rightEncoder = right2.getEncoder();
        gyro = new AHRS(SPI.Port.kMXP);
    }
    @Override
    public void setLeftSidePower(double val) {
        left1.set(-val);
        //left2.set(val); Maybe a CAN ID conflict with these ones?
    }

    @Override
    public void setRightSidePower(double val) {
        right1.set(-val);
        //right2.set(val); Maybe a CAN ID conflict with these ones?
    }

    @Override
    public double getLeftEncoderPos() {
        return leftEncoder.getPosition();
    }

    @Override
    public double getRightEncoderPos() {
        return rightEncoder.getPosition();
    }

    @Override
    public void resetEncoderPos() {
        leftEncoder.setPosition(0.);
        rightEncoder.setPosition(0.);
    }

    @Override
    public void resetGyro() {
        gyro.reset();
    }

    @Override
    public double getAngle() {
        return gyro.getAngle();
    }
}
