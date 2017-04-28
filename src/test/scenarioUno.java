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


public class scenarioUno {
    
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
	
	@Given("^usuario ingresa correo$")
	@Test
	public void a_usuario_ingresa_correo() {
		webDriver.get("http://www.linkedin.com");	
		webDriver.findElement(By.id("login-email")).sendKeys("mariajose.lopezdaza2017@gmail.com");		
	}
	
	@And("^usuario ingresa contraseña$")
	@Test
	public void b_usuario_ingresa_contraseña() {
		webDriver.findElement(By.id("login-password")).sendKeys("MariaJoseLopez");
	}
	
	@And("^usuario presiona boton iniciar sesion$")
	@Test
	public void c_usuario_inicia_sesion() throws InterruptedException {
		webDriver.findElement(By.id("login-submit")).click();
		Thread.sleep(5000); 
	}
	
	@When("^usuario busca un contacto$")
	@Test
	public void d_usuario_busca_contacto() throws InterruptedException {
		webDriver.findElement(By.xpath(".//*[@id='nav-search-controls-wormhole']/button")).click();
		Thread.sleep(5000); 
	}
	
	@Then("^se visualiza contacto$")	
	@Test
	public void e_visualizar_contacto() throws InterruptedException {
		webDriver.findElement(By.id("ember10164")).click();

	}
	
	@AfterClass
	 public static void closeBrowserF(){
		webDriver.quit();
	 }
	
 
}

