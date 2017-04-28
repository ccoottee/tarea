package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class scenarioDos {
	
	private static WebDriver webDriver;
 	WebElement element;

 	@BeforeClass
 	public static void openBrowser(){
 		
 		//Ejecutar chrome --> Modificar Ruta
 		/*
 		String ruta="/Users/mariajoselopezdaza/Documents/workspace/chromedriver";
 		System.setProperty("webdriver.chrome.driver", ruta);
 		webDriver = new ChromeDriver();*/
 		
 		//Ejecutar safari --> Modificar Ruta			
 		/*
 		String ruta="/Users/mariajoselopezdaza/Documents/workspace/SafariDriver";
 		System.setProperty("webdriver.safari.driver", ruta);			
 		WebDriver driver = new SafariDriver();*/
 	
 		webDriver = new FirefoxDriver();
 		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 

 	@Given("^usuario ingresa correo no registrado en sitio$")
 	@Test
 	public void a_usuario_ingresa_correo_no_registrado_en_sitio(){
	 	webDriver.get("http://www.linkedin.com");	
		webDriver.findElement(By.id("login-email")).sendKeys("prueba@gmail.com");
	}
 	
 	@And("^usuario ingresa contraseña no existente$")
 	@Test
 	public void b_usuario_ingresa_contraseña_no_existente(){
 		webDriver.findElement(By.id("login-password")).sendKeys("MariaJoseLopez");
	}
 	
 	@When("^usuario presiona boton iniciar sesion no existente$")
 	@Test
 	public void c_usuario_presiona_boton_iniciar_sesion_no_existente(){
 		webDriver.findElement(By.id("login-submit")).click();
 	}
 	
 	@Then("^se visualiza mensaje indicando que no existe$")
 	@Test
 	public void d_se_visualiza_mensaje_indicando_que_no_existe(){ 		
 		webDriver.findElement(By.xpath(".//*[@id='control_gen_1']"));

 	}


 	@AfterClass
 	public static void closeBrowser(){
 		webDriver.quit();
 }
}
