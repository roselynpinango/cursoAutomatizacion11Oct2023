package edit.EducacionIT_65093;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilidades.CapturaEvidencia;

public class Clase5Test {
	String url = "http://www.automationpractice.pl";
	String directorioEvidencias = "..\\EducacionIT-65093\\Evidencias\\";
	String nombreDocumento = "Evidencias de Prueba - AutomationPractice.docx";
	WebDriver driver;
	
	@BeforeSuite
	public void antesDeLaPrueba() {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Contactanos Caso Feliz", priority=100)
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(
				directorioEvidencias + nombreDocumento, 
				"Documento de Evidencias - AutomationPractice", 
				20);
		
		// Capturar pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg", 
				directorioEvidencias + nombreDocumento, 
				"Pantalla Principal");
				
		// Hacemos clic en 'Contact us'
		driver.findElement(By.linkText("Contact us")).click();
		
		// Capturar pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg", 
				directorioEvidencias + nombreDocumento, 
				"Paso 1 - Después de hacer clic en Contact Us");
		
		// Completar el formulario
		Select selSubject = new Select(driver.findElement(By.tagName("select")));
		selSubject.selectByVisibleText("Webmaster"); // Lista Subject
		
		driver.findElement(By.id("email")).sendKeys("correo@gmail.com"); // Campo Email
		
		driver.findElement(By.name("id_order")).sendKeys("123ABC"); // Order Reference
		
		WebElement filAdjunto = driver.findElement(By.xpath("//input[@id='fileUpload']"));
		filAdjunto.sendKeys("C:\\imagen.png");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Comentarios del Contacto");
		
		// Capturar Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg", 
				directorioEvidencias + nombreDocumento, 
				"Paso 2 - Después de completar el formulario");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
		
		// Capturar Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg", 
				directorioEvidencias + nombreDocumento, 
				"Paso 3 - Después de enviar el mensaje de contacto");
	}
	
	@Test(description="CP02 - Buscar Palabra Caso Feliz", priority=200)
	public void buscarPalabra() throws IOException {
		// Captura de Pantalla
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "01_pantallaprincipal.jpg"));
		
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "02_palabraABuscar.jpg"));
		
		driver.findElement(By.name("submit_search")).click();
		
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + "03_resultadoObtenido.jpg"));
		
		// Deberíamos hacer algún chequeo (Assertion o Assert)
		/*
		 * 1) Cambio en la URL 
		 * 2) Cambio en el título
		 * 3) Que aparezca cierto elemento: Texto en la página, mensaje de error
		 * 4) Que los datos que ingresamos se hayan guardado en la BD
		 * 
		 * Assertion => Validar el resultado esperado
		 * Comparar el resultado esperado vs. resultado obtenido
		 * */
		
		String tituloEsperado = "Search - My Shop";
		String tituloActual = driver.getTitle(); // devuelve el titulo de la pagina
 		Assert.assertEquals(tituloActual, tituloEsperado);
 		
 		Assert.assertNotEquals("A", "B");
 		Assert.assertNull(null);
 		Assert.assertTrue(true);
 		
 		String urlEsperada = "http://www.automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
 		String urlActual = driver.getCurrentUrl(); // devuelve la URL de la pagina
 		SoftAssert soft = new SoftAssert();
 		soft.assertEquals(urlActual, urlEsperada);
 		
	}
	
	@AfterSuite
	public void despuesDeLasPruebas() {
		driver.close();
	}
}
