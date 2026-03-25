package pe.edu.upeu.asociacion;

public class Profesor {

	/**
	 * 
	 * @param estudiante
	 */
	public void ensenhar(Estudiante estudiante) {
		System.out.println("Enseñando a "+estudiante.getNombre());
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Profesor p=new Profesor();
		p.ensenhar(new Estudiante("Juan"));

	}

}