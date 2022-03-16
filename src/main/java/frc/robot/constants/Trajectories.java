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
    public static Pose2d end2 = new Pose2d(18, 0, new Rotation2d(Math.PI/10));


    public static List<Pose2d> testTrajectoryWaypoints = List.of(start, end);
    public static List<Pose2d> test2Points = List.of(end, end2);
    public static Trajectory test = TrajectoryGenerator.generateTrajectory(testTrajectoryWaypoints, DriveConstants.DRIVE_CONFIG);
    public static Trajectory test2 = TrajectoryGenerator.generateTrajectory(test2Points, DriveConstants.DRIVE_CONFIG);



    public static List<Pose2d> Start2toBall3PointList = List.of(new Pose2d(FieldPositions.STARTING_POINT_TOUCHING_HUB_2, new Rotation2d(3/5*Math.PI)),
                                                        new Pose2d(FieldPositions.ALLIANCE_BALL_2, new Rotation2d(Math.PI)));
    public static Trajectory Start2toBall3 = TrajectoryGenerator.generateTrajectory(Start2toBall3PointList, DriveConstants.DRIVE_CONFIG);

}
