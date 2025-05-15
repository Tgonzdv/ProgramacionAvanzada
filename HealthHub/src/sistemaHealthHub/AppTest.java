package sistemaHealthHub;

import personal.Recepcionista;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AppTest {

    public static void main(String[] args) {
        String[] menuInicio = {
            "1. Ingresar a menu Recepcionista",
            "2. Ingresar a menu Medico",
            "99. Registrar recepcionista",
            "4. Salir"
        };
        int opcionInicial = 0;

        do {
            String menu = "=== BIENVENIDO A HEALTHHUB ===\n";
            for (String op : menuInicio) {
                menu += op + "\n";
            }

            String inputInicio = (String) JOptionPane.showInputDialog(
                null,
                menu,
                "Sistema de gestión para Pacientes - HEALTHHUB",
                JOptionPane.DEFAULT_OPTION,
                new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_inicio.png")),
                null,
                null
            );

            if (inputInicio == null) break;

            try {
                opcionInicial = Integer.parseInt(inputInicio);

                switch (opcionInicial) {
                    case 1:
          

                        Login();
                        break;
               
                    case 99:
                    	
            
                    	 RegistrarRecep();
                        
                        
                    case 4:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
            }

        } while (opcionInicial != 4);
    }

    
    
    
    
    
    
    
    public static void RegistrarRecep(){  //ESTE MENU ESTARA OCULTO, SE USA PARA CREAR EL PRIMER USUARIO RECEPCIONISTA

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del recepcionista:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del recepcionista:");
        String dniStr = JOptionPane.showInputDialog("Ingrese el DNI del recepcionista:");
        String domicilio = JOptionPane.showInputDialog("Ingrese el domicilio del recepcionista:");
        String email = JOptionPane.showInputDialog("Ingrese el email del recepcionista:");
        String password = JOptionPane.showInputDialog("Ingrese la contraseña del recepcionista:");


        if (nombre != null && apellido != null && dniStr != null && domicilio != null) {
            try {
                int dni = Integer.parseInt(dniStr);
               
            
             
                Recepcionista recepcionista = new Recepcionista(0,nombre, apellido, dni, domicilio,email,password);
                
                Recepcionista.RegistrarRecepcionista(recepcionista);
            
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un DNI válido.");
            }

            
        }
        
    	
    	
    }
    
    
  public static void Login(){ 
             String dniStr = JOptionPane.showInputDialog("Ingrese su DNI:");
            String pass = JOptionPane.showInputDialog("Ingrese la contraseña  :");
    
    if( dniStr != null && pass != null) {
            try {
                int dni = Integer.parseInt(dniStr);
               
              
                
                
                
                JOptionPane.showMessageDialog(null, "Login con éxito para DNI:\n" + dni );
          
                
               
                
                
                
                menuRecepcionista();
                
        
            
            
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un DNI válido.");
            } 
        
        
        } }
  
  
  
  
  
  
  
  
  
  
    
    public static void menuRecepcionista() {
        String[] opcionesRecepcionista = {
            "1. Ir a Turnos",
            "2. Ir a Pacientes",
            "3. Ir a Médicos",
            "4. Salir"
        };

        int opcionRecep = 0;
        do {
            String menuRecep = "=== MENÚ RECEPCIONISTA ===\n";
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
                        submenuTurnos();
                        break;
                    case 2:
                        submenuPacientes();
                        break;
                    case 3:
                        submenuMedicos();
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

    public static void submenuTurnos() {
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

    public static void submenuPacientes() {
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

    public static void submenuMedicos() {
        String[] opcionesMedicos = {
            "1. Cargar médico",
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
                        JOptionPane.showMessageDialog(null, "Cargar médico seleccionado");
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

    public static void menuMedico() {
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
