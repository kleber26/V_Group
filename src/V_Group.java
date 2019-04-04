import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class V_Group {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Kleber\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://verity.com.br");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[contains(text(),'Contato')]")).click();

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("empresa")));

		driver.findElement(By.name("empresa")).sendKeys("Verity");
		driver.findElement(By.name("nome")).sendKeys("Fulano");
		driver.findElement(By.name("email")).sendKeys("fulano@teste.com");
		driver.findElement(By.name("telefone")).sendKeys("11988755632");
		driver.findElement(By.xpath("//*[@value='Dúvidas']")).click();
		driver.findElement(By.name("mensagem")).sendKeys("Teste de automação no site da Verity.");

		driver.findElement(By.xpath("//*[contains(text(), 'Enviar')]")).click();
		
		validarEnvioDeMensagem(driver);
		driver.close();
	}

	public static void validarEnvioDeMensagem(WebDriver driver) {
		try {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Sua mensagem foi enviado com sucesso!')]")));
			System.out.println("Mensagem enviada com sucesso.");
		}catch (Exception e) {
			System.out.println("Erro ao tentar enviar mensagem.");
		}
		
	}
	
}
