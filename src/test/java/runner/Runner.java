package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @autor : eynar.pari
 * @date : 08/08/2020.
 **/

@RunWith(Cucumber.class)
@CucumberOptions()
public class Runner {

    // HOOKS ----> Cucumber
    @Before
    public void beforeCucumber(){
        System.out.println("INFO > Cucumber : este es mi BEFORE ---> HOOK");
    }

    @After
    public void afterCucumber(){
        System.out.println("INFO > Cucumber : este es mi AFTER ---> HOOK");
    }
}
