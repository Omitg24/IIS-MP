package uo.mp.s2.analyzer.model.wordanalyzer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <p>
 * T�tulo: Clase AllTests
 * </p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 12/02/2021
 */

@RunWith(Suite.class)
@SuiteClasses({ FirstRepeatedCharacterTest.class, WordAnalyzerTest.class, FirstMultipleCharacterTest.class, 
	CountGroupsOfRepeatedCharacters.class})
public class AllTests {

}
