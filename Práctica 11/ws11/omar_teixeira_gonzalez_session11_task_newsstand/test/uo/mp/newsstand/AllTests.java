package uo.mp.newsstand;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Titulo: Clase AllTests
 * 
 * @author Omitg
 * @version 16-04-2021
 */
@RunWith(Suite.class)
@SuiteClasses({ CreateOrdersTest.class, ImportPublicationsFromZipFileTest.class, LoadFileTest.class })
public class AllTests {

}
