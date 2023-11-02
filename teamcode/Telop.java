package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="Main", group="Competition")
public class Telop extends LinearOpMode {
    public DcMotor right;// Right Drive
    public DcMotor left;// Left Drive
    public DcMotor extendleft;// Left Arm Extension
    public DcMotor extendright;// Right Arm Extension
    public Servo arm;// Arm Servo
    public Servo elbow;// Elbow Servo
    public Servo claw;// Claw Servo
    public TouchSensor touch;// Touch Sensor
    public final static double ARM_HOME = 0;    // Starting position for arm
    public final static double CLAW_HOME = 0;    // Starting position for claw
    public final static double ELBOW_HOME = 0; // Starting position for elbow
    double armPosition = ARM_HOME;    // Sets safe position
    final double ARM_SPEED = 0.5;    // Sets rate to move the arm servo
    double Claw_Position = ARM_HOME;    // Sets safe position
    final double CLAW_SPEED = 0.5;    // Sets rate to move the claw servo
    double Elbow_Position = ELBOW_HOME; // Sets safe position
    final double ELBOW_SPEED = 0.5; // Sets rate to move the elbow servo

    @Override
    public void runOpMode() {
        //config translations
        right = hardwareMap.get(DcMotor.class, "rightDrive");//port 0 on hub (motor connections) (control hub)
        left = hardwareMap.get(DcMotor.class, "leftDrive");//port 1 on hub (motor connections) (control hub)
        extendleft = hardwareMap.get(DcMotor.class, "extendArmLeft");//port 2 on hub (motor connection) (control hub)
        extendright = hardwareMap.get(DcMotor.class, "extendArmRight");//port 3 on hub (motor connection) (control hub)
        arm = hardwareMap.get(Servo.class, "arm");//port 0 on hub (servo connections) (control hub)
        elbow = hardwareMap.get(Servo.class, "elbow");//port 2 on hub(servo connections) (control hub)
        claw = hardwareMap.get(Servo.class, "claw");
        touch = hardwareMap.get(TouchSensor.class, "sensor_touch");//port 0 on hub (digital connections) (control hub)
        //Put the servos in their home positions after pressing init on driver hub
        claw.setPosition(CLAW_HOME);// Claw Home
        arm.setPosition(ARM_HOME);// Arm Home
        elbow.setPosition(ELBOW_HOME);// Elbow Home
        telemetry.addData("Status", "Initialized");// Servo
        telemetry.addData(">", "Press Start To Scan Servo");// Servo
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {// Full start of controls
            //Servo Controls
            //GamePad 2 Non driving controls
            if (gamepad2.a) {
                claw.setPosition(0);
            }
                else if (gamepad2.b) {
                claw.setPosition(90);
            }
                    else if (gamepad2.x) {
                arm.setPosition(0);
            }
                        else if (gamepad2.y) {
                arm.setPosition(90);
            }
                            else if (gamepad2.right_bumper) {
                                elbow.setPosition(0);
                            }
                                else if (gamepad2.left_bumper) {
                                    elbow.setPosition(90);
                                }

                            else if (gamepad2.dpad_up) {
                                Claw_Position -= CLAW_HOME;
                            }
                            else if (gamepad2.dpad_down) {
                                armPosition -= ARM_HOME;
                            }
                            else if (gamepad2.dpad_left) {
                                Elbow_Position -= ELBOW_HOME;
                            }
                            idle();

                            //Motor Contols
                            //Gamepad 1 Driving controls
                            double rightPower;
                            double leftPower;
                            double forwardright = (gamepad1.left_stick_y);
                            double forwardleft = (-gamepad1.right_stick_y);
                            double extendLeft = (gamepad2.left_trigger);
                            double extendRight = (gamepad2.right_trigger);

                            //Motor Assignment After Init
                            rightPower = forwardright;
                            leftPower = forwardleft;

                            //Motor Power Assignment
                            right.setPower(rightPower);
                            left.setPower(leftPower);
                            extendleft.setPower(extendLeft);
                            extendright.setPower(extendRight);
                            //Touch Sensor
                            if (touch.isPressed()) {
                                telemetry.addData("Touch Sensor", "Is Pressed");
                            } else {
                                telemetry.addData("Touch Sensor", "Is Not Pressed");
                            }
                            telemetry.addData("Left Encoder:", left.getCurrentPosition());
                            telemetry.addData("Right Encoder:", right.getCurrentPosition());
                            telemetry.addData("Left Power:", "%.2f", leftPower);
                            telemetry.addData("Right Power:", "%.2f", rightPower);


                            telemetry.update();
                        }
                    }
                }