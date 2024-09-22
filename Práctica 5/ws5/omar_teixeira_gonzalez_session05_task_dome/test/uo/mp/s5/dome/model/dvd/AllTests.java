package uo.mp.s5.dome.model.dvd;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uo.mp.s5.dome.model.cd.ToStringTest;

/**
 * Titulo: Clase AllTests
 *  
 * @author Omitg
 * @version 18-02-2021
 */
@RunWith(Suite.class)
@SuiteClasses({ DvdTest.class, SetCommentTest.class, SetOwnTest.class, ToStringTest.class })
public class AllTests {

}
