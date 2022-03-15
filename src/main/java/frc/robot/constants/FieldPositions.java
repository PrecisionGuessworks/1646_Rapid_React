package frc.robot.constants;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

public class FieldPositions {

    public static final Translation2d ORIGIN = new Translation2d();
    public static final Translation2d STARTING_POINT_TOUCHING_HUB_1 = new Translation2d(23.75, 12.25);
    public static final Translation2d STARTING_POINT_TOUCHING_HUB_2 = new Translation2d(25.75, 16.754);

    public static final Translation2d OPPONENT_BALL_1 = new Translation2d(19.9, 3.4);
    public static final Translation2d OPPONENT_BALL_2 = new Translation2d(15, 16.2);
    public static final Translation2d OPPONENT_BALL_3 = new Translation2d(29.7, 25.5);
    public static final Translation2d OPPONENT_BALL_4 = new Translation2d(37.4, 20);
    public static final Translation2d OPPONENT_BALL_5 = new Translation2d(37, 6.4);
    public static final Translation2d OPPONENT_BALL_6 = new Translation2d(29.1, 1.3);
    public static final Translation2d OPPONENT_TERMINAL_BALL = new Translation2d( 50.15, 3.84);

    public static final Translation2d ALLIANCE_BALL_1 = new Translation2d(16.5, 6);
    public static final Translation2d ALLIANCE_BALL_2 = new Translation2d(16.9, 20.6);
    public static final Translation2d ALLIANCE_BALL_3 = new Translation2d(24.9, 25.7);
    public static final Translation2d ALLIANCE_BALL_4 = new Translation2d(34.1, 23.6);
    public static final Translation2d ALLIANCE_BALL_5 = new Translation2d(39.1, 10.8);
    public static final Translation2d ALLIANCE_BALL_6 = new Translation2d(24.3, 1.4);
    public static final Translation2d ALLIANCE_TERMINAL_BALL = new Translation2d(3.85, 23.6);  

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

