package testcases;

import org.testng.annotations.Test;

import Practice.AppiumFramework.Capability;
import Practice.AppiumFramework.SelectCoursePage;


public class SelectCourse extends Capability
{
	SelectCoursePage objSelCoursePage;
	
	@Test
	public void course() throws InterruptedException {
		objSelCoursePage=new SelectCoursePage(driver);
		//objSelCoursePage.clickEditBtn();
		objSelCoursePage.courseSelection();
	}
	
}
