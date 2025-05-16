package personal;

import complementos.Turno;

import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.JOptionPane;
import complementosBack.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import complementosBack.Encriptador;

import java.util.Date;
import java.util.LinkedList;
import java.time.LocalDateTime;

public class Medico extends Persona  implements Encriptador  {
	
 private int matricula;
 private String especialidad;
 private LinkedList<LocalDateTime> agendaLibre;
  private LinkedList<Turno> turnos;	
   protected String password;
 
 //Constructor de la clase Medico
 //Recibe como parametro la matricula,especialidad,nombre,apellido,fecha de nacimiento,dni y domicilio

 public Medico (int id,int matricula,String especialidad,String nombre,String apellido,String dni,String domicilio ,String email, String password) {
	 
  super(id,nombre,apellido,null,dni,domicilio,email,null);
  this.password = password;
  this.matricula=matricula;
  this.especialidad=especialidad;
  agendaLibre = new LinkedList<>();
  turnos = new LinkedList<>();

}

//constructoir con id, nombre, email, dni
public Medico(int id, String nombre, String email, String dni) {
  super(id, nombre, null, null, dni, null, email, null);
  this.matricula = 0;
  this.especialidad = null;
  agendaLibre = new LinkedList<>();
  turnos = new LinkedList<>();
}






//constructor con new medico id, matricula, especialidad, nombre, apellido,dni,domicilio,email,password




public Medico(int id, String nombre, String apellido, String dni, String domicilio, String email, String password) {
  super(id, nombre, apellido, null, dni, domicilio, email, null);
  this.password = password;
  this.matricula = 0;
  this.especialidad = null;
  agendaLibre = new LinkedList<>();
  turnos = new LinkedList<>();
}
 
public Medico(int id, String nombre, String apellido, String dni, String domicilio, String email, String password,String especialidad, int matricula) {
	  super(id, nombre, apellido, null, dni, domicilio, email, null);
	  this.password = password;
	  
	  this.matricula = matricula;
	  this.especialidad = especialidad;
	  agendaLibre = new LinkedList<>();
	  turnos = new LinkedList<>();
	}







//Constructor sin parametros  
public Medico() {
  super();
  this.matricula = 0;
  this.especialidad = null;
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
  
  public String getPassword() {
      return password;
  }

  
  
  
  

  private static Connection con = Conexion.getInstance().getConnection();


  
  
  
  
  
  public static Medico loginMedico(String dni, String password) {
  	Medico medico = new Medico();
  	
  	
      try {
          PreparedStatement stmt = con.prepareStatement(
              "SELECT * FROM medico WHERE dni = ? AND password = ?"
          );
          stmt.setString(1, dni);
          stmt.setString(2, medico.encriptar(password));
          
          ResultSet rs = stmt.executeQuery();

          if (rs.next()) {
            
          	
          	int id = rs.getInt("id"); //falta agregarlo al constructor
              String email = rs.getString("email");
              
              
              String nombre = rs.getString("nombre");
              String apellido = rs.getString("apellido");
              String domicilio = rs.getString("domicilio");
              String matriculastr = rs.getString("matricula");
              String especialidad = rs.getString("especialidad");

              int matricula = Integer.parseInt(matriculastr);
              
              
             //crear nuevo recepcionista con todos los datos de la base de datos
             medico = new Medico(id,nombre, apellido, dni, domicilio,email,password,especialidad,matricula); 
             

          }else {
              JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
              medico.setDni("99");
              return medico;
          }
      } catch (Exception e) {
          e.printStackTrace();
          medico.setDni("999");
          return medico;
      }
      return medico;
  }
  
  
  
  
  
  
  
  
  
  
 @Override
 public String toString() {
  return "Medico [matricula=" + matricula + ", especialidad=" + especialidad + ", agendaLibre=" + agendaLibre
    + "]";
 }


 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

}