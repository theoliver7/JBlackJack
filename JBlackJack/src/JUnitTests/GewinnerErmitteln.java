package JUnitTests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import JBlackjack.Bank;
import JBlackjack.Dealer;
import JBlackjack.Spieler;

@RunWith(Parameterized.class)
public class GewinnerErmitteln {
	private static int spieler;
	private static int dealer;
	private String gewinner;
	
	public GewinnerErmitteln(int spieler, int dealer, String gewinner) {
		
		GewinnerErmitteln.spieler = spieler;
		GewinnerErmitteln.dealer = dealer;
		this.gewinner = gewinner;
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Parameters
	public static Collection<Object[]> values() {
		return Arrays.asList(new Object[][] { 	{ 18, 19, "Der Dealer hat gewonnen, zieh eine Karte um eine neue Runde zu beginnen" }, 
												{ 21, 17, "Du hast gewonnen, zieh eine Karte um eine neue Runde zu beginnen" }, 
												{ 10, 10, "Beide Spieler haben den gleichen Kartenwert"}});
	}
	@Test
	public void GewinnerErmittelnTest() {
		Dealer.getdealerKartenwert(1);
		Spieler.getspielerKartenwert(1);
		Spieler.setspielerKartenwert(spieler);
		Dealer.setdealerkKartenwert(dealer);
		Bank.gewinnerErmitteln();
		System.out.println(gewinner);
		Assert.assertEquals(Bank.getGewinner(),gewinner);
		
	}
}
