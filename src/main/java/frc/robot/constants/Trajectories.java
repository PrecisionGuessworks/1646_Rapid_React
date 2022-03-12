package frc.robot.constants;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import frc.robot.constants.Constants.DriveConstants;

public class Trajectories {
    public static Pose2d start = new Pose2d(0, 0, new Rotation2d());
    public static Pose2d end = new Pose2d(10, 10, new Rotation2d());

    public static List<Pose2d> testTrajectoryWaypoints = List.of(start, end);
    public static Trajectory test = TrajectoryGenerator.generateTrajectory(testTrajectoryWaypoints, DriveConstants.DRIVE_CONFIG);
}
