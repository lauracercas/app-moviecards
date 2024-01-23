package com.lauracercas.moviecards.endtoendtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.openMocks;

public class IndexE2ETest {
    private final WebDriver driver = new ChromeDriver();


    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {
        closeable = openMocks(this);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
        driver.quit();

    }

    @Test
    public void tesLinks() {
        driver.get("http://localhost:9002");

        assertEquals("FichasPeliculasApp | Aplicación de gestión de fichas de peliculas", driver.getTitle());

        WebElement registerActorLink = driver.findElement(By.cssSelector("a[href*='/registerActorMovie']"));
        assertTrue(registerActorLink.isDisplayed());

        WebElement listActorsLink = driver.findElement(By.cssSelector("a[href*='/actors']"));
        assertTrue(listActorsLink.isDisplayed());

        WebElement newActorLink = driver.findElement(By.cssSelector("a[href*='/actors/new']"));
        assertTrue(newActorLink.isDisplayed());

        WebElement listMoviesLink = driver.findElement(By.cssSelector("a[href*='/movies']"));
        assertTrue(listMoviesLink.isDisplayed());

        WebElement newMovieLink = driver.findElement(By.cssSelector("a[href*='/movies/new']"));
        assertTrue(newMovieLink.isDisplayed());
    }

    @Test
    public void testTitles() {
        driver.get("http://localhost:9002");


        WebElement registerActorMovie = driver.findElement(By.className("registerActorMovie"));
        assertEquals("Inscripción Actor en Pelicula", registerActorMovie.getText());

        WebElement actorList = driver.findElement(By.className("actorList"));
        assertEquals("Listado actores", actorList.getText());

        WebElement newActor = driver.findElement(By.className("newActor"));
        assertEquals("Nuevo Actor", newActor.getText());

        WebElement moviesList = driver.findElement(By.className("moviesList"));
        assertEquals("Listado peliculas", moviesList.getText());

        WebElement newMovie = driver.findElement(By.className("newMovie"));
        assertEquals("Nueva pelicula", newMovie.getText());
    }
}
