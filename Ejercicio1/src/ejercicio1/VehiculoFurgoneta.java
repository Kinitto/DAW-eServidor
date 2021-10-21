package ejercicio1;

public class VehiculoFurgoneta extends Vehiculo {

	private int carga;

	public VehiculoFurgoneta() {

		carga = 0;
	}

	public VehiculoFurgoneta(int carga, String matricula, String marca, String modelo) {
		super(matricula, marca, modelo);

		this.carga = carga;

	}

	@Override
	public String mostrarDatos() {

		return "Matricula: " + getMatricula() + "\nMarca: " + getMarca() + "\nModelo: " + getModelo() + "\nCarga: "
				+ carga;

	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

}
