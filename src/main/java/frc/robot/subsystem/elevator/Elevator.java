package frc.robot.subsystem.elevator;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

public class Elevator {
    public Elevator() {
        configureMotors();
    }

    TalonFX elevatorMotor = new TalonFX(ElevatorConstants.kMotorID);
    final CurrentLimitsConfigs currentLimitsConfigs =
        new CurrentLimitsConfigs()
        .withSupplyCurrentLimit(ElevatorConstants.kSupplyCurrentLimit)
        .withSupplyCurrentLimitEnable(ElevatorConstants.kSupplyLimitEnabled)
        .withStatorCurrentLimit(ElevatorConstants.kSupplyCurrentLimit)
        .withStatorCurrentLimitEnable(ElevatorConstants.kSupplyLimitEnabled);

    final MotorOutputConfigs motoroutputConfigs = 
        new MotorOutputConfigs()
        .withInverted(ElevatorConstants.kInversion)
        .withNeutralMode(ElevatorConstants.kNeutralMode);

    final FeedbackConfigs feedbackConfigs =
        new FeedbackConfigs()
        .withSensorToMechanismRatio(ElevatorConstants.kGearRatio);

    final TalonFXConfiguration motorConfigs =
        new TalonFXConfiguration()
        .withCurrentLimits(currentLimitsConfigs)
        .withMotorOutput(motoroutputConfigs)
        .withFeedback(feedbackConfigs);
        
    private void configureMotors() {
        elevatorMotor.getConfigurator().apply(motorConfigs);
    }
}

