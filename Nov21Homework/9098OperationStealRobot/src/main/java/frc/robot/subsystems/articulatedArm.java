package frc.robot.subsystems;
import frc.robot.hardware.armHardwareOI;
import java.math.*;


public class articulatedArm {
    private final static double ENCODERPOS_ATNINETY = -90.5;
    private final static double ENCODERPOS_ATzero = -200.7;
    private final double EXTREME_VAL_MIN = 10;
    private final double EXTREME_VAL_MAX = 133;
    private final double ACCEPTABLE_RANGE_OF_ANGLE = 10;
    private final double kP = 0.0002; // test value, no way to test it
    private final double k_Force_Gravity = 0.000098; // again no way to test it, but yes its 98 bc of gravity 9.8 (just for fun no logic)
    
    private armHardwareOI armHardware;
    public articulatedArm(armHardwareOI armHardware){
        this.armHardware = armHardware;
    }

    public void setOpenLoopIntakePower(double val){
        armHardware.setBottomIntakePower(val);
        armHardware.setTopIntakePower(val);
    }
    
    public void setOpenLoopArmPower(double val){
        armHardware.setOpenLoopArmPower(val);
    }

    public double currentEncoderPosition(){
        return armHardware.getArmEncoderPos();
    }
    private double convertEncoderPosToAngle(double currentEncoderPosition){
        double angleEquivalent = 0;
        double m = (90 / (ENCODERPOS_ATNINETY - ENCODERPOS_ATzero));
        double b = -(m*ENCODERPOS_ATzero);
        angleEquivalent = (m*currentEncoderPosition) + b;
        return angleEquivalent;
    }

    public double getCurrentAngle(){
        double currentAngle = convertEncoderPosToAngle(currentEncoderPosition());
        return currentAngle;
    }
    public void articulatedArmMovement(double desiredAngle){

        double currentAngle = getCurrentAngle();
        double error = desiredAngle - currentAngle;
        double feedFwdVal = Math.cos(Math.toRadians(currentAngle)) * k_Force_Gravity;
        if(Math.abs(error) <= ACCEPTABLE_RANGE_OF_ANGLE){
            armHardware.setOpenLoopArmPower(feedFwdVal);
        } else {
            double output = (error*kP) + k_Force_Gravity;
            armHardware.setOpenLoopArmPower(output);
        }
    }
}
