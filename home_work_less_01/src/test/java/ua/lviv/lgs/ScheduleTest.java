package ua.lviv.lgs;

import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {

	private Schedule schedule;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED-->" + description.getMethodName());
		};
		
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED-->"+ description.getMethodName());
		};
	};
	
	@Before
	public void beforeTest() {
		schedule = new Schedule();
	}
	
	@After
	public void afterTest() {
		schedule = null;
	}
	
	@Test
	public void addSeanceTest() throws TimeException {
		Time duration = new Time(1, 48);
		Time startTime = new Time(13, 45);
		Movie movie = new Movie("Leo", duration);
		Seance seance = new Seance(movie, startTime);
		schedule.addSeances(seance);
		Set<Seance> expectedSeances = new TreeSet<>();
		expectedSeances.add(seance);
		Assert.assertEquals(expectedSeances, schedule.getSeanceSet());
	}
	
	@Test
	public void removeSeanceTest() throws TimeException{
		Time duration = new Time(1, 48);
		Time startTime = new Time(13, 45);
		Movie movie = new Movie("Leo", duration);
		Seance seance = new Seance(movie, startTime);
		schedule.addSeances(seance);
		schedule.removeSeances(seance);
		Set<Seance> expectedSeances = new TreeSet<>();
		expectedSeances.add(seance);
		expectedSeances.remove(seance);
		Assert.assertEquals(expectedSeances, schedule.getSeanceSet());
	}
}
