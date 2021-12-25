package com.libglobal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {

	static WebDriver driver;

	public static void getDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public WebDriver driver() {

		return driver;
	}

	public static void loadUrl(String url) {

		driver.get(url);
	}

	public void maximize() {

		driver.manage().window().maximize();
	}

	public static void type(WebElement element, String data) {

		element.sendKeys(data);
	}

	public static void click(WebElement element) {

		element.click();
	}

	public static WebElement findElementById(String data) {

		WebElement element = driver.findElement(By.id(data));

		return element;
	}

	public WebElement findElementByName(String data) {

		WebElement element = driver.findElement(By.name(data));
		return element;
	}

	public WebElement findElementByXpath(String data) {

		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}

	public String getEnteredUrl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public String getTitle() {

		String title = driver.getTitle();
		return title;
	}

	private Alert switchAlert() {

		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public void acceptAlert() {

		switchAlert().accept();

	}

	public void dimissAlert() {
		switchAlert().dismiss();
	}

	public String getText(WebElement element) {
		String data = element.getText();
		return data;
	}

	public static String getAttribute(WebElement element, String attributeName) {
		String data = element.getAttribute(attributeName);
		return data;
	}

	public static String getAttribute(WebElement element) {
		String data = element.getAttribute("Value");
		return data;
	}

	public static void selectoptionsByText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public void selectOptionsByAttribute(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByValue(data);

	}

	public void selectOptionsByIndex(WebElement element, int Index) {
		Select select = new Select(element);
		select.selectByIndex(Index);
	}

	public void switchToFrameById(String frameId) {
		driver.switchTo().frame(frameId);
	}

	public void switchToFramwByIndex(int Index) {
		driver.switchTo().frame(Index);
	}

	public void switchToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public String getData(String sheetName, int rowIndex, int cellIndex) throws IOException {

		String data = null;

		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\AutomationProject\\Excel\\Data.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowIndex);

		Cell cell = row.getCell(cellIndex);

		String type = cell.getCellType().toString();

		if (type == "STRING") {

			data = cell.getStringCellValue();

		}

		else if (type == "NUMERIC") {

			if (DateUtil.isCellDateFormatted(cell)) {

				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");

				data = format.format(cell.getDateCellValue());
			}

			else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				data = String.valueOf(l);
			}
		}

		return data;
	}

	public static void closeCurrentBrowser() {

		driver.close();
	}

	public static void closeAllBrowser() {

		driver.quit();
	}

	public void updateData(String sheetName, int rowNum, int cellNum, String newData) throws IOException {

		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\AutomationProject\\Excel\\Data.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.createCell(cellNum);

		cell.setCellValue(newData);

		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
	}

	public void updateData(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\AutomationProject\\Excel\\Data.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		String data = cell.getStringCellValue();

		if (data.equals(oldData)) {

			cell.setCellValue(data);
		}
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	public String getJs(WebElement element) {
		JavascriptExecutor script = (JavascriptExecutor) driver;
		Object executeScript = script.executeScript("return argument[0].getAttribute('value')", element);
		String valueOf = String.valueOf(executeScript);
		return valueOf;
	}

}
