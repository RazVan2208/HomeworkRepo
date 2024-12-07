package frc.robot.Oi;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInterface implements OperatorInterfaceOI {
    private Joystick operatorController;
    private Joystick driverController;
    public OperatorInterface(){
        operatorController = new Joystick(0);
        driverController = new Joystick(1);
    }

    public double getControllerDrive(){
        return driverController.getRawAxis(1);
    }

    public double getControllerRotate(){
        return driverController.getRawAxis(1);
    }

    public boolean pidArmButtom(){
        return false;
    }
    //it'll happen eventually

    public boolean pidSecondTierButtom(){
        return false;
    }

    public double controllerOpenLoopArmPower(){
        return operatorController.getRawAxis(1);
    }

    public double controllerOpenLoopIntakePower(){
        return operatorController.getRawAxis(3);
    }

    
    
}
