package personal;
import complementos.Historial;



import java.util.Date;

public class Paciente extends Persona{

	private Historial historial;
	
	

	 
    public Paciente( String nombre, String apellido, Date fn, int dni, String domicilio, String email, String tel) {
        super(nombre, apellido, fn, dni, domicilio,email,tel);
        this.historial = new Historial(); 
    }
	
	
	//get de historial
    public Historial getHistorial() {
        return historial;
    }

 
	//toString de la clase Paciente
    @Override
    public String toString() {
        return "Paciente{" +
                "historial=" + historial +
                '}';
    }
	
	
	
	
}
