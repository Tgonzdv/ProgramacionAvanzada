package personal;




import java.util.Date;
import java.util.LinkedList;
import java.time.LocalDateTime;

public class Medico extends Persona {
	
 private int matricula;
 private String especialidad;
 private LinkedList<LocalDateTime> agendaLibre;
	
 
 
 //Constructor de la clase Medico
 //Recibe como parametro la matricula,especialidad,rol,nombre,apellido,fecha de nacimiento,dni y domicilio

 public Medico (int matricula,String especialidad,int rol,String nombre,String apellido,Date fn,int dni,String domicilio) {
	 
  super(rol,nombre,apellido,fn,dni,domicilio);
  
  this.matricula=matricula;
  this.especialidad=especialidad;
  agendaLibre = new LinkedList<>();
}
	
public int getMatricula() {
  return matricula; 
  
}
}