package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@TeleOp(name ="secondary")
public class TELEOP extends LinearOpMode {
    public DcMotor right;
    public DcMotor left;
    public Servo claw;
    @Override
    public void runOpMode() {
        right = hardwareMap.get(DcMotor.class, "rightDrive");
        left = hardwareMap.get(DcMotor.class, "leftDrive");
        claw = hardwareMap.get(Servo.class, "claw");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.a) {
                claw.setPosition(0);
            }
                else if (gamepad1.b); {
                    claw.setPosition(90);
                }
                    else if (gamepad1.x) {
                    claw.setPosition(145);
                    }
                       else if (gamepad1.y) {
                            claw.setPosition(190);
                        }

                    double rightPower;
                    double leftPower;
                    double forwardRight = (0.5 * gamepad1.right_stick_y);
                    double forwardLeft = (0.5 * gamepad1.right_stick_y);

                    rightPower = forwardRight;
                    leftPower = forwardLeft;

                    right.setPower(rightPower);
                    left.setPower(leftPower);
            }
        }

    }