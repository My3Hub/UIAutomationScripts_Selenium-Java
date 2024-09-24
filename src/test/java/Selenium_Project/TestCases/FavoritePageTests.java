package Selenium_Project.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Selenium_Project.TestComponents.BaseTest;
import Selenium_Project.pageObjects.FavoritesPage;
import Selenium_Project.pageObjects.HomePage;

public class FavoritePageTests extends BaseTest {

	@Test
	public void VeriFyItemAddedToFavorites() throws IOException, InterruptedException {
		HomePage home = new HomePage(driver);
		home.MyAccountMenu();
		driver.findElement(By.cssSelector("[data-test='nav-home']")).click();
		home.getProducts();
		home.getProductName("Pliers");
		home.addItemToFavorites();
		driver.findElement(By.cssSelector("[id='menu']")).click();
		driver.findElement(By.cssSelector("[data-test='nav-my-favorites']")).click();
		FavoritesPage favs = new FavoritesPage(driver);
		String ExpectedItem = favs.getItemName();
		assertTrue(ExpectedItem.equals("Pliers"));

	}

}
