package frc.robot.subsystems;

import frc.robot.hardware.drivetrainHardwareOI;


public class drivetrain {
    private drivetrainHardwareOI hardware;
    private static final double converterConst = -3.752;
    public drivetrain(drivetrainHardwareOI hardware){
        this.hardware = hardware;
    }

    public double capInput(double min, double max, double val){
        if(val < min){
            val = min;
        }
        if(val > max){
            val = max;
        }
        return val;
    }

    public void ArcadeDrive(double forward, double rotate){
        double leftSidePower = capInput(-1., 1, rotate + forward);
        double rightSidePower = capInput(-1., 1, forward - rotate);
        hardware.setLeftSidePower(leftSidePower);
        hardware.setRightSidePower(rightSidePower);
    }
    public void resetEncoders() {
        hardware.resetEncoderPos();
    }

    public double getEncoderPos() {
        return (hardware.getLeftEncoderPosition() + hardware.getRightEncoderPosition()) / 2;
    }

    public double getDistTravelled() {        
        double currentPos = getEncoderPos();
        return convertEncoderPosToCm(currentPos);
    }

    // public void resetGyro() {
    //     hardware.resetGyro()
    // }

    // public double getAngle() {
    //     //System.out.println("OFFSET: " + offsetAngle);
    
    // }

    // public double getHeading() {
    //     return hardware.getAngle() % 360.;
    // }

    private double convertEncoderPosToCm(double encoderPos){
        double convertedDist = encoderPos / converterConst;
        return convertedDist;

    }
}
