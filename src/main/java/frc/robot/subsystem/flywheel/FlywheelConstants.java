package frc.robot.subsystem.flywheel;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;

public class FlywheelConstants {
   
    public static final double kGearRatio = 142.9;
    public static final Voltage kMaxVoltage = Volts.of(12);
    public static final Current kCurrent = Amps.of(40);
    public static final Current kSupplyCurrentLimit = Amps.of(40);
    public static final boolean kSupplyLimitEnabled = true;
    public static final boolean kStatoLimitEnabled = true;
    public static final int kMotorID = 11;
    public static final int kMotorID2 = 12;
    public static final InvertedValue kInversion = InvertedValue.Clockwise_Positive;
    public static final NeutralModeValue kNeutralMode = NeutralModeValue.Brake;
}