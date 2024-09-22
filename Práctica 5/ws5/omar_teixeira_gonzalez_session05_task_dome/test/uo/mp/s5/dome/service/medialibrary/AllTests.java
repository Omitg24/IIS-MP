package uo.mp.s5.dome.service.medialibrary;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Titulo: Clase AllTests
 * 
 * @author Omitg
 * @version 18-02-2021
 */
@RunWith(Suite.class)
@SuiteClasses({ AddTest.class, GetItemsTest.class, GetNumberOfItemsOwnedTest.class,
	SearchItemTest.class , TotalValueTest.class, GenerateCodeTest.class,
	BorrowTest.class, GiveBackTest.class})
public class AllTests {

}
