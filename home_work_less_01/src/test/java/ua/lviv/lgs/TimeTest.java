package ua.lviv.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {

	private Time time;

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
		time = new Time(9, 10);
	}

	@After
	public void afterTest() {
		time = null;
	}

	@Test(expected = TimeException.class)
	public void timeWithExceptionTest() throws TimeException {
		Time real = new Time(25, 61);
		Time expected = new Time(0, 0);
		Assert.assertEquals(expected, real);
	}
	
	@Test
	public void timeAddTest() throws TimeException{
		Time timeS = new Time(2, 10);
		Time real = time.addTime(timeS);
		Time expected = new Time(11, 20);
		Assert.assertEquals(expected.getHour(), real.getHour());
		Assert.assertEquals(expected.getMin(), real.getMin());
	}
}
