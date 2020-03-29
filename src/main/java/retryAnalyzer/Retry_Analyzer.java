package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Analyzer implements IRetryAnalyzer{

	int i=0;//int counter
	int j=3;//int retrylimit
	public boolean retry(ITestResult result) {
		if(i<j) {
			i++;
			return true;
		}
		return false;
	}

}
