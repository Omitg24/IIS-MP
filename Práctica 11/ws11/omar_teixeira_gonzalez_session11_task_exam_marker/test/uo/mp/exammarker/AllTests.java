package uo.mp.exammarker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Titulo: Clase AllTests
 * 
 * @author Omitg
 * @version 22-04-2021
 */
@RunWith(Suite.class)
@SuiteClasses({ GetExamsTest.class, GetQuestionsTest.class, LoadQuestionsTest.class, LoadStudentExamsTest.class })
public class AllTests {

}
