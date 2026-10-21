package frc.robot.subsystem.hood;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Radians;
import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class HoodConstants{
    public static final String kRobotName = "Walter";
    public static final Angle kFeedAngle = Degrees.of(15);
    public static final Angle kStartingAngle = Degrees.of(0);
    public static final double kFeedAngleDouble = kFeedAngle.in(Degrees); //Converts kFeedAngle degrees into a Double
    public static final double kFeedAngleRadians = kFeedAngle.in(Radians);
    public static final Angle kToleranceAngle = Degrees.of(1.5);
    public static final Angle kTargetAngle = Degrees.of(30);
    public static final double kGearRatio = 142.9;
    public static final Voltage kMaxVoltage = Volts.of(12);
    public static final Current kCurrent = Amps.of(40);
    public static final Current kSupplyCurrentLimit = Amps.of(40);
    public static final boolean kSupplyLimitEnabled = true;
    public static final boolean kStatorLimitEnabled = true;
    public static final int kMotorID = 11;
    public static final InvertedValue kInversion = InvertedValue.Clockwise_Positive;
    public static final NeutralModeValue kNeutralMode = NeutralModeValue.Brake;


}