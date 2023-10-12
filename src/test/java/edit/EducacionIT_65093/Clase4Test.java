package edit.EducacionIT_65093;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clase4Test {
	String url = "http://www.automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		WebDriverManager.chromedriver().setup();
		
		// 1) Definir qué navegador vamos a utilizar
		WebDriver driver = new ChromeDriver();
		
		// 2) Abrir el navegador en la página de prueba
		driver.navigate().to(url); // es igual a driver.get(url)
		
		// 3) Maximiza la ventana del navegador
		driver.manage().window().maximize();
		
		// 4) Hacer clic en el hipervínculo Sign In
		driver.findElement(By.partialLinkText("Sign")).click();
		
		Faker faker = new Faker();
		
		// 5) Escribir el correo electrónico 
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		//txtEmail.sendKeys("correo25092023@mailinator.com");
		txtEmail.sendKeys(faker.internet().emailAddress());
		
		// Email: faker.internet().emailAddress()
		// Direccion: faker.address().fullAddress()
		// Pais: faker.address().country()
		// Nombre: faker.name().firstName()
		// Apellido: faker.name().lastName();
		// Contraseña: faker.internet().password(8, 12, true, true, true)
		// Día de nacimiento: faker.number().numberBetween(1, 31)
		
		// 6) Hacer clic en el botón Create An Account
		driver.findElement(By.name("SubmitCreate")).click();
		
		// Agregamos una espera
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(15));
		espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		// 7) Completar el formulario
		driver.findElement(By.cssSelector("#id_gender1")).click(); // Radio button "Title" (Mr.)
		
		WebElement txtFirstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		txtFirstName.sendKeys("Gustavo"); // Campo de Texto Firstname
		
		WebElement txtLastName = driver.findElement(By.id("customer_lastname"));
		txtLastName.sendKeys("Jimenez"); // Campo de Texto Lastname 
		
		WebElement txtEmailAddress = driver.findElement(By.name("email"));
		txtEmailAddress.clear(); // Limpiar el valor del campo
		txtEmailAddress.sendKeys(faker.internet().emailAddress()); // Campo de Texto Email
		
		driver.findElement(By.cssSelector("#passwd")).sendKeys("1q2w3e4r5t"); // Campo de Texto Contraseña
		
		Select selDays = new Select(driver.findElement(By.cssSelector("#days")));
		selDays.selectByValue("18");
		
		Select selMonths = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		selMonths.selectByVisibleText("June ");
		
		Select selYears = new Select(driver.findElement(By.id("years")));
		selYears.selectByIndex(35);
		
		driver.findElement(By.name("newsletter")).click();
		
		// 8) Hacer clic en el botón Register
		driver.findElement(By.cssSelector("#submitAccount")).click();
	}
}
