package profileDesign;
import profileDesign.Profile.TaskType;

public class DecoratorFactory {
	public void getDecorator(TaskType taskType, Profile pro){
				
		switch(taskType){
		case T1:{pro.dRef = new Task1(pro);break;}
		case T2:{pro.dRef = new Task2(pro);break;}
		default: pro.dRef = new Task1(pro);
		}
	}
}
