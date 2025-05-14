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
	
	
	
	//getters y setters de la clase Persona
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
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

	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	//toString de la clase Persona
	@Override
	public String toString() {
		return "Persona [id=" + id + ", rol=" + rol + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac="
				+ fechaNac + ", dni=" + dni + ", domicilio=" + domicilio + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
