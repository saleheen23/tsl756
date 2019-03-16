package day7;

import org.testng.annotations.Test;

public class Grouping {
  @Test(groups="smoke")
  public void f1() {
	  System.out.println("In Test1");
  }
  @Test(groups= {"smoke","regression"})
  public void f2() {
	  System.out.println("In Test2");
  }
  @Test(groups= "regression")
  public void f3() {
	  System.out.println("In Test3");
  }
}
