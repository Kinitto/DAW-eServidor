package ejercicio1;

public class Main {

	public static void main(String[] args) {
		Vehiculo misVehiculos[] = new Vehiculo[4];

		misVehiculos[0] = new Vehiculo("HB2032", "Renault", "Megane");
		misVehiculos[1] = new VehiculoTurismo(5, "AO2033", "Toyota", "Avensis");
		misVehiculos[2] = new VehiculoDeportivo(720, "JM0101", "Ferrari", "488 Spider");
		misVehiculos[3] = new VehiculoFurgoneta(2000, "LL2223", "Renault", "Kangoo");

		for (Vehiculo verVehiculos : misVehiculos) {
			System.out.println(verVehiculos.mostrarDatos());
			System.out.println("");

		}

	}

}
