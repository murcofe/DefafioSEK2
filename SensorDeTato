import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class SensorDeTato {
	EV3TouchSensor sensorToque1 = new EV3TouchSensor(SensorPort.S2);
	EV3TouchSensor sensorToque2 = new EV3TouchSensor(SensorPort.S3);
	boolean tocado;

	public SensorDeTato() {

		Thread thSensorDeTato = new Thread(new Runnable() {
			public void run() {
				while (true) {
					SampleProvider toque1 = sensorToque1.getTouchMode();
					SampleProvider toque2 = sensorToque2.getTouchMode();
					float amostraToque1[] = new float[toque1.sampleSize()];
					float amostraToque2[] = new float[toque2.sampleSize()];
					toque1.fetchSample(amostraToque1, 0);
					toque2.fetchSample(amostraToque2, 0);
					if (amostraToque1[0] == 1 || amostraToque2[0] == 1)
						tocado = true;
					else
						tocado = false;

					if (tocado){
						ServoMotor.Re();
						Delay.msDelay(1000);
						Navegacao.VirarEsquerda();
						ServoMotor.Andar();
						Delay.msDelay(1000);
						tocado = false;
					}	
					
				}
			}
		});
		// Inicia a thread
		thSensorDeTato.start();
	}
}
