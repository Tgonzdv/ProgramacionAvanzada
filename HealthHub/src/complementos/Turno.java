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
    
}
