package frc.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
public class OperatorInterface implements InterfaceOI {
    public OperatorInterface() {
        drivetrainController = new Joystick(0);
    }
    public double getDrivetrainForward(){
        return drivetrainController.getRawAxis(1);
    }
    public double getDrivetrainRotate(){
        return drivetrainController.getRawAxis(4);
    }
}
