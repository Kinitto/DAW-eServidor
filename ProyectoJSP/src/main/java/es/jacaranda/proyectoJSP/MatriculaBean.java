package es.jacaranda.proyectoJSP;

public class MatriculaBean {

	private String nombre = "";
	private int matematicas = 0;
	private int ingles = 0;
	private int ciencias = 0;
	private int media = 0;
	private String beca = "";

	public MatriculaBean() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public int getMatematicas() {
		return matematicas;
	}

	public void setMatematicas(int matematicas) {
		/**
		 * @param envia la peticion de error si la nota es mayor de 10 o menor de 0.
		 */
		this.matematicas = matematicas;
		if (matematicas > 10 | matematicas < 0) {
			throw new RuntimeException("La nota no puede ser menor que 0 ni mayor que 10");
		}
	}

	public int getIngles() {
		return ingles;
	}

	public void setIngles(int ingles) {
		/**
		 * @param envia la peticion de error si la nota es mayor de 10 o menor de 0.
		 */
		this.ingles = ingles;
		if (ingles > 10 | ingles < 0) {
			throw new RuntimeException("La nota no puede ser menor que 0 ni mayor que 10");
		}
	}

	public int getCiencias() {
		return ciencias;
	}

	public void setCiencias(int ciencias) {
		/**
		 * @param envia la peticion de error si la nota es mayor de 10 o menor de 0.
		 */
		this.ciencias = ciencias;
		if (ciencias > 10 | ciencias < 0) {
			throw new RuntimeException("La nota no puede ser menor que 0 ni mayor que 10");
		}

	}

	public int getMedia() {
		/**
		 * @return devuelve la media de la nota con los datos que hemos introducido.
		 */
		media = (matematicas + ingles + ciencias) / 3;
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public String getBeca() {

		/**
		 * asignar el texto de la pagina beca.
		 *
		 * @return devuelve un String o otro dependiendo de la nota media.
		 */

		if (media >= 5) {
			beca = "BECA CONDECIDA \nEn un periodo entre 30-60 dias laborales la beca estará ingresada en su cuenta bancaria.";
		} else {
			beca = "BECA DENEGADA: \nSe necesita un minimo de 5 en la nota media para obtener la beca.";
		}

		return beca;
	}

	public void setBeca(String beca) {
		this.beca = beca;
	}

}
