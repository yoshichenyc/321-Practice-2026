package frc.robot.subsystem.pivot;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

public class Pivot {
    public Pivot() {
        configureMotors();
    }
    
    TalonFX pivotMotor = new TalonFX(PivotConstants.kMotorID);
    final CurrentLimitsConfigs currentLimitsConfigs = 
        new CurrentLimitsConfigs()
        .withSupplyCurrentLimit(PivotConstants.kSupplyCurrentLimit)
        .withSupplyCurrentLimitEnable(PivotConstants.kSupplyLimitEnabled)
        .withStatorCurrentLimit(PivotConstants.kSupplyCurrentLimit)
        .withStatorCurrentLimitEnable(PivotConstants.kSupplyLimitEnabled);
    final MotorOutputConfigs motoroutputConfigs =
        new MotorOutputConfigs()
        .withInverted(PivotConstants.kInversion)
        .withNeutralMode(PivotConstants.kNeutralMode);
    final FeedbackConfigs feedbackConfigs =
        new FeedbackConfigs()
        .withSensorToMechanismRatio(PivotConstants.kGearRatio);
    final TalonFXConfiguration motorConfigs =
        new TalonFXConfiguration()
        .withCurrentLimits(currentLimitsConfigs)
        .withMotorOutput(motoroutputConfigs)
        .withFeedback(feedbackConfigs);
    private void configureMotors() {
        pivotMotor.getConfigurator().apply(motorConfigs);
    }


}
