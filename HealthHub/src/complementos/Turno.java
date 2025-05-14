package complementos;
import personal.Paciente;
import personal.Medico;
import java.time.LocalDateTime;
public class Turno {

	
	private static int contadorId=1;
	
	private  int id;
    private Paciente paciente;
    private Medico medico;
    private String registro;
    private LocalDateTime fecha;
    
    
    
    public Turno (Medico medico,Paciente paciente,LocalDateTime fecha,String registro) {
    	 this.id = contadorId++;
    	 this.medico = medico;
         this.paciente = paciente;
         this.fecha = fecha;
         this.registro = registro;
    	
    	
    }
 
    //getters y setters de la clase Turno
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public String getRegistro() {
        return registro;
    }
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public LocalDateTime getFechaHora() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    //toString de la clase Turno
    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", registro='" + registro + '\'' +
                ", fecha=" + fecha +
                '}';
    }


}
