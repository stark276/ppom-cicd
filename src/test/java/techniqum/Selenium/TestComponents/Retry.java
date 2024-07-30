package techniqum.Selenium.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int count = 0;
	int tryMax = 1;

	@Override
	public boolean retry(ITestResult result) {
		
		if(count<tryMax) {
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
