import java.util.Scanner;

public class MainArray {
    public static void main(String[] args) {

        Empleado[] empleados;
        Empleado e2;

        String nombre, apellido;
        int dia, mes, anio, tam, ind = 0;
        boolean genero;
        int opc, indice=0;
        double salario;
        int hijos, subalternos;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de empleados");
        tam = Integer.parseInt(sc.next());

        empleados = new Empleado[tam];

        do{
            System.out.println("1.- Ingresar Empleado");
            System.out.println("2.- Cambiar salario");
            System.out.println("3.- Calcular edad");
            System.out.println("4.- Calcular antiguedad");
            System.out.println("5.- Calcular prestaciones");
            System.out.println("6.- Mostrar empleado");
            System.out.println("7.- Auxilio educativo");
            System.out.println("8.- Auxilio educativo porcentaje");
            System.out.println("9.- Diferencia salarial");
            System.out.println("10.- Bonificaciones");
            System.out.println("11.- Salir");
            System.out.print("\nIngrese una opción: ");
            opc = Integer.parseInt(sc.next());
            switch (opc){
                case 1:{

                    if (ind < empleados.length){
                        System.out.println("Ingreso del empleado "+indice+1);
                        System.out.print("Ingrese el nombre: ");
                        nombre = sc.next();
                        System.out.print("Ingrese el apellido: ");
                        apellido = sc.next();
                        System.out.print("Ingrese el genero 1 Masculino, 0 Femenino: ");
                        if(Integer.parseInt(sc.next())==1)
                            genero = true;
                        else genero = false;

                        System.out.print("Ingrese el dia de nacimiento: ");
                        dia = Integer.parseInt(sc.next());
                        System.out.print("Ingrese el mes de nacimiento: ");
                        mes = Integer.parseInt(sc.next());
                        System.out.print("Ingrese el anio de nacimiento: ");
                        anio = Integer.parseInt(sc.next());
                        Fecha fn = new Fecha(dia,mes,anio);

                        System.out.print("Ingrese el dia de ingreso: ");
                        dia = Integer.parseInt(sc.next());
                        System.out.print("Ingrese el mes de ingreso: ");
                        mes = Integer.parseInt(sc.next());
                        System.out.print("Ingrese el anio de ingreso: ");
                        anio = Integer.parseInt(sc.next());
                        Fecha fi = new Fecha(dia,mes,anio);

                        System.out.print("Ingrese el salario: ");
                        salario = Double.parseDouble(sc.next());

                        System.out.println("Ingrese el numero de hijos del empleado: ");
                        hijos = Integer.parseInt(sc.next());

                        System.out.println("Ingrese el numero de subalternos");
                        subalternos = Integer.parseInt(sc.next());

                        empleados[ind] = new Empleado( nombre, apellido, genero, fn, fi, salario, hijos, subalternos );

                        ind++;
                    } else {
                        System.out.println("Cantidad de empleados exceden tamaño del array");
                    }
                }break;
                case 2:{
                    System.out.println("Ingrese el numero de empleado (0 - " + empleados.length + ")");
                    ind = Integer.parseInt(sc.next());
                    System.out.print("Ingrese el salario: ");
                    salario = Double.parseDouble(sc.next());
                    empleados[ind].cambiarSalario(salario);
                }break;
                case 3:{
                    System.out.println("Ingrese el numero de empleado (0 - " + empleados.length + ")");
                    ind = Integer.parseInt(sc.next());
                    System.out.println("La edad de "+empleados[ind].darNombre()+" "+empleados[ind].darApellido()+" es "+empleados[ind].calcularEdad());
                }break;
                case 4:{
                    System.out.println("Ingrese el numero de empleado (0 - " + empleados.length + ")");
                    ind = Integer.parseInt(sc.next());
                    System.out.println("La antiguedad de "+empleados[ind].darNombre()+" "+empleados[ind].darApellido()+" es "+empleados[ind].calcularAntiguedad());
                }break;
                case 5:{
                    System.out.println("Ingrese el numero de empleado (0 - " + empleados.length + ")");
                    ind = Integer.parseInt(sc.next());
                    System.out.println("Las prestaciones de "+empleados[ind].darNombre()+" "+empleados[ind].darApellido()+" es "+empleados[ind].calcularPrestaciones());
                }break;
                case 6:{
                    System.out.println("Ingrese el numero de empleado (0 - " + empleados.length + ")");
                    ind = Integer.parseInt(sc.next());
                    System.out.println(empleados[ind].toString());
                }break;
                case 7:{
                    System.out.println("Ingrese el numero de empleado (0 - " + empleados.length + ")");
                    ind = Integer.parseInt(sc.next());
                    System.out.println("El auxilio educativo por defecto es de " + empleados[ind].auxilioEducativo());
                }break;
                case 8:{
                    double porcentaje;
                    System.out.println("Ingrese el numero de empleado (0 - " + empleados.length + ")");
                    ind = Integer.parseInt(sc.next());
                    System.out.println("Ingrese el porcentaje de auxilio: ");
                    porcentaje = Double.parseDouble(sc.next());
                    System.out.println("El auxilio educativo por el" + porcentaje + " porciento es de " + empleados[ind].auxilioEducativoPorcentaje(porcentaje));
                }break;
                case 9:{
                    System.out.println("Ingrese el numero de empleado (0 - " + empleados.length + ")");
                    ind = Integer.parseInt(sc.next());
                    e2 = new Empleado("Javier", "Villa", true, new Fecha(04,04,2001), new Fecha(01,01,2020), 1200, 2, 5);
                    System.out.println("La diferencia salarial con " + e2.darNombre() + " es: " + empleados[ind].calcularDiferenciaSalarial(e2));
                }break;
                case 10:{
                    System.out.println("Ingrese el numero de empleado (0 - " + (empleados.length-1) + ")");
                    ind = Integer.parseInt(sc.next());
                    System.out.println("Bonificacion: " + empleados[ind].bonificacionCoord() + " por labor de coordinacion");
                }break;
                case 11:{
                    System.out.println("Gracias!");
                }break;
                default:
                    System.out.println("opción no válida");

            }


        }while(opc!=11);

    }

}