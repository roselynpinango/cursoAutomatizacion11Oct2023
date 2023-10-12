package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase8Test {
	String url = "http://www.automationpractice.pl/index.php";
	String directorioDatos = "..\\EducacionIT-65093\\Datos\\";
	String nombreArchivoDatos = "Datos_Login09Oct2023.xlsx";
	String nombreHoja = "Hoja1";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
		
		// Si las credenciales son válidas
		// 	entonces hay que salir de la sesión
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel(
				directorioDatos + nombreArchivoDatos,
				nombreHoja);
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2]; // Definir el tamaño del arreglo (filas y columnas)
		
		// Llenar el arreglo con datos
		datos[0][0] = "abc@gmail.com";
		datos[0][1] = "1q2w3e4r";
		
		datos[1][0] = "def@gmail.com";
		datos[1][1] = "2w3e4r5t";
		
		datos[2][0] = "ghi@gmail.com";
		datos[2][1] = "0p9o8i7u6";
		
		return datos;
	}
	
	@AfterSuite() 
	public void tearDown() {
		//driver.close();
	}
}
