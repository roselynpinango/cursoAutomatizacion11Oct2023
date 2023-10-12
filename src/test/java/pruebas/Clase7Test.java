package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase7Test {
	String url = "http://www.automationpractice.pl/index.php";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo@gmail.com");
		login.escribirPassword("0p9o8i7u6y");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@AfterSuite() 
	public void tearDown() {
		//driver.close();
	}
}
