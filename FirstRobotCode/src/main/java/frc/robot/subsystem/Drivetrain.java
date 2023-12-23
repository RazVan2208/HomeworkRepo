package frc.robot.subsystem;

import frc.robot.hardware.IDrivetrainHardware;


public class Drivetrain {
    private IDrivetrainHardware hardware;

    public Drivetrain(IDrivetrainHardware hardware) {
        this.hardware = hardware;
    }
    private double cap(double val, double min, double max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    public void arcadeDrive(double forward, double rotate) {
        double leftSidePower = cap(forward + rotate, -1., 1.);
        double rightSidePower = cap(forward - rotate, -1., 1.);
        hardware.setLeftSidePower(leftSidePower);
        hardware.setRightSidePower(rightSidePower);
    }

    // public void resetEncoders() {
    //     hardware.resetEncoderPos();
    // }

    // private double getEncoderPos() {
    //     return (hardware.getLeftEncoderPos() + hardware.getRightEncoderPos()) / 2;
    // }

    // public double getDistTravelled() {
    //     double encoderPos = getEncoderPos();
    //     // Do some math to figure out the actual distance.
    //     double distTravelled = encoderPos;
    //     return distTravelled;
    // }

    // public void resetGyro() {
    //     hardware.resetGyro();
    // }

    // public double getAngle() {
    //     return hardware.getAngle();
    // }

    // public double getHeading() {
    //     return hardware.getAngle() % 360.;
    // }
}
