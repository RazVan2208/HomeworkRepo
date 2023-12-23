package frc.robot.hardware;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SPI;
public class DrivetrainHardware implements InterfaceDrivetrainHardware{
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
    
}
