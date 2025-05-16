package personal;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import complementosBack.Conexion;
import complementosBack.Encriptador;
import complementos.Turno;
import personal.Medico;
import personal.Paciente;
import personal.Persona;

public class Recepcionista extends Persona implements Encriptador {

    protected String password;
    private static Connection con = Conexion.getInstance().getConnection();

    // Getters and setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Recepcionista() {
        super();
    }

    // Constructor completo
    public Recepcionista(int id, String nombre, String apellido, int dni, String domicilio, String email, String password) {
        super(id, nombre, apellido, null, dni, domicilio, email, null);
        this.password = password;
    }

    // Constructor reducido
    public Recepcionista(int id, String nombre, String email, int dni) {
        super(nombre, dni, email);
    }

    // Asignar turno
    public boolean asignarTurno(Medico medico, Paciente paciente, LocalDateTime fechaHora) {
        if (medico.hayTurnoDisponible(fechaHora)) {
            medico.removeAgendaLibre(fechaHora);
        } else {
            System.out.println("El medico no tiene turnos disponibles para esa fecha");
            return false;
        }
        Turno turno = new Turno(medico, paciente, fechaHora, "Turno de " + paciente.getNombre() + " " + paciente.getApellido());
        paciente.getHistorial().addTurno(turno);
        medico.getTurnos().add(turno);
        return true;
    }

    // Cancelar turno
    public boolean cancelarTurno(Medico medico, Paciente paciente, LocalDateTime fechaHora) {
        Turno turno = paciente.getHistorial().getTurnos().stream()
                .filter(t -> t.getMedico().equals(medico) && t.getFechaHora().equals(fechaHora))
                .findFirst()
                .orElse(null);

        if (turno != null) {
            paciente.getHistorial().removeTurno(turno);
            medico.addAgendaLibre(fechaHora);
            medico.getTurnos().remove(turno);
            return true;
        } else {
            System.out.println("No se encontro el turno");
            return false;
        }
    }

    // Reprogramar turno
    public boolean reprogramarTurno(Medico medico, Paciente paciente, LocalDateTime fechaHoraVieja, LocalDateTime fechaHoraNueva) {
        Turno turno = paciente.getHistorial().getTurnos().stream()
                .filter(t -> t.getMedico().equals(medico) && t.getFechaHora().equals(fechaHoraVieja))
                .findFirst()
                .orElse(null);

        if (turno != null) {
            if (medico.hayTurnoDisponible(fechaHoraNueva)) {
                medico.removeAgendaLibre(fechaHoraNueva);
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

    // Registrar paciente
    public Paciente registrarPaciente(int id, String nombre, String apellido, Date fn, int dni, String domicilio, String email) {
        return new Paciente(id, nombre, apellido, fn, dni, domicilio, email, null);
    }

    // Modificar datos de paciente
    public void modificarDatosPaciente(Paciente paciente, String nombre, String apellido, Date fn, int dni, String domicilio) {
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setFn(fn);
        paciente.setDni(dni);
        paciente.setDomicilio(domicilio);
    }

    // Modificar datos de medico
    public void modificarDatosMedico(Medico medico, String nombre, String apellido, Date fn, int dni, String domicilio) {
        medico.setNombre(nombre);
        medico.setApellido(apellido);
        medico.setFn(fn);
        medico.setDni(dni);
        medico.setDomicilio(domicilio);
    }

    // Agregar recepcionista a la base de datos
    public static void agregarRecepcionista(Recepcionista nuevo) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO recepcionista (nombre,apellido,domicilio, email,dni, password) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, nuevo.getNombre());
            statement.setString(2, nuevo.getApellido());
            statement.setString(3, nuevo.getDomicilio());
            statement.setString(4, nuevo.getEmail());
            statement.setInt(5, nuevo.getDni());
            statement.setString(6, nuevo.encriptar(nuevo.getPassword()));
            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Recepcionista agregado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mostrar recepcionistas
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

    // Registrar recepcionista si no existe
    public static void RegistrarRecepcionista(Recepcionista nuevo) {
        LinkedList<Recepcionista> existentes = mostrarRecepcionistas();
        boolean flag = true;
        for (Recepcionista existente : existentes) {
            if (existente.getDni() == nuevo.getDni() || existente.getEmail().equals(nuevo.getEmail())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            agregarRecepcionista(nuevo);
            JOptionPane.showMessageDialog(null, "Recepcionista creado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Recepcionista ya creado con ese dni o email");
        }
    }

    // Login recepcionista
    public static Recepcionista loginRecepcionista(int dni, String password) {
        Recepcionista recepcionista = new Recepcionista();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM recepcionista WHERE dni = ? AND password = ?");
            stmt.setInt(1, dni);
            stmt.setString(2, recepcionista.encriptar(password));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String domicilio = rs.getString("domicilio");
                recepcionista = new Recepcionista(id, nombre, apellido, dni, domicilio, email, password);
            } else {
                recepcionista.setDni(999);
                return recepcionista;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recepcionista;
    }

    // Agregar medico a la base de datos
    public static void agregarMedico(Medico nuevo) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO medico (nombre,apellido,domicilio, email,dni,matricula,especialidad, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, nuevo.getNombre());
            statement.setString(2, nuevo.getApellido());
            statement.setString(3, nuevo.getDomicilio());
            statement.setString(4, nuevo.getEmail());
            statement.setInt(5, nuevo.getDni());
            statement.setInt(6, nuevo.getMatricula());
            statement.setString(7, nuevo.getEspecialidad());
            statement.setString(8, nuevo.encriptar(nuevo.getPassword()));
            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Medico agregado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mostrar medicos
    public static LinkedList<Medico> mostrarMedicos() {
        LinkedList<Medico> medicos = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM medico");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                int dni = rs.getInt("dni");
                medicos.add(new Medico(id, nombre, email, dni));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicos;
    }

    // Registrar medico si no existe
    public static void RegistrarMedico(Medico nuevo) {
        LinkedList<Medico> existentes = mostrarMedicos();
        boolean flag = true;
        for (Medico existente : existentes) {
            if (existente.getDni() == nuevo.getDni() || existente.getEmail().equals(nuevo.getEmail())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            agregarMedico(nuevo);
            JOptionPane.showMessageDialog(null, "Medico creado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Medico ya creado con ese dni o email");
        }
    }
}
