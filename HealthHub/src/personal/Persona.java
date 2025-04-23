package personal;
import java.util.Date;




public class Persona {
	private static int contadorId=1;
	private  int id;
	private int rol;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private int dni;
	private String domicilio;
	

	
	
	public Persona(int rol,String nombre,String apellido,Date fn,int dni,String domicilio) {
		 this.id = contadorId++;
		this.rol=rol;
		this.nombre=nombre;
		this.apellido=apellido;
		this.fechaNac=fn;
		this.dni=dni;
		this.domicilio=domicilio;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
