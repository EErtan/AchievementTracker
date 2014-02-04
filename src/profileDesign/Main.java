package profileDesign;
import profileDesign.Profile.TaskType;

public class Main {

	public static void main(String...strings){
		
		Profile p = new Profile();
		p.addTask(TaskType.T1);
		p.addTask(TaskType.T2);
		p.addTask(TaskType.T1);
		p.showTasks();
		p.showTPC();
		
		p.updateTask(1,100);
		p.updateTask(2,50);
		
		p.showTasks();
		p.showTPC();
	}
}
