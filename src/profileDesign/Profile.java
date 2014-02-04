package profileDesign;

public class Profile implements Observer, Decorator{
	
	private float totalPercentComplete = 0;
	protected enum TaskType {T1, T2};
	Decorator dRef = this;
	Observer obs = this;
	
	private DecoratorFactory dFactory = new DecoratorFactory();
	private Stack TaskStack = new Stack();
	
	public void addTask(TaskType t){
		dFactory.getDecorator(t, this); // the decorators arnt chaining / encapsulating
		TaskStack.push(dRef);
	}
	
	public void updateTPC(){
		totalPercentComplete = TaskStack.getTaskTotalPercentage();
	}
	
	public void showTPC(){
		System.out.println("Total percent complete\t" + totalPercentComplete * 100 + "%\n");
	}

	@Override
	public float getPercentDone() {
		return 0; // start value, if altered must include this value in stack to be added
		// in totalPercentComplete calculation
	}
	
	public void showTasks(){
		TaskStack.showTasks();
	}

	@Override
	public void showMyPercentageDone() {
	}

	@Override
	public void showMyName() {
	}
	
	public void updateTask(int taskNum, int amount){
		if(!TaskStack.updateTask(taskNum, amount)){
			System.out.println("That is not a valid task number");
		}
		else System.out.println("~*Updated*~\n");
	}

	@Override
	public void updatePercentDone(int in) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMyID() {
		// TODO Auto-generated method stub
		
	}
}
