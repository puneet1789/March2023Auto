package march.Automation.testcases;

import org.testng.annotations.Test;

import march.BaseTest;

public class TestEnvironment extends BaseTest{

@Test
public void testEnv () {
	System.out.println("Environment selected : " + System.getenv("env"));
}


}
