package JUnitTests;

import java.util.Arrays;
import java.util.Collection;

import javax.swing.JTextField;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import JBlackjack.Bank;
import JBlackjack.Dealer;
import JBlackjack.Gui;
import JBlackjack.Spieler;

@RunWith(Parameterized.class)

public class BankTest {
	private static int einsatz;
	private static int kontostand;
	private int result;

	public BankTest(int einsatz, int kontostand, int result) {
		BankTest.einsatz = einsatz;
		BankTest.kontostand = kontostand;
		this.result = result;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Parameters
	public static Collection<Object[]> values() {
		return Arrays.asList(new Object[][] { 	{ 21, 500, 521}, 
												{ 10, 0, 10 }, 
												{ 0, 0, 0}});
	}

	@Test
	public void testKontostandanpassen() {
		Bank.setKontostand(kontostand);
		Bank.kontostandanpassen(einsatz);
		Assert.assertEquals(Bank.getKontostand(),result);
	}
}
