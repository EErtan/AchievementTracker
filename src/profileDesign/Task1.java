package profileDesign;

public class Task1 extends Task{
	public Task1(Profile pro){
		myDecorator = pro.dRef;
		myObserver = pro.obs;
		desc = "Task1";
		myID = ID;
	}
}
