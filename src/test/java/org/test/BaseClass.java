package org.test;


	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	import java.util.Set;
	import java.util.Vector;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
		
		public static WebDriver driver;

		public static WebDriver chromeBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;
		}

		// Browser Launch using else if ---->>>> Way 1
		public static WebDriver browserLaunch(String browsername) {
			if (browsername.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browsername.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} 
			else if (browsername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			return driver;
		}

		// browser launch using Switch case ---->>>> Way 2
		public static WebDriver browserLaunch2(String browsername) {
			switch (browsername) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			case "edge":
				WebDriverManager.edgedriver();
				driver = new EdgeDriver();
			}
			return driver;
		}

		public static void urlLaunch(String url) {
			driver.get(url);
			driver.manage().window().maximize();
		}

		public static void implicitlyWait(int a) {
			driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
		}

		public static String getText(WebElement e) {
			String text = e.getText();
			return text;
		}

		public static String getAttribute(WebElement e ) {
			String attribute =e.getAttribute("value");
			return attribute;
		}

		public static String getAttribute1(WebElement e) {
			String attribute = e.getAttribute("innerText");
			return attribute;
		}

		public static void sendKeys(String a, WebElement e) {
			e.sendKeys(a);
		}

		public static void click(WebElement e) {
			e.click();
		}

		public static String getTitle() {
			String title = driver.getTitle();
			return title;
		}

		public static String getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}

		public static void close() {
			driver.close();
		}

		public static void quit() {
			driver.quit();
		}

		public static void clear(WebElement e) {
			e.clear();
		}

		// Actions
		public static void moveToElement(WebElement e) {
			Actions a = new Actions(driver);
			a.moveToElement(e).perform();
		}

		public static void dragAndDrop(WebElement source, WebElement target) {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).perform();
		}

		public static void clickAndHold(WebElement e) {
			Actions a = new Actions(driver);
			a.clickAndHold(e).perform();
		}

		public static void release(WebElement e) {
			Actions a = new Actions(driver);
			a.release(e).perform();
		}

		public static void doubleClick(WebElement e) {
			Actions a = new Actions(driver);
			a.doubleClick(e).perform();
		}

		public static void contextClick(WebElement e) {
			Actions a = new Actions(driver);
			a.contextClick(e).perform();
		}

		public static void senKeys1(WebElement e, String a) {
			Actions s = new Actions(driver);
			s.sendKeys(a);

		}

		// Robot
		public static void keyEnter() throws AWTException {
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

		public static void keyDown() throws AWTException {
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

		public static void copy() throws AWTException {
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_CONTROL);

			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
		}

		public static void paste() throws AWTException {
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}

		public static void move() throws AWTException {
			Robot r = new Robot();

		}
		// Dropdown

		public static void selectByIndex(WebElement e, int a) {
			Select s = new Select(e);
			s.selectByIndex(a);
		}

		public static void selectByValue(WebElement e, String a) {
			Select s = new Select(e);
			s.selectByValue(a);
		}

		public static void selectByVisibleText(WebElement e, String a) {
			Select s = new Select(e);
			s.selectByVisibleText(a);
		}

		public static String getOptions(WebElement e) {
			Select s = new Select(e);
			List<WebElement> a = s.getOptions();
			for (int i = 0; i < a.size(); i++) {
				WebElement x = a.get(i);
				String text = x.getText();
			}
			return null;

		}

		public static String getAllSelectedOptions(WebElement e) {
			Select s = new Select(e);
			List<WebElement> x = s.getAllSelectedOptions();
			for (int i = 0; i < x.size(); i++) {
				WebElement y = x.get(i);
				String text = y.getText();
			}
			return null;

		}

		public static String getFirstSelectedOption(WebElement e) {
			Select s = new Select(e);
			WebElement x = s.getFirstSelectedOption();
			String text = x.getText();
			return text;
		}

		public static boolean isMultiple(WebElement e) {
			Select s = new Select(e);
			boolean b = s.isMultiple();
			return b;
		}
//		 public static void deSelectall(WebElement e) {
//		 Select s = new Select(e);
//		 s.deselectAll();
//		 
//		 
//		 }

		public static void deSelectByIndex(WebElement e, int a) {
			Select s = new Select(e);
			s.deselectByIndex(a);
		}

		public static void deselecetByValue(WebElement e, String a) {
			Select s = new Select(e);
			s.deselectByValue(a);
		}

		public static void deselectByVisibleText(WebElement e, String a) {
			Select s = new Select(e);
			s.deselectByVisibleText(a);
		}

		// TakesScreenshot

		public static void getScreenshot() {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File x = ts.getScreenshotAs(OutputType.FILE);
		}

		public static void copyFile() throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			File f = new File("file");
			FileUtils.copyFile(file, f);
		}

		// JavaScript Executor

		// public static void executeScript(String a,WebElement e) {
		// JavaScriptExecutor js = (JavaScriptExecutor) driver;
		// js.executeScript(a,e);
		// }

		// Frames

		public static void switchToFrame1(String name) {
			driver.switchTo().frame(name);
		}

		public static void switchToFrame2(String id) {
			driver.switchTo().frame(id);
		}

		public static void switchToFrame3(int index) {
			driver.switchTo().frame(index);
		}

		public static void switchToFrame4(WebElement e) {
			driver.switchTo().frame(e);
		}

		public static void switchToParentFrame() {
			driver.switchTo().parentFrame();
		}

		public static void switchOutAllFrame() {
			driver.switchTo().defaultContent();
		}

		// Navigation Commands

		public static void urlLaunch1(String url) {
			driver.navigate().to(url);
		}

		public static void backward() {
			driver.navigate().back();
		}

		public static void forward() {
			driver.navigate().forward();
		}

		public static void refresh() {
			driver.navigate().refresh();
		}

		public static boolean isSelected(WebElement e) {
			boolean selected = e.isSelected();
			return selected;
		}

		public static boolean isDisplayed(WebElement e) {
			boolean selected = e.isDisplayed();
			return selected;
		}

		public static boolean isEnabled(WebElement e) {
			boolean enabled = e.isEnabled();
			return enabled;
		}

		// Window Handling

		public static void switchToWindow() {
			driver.getWindowHandle();
		}

		public static String switchToWindows(int a) {
			Set<String> set = driver.getWindowHandles();

			List<String> l = new Vector();
			l.addAll(set);
			String string = l.get(a);
			driver.switchTo().window(string);
			return string;
		}
		public static void screenshotFailedTestCase(String filename) throws IOException {
			
			TakesScreenshot ts =(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File f = new File("C:\\Users\\Administrator\\eclipse-workspace\\TestNG_Day1\\src\\test\\resources\\Screenshot"+filename+".png");
			FileUtils.copyFile(src, f);
		}
		


		}
		 



