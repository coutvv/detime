package ru.coutvv.detime.decimal;

import org.junit.Assert;
import org.junit.Test;
import ru.coutvv.detime.decimal.date.DeCalendar;
import ru.coutvv.detime.decimal.date.DeDate;

import java.time.LocalDate;

/**
 * @author coutvv    2019-07-01
 */
public class TestDeLogic {

	@Test
	public void testSample() {
		LocalDate revolution = LocalDate.of(1792, 9, 22);
		DeDate start = new DeDate(revolution);
		Assert.assertEquals("1 Month 1 Day 1", start.deName());

		LocalDate modern = LocalDate.of(2019, 8, 4);
		DeDate my = new DeDate(modern);
		Assert.assertEquals("227 Month 11 Day 17", my.deName());
	}

	@Test
	public void testVandemier() {
		LocalDate modern = LocalDate.of(2019, 9, 22);
		DeDate my = new DeDate(modern);
		Assert.assertEquals("228 Month 1 Day 1", my.deName());
	}

	@Test
	public void sanculiteden() {
		String firstOfOlympic = new DeDate(LocalDate.of(2019, 9, 17)).deName();
		Assert.assertEquals("227 Olympic Week Olympic Day 1", firstOfOlympic);
	}
}
