package ejercicio1;

public class VehiculoTurismo extends Vehiculo {

	private int nPuertas;

	public VehiculoTurismo() {

		nPuertas = 0;
	}

	public VehiculoTurismo(int nPuertas, String matricula, String marca, String modelo) {
		super(matricula, marca, modelo);

		this.nPuertas = nPuertas;
	}

	@Override
	public String mostrarDatos() {

		return "Matricula: " + getMatricula() + "\nMarca: " + getMarca() + "\nModelo: " + getModelo()
				+ "\nNumero de Puertas: " + nPuertas;

	}

	public int getnPuertas() {
		return nPuertas;
	}

	public void setnPuertas(int nPuertas) {
		this.nPuertas = nPuertas;
	}

}
