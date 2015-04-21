import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.Button;
import lejos.utility.Delay;

public class ServoMotor {
	public static EV3LargeRegulatedMotor motorDireito = new EV3LargeRegulatedMotor(
			MotorPort.A);
	public static EV3LargeRegulatedMotor motorEsquerdo = new EV3LargeRegulatedMotor(
			MotorPort.B);
	private static boolean ligado = false;
	private static boolean re = false;

	public static void Andar() {
		motorDireito.setSpeed(360);
		motorEsquerdo.setSpeed(360);
		ligado = true;
		while (ligado) {
			motorDireito.forward();
			motorEsquerdo.forward();
			if (Button.ESCAPE.isDown()) {
				System.exit(0);
			}
		}
	}

	public static void Parar() {
		ligado = false;
		motorDireito.stop(true);
		motorEsquerdo.stop();
	}

	public static void Re() {
		Parar();
		motorDireito.setSpeed(360);
		motorEsquerdo.setSpeed(360);
		re = true;
		motorDireito.backward();
		motorEsquerdo.backward();
		Delay.msDelay(1000);
		Parar();
	}
}
