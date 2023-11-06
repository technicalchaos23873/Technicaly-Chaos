package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="Main", group="Competition")
public class Telop extends LinearOpMode {
    //Drive Motors
    public DcMotor right;// Right Drive (Ultra Planetary Gear Box)
    public DcMotor left;// Left Drive (Ultra Planetary Gear Box)
    //Arm Motors And Servo
    public DcMotor arm;// Arm Motor (Core Hex Servo)
    public Servo elbow;// Elbow Servo (Axon Servo)
    public Servo claw;// Claw Servo (Smart Robot Servo)
    //Sensors
    public TouchSensor touch;// Touch Sensor
    private ColorSensor color;// Color Sensor
    //Home Positions
    public final static double CLAW_HOME = 0;    // Starting position for claw
    public final static double ELBOW_HOME = 0; // Starting position for elbow
    double Claw_Position = CLAW_HOME; // Sets Safe Position
    final double CLAW_SPEED = 0.5;    // Sets rate to move the claw servo
    double Elbow_Position = ELBOW_HOME; // Sets safe position
    final double ELBOW_SPEED = 0.5; // Sets rate to move the elbow servo

    @Override
    public void runOpMode() {
        //Config Translations
        right = hardwareMap.get(DcMotor.class, "rightDrive");//port 0 on hub (motor connections) (control hub)
        left = hardwareMap.get(DcMotor.class, "leftDrive");//port 1 on hub (motor connections) (control hub)
        arm = hardwareMap.get(DcMotor.class, "arm");//port 2 on hub (motor connections) (control hub)
        elbow = hardwareMap.get(Servo.class, "elbow");//port 0 on hub(servo connections) (control hub)
        claw = hardwareMap.get(Servo.class, "claw");//port 1 on hub(servo connections) (control hub)
        touch = hardwareMap.get(TouchSensor.class, "sensor_touch");//port 0 on hub (digital connections) (control hub)
        color = hardwareMap.get(ColorSensor.class, "color");//port 0 on hub (I2C channel) (control hub)
        //Put the servos in their home positions after pressing init on driver hub
        claw.setPosition(CLAW_HOME);// Claw Home
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
                            else if (gamepad2.right_bumper) {
                                elbow.setPosition(0);
                            }
                                else if (gamepad2.left_bumper) {
                                    elbow.setPosition(90);
                                }
                            else if (gamepad2.dpad_down) {
                                Elbow_Position -= ELBOW_HOME;
                            }
                            else if (gamepad2.dpad_up) {
                                Claw_Position -= CLAW_HOME;
            }
                            idle();

                            //Motor Contols
                            //Gamepad 1 Driving controls
                            double rightPower;
                            double leftPower;
                            double armPower;
                            double forwardright = (gamepad1.left_stick_y);
                            double forwardleft = (-gamepad1.right_stick_y);
                            double armMove = (gamepad2.left_stick_x);

                            idle();

                            //Motor Assignment After Init
                            rightPower = forwardright;
                            leftPower = forwardleft;
                            armPower = armMove;

                            //Motor Power Assignment
                            right.setPower(rightPower);
                            left.setPower(leftPower);
                            arm.setPower(armPower);
                            //Touch Sensor
                            if (touch.isPressed()) {
                                telemetry.addData("Touch Sensor", "Is Pressed");
                            } else {
                                telemetry.addData("Touch Sensor", "Is Not Pressed");
                            }

                            idle();

                            //Telem Stuffs
                            telemetry.addData("Left Encoder:", left.getCurrentPosition());
                            telemetry.addData("Right Encoder:", right.getCurrentPosition());
                            telemetry.addData("Arm Encoder", arm.getCurrentPosition());
                            telemetry.addData("Left Power:", "%.2f", leftPower);
                            telemetry.addData("Right Power:", "%.2f", rightPower);
                            telemetry.addData("Arm Power", "%.2f", armPower);
                            telemetry.addData("Color", "%1.0f", color.argb());

                            idle();


                            telemetry.update();
                        }
                    }
                }