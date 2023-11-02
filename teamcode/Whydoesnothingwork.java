package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@Autonomous(name="i do not know what i am doing")

public class Whydoesnothingwork extends LinearOpMode {
    //Naming Stuffs
   private ColorSensor COLOR;
   private DigitalChannel TOUCH;
   private HardwareDevice WEBCAM;
   private DcMotor LD; //Left Drive
   private DcMotor RD; //Right Drive
   private DcMotor ARM;
   private Servo ELBOW;
   private Servo CLAW;

   //Servo Stuffs

    public final static double CLAW_HOME = 0.1;     //Starting Positon For Claw
    public final static double CLAW_MIN_RANGE = 0.10;      //Smallest Value For Claw Position
    public final static double CLAW_MAX_RANGE = 1;      //Largest Value For claw Position

    double clawPostion = CLAW_HOME;     //Sets Safe Position
    final double CLAW_SPEED = 0.5;  //Sets Rate To Move Servo

    public final static double ELBOW_HOME = 0.1;     //Starting Positon For Claw
    public final static double ELBOW_MIN_RANGE = 0.10;      //Smallest Value For Claw Position
    public final static double ELBOW_MAX_RANGE = 1;      //Largest Value For claw Position

    double elbowPostion = ELBOW_HOME;     //Sets Safe Position
    final double ELBOW_SPEED = 0.5;     //Sets Rate To Move Servo

    //Custom Commands

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
