import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Clase para representar una fecha.
 */
public class Fecha
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------


    private int dia;
    private int mes;
    private int anio;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye una fecha con los par�metros proporcionados
     * El d�a, mes y a�o de la fecha tienen los valores dados por par�metro.
     * @param pDia D�a de la fecha. pDia > 0 y pDia <= 31 y pDia es un valor v�lido seg�n el mes.
     * @param pMes Mes de la fecha. pMes > 0 y pMes <= 12.
     * @param pAnio A�o de la fecha. pAnio > 0.
     */
    public Fecha( int pDia, int pMes, int pAnio )
    {
        dia = pDia;
        mes = pMes;
        anio = pAnio;
    }

    /**
     * Retorna el d�a de la fecha.
     * @return D�a de la fecha.
     */
    public int darDia( )
    {
        return dia;
    }

    /**
     * Retorna el mes de la fecha.
     * @return Mes de la fecha.
     */
    public int darMes( )
    {
        return mes;
    }

    /**
     * Retorna el a�o de la fecha.
     * @return A�o de la fecha.
     */
    public int darAnio( )
    {
        return anio;
    }

    /**
     * Retorna la diferencia en meses que hay entre dos fechas.
     * @param pFecha Fecha contra la que se est� comparando. pFecha != null.
     * @return Diferencia en meses de la fechas.
     */
    public int darDiferenciaEnMeses( Fecha pFecha )
    {
        int diferencia = 0;

        int otroAnho = pFecha.darAnio( );
        int otroMes = pFecha.darMes( );
        int otroDia = pFecha.darDia( );

        // Calcula la diferencia en meses
        diferencia = 12 * ( otroAnho - anio ) + ( otroMes - mes );

        // Si el d�a no es mayor, resta un mes
        if( otroDia < dia )
        {
            diferencia--;
        }

        return diferencia;
    }
    /**
     * Retorna la fecha actual.
     * @return Fecha actual.
     */

    public void darFechaActual( )
    {
        GregorianCalendar gc = new GregorianCalendar( );

        dia = gc.get( Calendar.DAY_OF_MONTH );
        mes = gc.get( Calendar.MONTH ) + 1;
        anio = gc.get( Calendar.YEAR );


    }


    /**
     * Retorna una cadena que representa la fecha.
     * @return Cadena con la informaci�n de la fecha, sigue el formato dia/mes/a�o.
     */
    public String toString( )
    {
        return dia + "/" + mes + "/" + anio;
    }
}
