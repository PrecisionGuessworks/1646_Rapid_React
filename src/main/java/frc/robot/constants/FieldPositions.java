package frc.robot.constants;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public class FieldPositions {

    public static final Pose2d ORIGIN = new Pose2d();
    public static final Pose2d STARTING_POINT_TOUCHING_HUB_1 = new Pose2d(12.25, 23.75, new Rotation2d());
    public static final Pose2d STARTING_POINT_TOUCHING_HUB_2 = new Pose2d(16.754, 25.75, new Rotation2d());

    public static final Pose2d OPPONENT_BALL_1 = new Pose2d(3.4, 19.9, new Rotation2d());
    public static final Pose2d OPPONENT_BALL_2 = new Pose2d(16.2, 15, new Rotation2d());
    public static final Pose2d OPPONENT_BALL_3 = new Pose2d(25.5, 29.7, new Rotation2d());
    public static final Pose2d OPPONENT_BALL_4 = new Pose2d(20, 37.4, new Rotation2d());
    public static final Pose2d OPPONENT_BALL_5 = new Pose2d(6.4, 37, new Rotation2d());
    public static final Pose2d OPPONENT_BALL_6 = new Pose2d(1.3, 29.1, new Rotation2d());
    public static final Pose2d OPPONEN_TERMINAL_BALL = new Pose2d(3.84, 50.15, new Rotation2d());

    public static final Pose2d ALLIANCE_BALL_1 = new Pose2d(6, 16.5, new Rotation2d());
    public static final Pose2d ALLIANCE_BALL_2 = new Pose2d(20.6, 16.9, new Rotation2d());
    public static final Pose2d ALLIANCE_BALL_3 = new Pose2d(25.7, 24.9, new Rotation2d());
    public static final Pose2d ALLIANCE_BALL_4 = new Pose2d(23.6, 34.1, new Rotation2d());
    public static final Pose2d ALLIANCE_BALL_5 = new Pose2d(10.8, 39.1, new Rotation2d());
    public static final Pose2d ALLIANCE_BALL_6 = new Pose2d(1.4, 24.3, new Rotation2d());
    public static final Pose2d ALLIANCE_TERMINAL_BALL = new Pose2d(23.6, 3.85, new Rotation2d());  

    public static final double DIST_CENTER_TO_INTAKE = 2.25;
    
    public static Pose2d addRotation(Pose2d pos, Rotation2d rotation){
        return new Pose2d(pos.getTranslation(), rotation);
    }

    public static Pose2d pointAtIntake(Pose2d pos){
        double x = pos.getTranslation().getX();
        double y = pos.getTranslation().getY();
        double heading = pos.getRotation().getRadians();
        return new Pose2d(x - DIST_CENTER_TO_INTAKE*Math.cos(heading), y - DIST_CENTER_TO_INTAKE*Math.sin(heading), pos.getRotation());
    }

}

