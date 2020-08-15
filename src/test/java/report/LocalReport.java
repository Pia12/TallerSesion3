package report;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor : eynar.pari
 * @date : 08/08/2020.
 **/
public class LocalReport {
    public static void generarReport(){
        String path="D:\\Clases\\Movile\\Sesion 3\\JB_Movile\\JB_Movile\\movile\\build\\reports\\cucumber\\";
        File reportOutPutDirectory = new File(path+"target");

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(path+"/report.json");

        String buildNumber="1";
        String projectName = "Appium + Cucumber";

        Configuration configuration = new Configuration(reportOutPutDirectory,projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("SO","Android");
        configuration.addClassifications("Platform","9.0");
        configuration.addClassifications("Branch","master");
        configuration.addClassifications("Report","Local");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles,configuration);
        Reportable result = reportBuilder.generateReports();

    }

}
