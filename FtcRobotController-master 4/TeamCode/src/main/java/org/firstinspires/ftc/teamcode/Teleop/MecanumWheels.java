package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Mecanum")
public class MecanumWheels extends LinearOpMode {

    //Drive Motors
    private DcMotor LFD;//Left Front Drive
    private DcMotor LBD;//Left Back Drive
    private DcMotor RFD;//Right Front Drive
    private DcMotor RBD;//Right Back Drive

    //Arm Parts
    private DcMotor arm;
    private Servo claw;


   public final static double CLAW_HOME = 0.1;     // Starting position for claw
    public final static double CLAW_MIN_RANGE = 0.15;  // Smallest number value allowed for claw position
    public final static double CLAW_MAX_RANGE = 0.8;  // Largest number value allowed for claw position

    double clawPosition = CLAW_HOME;  // Sets safe position
    final double CLAW_SPEED = 0.7 ;  // Sets rate to move servo


    public void RunToPosition() {
        RFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void ArmRunToPosition() {
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void DriveRunToPosition() {
        RFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void ResetEncoders() {
        LFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void DriveResetEncoders() {
        LFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void ResetArmEncoder() {
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    // Send calculated power to motors
    public void Power(double Power) {
        LFD.setPower(Power);
        RFD.setPower(Power);
        LBD.setPower(Power);
        RBD.setPower(Power);
    }
    // public void Arm(int Pos1, double Power) {
    //     armR.setTargetPosition(Pos1);
    //     armR.setPower(Power);

    // }
   /* public void Arm(int Pos5) {
        armR.setTargetPosition(Pos5);
    }*/
    /*public void TelemetryN() {
        while (armR.isBusy() && LFD.isBusy() && RFD.isBusy() && LBD.isBusy() && RBD.isBusy()) {
            //telemetry.addData("EE, UU");
            telemetry.addData("Arm Encoder", armR.getCurrentPosition());
            telemetry.addData("Arm Power", "%.2f", armR.getPower());
            telemetry.update();
        }
    }
    public void TelemetryL() {
        while (armR.isBusy() && LFD.isBusy() && RFD.isBusy() && LBD.isBusy() && RBD.isBusy()) {
            telemetry.addData("Stauts", "UR MUM");
            telemetry.update();
        }
    }
    public void HoldPos(double Power) {

        armR.setPower(Power);
    }
    public void ArmPower(double Power) {

        armR.setPower(Power);
    }
    // public void ArmRuntoPsoition() {
    //     armR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    // }
    public void ArmVelocity(double Power) {

        ((DcMotorEx) armR).setVelocity(Power);
    }*/
    /*public void TelemetryM() {
        while (arm.isBusy()) {
            telemetry.addData("Stauts", "Medium Junction");
            telemetry.update();
        }
    }
    public void TelemetryHi() {
        while (arm.isBusy()) {
            telemetry.addData("Stauts", "High Junction");
            telemetry.update();
        }
    }
    public void TelemetryH() {
        while (arm.isBusy()) {
            telemetry.addData("Stauts", "Home");
            telemetry.update();
        }
    }*/

    public void StopUsingEncoders() {
        LFD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void RunUsingEncoders() {
        LFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void ArmRunUsingEncoders() {
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void ArmStopUsingEncoders() {
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void DriveRunUsingEncoders() {
        LFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void DriveStopUsingEncoders() {
        LFD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
    /*public void Touch() {
        if (touch.getState() == true) {
            telemetry.addData("Digital Touch", "Is Not Pressed");
        } else {
            // ResetArmEncoder();
            //Arm(-1);
            //ArmPower(-1);
            //ArmVelocity(100);
            //ArmRuntoPsoition();
            //Telemetry();


            telemetry.addData("Digital Touch", "Is Pressed");
        }
    }*/

    @Override
    public void runOpMode(){

        LFD  = hardwareMap.get(DcMotor.class, "left front drive");
        LBD  = hardwareMap.get(DcMotor.class, "left back drive");
        RFD = hardwareMap.get(DcMotor.class, "right front drive");
        RBD = hardwareMap.get(DcMotor.class, "right back drive");
        arm = hardwareMap.get(DcMotor.class, "arm");
        claw = hardwareMap.get(Servo.class, "claw");

        LFD.setDirection(DcMotor.Direction.REVERSE);
        LBD.setDirection(DcMotor.Direction.REVERSE);
        RFD.setDirection(DcMotor.Direction.FORWARD);
        RBD.setDirection(DcMotor.Direction.FORWARD);

        DriveStopUsingEncoders();
        ArmRunUsingEncoders();

       //claw.setPosition(CLAW_HOME);

        ResetEncoders();

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad2.x) {
                claw.setPosition(0);
            }
        else if (gamepad2.a) {
            claw.setPosition(90);
            }

        idle();
        StopUsingEncoders();



            double axial   =  (gamepad1.left_stick_y); // forward and backward
            double lateral =  (gamepad1.left_stick_x); // turning left and right
            double yaw     =  (gamepad1.right_stick_x); // strafing

            double RFPower = axial + lateral + yaw;
            double LFPower = axial - lateral - yaw;
            double LBPower = axial - lateral + yaw;
            double RBPower = axial + lateral - yaw;

            LFD.setPower(LFPower);
            RFD.setPower(RFPower);
            LBD.setPower(LBPower);
            RBD.setPower(RBPower);

            double armPower;

            ArmStopUsingEncoders();

            armPower = (1 * gamepad2.left_stick_y);

            arm.setPower(armPower);

            //Active Diagnostics
            telemetry.addData("LF Encoder:", LFD.getCurrentPosition());
            telemetry.addData("RF Encoder:", RFD.getCurrentPosition());
            telemetry.addData("LB Encoder:", LBD.getCurrentPosition());
            telemetry.addData("RB Encoder:", RBD.getCurrentPosition());
            telemetry.addData("LF Power ", "%.2f", LFPower);
            telemetry.addData("RF Power", "%.2f", RFPower);
            telemetry.addData("LB Power", "%.2f", LBPower);
            telemetry.addData("RB Power", "%.2f", RBPower);
            telemetry.addData("Arm Power", "%.2f", armPower);
        }
    }
}
