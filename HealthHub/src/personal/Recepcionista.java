package personal;

import java.time.LocalDateTime;
import java.util.Date;

import personal.Medico;

import complementos.Turno;

import personal.Paciente;
import personal.Persona;
import java.util.LinkedList;
 

public class Recepcionista extends Persona {
    
   
   
   
   
   
   
   
    //Constructor de la clase Recepcionista
    public Recepcionista(int rol, String nombre, String apellido, Date fn, int dni, String domicilio) {
        super(rol, nombre, apellido, fn, dni, domicilio);
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

    
    
    

}

  
 










 
