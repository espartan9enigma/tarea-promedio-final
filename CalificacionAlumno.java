// [+] Este codigo es el Ejercicio 1 de la tarea Final
/**
 *
 * @author BELU und Dunk3lheit
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class CalificacionAlumno {
    public static DecimalFormat dc = new DecimalFormat("#.00");
    static String categoria = "";
    static String text = "Ingresa la" + categoria+ " calificación  parcial: ";

    public static void main(String[] args) { 
        double calificacionParciales = calProInpt(); 
        double calificacionExamenFinal = caliExamFin();
        double calificacionTrabajoFinal = caliTraFin();
        double[] calfinal = calFinal(calificacionParciales, calificacionExamenFinal, calificacionTrabajoFinal);
        

        double porcentajeParcial = calfinal[0];
        double porcentajeExamenF = calfinal[1];
        double porcentajeTrabajo = calfinal[2];
        double calificacionFinal = calfinal[3];


        String mensaje = "\n"
                + "============================================================\n"
                + "                                Boleta de Notas                     \n"
                + "============================================================\n"
                + "\nPromedio de la calificacion parcial    : " + dc.format(calificacionParciales)
                + "\nCalificacion de examenes finales       : " + dc.format(calificacionExamenFinal)
                + "\nCalificacion de trabajos finales       : " + dc.format(calificacionTrabajoFinal)
                + "\n============================================================\n"
                + "Porcentaje del promedio de las calificaciones parciales (%55): " + (porcentajeParcial) + "\n"
                + "Porcentaje de la calificación del examen final                (%30): " + (porcentajeExamenF) + "\n"
                + "Porcentaje de la calificación del trabajo final               (%15): " + (porcentajeTrabajo) + "\n"
                + "\n============================================================"
                + "\nLa calificación final del alumno es                    : " + Double.parseDouble(dc.format(calificacionFinal));

        // Mostrar el cuadro de diálogo con el mensaje
        JOptionPane.showMessageDialog(null, mensaje);
    }


    public static double[] calFinal(double calificacionParciales, double calificacionExamenFinal, double calificacionTrabajoFinal) {
        double porcentajeParcial = calificacionParciales * 0.55;
        double porcentajeExamenF = calificacionExamenFinal * 0.30;
        double porcentajeTrabajo = calificacionTrabajoFinal * 0.15;
        double calificacionFinal = porcentajeParcial + porcentajeExamenF + porcentajeTrabajo;
        
        return new double[]{
            Double.parseDouble(dc.format(porcentajeParcial)),
            Double.parseDouble(dc.format(porcentajeExamenF)), 
            Double.parseDouble(dc.format(porcentajeTrabajo)), 
            Double.parseDouble(dc.format(calificacionFinal)),
            };
    }

    public static double caliTraFin() {
        double calificacionTrabajoFinal = 0;

        boolean validInput = false;
        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog("Ingresa la calificación del trabajo final: ");
                calificacionTrabajoFinal = Double.parseDouble(input);

                if (calificacionTrabajoFinal < 0 || calificacionTrabajoFinal > 20) {
                    JOptionPane.showMessageDialog(null, "La calificación debe estar entre 0 y 20");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una calificación válida.");
            }
        }

        return calificacionTrabajoFinal;
    }

    public static double caliExamFin() {
        double calificacionExamenFinal = 0;
        
        boolean validInput = false;
        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog("Ingresa la calificación del examen final: ");
                calificacionExamenFinal = Double.parseDouble(input);
                
                if (calificacionExamenFinal < 0 || calificacionExamenFinal > 20) {
                    JOptionPane.showMessageDialog(null, "La calificación debe estar entre 0 y 20");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una calificación válida.");
            }
        }
        
        return calificacionExamenFinal;
    }


    public static double calProInpt() {
        ArrayList<Double> notas = new ArrayList<>();
        int rango = 3;
        
        for (int i = 0; i < rango; i++) {
            String categoria = "Parcial " + (i + 1);
            String text = "Ingrese la calificación para " + categoria + ":";
            
            boolean validInput = false;
            double calificacionParcial = 0;
            
            while (!validInput) {
                try {
                    String input = JOptionPane.showInputDialog(text);
                    calificacionParcial = Double.parseDouble(input);
                    
                    if (calificacionParcial < 0 || calificacionParcial > 20) {
                        JOptionPane.showMessageDialog(null, "La calificación debe estar entre 0 y 20");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una calificación válida.");
                }
            }
            
            notas.add(calificacionParcial);
        }
        
        double promedio = 0;
        for (double nota : notas) {
            promedio += nota;
        }
        
        return promedio / rango;
    }


}
