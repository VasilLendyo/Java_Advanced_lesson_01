package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {

	private Cinema cinema;
	private Movie movie;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED-->" + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED-->" + description.getMethodName());
		};
	};

	@Before
	public void beforeTest() throws TimeException {
		Time open = new Time(9, 00);
		Time close = new Time(20, 00);
		cinema = new Cinema(open, close);
		Time duration = new Time(1, 30);
		Movie movie = new Movie("Leo", duration);
	}

	@After
	public void afterTest() {
		cinema = null;
		movie = null;
	}

	@Test
	public void addMovieTest() {
		cinema.addMovie(movie);
		List<Movie> real = cinema.getMoviesLibrary();
		List<Movie> expected = new ArrayList<>();
		expected.add(movie);
		Assert.assertEquals(expected, real);
	}
	
	@Test
	public void removeMovieTest() {
		cinema.addMovie(movie);
		cinema.removeMovie(movie);
		List<Movie> real = cinema.getMoviesLibrary();
		List<Movie> expected = new ArrayList<>();
		expected.add(movie);
		expected.remove(movie);
		Assert.assertEquals(expected, real);
	}
}
