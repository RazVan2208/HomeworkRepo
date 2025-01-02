package frc.robot.Oi;

public interface OperatorInterfaceOI {
    public double getControllerDrive();

    public double getControllerRotate();

    public boolean pidArmButtom();
    //it'll happen eventually

    public double controllerOpenLoopArm();

    public double controllerOpenLoopIntake();

    public boolean armOpenLoopButton();
    
    public boolean intakeOpenLoopButton();

    public boolean outtakeFirstTier();
    
    public boolean outtakeSecondTier();
    
}
