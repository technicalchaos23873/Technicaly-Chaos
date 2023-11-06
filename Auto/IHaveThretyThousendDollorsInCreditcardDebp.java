package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@Disabled
@Autonomous(name = "CreditCardDebt", group = "Pain")
public class IHaveThretyThousendDollorsInCreditcardDebp extends LinearOpMode {

    //Drive Motors
    private DcMotor LFD;//Left Front Drive
    private DcMotor LBD;//Left Back Drive
    private DcMotor RFD;//Right Front Drive
    private DcMotor RBD;//Right Back Drive

    //Arm Move
    private DcMotor armR;//Arm Rotate
    private Servo elbow;
    private Servo claw;

    //Sensors
    private ColorSensor color;
    private DigitalChannel touch;

    //Servo Stuffs
    public final static double CLAW_HOME = 0.1;         // Starting Position For Claw
    public final static double CLAW_MIN_RANGE = 0.15;       // Smallest Number Value Allowed For Claw Position
    private final static double CLAW_MAX_RANGE = 0.9;       //Largest Number Value Allowed For Claw Position

    double clawPosition = CLAW_HOME;        // Sets Safe Position
    final double CLAW_SPEED = 0.7;          // Sets Safe Speed To Run Servo

    public final static double ELBOW_HOME = 0.1;         // Starting Position For Claw
    public final static double ELBOW_MIN_RANGE = 0.15;       // Smallest Number Value Allowed For Claw Position
    private final static double ELBOW_MAX_RANGE = 0.9;       //Largest Number Value Allowed For Claw Position

    double elbowPosition = ELBOW_HOME;        // Sets Safe Position
    final double ELBOW_SPEED = 0.7;          // Sets Safe Speed To Run Servo

    //Custom Stuffs
    public void StopUsingEncoders() {
        LFD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void RunUsingEncoders() {
        LFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void RunToPosition() {
        RFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LFD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void ArmRuntoPsoition() {
        armR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
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
        armR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void ResetDriveEncoders() {
        RFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LFD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void ArmResetEncoders() {
        armR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void Power(double Power) {
        LFD.setPower(Power);
        LBD.setPower(Power);
        RFD.setPower(Power);
        RBD.setPower(Power);
    }

    public void ArmPower(double Power) {
        armR.setPower(Power);
    }

    public void Arm(int Pos5) {
        armR.setTargetPosition(Pos5);
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
        ((DcMotorEx) armR).setVelocity(Power);
    }

    public void Velocity2() {
        ((DcMotorEx) LFD).setVelocity(2500);
        ((DcMotorEx) LBD).setVelocity(2500);
        ((DcMotorEx) RFD).setVelocity(2500);
        ((DcMotorEx) RBD).setVelocity(2500);
    }

    public void ArmVelocity2() {
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
    }

    public void Telemetry() {
        while (opModeIsActive() && LFD.isBusy()) {   //leftMotor.getCurrentPosition() < leftMotor.getTargetPosition())
            telemetry.addData("encoder-fwd-left", LFD.getCurrentPosition() + "  busy=" + LFD.isBusy());
            telemetry.addData("encoder-fwd-right", RFD.getCurrentPosition() + "  busy=" + RFD.isBusy());
            telemetry.addData("encoder-bwd-left", LBD.getCurrentPosition() + "  busy=" + LBD.isBusy());
            telemetry.addData("encoder-bwd-right", RBD.getCurrentPosition() + "  busy=" + RBD.isBusy());
            telemetry.addData("encoder-arm", armR.getCurrentPosition() + "  busy=" + armR.isBusy());
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
            telemetry.addData("encoder-arm", armR.getCurrentPosition() + "  busy=" + armR.isBusy());
            telemetry.update();
            idle();
        }
    }

    public void Color() {
        while (opModeIsActive()) {
            //color sensor telemetry
            telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.update();

            //
            if (color.red() > color.green() && color.red() > color.blue()) {
                ResetDriveEncoders();
                MDrive(0, 0, 0, 0);
                RunToPosition();
                Velocity2();
                Power(0.3);
                Telemetry2();

                sleep(10);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(744, 744, 744, 744);
                RunToPosition();
                Velocity(2500);
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-744, -744, -744, -744);
                RunToPosition();
                Velocity(2500);
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-388, 388, -388, 388);
                RunToPosition();
                Velocity(0.5);
                Power(0.3);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(124, 124, 124, 124);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2();
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                Arm(1500);
                // ArmVelocity(8000); // Velocity(0.5);
                ArmPower(-0.4);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                claw.setPosition(CLAW_MAX_RANGE);

                sleep(100);

                ResetDriveEncoders();
                MDrive(-124, -124, -124, -124);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(2500); //1
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(388, -388, 388, -388);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(1000); //1
                Power(0.3);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(1288, 1288, 1288, 1288);
                Velocity(2500); //0.5
                Power(0.7);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(844, -844, 844, -844);
                Velocity(0.5); //0.5
                Power(0.3);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                Arm(963);  /*    563   93.91304347826087    1080   2145  180 = about 1 inch */
                ArmVelocity(8000);
                ArmPower(0.4);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                ResetDriveEncoders();
                MDrive(1000, 1000, 1000, 1000);
                Velocity(2500); //0.5
                Power(0.35);
                RunToPosition();
                Telemetry2();
                Arm(743);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
                ArmVelocity(8000);
                ArmPower(0.7);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                Power(0);

                sleep(10);

                claw.setPosition(CLAW_HOME);

                sleep(490);

                ResetDriveEncoders();
                Arm(2145);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
                MDrive(-1026, -1026, -1026, -1026);
                ArmVelocity(8000);
                Velocity(2500); //0.5
                ArmPower(0.6);
                Power(0.4);
                ArmRuntoPsoition();
                RunToPosition();
                TelemetryM();
                Telemetry2();

                sleep(300);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(1319, -1319, 1319, -1319);
                Velocity(0.5); //0.5
                Power(0.3);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-74, -74, -74, -74);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(500); //1
                Power(0.5);
                Telemetry2();

                sleep(100);

                Power(0);

                Arm(863);
                ArmVelocity(8000); // Velocity(0.5);
                ArmPower(0.6);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                claw.setPosition(CLAW_MAX_RANGE);

                sleep(250);

                Arm(2145);
                ArmVelocity(8000); //Velocity(0.5);
                ArmPower(0.6);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                ResetDriveEncoders();
                MDrive(-488, 488, -488, 488);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2(); //1
                Power(1);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-124, -124, -124, -124);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2(); //1
                Power(1);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(1332, -1332, -1332, 1332);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2(); //1
                Power(1);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);
                // ResetDriveEncoders();
                // Arm(180);
                // ArmVelocity(8000); //Velocity(0.5);
                // ArmPower(0.6);
                // ArmRuntoPsoition();
                // TelemetryM();
                // MDrive(1200, 1200, 1200, 1200);/*  1116   1 inch = 62 */
                // RunToPosition();
                // Velocity2(); //1
                // Power(1);
                // Telemetry2();

                // sleep(50);

                // Power(0);

                // sleep(50);

                // MDrive(-844, 844, -844, 844);/*  1116   1 inch = 62 */
                // RunToPosition();
                // Velocity2(); //1
                // Power(1);
                // Telemetry2();

                // sleep(50);

                // Power(0);

                sleep(1000000);

            } else if (color.green() > color.red() && color.green() > color.blue()) {
                ResetDriveEncoders();
                MDrive(0, 0, 0, 0);
                RunToPosition();
                Velocity2();
                Power(0.3);
                Telemetry2();

                sleep(10);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(744, 744, 744, 744);
                RunToPosition();
                Velocity(2500);
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-744, -744, -744, -744);
                RunToPosition();
                Velocity(2500);
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-388, 388, -388, 388);
                RunToPosition();
                Velocity(0.5);
                Power(0.3);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(124, 124, 124, 124);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2();
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                Arm(1500);
                ArmVelocity(8000); // Velocity(0.5);
                ArmPower(-0.4);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                claw.setPosition(CLAW_MAX_RANGE);

                sleep(100);

                ResetDriveEncoders();
                MDrive(-124, -124, -124, -124);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(2500); //1
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(388, -388, 388, -388);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(1000); //1
                Power(0.3);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(1288, 1288, 1288, 1288);
                Velocity(2500); //0.5
                Power(0.7);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(844, -844, 844, -844);
                Velocity(0.5); //0.5
                Power(0.3);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                Arm(963);  /*    563   93.91304347826087    1080   2145  180 = about 1 inch */
                ArmVelocity(8000);
                ArmPower(0.4);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                ResetDriveEncoders();
                MDrive(1000, 1000, 1000, 1000);
                Velocity(2500); //0.5
                Power(0.35);
                RunToPosition();
                Telemetry2();
                Arm(743);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
                ArmVelocity(8000);
                ArmPower(0.7);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                Power(0);

                sleep(10);

                claw.setPosition(CLAW_HOME);

                sleep(490);

                ResetDriveEncoders();
                Arm(2145);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
                MDrive(-1026, -1026, -1026, -1026);
                ArmVelocity(8000);
                Velocity(2500); //0.5
                ArmPower(0.6);
                Power(0.4);
                ArmRuntoPsoition();
                RunToPosition();
                TelemetryM();
                Telemetry2();

                sleep(300);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(1319, -1319, 1319, -1319);
                Velocity(0.5); //0.5
                Power(0.3);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-74, -74, -74, -74);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(500); //1
                Power(0.5);
                Telemetry2();

                sleep(100);

                Power(0);

                Arm(863);
                ArmVelocity(8000); // Velocity(0.5);
                ArmPower(0.6);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                claw.setPosition(CLAW_MAX_RANGE);

                sleep(250);

                Arm(2145);
                ArmVelocity(8000); //Velocity(0.5);
                ArmPower(0.6);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                ResetDriveEncoders();
                MDrive(-488, 488, -488, 488);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2(); //1
                Power(1);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-1332, 1332, 1332, -1332);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2(); //1
                Power(1);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);
                // ResetDriveEncoders();
                // MDrive(-1332, 1332, -1332, 1332);/*  1116   1 inch = 62 */
                // RunToPosition();
                //Velocity2(); //1
                // Power(1);
                // Telemetry2();

                // sleep(100);

                // Power(0);

                // sleep(10);

                // ResetDriveEncoders();
                // MDrive(1488, 1488, 1488, 1488);/*  1116   1 inch = 62 */
                // RunToPosition();
                //Velocity(999999); //1
                // Power(1);
                // Telemetry2();

                // sleep(100);

                // Power(0);

                // ResetDriveEncoders();
                // Arm(280);
                // ArmVelocity(8000); //Velocity(0.5);
                // ArmPower(1);
                // ArmRuntoPsoition();
                // MDrive(900, 900, 900, 900);/*  1116   1 inch = 62 */
                // RunToPosition();
                //Velocity2(); //1
                // Power(1);
                // Telemetry2();
                // TelemetryM();

                // sleep(100);

                // Power(0);

                // sleep(100);

                // ResetDriveEncoders();
                // MDrive(1044, -44, 1044, -44);/*  1116   1 inch = 62 */
                // RunToPosition();
                //Velocity2(); //1
                // Power(1);
                // Telemetry2();

                // sleep(100);

                // Power(0);

                sleep(1000000);

            } else if (color.blue() > color.green() && color.blue() > color.red()) {
                ResetDriveEncoders();
                MDrive(0, 0, 0, 0);
                RunToPosition();
                Velocity2();
                Power(0.3);
                Telemetry2();

                sleep(10);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(744, 744, 744, 744);
                RunToPosition();
                Velocity(2500);
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-744, -744, -744, -744);
                RunToPosition();
                Velocity(2500);
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-388, 388, -388, 388);
                RunToPosition();
                Velocity(0.5);
                Power(0.3);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(124, 124, 124, 124);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2();
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                Arm(1500);
                ArmVelocity(8000); // Velocity(0.5);
                ArmPower(-0.4);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                claw.setPosition(CLAW_MAX_RANGE);

                sleep(100);

                ResetDriveEncoders();
                MDrive(-124, -124, -124, -124);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(2500); //1
                Power(0.6);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(388, -388, 388, -388);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(1000); //1
                Power(0.3);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(1288, 1288, 1288, 1288);
                Velocity(2500); //0.5
                Power(0.7);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);
                //turns and faces stack
                ResetDriveEncoders();
                MDrive(844, -844, 844, -844);
                Velocity(0.5); //0.5
                Power(0.3);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                Arm(963);  /*    563   93.91304347826087    1080   2145  180 = about 1 inch */
                ArmVelocity(8000);
                ArmPower(0.4);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                //Moves toward stack
                ResetDriveEncoders();
                MDrive(976, 976, 976, 976);
                Velocity(2500); //0.5
                Power(0.35);
                RunToPosition();
                Telemetry2();
                Arm(743);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
                ArmVelocity(8000);
                ArmPower(0.7);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                Power(0);

                sleep(10);

                claw.setPosition(CLAW_HOME);

                sleep(490);

                ResetDriveEncoders();
                Arm(2145);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
                MDrive(-1026, -1026, -1026, -1026);
                ArmVelocity(8000);
                Velocity(2500); //0.5
                ArmPower(0.6);
                Power(0.4);
                ArmRuntoPsoition();
                RunToPosition();
                TelemetryM();
                Telemetry2();

                sleep(300);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(1319, -1319, 1319, -1319); // 1270
                Velocity(0.5); //0.5
                Power(0.3);
                RunToPosition();
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(-74, -74, -74, -74);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity(500); //1
                Power(0.5);
                Telemetry2();

                sleep(100);

                Power(0);

                Arm(863);
                ArmVelocity(8000); // Velocity(0.5);
                ArmPower(0.6);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                claw.setPosition(CLAW_MAX_RANGE);

                sleep(250);

                Arm(2145);
                ArmVelocity(8000); //Velocity(0.5);
                ArmPower(0.6);
                ArmRuntoPsoition();
                TelemetryM();

                sleep(100);

                ResetDriveEncoders();
                MDrive(-488, 488, -488, 488);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2(); //1
                Power(1);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(10);

                ResetDriveEncoders();
                MDrive(488, 488, 488, 488);/*  1116   1 inch = 62 */
                RunToPosition();
                Velocity2(); //1
                Power(1);
                Telemetry2();

                sleep(100);

                Power(0);

                sleep(1000000);
            }
        }
    }

    public void Touch() {
        if (touch.getState() == true) {
            telemetry.addData("Digital Touch", "Is Not Pressed");
        } else {

            ArmPower(0);

            sleep(100);

            Arm(2145);
            ArmPower(0.5);
            ArmVelocity(10000);
            ArmRuntoPsoition();

            sleep(100);

            ResetDriveEncoders();
            MDrive(-1000, 1000, -1000, 1000);
            Velocity(1000);
            Power(0.3);
            RunToPosition();
            Telemetry2();

            sleep(1000);
            telemetry.addData("Digital Touch", "Is Pressed");
        }
    }

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        touch = hardwareMap.get(DigitalChannel.class, "sensor_digital");
        color = hardwareMap.get(ColorSensor.class, "color");
        LFD = hardwareMap.get(DcMotor.class, "left front drive");
        LBD = hardwareMap.get(DcMotor.class, "left back drive");
        RFD = hardwareMap.get(DcMotor.class, "right front drive");
        RBD = hardwareMap.get(DcMotor.class, "right back drive");
        //turret = hardwareMap.get(DcMotor.class, "turret");
        armR = hardwareMap.get(DcMotor.class, "arm right");
        claw = hardwareMap.get(Servo.class, "claw");

        LFD.setDirection(DcMotor.Direction.REVERSE);
        LBD.setDirection(DcMotor.Direction.REVERSE);
        RFD.setDirection(DcMotor.Direction.FORWARD);
        RBD.setDirection(DcMotor.Direction.FORWARD);
        touch.setMode(DigitalChannel.Mode.INPUT);
        //turret.setDirection(DcMotor.Direction.FORWARD);
        //arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.addData(">", "Press Start to scan Servo.");
        telemetry.update();

        ResetEncoders();
        RunUsingEncoders();

        waitForStart();

        Power(0);

        int Red; //= color.red();
        int Green; //= color.green();
        int Blue; //= color.blue();

        int color;

        claw.setPosition(CLAW_HOME);

        sleep(1000);

        /*MDrive(1488, 1488, 1488, 1488);
        Velocity(0.5);
        Power(0.3);
        RunToPosition();
        Telemetry2();

        sleep(100);

        LFD.setPower(0);
        RFD.setPower(0);
        LBD.setPower(0);
        RBD.setPower(0);
        ResetDriveEncoders();

        sleep(200);

        MDrive(844, -844, 844, -844);
        Velocity(0.5);
        Power(0.3);
        RunToPosition();
        Telemetry2();

        sleep(100);

        LFD.setPower(0);
        RFD.setPower(0);
        LBD.setPower(0);
        RBD.setPower(0);
        ResetDriveEncoders();

        sleep(200);

        Arm(563);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
        /*ArmVelocity(10000);
        ArmPower(0.6);
        ArmRuntoPsoition();
        TelemetryM();

        sleep(500);

        MDrive(1188, 1188, 1188, 1188);
        Velocity(0.5);
        Power(0.3);
        RunToPosition();
        Telemetry2();

        sleep(100);

        LFD.setPower(0);
        RFD.setPower(0);
        LBD.setPower(0);
        RBD.setPower(0);
        ResetDriveEncoders();

        sleep(200);

        claw.setPosition(CLAW_HOME);
        claw2.setPosition(CLAW2_HOME);

        sleep(600);

        Arm(1290);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
        /*MDrive(-1188, -1188, -1188, -1188);
        // ArmVelocity(10000);
        Velocity(0.5);
        ArmPower(0.6);
        Power(0.5);
        ArmRuntoPsoition();
        RunToPosition();
        TelemetryM();
        Telemetry2();


        sleep(500);*/

        claw.setPosition(CLAW_HOME);

        sleep(200);

        Arm(2145);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
        ArmVelocity(10000);
        ArmPower(0.6);
        ArmRuntoPsoition();
        TelemetryM();

        sleep(100);

        Power(0);

        sleep(50);

        // ResetDriveEncoders();
        // MDrive(64, -54, -64, 64);
        // RunToPosition();
        // Velocity2();
        // Power(0.3);
        // Telemetry2();

        // sleep(10);

        // Power(0);

        // sleep(10);

        ResetDriveEncoders();
        MDrive(1395, 1395, 1395, 1395);/* 1333 1116   1 inch = 62 */
        RunToPosition();
        Velocity2();
        Power(0.6);
        Telemetry2();

        sleep(50);

        Power(0);

        sleep(50);

        ResetDriveEncoders();
        Color();

        // Arm(2145);  /*   93.91304347826087    1080   2145  180 = about 1 inch */
        //ArmVelocity(10000);
        // ArmPower(0.6);
        // ArmRuntoPsoition();
        // TelemetryM();

        // Touch();

        sleep(100);


        sleep(10000000);

        sleep(1000000);


    }
}