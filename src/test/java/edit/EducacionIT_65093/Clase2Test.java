package edit.EducacionIT_65093;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2Test {
	// Variable para almacenar la URL de la pagina a probar
	String url = "http://www.automationpractice.pl";
	
	/*
	 * Metodo de prueba para 
	 * usar el buscador de AutomationPractice.pl
	 * */
	@Test
	public void buscarPalabraFirefox() {
		// 1) Definir qué navegador vamos a utilizar para la prueba
		WebDriver navegador = new FirefoxDriver();
		
		// 2) Abrir el navegador en la URL de prueba
		navegador.get(url);
		
		// 3) Maximizamos el navegador
		navegador.manage().window().maximize();
		
		// 4) Borrar las cookies
		navegador.manage().deleteAllCookies();
		
		// 5) Escribir la palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 6) Hacer la búsqueda (simulamos la tecla ENTER)
		txtBuscador.sendKeys(Keys.ENTER);
		
		// 7) Cerrar el navegador
		navegador.close();
	}
	
	@Test
	public void buscarPalabraEdge() {
		// 1) Definir qué navegador vamos a utilizar para la prueba
		WebDriver navegador = new EdgeDriver();
		
		// 2) Abrir el navegador en la URL de prueba
		navegador.get(url);
		
		// 3) Maximizamos el navegador
		navegador.manage().window().maximize();
		
		// 4) Borrar las cookies
		navegador.manage().deleteAllCookies();
		
		// 5) Escribir la palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 6) Hacer la búsqueda (simulamos la tecla ENTER)
		txtBuscador.sendKeys(Keys.ENTER);
		
		// 7) Cerrar el navegador
		
	}
}
