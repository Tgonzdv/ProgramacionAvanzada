package personal;

import complementos.Turno;


import java.util.Date;
import java.util.LinkedList;
import java.time.LocalDateTime;

public class Medico extends Persona {
	
 private int matricula;
 private String especialidad;
 private LinkedList<LocalDateTime> agendaLibre;
private LinkedList<Turno> turnos;	
   protected String password;
 
 //Constructor de la clase Medico
 //Recibe como parametro la matricula,especialidad,nombre,apellido,fecha de nacimiento,dni y domicilio

 public Medico (int matricula,String especialidad,String nombre,String apellido,Date fn,int dni,String domicilio ,String email, String password) {
	 
  super(nombre,apellido,fn,dni,domicilio,email,null);
  this.password = password;
  this.matricula=matricula;
  this.especialidad=especialidad;
  agendaLibre = new LinkedList<>();
  turnos = new LinkedList<>();

}
	 
//getters y setters de la clase Medico
public int getMatricula() {
  return matricula;
 }
public void setMatricula(int matricula) {
  this.matricula = matricula;
 }

public String getEspecialidad() {
  return especialidad;
 }
public void setEspecialidad(String especialidad) {
  this.especialidad = especialidad;
 }

 //mwtodo para obtener la agenda 
public LinkedList<LocalDateTime> getAgendaLibre() {
  return agendaLibre;
 }

 
//Metodo para agregar una fecha a la agenda
 public void addAgendaLibre(LocalDateTime fechaHora) {
  this.agendaLibre.add(fechaHora);
 }



//Metodo para eliminar una fecha de la agenda
 public void removeAgendaLibre(LocalDateTime fechaHora) {
  this.agendaLibre.remove(fechaHora);
 }
 
//metodo para saber si hay turno disponible
  public boolean hayTurnoDisponible(LocalDateTime fechaHora) {
    return agendaLibre.contains(fechaHora);
  }
 

//getters y setters de la lista de turnos
  public LinkedList<Turno> getTurnos() {
    return turnos;
  }
  public void setTurnos(LinkedList<Turno> turnos) {
    this.turnos = turnos;
  }
  


 @Override
 public String toString() {
  return "Medico [matricula=" + matricula + ", especialidad=" + especialidad + ", agendaLibre=" + agendaLibre
    + "]";
 }



}