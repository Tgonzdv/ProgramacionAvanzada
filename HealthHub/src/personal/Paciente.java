package personal;
import complementos.Historial;



import java.util.Date;

public class Paciente extends Persona{

	private Historial historial;
	
	

	 
    public Paciente(int rol, String nombre, String apellido, Date fn, int dni, String domicilio) {
        super(rol, nombre, apellido, fn, dni, domicilio);
        this.historial = new Historial(); 
    }
	
	
	
	
	
	
	
	
	
	
}
