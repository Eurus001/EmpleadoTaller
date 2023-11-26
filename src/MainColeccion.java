import java.util.ArrayList;
import java.util.Scanner;

public class MainColeccion {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opc;
        double salario;

        do {
            System.out.println("1.- Ingresar Empleado");
            System.out.println("2.- Cambiar salario");
            System.out.println("3.- Calcular edad");
            System.out.println("4.- Calcular antigüedad");
            System.out.println("5.- Calcular prestaciones");
            System.out.println("6.- Mostrar empleado");
            System.out.println("7.- Auxilio educativo");
            System.out.println("8.- Auxilio educativo porcentaje");
            System.out.println("9.- Diferencia salarial");
            System.out.println("10.- Bonificaciones");
            System.out.println("11.- Salir");
            System.out.print("\nIngrese una opción: ");
            opc = Integer.parseInt(sc.next());

            switch (opc) {
                case 1:
                    ingresarEmpleado(empleados, sc);
                    break;
                case 2:
                    cambiarSalario(empleados, sc);
                    break;
                case 3:
                    calcularEdad(empleados, sc);
                    break;
                case 4:
                    calcularAntiguedad(empleados, sc);
                    break;
                case 5:
                    calcularPrestaciones(empleados, sc);
                    break;
                case 6:
                    mostrarEmpleado(empleados, sc);
                    break;
                case 7:
                    auxilioEducativo(empleados, sc);
                    break;
                case 8:
                    auxilioEducativoPorcentaje(empleados, sc);
                    break;
                case 9:
                    diferenciaSalarial(empleados, sc);
                    break;
                case 10:
                    bonificaciones(empleados, sc);
                    break;
                case 11:
                    System.out.println("Gracias!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opc != 11);

        sc.close();
    }

    private static Empleado buscarEmpleadoPorCedula(ArrayList<Empleado> empleados, String cedula) {
        for (Empleado empleado : empleados) {
            if (empleado.darCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null;
    }

    private static void ingresarEmpleado(ArrayList<Empleado> empleados, Scanner sc){
            String nombre, apellido;
            int dia, mes, anio;
            boolean genero;
            double salario;
            int hijos, subalternos;

            System.out.print("Ingrese el nombre: ");
            nombre = sc.next();
            System.out.print("Ingrese el apellido: ");
            apellido = sc.next();
            System.out.print("Ingrese el genero (1 para Masculino, 0 para Femenino): ");
            genero = Integer.parseInt(sc.next()) == 1;

            System.out.print("Ingrese el dia de nacimiento: ");
            dia = Integer.parseInt(sc.next());
            System.out.print("Ingrese el mes de nacimiento: ");
            mes = Integer.parseInt(sc.next());
            System.out.print("Ingrese el año de nacimiento: ");
            anio = Integer.parseInt(sc.next());
            Fecha fechaNacimiento = new Fecha(dia, mes, anio);

            System.out.print("Ingrese el dia de ingreso: ");
            dia = Integer.parseInt(sc.next());
            System.out.print("Ingrese el mes de ingreso: ");
            mes = Integer.parseInt(sc.next());
            System.out.print("Ingrese el año de ingreso: ");
            anio = Integer.parseInt(sc.next());
            Fecha fechaIngreso = new Fecha(dia, mes, anio);

            System.out.print("Ingrese el salario: ");
            salario = Double.parseDouble(sc.next());

            System.out.print("Ingrese el número de hijos: ");
            hijos = Integer.parseInt(sc.next());

            System.out.print("Ingrese el número de subalternos: ");
            subalternos = Integer.parseInt(sc.next());

            Empleado nuevoEmpleado = new Empleado(nombre, apellido, genero, fechaNacimiento, fechaIngreso, salario, hijos, subalternos);
            empleados.add(nuevoEmpleado);

            System.out.println("Empleado agregado exitosamente.");
    }

    private static void cambiarSalario(ArrayList<Empleado> empleados, Scanner sc) {
        System.out.print("Ingrese la cédula del empleado para cambiar el salario: ");
        String cedula = sc.next();
        Empleado empleado = buscarEmpleadoPorCedula(empleados, cedula);

        if (empleado != null) {
            System.out.print("Ingrese el nuevo salario: ");
            double salario = Double.parseDouble(sc.next());
            empleado.cambiarSalario(salario);
            System.out.println("Salario actualizado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void calcularEdad(ArrayList<Empleado> empleados, Scanner sc) {
        System.out.print("Ingrese la cédula del empleado para calcular la edad: ");
        String cedula = sc.next();
        Empleado empleado = buscarEmpleadoPorCedula(empleados, cedula);

        if (empleado != null) {
            System.out.println("La edad del empleado es: " + empleado.calcularEdad());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void calcularAntiguedad(ArrayList<Empleado> empleados, Scanner sc) {
        System.out.print("Ingrese la cédula del empleado para calcular la antiguedad: ");
        String cedula = sc.next();
        Empleado empleado = buscarEmpleadoPorCedula(empleados, cedula);

        if (empleado != null) {
            System.out.println("La antiguedad del empleado es: " + empleado.calcularAntiguedad());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void calcularPrestaciones(ArrayList<Empleado> empleados, Scanner sc) {
        System.out.print("Ingrese la cédula del empleado para calcular las prestaciones: ");
        String cedula = sc.next();
        Empleado empleado = buscarEmpleadoPorCedula(empleados, cedula);

        if (empleado != null) {
            System.out.println("Las prestaciones del empleado son: " + empleado.calcularPrestaciones());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void mostrarEmpleado(ArrayList<Empleado> empleados, Scanner sc) {
        System.out.print("Ingrese la cédula del empleado para mostrar informacion: ");
        String cedula = sc.next();
        Empleado empleado = buscarEmpleadoPorCedula(empleados, cedula);

        if (empleado != null) {
            int i = 0;
            System.out.println("Modo de recorrido del array (0. For, 1. While): ");
            int modo = sc.nextInt();
            if (modo == 0){
                for (i = 0; i < empleados.size(); i++){
                    System.out.println(empleados.get(i).toString());
                }
            } else if (modo == 1) {
                while(i < empleados.size()){
                    System.out.println(empleados.get(i).toString());
                    i++;
                }
            }else{
                System.out.println("No se ingreso un modo valido");
            }

        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void auxilioEducativo(ArrayList<Empleado> empleados, Scanner sc) {
        System.out.print("Ingrese la cédula del empleado para calcular el auxilio educativo: ");
        String cedula = sc.next();
        Empleado empleado = buscarEmpleadoPorCedula(empleados, cedula);

        if (empleado != null) {
            System.out.println("El auxilio educativo del empleado es: " + empleado.auxilioEducativo());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void auxilioEducativoPorcentaje(ArrayList<Empleado> empleados, Scanner sc) {
        System.out.print("Ingrese la cédula del empleado para calcular el auxilio educativo: ");
        String cedula = sc.next();
        Empleado empleado = buscarEmpleadoPorCedula(empleados, cedula);

        if (empleado != null) {
            System.out.println("Ingrese el porcentaje de auxilio educativo que desea: ");
            double porcentaje = sc.nextDouble();
            System.out.println("El auxilio educativo del empleado es: " + empleado.auxilioEducativoPorcentaje(porcentaje));
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void diferenciaSalarial(ArrayList<Empleado> empleados, Scanner sc) {

        if (empleados.size() > 2){
            System.out.print("Ingrese la cédula del primer empleado para calcular la diferencia salarial: ");
            String cedula1 = sc.next();
            Empleado empleado1 = buscarEmpleadoPorCedula(empleados, cedula1);

            if (empleado1 != null) {
                System.out.print("Ingrese la cédula del segundo empleado para comparar salarios: ");
                String cedula2 = sc.next();
                Empleado empleado2 = buscarEmpleadoPorCedula(empleados, cedula2);

                if (empleado2 != null) {
                    double diferencia = empleado1.darSalario() - empleado2.darSalario();
                    System.out.println("La diferencia salarial entre " + empleado1.darNombre() + " y " + empleado2.darNombre() + " es: " + diferencia);
                } else {
                    System.out.println("Segundo empleado no encontrado.");
                }
            } else {
                System.out.println("Primer empleado no encontrado.");
            }
        }else{
            System.out.println("No hay suficientes empleados para comparar, agregue más");
        }
    }

    private static void bonificaciones(ArrayList<Empleado> empleados, Scanner sc) {
        System.out.print("Ingrese la cédula del empleado para calcular bonificaciones: ");
        String cedula = sc.next();
        Empleado empleado = buscarEmpleadoPorCedula(empleados, cedula);

        if (empleado != null) {
            System.out.println("Las bonificaciones del empleado son: " + empleado.bonificacionCoord());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

}
