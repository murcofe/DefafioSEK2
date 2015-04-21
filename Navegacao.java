import lejos.utility.Delay;

public class Navegacao {
	static SensorUltrassom sensorultrassonico = new SensorUltrassom();

	public static void Desviar() {
		float distancia = sensorultrassonico.Leitura();
		VirarEsquerda();
		while (distancia < 0.10) {
			ServoMotor.Andar();
		}
		ServoMotor.Parar();
		if (distancia > 0.10) {
			VirarDireita();
			while (distancia < 0.10) {
				ServoMotor.Andar();
			}
			VirarDireita();
		}

	}

	public static void VirarDireita() {
		ServoMotor.motorDireito.setSpeed(180);
		ServoMotor.motorEsquerdo.setSpeed(180);
		ServoMotor.motorDireito.backward();
		ServoMotor.motorEsquerdo.forward();
		Delay.msDelay(1000);
		ServoMotor.Parar();
	}

	public static void VirarEsquerda() {
		ServoMotor.motorDireito.setSpeed(180);
		ServoMotor.motorEsquerdo.setSpeed(180);
		ServoMotor.motorDireito.forward();
		ServoMotor.motorEsquerdo.backward();
		Delay.msDelay(1000);
		ServoMotor.Parar();
	}
}
