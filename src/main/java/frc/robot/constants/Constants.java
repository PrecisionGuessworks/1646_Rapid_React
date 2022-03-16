// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import edu.wpi.first.math.trajectory.TrajectoryConfig;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants{
        public static final double THROTTLE_SCALER = 0.6;
        public static final double ROTATION_SCALE = 0.2;

        public static final TrajectoryConfig  DRIVE_CONFIG = new TrajectoryConfig(10, 5);

        public static final double MAX_SPEED = 15;
        public static final double MAX_ACCEL = 15;

        public static final double kS = 0.61746;
        public static final double kV = 0.7228;
        public static final double kA = 0.19154;

        public static final double feetToEncoderCounts = 12 //inches per foot
                                                        / 18.85// wheel rotations per inch
                                                        * 10.86 //output shaft rotations per wheel rotation
                                                        * 2048 //Encoder Counts per output shaft rotations
                                                        / 10; //Convert 100 Millsecond to seconds
        
    }

    public final class IntakeConstants {
        public static final double PULL_IN_POWER = 0.9;
        public static final double SPIT_OUT_POWER = -0.9;
    }

    public static final class ArmConstants {
        public static final double UPPER_LIMIT = 45000.0;//-7846.0;
        public static final double LOWER_LIMIT = 1000.0;//-53587.0;

        public static final double HOLD_DOWN_POWER = -0.13;

        public static enum ArmPosition{
            LOW, HIGH
        }


    }
}
