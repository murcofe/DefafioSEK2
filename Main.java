import lejos.hardware.Button;

public class Principal2 {

	public static void main(String[] args) {
		ServoMotor motor = new ServoMotor();
		SensorDeTato sensortato = new SensorDeTato();
		SensorUltrassom sensorultrassonico = new SensorUltrassom();

		motor.Andar();
		while (true) {
			if (Button.ESCAPE.isDown()) {
				System.exit(0);
			}
		}

	}

}
