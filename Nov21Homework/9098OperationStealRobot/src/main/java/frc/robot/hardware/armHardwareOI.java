package frc.robot.hardware;

public interface armHardwareOI {
    public void setBottomIntakePower(double val);

    public void setTopIntakePower(double val);

    public void setOpenLoopArmPower(double val);

    public double getIntakeBottomEncoderPos();

    public double getIntakeTopEncoderPos();
    
    public double getArmEncoderPos();

    public void resetEncoderPos();


}
