package profileDesign;

public class Task2 extends Task{
	public Task2(Profile pro){
		myDecorator = pro.dRef;
		myObserver = pro.obs;
		desc = "Task2";
		myID = ID;
	}
}
