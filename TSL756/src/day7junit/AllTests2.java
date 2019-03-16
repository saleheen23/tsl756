package day7junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HeadlessExecution.class, LinkImageTest.class })
public class AllTests2 {

}
