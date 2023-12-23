package frc.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
public class OperatorInterface implements InterfaceOI {
    private Joystick drivetrainController;
    
    public OperatorInterface() {
        drivetrainController = new Joystick(0);
    }
    @Override
    public double getDrivetrainForward(){
        return drivetrainController.getRawAxis(1);
    }
    @Override
    public double getDrivetrainRotate(){
        return drivetrainController.getRawAxis(2);
    }
}
