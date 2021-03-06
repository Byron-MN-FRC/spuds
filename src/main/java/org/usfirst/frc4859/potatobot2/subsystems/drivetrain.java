// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4859.potatobot2.subsystems;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.PigeonState;

import org.usfirst.frc4859.potatobot2.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class drivetrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX leftMotor = RobotMap.drivetrainLeftMotor;
    private final WPI_TalonSRX rightMotor = RobotMap.drivetrainRightMotor;
    private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void arcadedrive(Joystick stick) {
    		robotDrive.arcadeDrive(stick);
    }
    public void driveStraight(double speed) {
        PigeonIMU _pidgey = RobotMap.drivetrainPigeonIMU;
    //	robotDrive.tankDrive(speed, speed);
        PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
        PigeonIMU.FusionStatus fusionStatus = new PigeonIMU.FusionStatus();
            double [] xyz_dps = new double [3];
    /* grab some input data from Pigeon and gamepad*/
         _pidgey.getGeneralStatus(genStatus);
        _pidgey.getRawGyro(xyz_dps);
            double currentAngle = _pidgey.getFusedHeading(fusionStatus);
            boolean angleIsGood = (_pidgey.getState() == PigeonState.Ready) ? true : false;
            double currentAngularRate = xyz_dps[2];
        RobotMap.drivetrainLeftMotor.set(-speed);
        RobotMap.drivetrainRightMotor.set(speed);

    }
}

