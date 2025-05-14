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
	
	//getters y setters de la clase Historial
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(LinkedList<Turno> turnos) {
		this.turnos = turnos;
	}
	public String getRegistro_clinico() {
		return registro_clinico;
	}
	public void setRegistro_clinico(String registro_clinico) {
		this.registro_clinico = registro_clinico;
	}
	public void addTurno(Turno turno) {
		this.turnos.add(turno);
	}
	public void removeTurno(Turno turno) {
		this.turnos.remove(turno);
	}

	//toString de la clase Historial
	@Override
	public String toString() {
		return "Historial [id=" + id + ", turnos=" + turnos + ", registro_clinico=" + registro_clinico + "]";
	}
	
	
	
}