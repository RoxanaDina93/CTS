package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCuFisierText.class, TestKnockKnockProtocol.class,
		TestMessage.class, TestServerObject.class })

public class AllTests {

}
