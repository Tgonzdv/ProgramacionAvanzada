package personal;

import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.JOptionPane;
import complementosBack.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import complementosBack.Encriptador;
import personal.Medico;
import complementos.Turno;
import personal.Paciente;
import personal.Persona;


import java.util.LinkedList;
 
 

public class Recepcionista  extends Persona implements Encriptador  {



    
    protected String password;
     
   
   
   //get password
    public String getPassword() {
        return password;
    }
    //set password
    public void setPassword(String password) {
        this.password = password;
    }
   
   
    public Recepcionista() {
    	super();
    }
    
   
    //Constructor de la clase Recepcionista
    public Recepcionista(int id,String nombre, String apellido, int dni, String domicilio , String email, String password) {
        super(id, nombre, apellido, null, dni, domicilio,email,null);
        this.password = password;
       
    }
    

  //constructor para new Recepcionista(id, nombre, email, dni)
    public Recepcionista(int id, String nombre, String email, int dni) {
    	   super( nombre, dni, email);
        
        
        
        
    }
    




   //metodo para asignar turno a paciente Medico,Paciente,Turno,LocalDateTime
    public boolean asignarTurno(Medico medico, Paciente paciente,  LocalDateTime fechaHora) {
        if(medico.hayTurnoDisponible(fechaHora)) {
            medico.removeAgendaLibre(fechaHora); // Eliminar el turno de la agenda del medico
        } else {
            System.out.println("El medico no tiene turnos disponibles para esa fecha");
            return false;
        } 

       //genero turno
        Turno turno = new Turno(medico, paciente, fechaHora, "Turno de " + paciente.getNombre() + " " + paciente.getApellido());
        //agrego el turno al paciente
        paciente.getHistorial().addTurno(turno);

    

        //agrego el turno a la lista de turnos del medico
        medico.getTurnos().add(turno);

        return true;
    }
  
    

//metodo para cancelar turno
    public boolean cancelarTurno(Medico medico, Paciente paciente, LocalDateTime fechaHora) {
        Turno turno = paciente.getHistorial().getTurnos().stream()
                .filter(t -> t.getMedico().equals(medico) && t.getFechaHora().equals(fechaHora))
                .findFirst()
                .orElse(null);
        
        if(turno != null) {
            paciente.getHistorial().removeTurno(turno);
            medico.addAgendaLibre(fechaHora); // Agregar el turno de vuelta a la agenda del medico
            medico.getTurnos().remove(turno);
            return true;
        } else {
            System.out.println("No se encontro el turno");
            return false;
        }
    }

    
    //metodo para reprogramar turno
    public boolean reprogramarTurno(Medico medico, Paciente paciente, LocalDateTime fechaHoraVieja, LocalDateTime fechaHoraNueva) {
        Turno turno = paciente.getHistorial().getTurnos().stream()
                .filter(t -> t.getMedico().equals(medico) && t.getFechaHora().equals(fechaHoraVieja))
                .findFirst()
                .orElse(null);
        
        if(turno != null) {
            if(medico.hayTurnoDisponible(fechaHoraNueva)) {
                medico.removeAgendaLibre(fechaHoraNueva); // Eliminar el nuevo turno de la agenda del medico
                turno.setFecha(fechaHoraNueva);
                return true;
            } else {
                System.out.println("El medico no tiene turnos disponibles para esa fecha");
                return false;
            }
        } else {
            System.out.println("No se encontro el turno");
            return false;
        }
    }
    


 //metodo para registrar nuevo medico 
    public Medico registrarMedico(int id,int matricula, String especialidad, int rol, String nombre, String apellido, Date fn, int dni, String domicilio,String email,String password) {
        Medico medico = new Medico(id,matricula, especialidad,  nombre, apellido, fn, dni, domicilio,email,password);
        return medico;
    }
    
   
    
    
    
    
    
    
    //metodo para registrar nuevo paciente creando clase con datos completos
    public Paciente registrarPaciente( int id,String nombre, String apellido, Date fn, int dni, String domicilio,String email) {
        Paciente paciente = new Paciente(id,nombre, apellido, fn, dni, domicilio,email,null);
        return paciente;
    }
    //metodo para modificar datos de paciente
    public void modificarDatosPaciente(Paciente paciente, String nombre, String apellido, Date fn, int dni, String domicilio) {
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setFn(fn);
        paciente.setDni(dni);
        paciente.setDomicilio(domicilio);
    }
    //metodo para modificar datos de medico
    public void modificarDatosMedico(Medico medico, String nombre, String apellido, Date fn, int dni, String domicilio) {
        medico.setNombre(nombre);
        medico.setApellido(apellido);
        medico.setFn(fn);
        medico.setDni(dni);
        medico.setDomicilio(domicilio);
    }
    


    private static Connection con = Conexion.getInstance().getConnection();





    public static void agregarRecepcionista(Recepcionista nuevo) {
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO recepcionista (nombre,apellido,domicilio, email,dni, password) VALUES (?, ?, ?, ?, ?, ?)"
            );


           
            statement.setString(1, nuevo.getNombre());
          statement.setString(2, nuevo.getApellido());
          statement.setString(3, nuevo.getDomicilio());
          statement.setString(4, nuevo.getEmail());
            statement.setInt(5, nuevo.getDni());
            statement.setString(6, 
            		
            		
            		nuevo.encriptar(nuevo.getPassword())
            		
            		);

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Recepcionista agregado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    



    public static LinkedList<Recepcionista> mostrarRecepcionistas() {
        LinkedList<Recepcionista> recepcionistas = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM recepcionista");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");

                
                int dni = rs.getInt("dni");

                recepcionistas.add(new Recepcionista(id, nombre, email, dni));

            }
        } catch (Exception e) {
            e.printStackTrace();


}

  

        return recepcionistas;
    }
    
    
    




  //metodo para verificar si ya existe
    public static void RegistrarRecepcionista(Recepcionista nuevo) {
    	
    	LinkedList<Recepcionista> existentes = mostrarRecepcionistas();
    	boolean flag = true;
    	for (Recepcionista existente : existentes) {
			if (existente.getDni()==(nuevo.getDni())     
                    || existente.getEmail().equals(nuevo.getEmail())) {
				flag = false;
				break;
			}
		}
    	if (flag) {
    		agregarRecepcionista(nuevo);
    		JOptionPane.showMessageDialog(null, "Recepcionista creado con exito");
		}else {
			
			
			JOptionPane.showMessageDialog(null, "Recepcionista ya creado con ese dni o email");
		}
    	
    	
    }
    
    

    
    
    
    
    
    
    
    
   
    
    public static Recepcionista loginRecepcionista(int dni, String password) {
    	Recepcionista recepcionista = new Recepcionista();
    	
    	
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM recepcionista WHERE dni = ? AND password = ?"
            );
            stmt.setInt(1, dni);
            stmt.setString(2, recepcionista.encriptar(password));
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
              
            	
            	int id = rs.getInt("id"); //falta agregarlo al constructor
                String email = rs.getString("email");
                
                
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String domicilio = rs.getString("domicilio");
                
 

               //crear nuevo recepcionista con todos los datos de la base de datos
               recepcionista = new Recepcionista(id,nombre, apellido, dni, domicilio,email,password); 
               

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recepcionista;
    }








    
}
    
    

 









 
