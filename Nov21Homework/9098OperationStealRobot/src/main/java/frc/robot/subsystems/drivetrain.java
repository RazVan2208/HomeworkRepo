package frc.robot.subsystems;

import frc.robot.hardware.drivetrainHardwareOI;


public class drivetrain {
    private drivetrainHardwareOI hardware;
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
        
    }
}
