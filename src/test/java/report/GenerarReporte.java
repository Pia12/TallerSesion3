package report;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @autor : eynar.pari
 * @date : 08/08/2020.
 **/
@RunWith(JUnit4.class)
public class GenerarReporte {

    @Test
    public void generar(){
        LocalReport.generarReport();
    }
}