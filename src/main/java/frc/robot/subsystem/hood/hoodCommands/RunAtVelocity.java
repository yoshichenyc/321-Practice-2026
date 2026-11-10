package frc.robot.subsystem.hood.hoodCommands;

import static edu.wpi.first.units.Units.Volts;

import java.util.function.Supplier;

import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.hood.Hood;
import frc.robot.subsystem.hood.HoodConstants;

public class RunAtVelocity extends Command{
    Hood hood;
    Supplier<Voltage> voltage;

    public RunAtVelocity(Hood hood, Supplier<Voltage> voltage) {
        this.hood = hood;
        this.voltage = voltage;
        addRequirements(hood);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        hood.setVoltage(HoodConstants.kHomingVoltage);
    }

    @Override
    public boolean isFinished() {
       return hood.atHomedPosition();
    }

    @Override
    public void end(boolean interrupted) {
       // hood.zeroEncoder();
        hood.setVoltage(Volts.of(0));
    }
}