package frc.robot.subsystem.hood;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.measure.Angle;

public class Hood {
    public Hood() {
        configureMotors();
    }


    TalonFX hoodMotor = new TalonFX(HoodConstants.kMotorID);
    
    final CurrentLimitsConfigs currentLimitsConfigs = 
            new CurrentLimitsConfigs()
            .withSupplyCurrentLimit(HoodConstants.kSupplyCurrentLimit)
            .withSupplyCurrentLimitEnable(HoodConstants.kSupplyLimitEnabled)
            .withStatorCurrentLimit(HoodConstants.kSupplyCurrentLimit)
            .withStatorCurrentLimitEnable(HoodConstants.kSupplyLimitEnabled);

    final MotorOutputConfigs motoroutputConfigs = 
            new MotorOutputConfigs()
            .withInverted(HoodConstants.kInversion)
            .withNeutralMode(HoodConstants.kNeutralMode);

    final FeedbackConfigs feedbackConfigs =
            new FeedbackConfigs()
            .withSensorToMechanismRatio(HoodConstants.kGearRatio);

    final TalonFXConfiguration motorConfigs =
            new TalonFXConfiguration()
            .withCurrentLimits(currentLimitsConfigs)
            .withMotorOutput(motoroutputConfigs)
            .withFeedback(feedbackConfigs);
            
    private void configureMotors(){
        hoodMotor.getConfigurator().apply(motorConfigs);
    }
    @Logged(name = "hoodPitch")
    public Angle getAngle() {
        Angle angle = hoodMotor.getPosition().getValue();
        return angle;
 }  
    @Logged(name = "atTargetAngle")
    public boolean atTargetAngle() {
       boolean atTargetAngle = Math.abs(getAngle().in(Degrees) - HoodConstants.kTargetAngle.in(Degrees)) < HoodConstants.kToleranceAngle.in(Degrees);
        return atTargetAngle;
        }

}