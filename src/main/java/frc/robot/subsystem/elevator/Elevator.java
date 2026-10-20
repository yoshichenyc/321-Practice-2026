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

    TalonFX elevatorMotorRight = new TalonFX(ElevatorConstants.kMotorID);
    TalonFX elevatorMotorLeft = new TalonFX(ElevatorConstants.kMotorID2);

    final CurrentLimitsConfigs currentLimitsConfigs =
        new CurrentLimitsConfigs()
        .withSupplyCurrentLimit(ElevatorConstants.kSupplyCurrentLimit)
        .withSupplyCurrentLimitEnable(ElevatorConstants.kSupplyLimitEnabled)
        .withStatorCurrentLimit(ElevatorConstants.kSupplyCurrentLimit)
        .withStatorCurrentLimitEnable(ElevatorConstants.kSupplyLimitEnabled);

    final CurrentLimitsConfigs currentLimitsConfigs2 =
        new CurrentLimitsConfigs()
        .withSupplyCurrentLimit(ElevatorConstants.kSupplyCurrentLimit)
        .withSupplyCurrentLimitEnable(ElevatorConstants.kSupplyLimitEnabled)
        .withStatorCurrentLimit(ElevatorConstants.kSupplyCurrentLimit)
        .withStatorCurrentLimitEnable(ElevatorConstants.kSupplyLimitEnabled);

    final MotorOutputConfigs motorOutputConfigsRight = 
        new MotorOutputConfigs()
        .withInverted(ElevatorConstants.kInversion)
        .withNeutralMode(ElevatorConstants.kNeutralMode);

    final MotorOutputConfigs motorOutputConfigsLeft =
        new MotorOutputConfigs()
        .withInverted(ElevatorConstants.kInversion)
        .withNeutralMode(ElevatorConstants.kNeutralMode);


    final FeedbackConfigs feedbackConfigs =
        new FeedbackConfigs()
        .withSensorToMechanismRatio(ElevatorConstants.kGearRatio);

    final TalonFXConfiguration motorConfigsRight =
        new TalonFXConfiguration()
        .withCurrentLimits(currentLimitsConfigs)
        .withMotorOutput(motorOutputConfigsRight)
        .withFeedback(feedbackConfigs);

    final TalonFXConfiguration motorConfigsLeft =
        new TalonFXConfiguration()
        .withCurrentLimits(currentLimitsConfigs)
        .withMotorOutput(motorOutputConfigsLeft)
        .withFeedback(feedbackConfigs);

    private void configureMotors() {
        elevatorMotorRight.getConfigurator().apply(motorConfigsRight);
        elevatorMotorLeft.getConfigurator().apply(motorConfigsRight);
    }
}

