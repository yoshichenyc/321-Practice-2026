package frc.robot.subsystem.flywheel;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

public class Flywheel {
    public Flywheel() {
        configureMotors();
    }
       TalonFX flywheelMotor = new TalonFX(FlywheelConstants.kMotorID);
    
    final CurrentLimitsConfigs currentLimitsConfigs = 
            new CurrentLimitsConfigs()
            .withSupplyCurrentLimit(FlywheelConstants.kSupplyCurrentLimit)
            .withSupplyCurrentLimitEnable(FlywheelConstants.kSupplyLimitEnabled)
            .withStatorCurrentLimit(FlywheelConstants.kSupplyCurrentLimit)
            .withStatorCurrentLimitEnable(FlywheelConstants.kSupplyLimitEnabled);

    final MotorOutputConfigs motoroutputConfigs = 
            new MotorOutputConfigs()
            .withInverted(FlywheelConstants.kInversion)
            .withNeutralMode(FlywheelConstants.kNeutralMode);

    final FeedbackConfigs feedbackConfigs =
            new FeedbackConfigs()
            .withSensorToMechanismRatio(FlywheelConstants.kGearRatio);

    final TalonFXConfiguration motorConfigs =
            new TalonFXConfiguration()
            .withCurrentLimits(currentLimitsConfigs)
            .withMotorOutput(motoroutputConfigs)
            .withFeedback(feedbackConfigs);
            
    private void configureMotors(){
        flywheelMotor.getConfigurator().apply(motorConfigs);
}
}