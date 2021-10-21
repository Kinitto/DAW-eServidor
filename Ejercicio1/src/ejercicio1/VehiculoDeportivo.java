package ejercicio1;

public class VehiculoDeportivo extends Vehiculo {

	private int caballos;

	public VehiculoDeportivo() {

		caballos = 0;
	}

	public VehiculoDeportivo(int caballos, String matricula, String marca, String modelo) {
		super(matricula, marca, modelo);

		this.caballos = caballos;
	}

	@Override
	public String mostrarDatos() {

		return "Matricula: " + getMatricula() + "\nMarca: " + getMarca() + "\nModelo: " + getModelo()
				+ "\nNumero de Caballos: " + caballos;

	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

}
