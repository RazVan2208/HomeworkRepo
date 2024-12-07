package frc.robot.hardware;

public interface drivetrainHardwareOI {
    public void setLeftSidePower(double val);

    public void setRightSidePower(double val);

    public double getLeftEncoderPosition();

    public double getRightEncoderPosition();

    public void resetEncoderPos();

}
