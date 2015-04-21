import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class SensorUltrassom {
	static EV3UltrasonicSensor sensorUltrassom = new EV3UltrasonicSensor(SensorPort.S1);
	static float dis;
	public SensorUltrassom(){
		Leitura();
	}
	public float Leitura(){
		Thread thSensorUltrassom = new Thread(new Runnable() {
			public void run() {
				while(true){
					SampleProvider distancia = sensorUltrassom.getDistanceMode();
					float amostraDistancia[] = new float[distancia.sampleSize()];
					distancia.fetchSample(amostraDistancia, 0);
					System.out.println(amostraDistancia[0]);
					dis = amostraDistancia[0];
					Delay.msDelay(1000);
				}
			}
		});
		// Inicia a thread
		thSensorUltrassom.start();		
		return dis;
	}
}
