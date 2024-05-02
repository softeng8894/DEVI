import org.testng.TestNG;

public class Temp {

	public static void main(String[] args) {
	
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] {docker.class});
        testng.run();
	}

}
