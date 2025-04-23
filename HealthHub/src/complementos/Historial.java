package complementos;

import java.util.LinkedList;

public class Historial {
  
	private static int contadorId=1;
	private  int id;
	private LinkedList<Turno> turnos;
	private String registro_clinico;
	
	
	public Historial () {
		
		 this.id = contadorId++;
		 this.turnos = new LinkedList<>();
		 this.registro_clinico="";
	}
	
	
	
	
	
	
}