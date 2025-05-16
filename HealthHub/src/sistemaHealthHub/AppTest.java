package sistemaHealthHub;

import personal.Medico;
import personal.Recepcionista;

import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class AppTest {

    public static void main(String[] args) {
        UIManager.put("OptionPane.background", new java.awt.Color(245, 245, 245));
        UIManager.put("Panel.background", new java.awt.Color(245, 245, 245));
        UIManager.put("OptionPane.messageFont", new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));
        UIManager.put("OptionPane.buttonFont", new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

        ImageIcon icono = new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_inicio.png"));

        String[] opciones = {
            "Ingresar a menú Recepcionista",
            "Ingresar a menú Médico",
            "Registrar Recepcionista",
            "Salir"
        };

        while (true) {
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "<html><h2 style='color:#2E86C1;'>Bienvenido a <b>HEALTHHUB</b></h2><hr>"
                + "<p style='font-size:13px;'>Seleccione una opción para continuar:</p></html>",
                "Sistema de Gestión para Pacientes - HEALTHHUB",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icono,
                opciones,
                opciones[0]
            );

            if (seleccion == 0) {
                LoginRecep();
            } else if (seleccion == 1) {
                LoginMed();
            } else if (seleccion == 2) {
                RegistrarRecep();
            } else {
                // Salir o cerrar ventana
                JOptionPane.showMessageDialog(
                    null,
                    "<html><center><b>Gracias por usar HealthHub.<br>¡Hasta pronto!</b></center></html>",
                    "Salir",
                    JOptionPane.INFORMATION_MESSAGE,
                    icono
                );
                break;
            }
        }
    }

    public static String validarVacio(String mensaje) {
        String data;
        do {
            data = JOptionPane.showInputDialog(null, "<html><p style='font-size:13px;'>" + mensaje + "</p></html>", "HEALTHHUB", JOptionPane.QUESTION_MESSAGE);
            if (data == null) data = ""; // Si cancela, forzar a repetir
        } while (data.trim().isEmpty());
        return data.trim();
    }
 
    
    
    public static void RegistrarRecep(){  //ESTE MENU ESTARA OCULTO, SE USA PARA CREAR EL PRIMER USUARIO RECEPCIONISTA

        String dniStr;
        do {
            dniStr = validarVacio("Ingrese el DNI del recepcionista:");
            if (dniStr.length() < 7 || !dniStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El DNI debe tener al menos 7 dígitos numéricos.");
            dniStr = "";
            }
        } while (dniStr.isEmpty());

        String nombre;
        do {
            nombre = validarVacio("Ingrese el nombre del recepcionista:");
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras.");
            nombre = "";
            }
        } while (nombre.isEmpty());

        String apellido;
        do {
            apellido = validarVacio("Ingrese el apellido del recepcionista:");
            if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(null, "El apellido solo debe contener letras.");
            apellido = "";
            }
        } while (apellido.isEmpty());

        String domicilio = validarVacio("Ingrese el domicilio del recepcionista:");

        String email;
        do {
            email = validarVacio("Ingrese el email del recepcionista:");
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Ingrese un email válido.");
            email = "";
            }
        } while (email.isEmpty());

        String password;
        do {
            password = validarVacio("Ingrese la contraseña del recepcionista:");
            if (password.length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.");
            password = "";
            }
        } while (password.isEmpty());


     
         
            	 
              
             
                Recepcionista recepcionista = new Recepcionista(0,nombre, apellido, dniStr, domicilio,email,password);
                
                Recepcionista.RegistrarRecepcionista(recepcionista);
            
       

            
        
        	
    }
    
    
  public static void LoginRecep(){ 
	  
	  
      String dniStr = validarVacio("Ingrese su DNI:");
      String pass = validarVacio("Ingrese la contraseña  :");
    
 
            try {
               
                 Recepcionista recepcionista = new Recepcionista();
                
                
                 recepcionista=recepcionista.loginRecepcionista(dniStr, pass);
                
              if(recepcionista.getDni()=="999") {
                 JOptionPane.showMessageDialog(null, "Error la ingresar");
              return;
                }else {
                JOptionPane.showMessageDialog(null, "Login con éxito para DNI:\n" + dniStr );
                  menuRecepcionista(recepcionista);
               }   
               
                
        
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un DNI válido.");
            } 
        
        
          }
  
  
  public static void LoginMed(){ 
	  
	  
      String dniStr = validarVacio("Ingrese su DNI:");
      String pass = validarVacio("Ingrese la contraseña  :");
    
 
            try {
                 
                 Medico medico = new Medico();
                
                
                 medico=medico.loginMedico(dniStr, pass);
                
                if(medico.getDni()=="999") {
                 JOptionPane.showMessageDialog(null, "Error al ingresar");
                    return;
 } else {
                JOptionPane.showMessageDialog(null, "Login con éxito para DNI:\n" + dniStr );
          
                 
                menuMedico(medico);
                }
                
        
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un DNI válido.");
            } 
        
        
          }
  
  
  
  
  
  
  
    
    public static void menuRecepcionista(Recepcionista r) {
        String[] opcionesRecepcionista = {
            "1. Ir a Turnos",
            "2. Ir a Pacientes",
            "3. Ir a Médicos",
            "4. Salir"
        };

        int opcionRecep = 0;
        do {
            String menuRecep = "=== MENÚ RECEPCIONISTA === Usuario " + r.getNombre() + "\n";
            for (String op : opcionesRecepcionista) {
                menuRecep += op + "\n";
            }

            String input = (String) JOptionPane.showInputDialog(
                null,
                menuRecep,
                "HEALTHHUB - Recepcionista",
                JOptionPane.DEFAULT_OPTION,
                new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_rec.png")),
                null,
                null
            );

            if (input == null) break;

            try {
                opcionRecep = Integer.parseInt(input);

                switch (opcionRecep) {
                    case 1:
                        submenuTurnos(r);
                        break;
                    case 2:
                        submenuPacientes(r);
                        break;
                    case 3:
                        submenuMedicos(r);
                        break;
                    case 4:
                        break;
                    default:
                         
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
            }

        } while (opcionRecep != 4);
    }

    
    
    
    
    
    
    
    
    
    public static void submenuTurnos(Recepcionista r) {
        String[] opcionesTurnos = {
            "1. Asignar turno",
            "2. Cancelar turno",
            "3. Reprogramar turno",
            "4. Volver"
        };

        String menuTurnos = "=== GESTIÓN DE TURNOS ===\n";
        for (String op : opcionesTurnos) {
            menuTurnos += op + "\n";
        }

        String inputTurno = (String) JOptionPane.showInputDialog(
            null,
            menuTurnos,
            "HEALTHHUB - Turnos",
            JOptionPane.DEFAULT_OPTION,
            new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_rec.png")),
            null,
            null
        );

        if (inputTurno != null) {
            try {
                int subOpcion = Integer.parseInt(inputTurno);
                switch (subOpcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Asignar turno seleccionado");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Cancelar turno seleccionado");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Reprogramar turno seleccionado");
                        break;
                    case 4:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida en Turnos");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido para Turnos.");
            }
        }
    }

    public static void submenuPacientes(Recepcionista r) {
        String[] opcionesPacientes = {
            "1. Cargar paciente",
            "2. Modificar paciente",
            "3. Volver"
        };

        String menuPacientes = "=== GESTIÓN DE PACIENTES ===\n";
        for (String op : opcionesPacientes) {
            menuPacientes += op + "\n";
        }

        String inputPaciente = (String) JOptionPane.showInputDialog(
            null,
            menuPacientes,
            "HEALTHHUB - Pacientes",
            JOptionPane.DEFAULT_OPTION,
            new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_paciente.png")),
            null,
            null
        );

        if (inputPaciente != null) {
            try {
                int subOpcion = Integer.parseInt(inputPaciente);
                switch (subOpcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Cargar paciente seleccionado");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Modificar paciente seleccionado");
                        break;
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida en Pacientes");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido para Pacientes.");
            }
        }
    }

    public static void submenuMedicos(Recepcionista r) {
        String[] opcionesMedicos = {
            "1. Registrar médico",
            "2. Modificar médico",
            "3. Volver"
        };

        String menuMedicos = "=== GESTIÓN DE MÉDICOS ===\n";
        for (String op : opcionesMedicos) {
            menuMedicos += op + "\n";
        }

        String inputMedico = (String) JOptionPane.showInputDialog(
            null,
            menuMedicos,
            "HEALTHHUB - Médicos",
            JOptionPane.DEFAULT_OPTION,
            new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_rec.png")),
            null,
            null
        );

        if (inputMedico != null) {
            try {
                int subOpcion = Integer.parseInt(inputMedico);
                switch (subOpcion) {
                    case 1:
                    	RegistrarMed(r);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Modificar médico seleccionado");
                        break;
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida en Médicos");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido para Médicos.");
            }
        }
    }

    
    
    //Funciona , falta emprolijar codigo y diseño
    public static void RegistrarMed(Recepcionista r){  //ESTE MENU ESTARA OCULTO, SE USA PARA CREAR EL PRIMER USUARIO RECEPCIONISTA
    String dniStr;
    do {
        dniStr = validarVacio("Ingrese el DNI:");
        if (dniStr.length() < 7 || !dniStr.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "El DNI debe tener al menos 7 dígitos numéricos.");
        dniStr = "";
        }
    } while (dniStr.isEmpty());

    String nombre;
    do {
        nombre = validarVacio("Ingrese el nombre:");
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
        JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras.");
        nombre = "";
        }
    } while (nombre.isEmpty());

    String apellido;
    do {
        apellido = validarVacio("Ingrese el apellido:");
        if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
        JOptionPane.showMessageDialog(null, "El apellido solo debe contener letras.");
        apellido = "";
        }
    } while (apellido.isEmpty());

    String domicilio = validarVacio("Ingrese el domicilio:");

    String matriculastr;
    do {
        matriculastr = validarVacio("Ingrese la matrícula:");
        if (!matriculastr.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "La matrícula debe ser numérica.");
        matriculastr = "";
        }
    } while (matriculastr.isEmpty());

    String especialidad;
    do {
        especialidad = validarVacio("Ingrese la especialidad:");
        if (!especialidad.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
        JOptionPane.showMessageDialog(null, "La especialidad solo debe contener letras.");
        especialidad = "";
        }
    } while (especialidad.isEmpty());

    String email;
    do {
        email = validarVacio("Ingrese el email:");
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(null, "Ingrese un email válido.");
        email = "";
        }
    } while (email.isEmpty());

    String password;
    do {
        password = validarVacio("Ingrese la contraseña:");
        if (password.length() < 6) {
        JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.");
        password = "";
        }
    } while (password.isEmpty());

    
         
            	
              
                int matricula = Integer.parseInt(matriculastr);
                
                
            
                  Medico medico = new Medico(0,nombre, apellido, dniStr, domicilio,email,password,especialidad,matricula); 
                
               
                
                Recepcionista.RegistrarMedico(medico);
            
         

            
        
        	
    }
    
    
    
    public static void menuMedico(Medico m) {
        String[] opcionesMedico = {
            "1. Agenda",
            "2. Pacientes",
            "3. Volver"
        };

        int opcionMedico = 0;
        do {
            String menuMedico = "=== MENÚ MÉDICO ===\n";
            for (String op : opcionesMedico) {
                menuMedico += op + "\n";
            }

            String input = (String) JOptionPane.showInputDialog(
                null,
                menuMedico,
                "HEALTHHUB - Médico",
                JOptionPane.DEFAULT_OPTION,
                new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_medico.png")),
                null,
                null
            );

            if (input == null) break;

            try {
                opcionMedico = Integer.parseInt(input);
                switch (opcionMedico) {
                    case 1:
                        submenuAgenda();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Acceso a pacientes del médico (por implementar)");
                        break;
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }

        } while (opcionMedico != 3);
    }

    public static void submenuAgenda() {
        String[] opcionesAgenda = {
            "1. Consultar agenda",
            "2. Modificar agenda",
            "3. Volver"
        };

        String menuAgenda = "=== AGENDA DEL MÉDICO ===\n";
        for (String op : opcionesAgenda) {
            menuAgenda += op + "\n";
        }

        String inputAgenda = (String) JOptionPane.showInputDialog(
            null,
            menuAgenda,
            "HEALTHHUB - Agenda",
            JOptionPane.DEFAULT_OPTION,
            new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_agenda.png")),
            null,
            null
        );

        if (inputAgenda != null) {
            try {
                int subOpcion = Integer.parseInt(inputAgenda);
                switch (subOpcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Consultar agenda seleccionada");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Modificar agenda seleccionada");
                        break;
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida en Agenda");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido para Agenda.");
            }
        }
    }
}
