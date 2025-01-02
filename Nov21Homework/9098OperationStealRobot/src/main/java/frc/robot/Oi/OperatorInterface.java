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

    public boolean armOpenLoopButton(){
        return operatorController.getRawButton(0);
    }

     public boolean intakeOpenLoopButton(){
        return operatorController.getRawButton(1);
    }

    public double controllerOpenLoopArm(){
        return operatorController.getRawAxis(1);
    }

    public double controllerOpenLoopIntake(){
        return operatorController.getRawAxis(3);
    }

    public boolean deployArticulatedIntake(){
        return operatorController.getRawButton(2);
    }

    public boolean outtakeFirstTier(){
        return operatorController.getRawButton(3);
    }
    
    public boolean outtakeSecondTier(){
        return operatorController.getRawButton(4);
    }
    
}
