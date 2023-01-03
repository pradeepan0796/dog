package org.clss;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonApp {
	public static WebDriver w;
	public static long cur;
	public static long end;
	@BeforeClass
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
	    w=new ChromeDriver();	
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
		 long output=end-cur;
		System.out.println("afterMethod");
	}
	@Test
	public void test1() {
		
		w.get("https://www.amazon.com");
	    System.out.println("launch");
	}
	@Test
	public void test2() {
		//w.findElement(By.id());
	   System.out.println("search");
    }
	@Test
	public void test3() {
	   System.out.println("product");
	}
	@Test
	public void test4() {
		//Assert.assertTrue(false);
	   System.out.println("selectproduct");
	}
	//@Ignore
	@Test
	public void test5() {
	  System.out.println("buynow");
	}
}

	