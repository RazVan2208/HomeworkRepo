package frc.robot.Oi;

public interface OperatorInterfaceOI {
    public double getControllerDrive();

    public double getControllerRotate();

    public boolean pidArmButtom();
    //it'll happen eventually

    public boolean pidSecondTierButtom();

    public double controllerOpenLoopArmPower();

    public double controllerOpenLoopIntakePower();

    
    
}
