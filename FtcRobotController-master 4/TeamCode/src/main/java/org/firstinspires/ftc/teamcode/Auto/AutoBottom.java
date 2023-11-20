package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class AutoBottom extends LinearOpMode {

    private DcMotor LBD;
    private DcMotor LFD;
    private DcMotor RBD;
    private DcMotor RFD;

    private DcMotor arm;
    private Servo claw;

    public void StopUsingEncoders() {
        LFD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void SetTargetPos(int pos1, int pos2, int pos3, int pos4) {
        LFD.setTargetPosition(pos1);
        LBD.setTargetPosition(pos2);
        RFD.setTargetPosition(pos3);
        RBD.setTargetPosition(pos4);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void RunUsingEncoders() {
        LFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void RunToPosition() {
        RFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void ArmRuntoPsoition() {
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void DriveRunToPosition() {
        RFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void ResetEncoders() {
        RFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void ResetDriveEncoders() {
        RFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void ArmResetEncoders() {
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void Power(double Power) {
        LFD.setPower(Power);
        LBD.setPower(Power);
        RFD.setPower(Power);
        RBD.setPower(Power);
    }

    public void ArmPower(double Power) {
        arm.setPower(Power);
    }

    public void Arm(int Pos5) {
        arm.setTargetPosition(Pos5);
    }

    public void MDrive(int Pos1, int Pos2, int Pos3, int Pos4) {
        LFD.setTargetPosition(Pos1);
        RFD.setTargetPosition(Pos2);
        LBD.setTargetPosition(Pos3);
        RBD.setTargetPosition(Pos4);
    }

    public void Drive(int Pos1, int Pos2) {
        LFD.setTargetPosition(Pos1);
        RFD.setTargetPosition(Pos2);
        LBD.setTargetPosition(Pos1);
        RBD.setTargetPosition(Pos2);
    }

    public void Velocity(double Power) {
        ((DcMotorEx) LFD).setVelocity(Power);
        ((DcMotorEx) LBD).setVelocity(Power);
        ((DcMotorEx) RFD).setVelocity(Power);
        ((DcMotorEx) RBD).setVelocity(Power);
    }

    public void ArmVelocity(double Power) {
        ((DcMotorEx) arm).setVelocity(Power);
    }

    public void Velocity2() {
        ((DcMotorEx) LFD).setVelocity(2500);
        ((DcMotorEx) LBD).setVelocity(2500);
        ((DcMotorEx) RFD).setVelocity(2500);
        ((DcMotorEx) RBD).setVelocity(2500);
    }

    /*public void ArmVelocity2() {
        ((DcMotorEx) armR).setVelocity(10000);
    }

    public void TelemetryL() {
        while (armR.isBusy()) {
            telemetry.addData("Stauts", "Low Junction");
            telemetry.update();
        }
    }

    public void TelemetryM() {
        while (armR.isBusy()) {
            telemetry.addData("Stauts", "Medium Junction");
            telemetry.update();
        }
    }

    public void TelemetryHi() {
        while (armR.isBusy()) {
            telemetry.addData("Stauts", "High Junction");
            telemetry.update();
        }
    }

    public void TelemetryH() {
        while (armR.isBusy()) {
            telemetry.addData("Stauts", "Home");
            telemetry.update();
        }
    }*/

    public void Telemetry() {
        while (opModeIsActive() && LFD.isBusy()) {   //leftMotor.getCurrentPosition() < leftMotor.getTargetPosition())
            telemetry.addData("encoder-fwd-left", LFD.getCurrentPosition() + "  busy=" + LFD.isBusy());
            telemetry.addData("encoder-fwd-right", RFD.getCurrentPosition() + "  busy=" + RFD.isBusy());
            telemetry.addData("encoder-bwd-left", LBD.getCurrentPosition() + "  busy=" + LBD.isBusy());
            telemetry.addData("encoder-bwd-right", RBD.getCurrentPosition() + "  busy=" + RBD.isBusy());
            telemetry.addData("encoder-arm", arm.getCurrentPosition() + "  busy=" + arm.isBusy());
            telemetry.update();
            idle();
        }
    }

    public void Telemetry2() {
        while (opModeIsActive() && LFD.isBusy()) {   //leftMotor.getCurrentPosition() < leftMotor.getTargetPosition())
            telemetry.addData("encoder-fwd-left", LFD.getCurrentPosition() + "  busy=" + LFD.isBusy());
            telemetry.addData("encoder-fwd-right", RFD.getCurrentPosition() + "  busy=" + RFD.isBusy());
            telemetry.addData("encoder-bwd-left", LBD.getCurrentPosition() + "  busy=" + LBD.isBusy());
            telemetry.addData("encoder-bwd-right", RBD.getCurrentPosition() + "  busy=" + RBD.isBusy());
            telemetry.addData("encoder-arm", arm.getCurrentPosition() + "  busy=" + arm.isBusy());
            telemetry.update();
            idle();
        }
    }



    @Override
    public void runOpMode() {

        LFD  = hardwareMap.get(DcMotor.class, "left front drive");
        LBD  = hardwareMap.get(DcMotor.class, "left back drive");
        RFD = hardwareMap.get(DcMotor.class, "right front drive");
        RBD = hardwareMap.get(DcMotor.class, "right back drive");
        arm = hardwareMap.get(DcMotor.class, "arm");

        LFD.setDirection(DcMotor.Direction.REVERSE);
        LBD.setDirection(DcMotor.Direction.REVERSE);
        RFD.setDirection(DcMotor.Direction.FORWARD);
        RBD.setDirection(DcMotor.Direction.FORWARD);

        LFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.addData(">", "Press Start to scan Servo.");
        telemetry.update();


        ResetEncoders();
        RunUsingEncoders();

        Telemetry();
        Telemetry2();

        waitForStart();

        while (opModeIsActive()){
            SetTargetPos(1000, 1000, 1000, 1000);
            RunToPosition();
            Power(0.5);
            sleep(5000);

            ResetEncoders();

            Drive(-5000, 5000);
            RunToPosition();
            Power(0.5);
            sleep(500);

            ResetEncoders();

            SetTargetPos(2000, 2000, 2000, 2000);
            RunToPosition();
            Power(0.5);
            sleep(2000);

            ResetEncoders();

            stop();
        }
    }
}
