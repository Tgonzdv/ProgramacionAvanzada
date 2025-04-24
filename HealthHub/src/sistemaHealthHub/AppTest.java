  package sistemaHealthHub;
 import javax.swing.ImageIcon;

 import javax.swing.JOptionPane;

 public class AppTest {

     public static void main(String[] args) {

         String[] menuInicio = {
             "1. Ingresar como Recepcionista",
             "2. Ingresar como Médico",
             "3. Salir"
         };


         // Proximamente
         //    String[] opciones = {    
         //          "Login",
         //          "Registrarse",
         //           "Salir"
         //      };

         
         
         
         int opcionInicial = 0;

         do { // PARA MANTENERME DENTRO DE MENU PRINICPAL DONDE ELIJO PERFIL

             String menu = "=== BIENVENIDO A HEALTHHUB ===\n";
             for (String op: menuInicio) {
                 menu += op + "\n";
             }

             String inputInicio = (String) JOptionPane.showInputDialog(
                 null,
                 menu,
                 "Sistema de gestion para Pacientes - HEALTHHUB",
                 JOptionPane.DEFAULT_OPTION,
                 new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_inicio.png")), null, null


             );





             if (inputInicio == null) break;

             try {
                 opcionInicial = Integer.parseInt(inputInicio);

                 switch (opcionInicial) {

                     case 1: // RECEPCIONISTA
                         int opcionRecep = 0;
                         String[] opcionesRecepcionista = {
                             "1. Ir a Turnos",
                             "2. Ir a Pacientes",
                             "3. Ir a Médicos",
                             "4. Volver"
                         };

                         do { // PARA MANTENERME DENTRO DE MENU DE RECEPCIONISTA
                             String menuRecep = "=== MENÚ RECEPCIONISTA ===\n";
                             for (String op: opcionesRecepcionista) {
                                 menuRecep += op + "\n";
                             }

                             String input = (String) JOptionPane.showInputDialog(
                                 null,
                                 menuRecep,
                                 "HEALTHHUB - Recepcionista",
                                 JOptionPane.DEFAULT_OPTION,
                                 new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_rec.png")), null, null


                             );





                             if (input == null) break;

                             opcionRecep = Integer.parseInt(input);

                             switch (opcionRecep) {
                                 case 1: // Turnos
                                     String[] opcionesTurnos = {
                                         "1. Asignar turno",
                                         "2. Cancelar turno",
                                         "3. Reprogramar turno",
                                         "4. Volver"
                                     };

                                     String menuTurnos = "=== GESTIÓN DE TURNOS ===\n";
                                     for (String op: opcionesTurnos) {
                                         menuTurnos += op + "\n";
                                     }




                                     String inputTurno = (String) JOptionPane.showInputDialog(
                                         null,
                                         menuTurnos,
                                         "HEALTHHUB - Recepcionista",
                                         JOptionPane.DEFAULT_OPTION,
                                         new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_rec.png")), null, null


                                     );


                                     if (inputTurno != null) {
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
                                     }
                                     break;

                                 case 2: // Pacientes
                                     String[] opcionesPacientes = {
                                         "1. Cargar paciente",
                                         "2. Modificar paciente",
                                         "3. Volver"
                                     };

                                     String menuPacientes = "=== GESTIÓN DE PACIENTES ===\n";
                                     for (String op: opcionesPacientes) {
                                         menuPacientes += op + "\n";
                                     }


                                     String inputPaciente = (String) JOptionPane.showInputDialog(
                                         null,
                                         menuPacientes,
                                         "HEALTHHUB - Recepcionista",
                                         JOptionPane.DEFAULT_OPTION,
                                         new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_paciente.png")), null, null


                                     );




                                     if (inputPaciente != null) {
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
                                     }
                                     break;

                                 case 3: // Médicos
                                     String[] opcionesMedicos = {
                                         "1. Cargar médico",
                                         "2. Modificar médico",
                                         "3. Volver"
                                     };

                                     String menuMedicos = "=== GESTIÓN DE MÉDICOS ===\n";
                                     for (String op: opcionesMedicos) {
                                         menuMedicos += op + "\n";
                                     }

                                     String inputMedico = (String) JOptionPane.showInputDialog(
                                         null,
                                         menuMedicos,
                                         "HEALTHHUB - Personal Medico",
                                         JOptionPane.DEFAULT_OPTION,
                                         new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_rec.png")), null, null


                                     );


                                     if (inputMedico != null) {
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
                                     }
                                     break;

                                 case 4:
                                     break;
                                 default:
                                     JOptionPane.showMessageDialog(null, "Opción inválida");
                             }

                         } while (opcionRecep != 4);
                         break;

                     case 2: // MÉDICO

                         int opcionMedico = 0;
                         String[] opcionesMedico = {
                             "1. Agenda",
                             "2. Pacientes",
                             "3. Volver"
                         };

                         do { // PARA MANTENERME DENTRO DE MENU DEL MEDICO
                             String menuMedico = "=== MENÚ MÉDICO ===\n";
                             for (String op: opcionesMedico) {
                                 menuMedico += op + "\n";
                             }

                             String input = (String) JOptionPane.showInputDialog(
                                 null,
                                 menuMedico,
                                 "HEALTHHUB - Personal Medico",
                                 JOptionPane.DEFAULT_OPTION,
                                 new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_medico.png")), null, null


                             );


                             if (input == null) break;

                             opcionMedico = Integer.parseInt(input);

                             switch (opcionMedico) {
                                 case 1: // Submenú Agenda
                                     String[] opcionesAgenda = {
                                         "1. Consultar agenda",
                                         "2. Modificar agenda",
                                         "3. Volver"
                                     };

                                     String menuAgenda = "=== AGENDA DEL MÉDICO ===\n";
                                     for (String op: opcionesAgenda) {
                                         menuAgenda += op + "\n";
                                     }

                                     String inputAgenda = (String) JOptionPane.showInputDialog(
                                         null,
                                         menuAgenda,
                                         "HEALTHHUB - Personal Medico",
                                         JOptionPane.DEFAULT_OPTION,
                                         new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_agenda.png")), null, null


                                     );


                                     if (inputAgenda != null) {
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
                                     }
                                     break;

                                 case 2: // Submenú Pacientes (Historial)
                                     String[] opcionesHistorial = {
                                         "1. Ver historial clínico",
                                         "2. Modificar historial clínico",
                                         "3. Volver"
                                     };

                                     String menuHistorial = "=== HISTORIAL CLÍNICO ===\n";
                                     for (String op: opcionesHistorial) {
                                         menuHistorial += op + "\n";
                                     }

                                     String inputHistorial = (String) JOptionPane.showInputDialog(
                                         null,
                                         menuHistorial,
                                         "HEALTHHUB - Personal Medico",
                                         JOptionPane.DEFAULT_OPTION,
                                         new ImageIcon(AppTest.class.getResource("../Imagenes/fondo_medico.png")), null, null


                                     );

                                     if (inputHistorial != null) {
                                         int subOpcion = Integer.parseInt(inputHistorial);
                                         switch (subOpcion) {
                                             case 1:
                                                 JOptionPane.showMessageDialog(null, "Ver historial clínico seleccionado");
                                                 break;
                                             case 2:
                                                 JOptionPane.showMessageDialog(null, "Modificar historial clínico seleccionado");
                                                 break;
                                             case 3:
                                                 break;
                                             default:
                                                 JOptionPane.showMessageDialog(null, "Opción inválida en Historial");
                                         }
                                     }
                                     break;

                                 case 3:
                                     break;
                                 default:
                                     JOptionPane.showMessageDialog(null, "Opción inválida");
                             }


                         } while (opcionMedico != 3);
                         break;

                     case 3:
                         JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                         break;

                     default:
                         JOptionPane.showMessageDialog(null, "Opción inválida");
                 }

             } catch (NumberFormatException e) {
                 JOptionPane.showMessageDialog(null, "Por favor, ingresá un número válido.");
             }

         } while (opcionInicial != 3);
     }
 }