import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    private String nombre;
    private String apellido;
    private String cedula;
    private boolean genero;
    private Fecha fechaNacimiento;
    private Fecha fechaIngreso;
    private double salario;
    private int nHijos, nSubalternos;


    public Empleado( )
    {
        nombre = "Juan";
        apellido = "Piguave";
        genero = true;
        fechaNacimiento = new Fecha( 16, 6, 1982 );
        fechaIngreso = new Fecha( 5, 4, 2000 );
        salario = 2500;
        nHijos = 2;
        nSubalternos = 3;
    }

    public Empleado(String nombre, String apellido, boolean genero, Fecha fechaNacimiento, Fecha fechaIngreso, double salario, int nHijos, int nSubalternos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
        this.nHijos = nHijos;
        this.nSubalternos = nSubalternos;
    }

    public String darCedula(){
        return cedula;
    }

    public String darNombre( ) {
        return nombre;
    }

    public boolean darGenero( ) {
        return genero;
    }

    public String darFechaNacimiento( ) {
        String strFecha = fechaNacimiento.toString( );
        return strFecha;
    }

    public String darFechaIngreso( ) {
        String strFecha = fechaIngreso.toString( );
        return strFecha;
    }

    public double darSalario( ) {
        return salario;
    }

    public String darApellido( ) {
        return apellido;
    }

    public int darnHijos() {
        return nHijos;
    }

    public void obtenernSubalternos(int nSubalternos) {
        this.nSubalternos = nSubalternos;
    }

    public int darnSubalternos() {
        return nSubalternos;
    }

    public int calcularEdad( ) {
        Fecha hoy = new Fecha(0,0,0);
        hoy.darFechaActual( );
        int edad = fechaNacimiento.darDiferenciaEnMeses( hoy ) / 12;
        return edad;
    }

    public int calcularAntiguedad( ) {
        Fecha hoy = new Fecha(0,0,0);
        hoy.darFechaActual( );
        int antiguedad = fechaIngreso.darDiferenciaEnMeses( hoy ) / 12;
        return antiguedad;
    }

    public double calcularPrestaciones( ) {
        int antiguedad = calcularAntiguedad( );
        double prestaciones = ((( antiguedad * salario ))/12) + bonificacionCoord();
        return prestaciones;
    }

    public void cambiarSalario( double pSalario ) {
        salario = pSalario;
    }

    public double auxilioEducativo(){
        return ((salario*nHijos)*(double) (5/100));
    }

    public double auxilioEducativoPorcentaje(double porcentaje){
        return ((salario*nHijos)*((double) porcentaje/100));
    }

    public double calcularDiferenciaSalarial ( Empleado otroEmpleado ){
        return (this.salario - otroEmpleado.darSalario());
    }

    public double bonificacionCoord(){
        return ((salario * ((double) 7/100))*nSubalternos);
    }

    @Override
    public String toString() {
        String s = "Nombre completo: " +
                nombre + " " + apellido +
              "\nGenero: " + (darGenero() ? "masculino" : "femenino") +
                "\nFecha de Nacimiento: " + fechaNacimiento +
                "\nFecha de Ingreso: " + fechaIngreso +
                "\nSalario: " + salario +
                "\nHijos " + nHijos +
                "\nSubalternos: " + nSubalternos;

        return s;
    }
}
