package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	// Elementos web que voy a utilizar de la página
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(css="#SubmitLogin")
	WebElement btnLogin;
	
	// Constructor de la página
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que podemos hacer con los elementos 
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void ingresarCredenciales(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
