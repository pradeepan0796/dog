package org.clss;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazeE {
	public static WebDriver w;
	public static long cur;
	public static long end;

	@BeforeClass
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.get("https://www.amazon.com");
	}

	public static void closeBrowser() {
		 w.quit();
	}

	@Before
	public void beforeMethod() {
		cur = System.currentTimeMillis();
		System.out.println("beforeMethod");
	}

	@After
	public void afterMethod() {
		end = System.currentTimeMillis();
		long output = end - cur;
		System.out.println("afterMethod");
	}

	@Test
	public void test2() {
		WebElement f = w.findElement(By.id("twotabsearchtextbox"));
		f.sendKeys("tv redmi");// ,Keys.ENTER);
		WebElement fi = w.findElement(By.id("nav-search-submit-button"));
		fi.click();
		System.out.println("search");
	}
	public static String text2;
	@Test
	public void test3() throws Throwable {
		//File file = new File("C:\\Users\\Pradeepan sadhasivam\\Desktop\\junit.xlsx");
		File file = new File("C:\\Users\\Pradeepan sadhasivam\\New folder\\ProjectPractice\\target\\junit.xlsx");
		Workbook wrk = new XSSFWorkbook();
		Sheet sh = wrk.createSheet("sheet1");
		List<WebElement> listofmobiles = w.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int s = listofmobiles.size();
		System.out.println(s);
		Thread.sleep(3000);
		for (int i = 0; i < listofmobiles.size(); i++) {
			WebElement text = listofmobiles.get(i);
			text2 = text.getText();
			System.out.println(text2);

			Row r = sh.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(text2);
		}
		FileOutputStream out = new FileOutputStream(file);
		wrk.write(out);
		out.close();		
	}
	@Test
	public void test4() {
		
		WebElement find2 = w.findElement(By.xpath("//span[contains(@class,'size-medium a-color-base a-text-normal')]"));
		String text = find2.getText();
		System.out.println(text);
		WebElement find = w.findElement(By.xpath("//span[contains(@class,'size-medium a-color-base a-text-normal')]"));
		find.click();
		WebElement find3 = w.findElement(By.xpath("//h1[contains(@class,'a-size-large a-spacing-none')]"));
		String text2 = find3.getText();
		System.out.println(text2);
		
		Assert.assertEquals(text,text2);
		System.out.println("selectproduct");
	}
	// @Ignore
	@Test
	public void test5() {
		WebElement fin = w.findElement(By.xpath("//input[contains(@type,'submit')]"));
		fin.click();
		System.out.println("buynow");
	}

}
