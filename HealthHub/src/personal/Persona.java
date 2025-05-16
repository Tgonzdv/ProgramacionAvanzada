package personal;
import java.util.Date;
import java.time.LocalDateTime;



public class Persona {
	private int contadorId=1;
	private  int id;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private String dni;
	private String email;
	private String telefono;
	private String domicilio;
	

	public Persona(){}
	
	public Persona(int id,String nombre,String apellido,Date fn,String dni,String domicilio ,String email, String telefono) {
		
		this.id =id;
		
		this.nombre=nombre;
		this.apellido=apellido;
		this.fechaNac=fn;
		this.dni=dni;
		this.domicilio=domicilio;
		this.email=email;
		this.telefono=telefono;
	}
	
	
	public Persona(String nombre,String dni,String email) {
		 this.id = contadorId++;
		
		this.nombre=nombre;
	
		this.dni=dni;
		
		this.email=email;
	
	}
	
	//getters y setters de la clase Persona
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	//metodo para setear fecha nacimiento con parametro date 
	public void setFn(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	
	//get email
	public String getEmail() {
		return email;
	}
	//set email
	public void setEmail(String email) {
		this.email = email;
	}
	

	//toString de la clase Persona
	@Override
	public String toString() {
		return "Persona [id=" + id + ", rol="  + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac="
				+ fechaNac + ", dni=" + dni + ", domicilio=" + domicilio + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
