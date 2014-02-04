package profileDesign;

public abstract class Task implements Subject, Decorator{
	
	protected Decorator myDecorator;
	protected Observer myObserver;
	protected float percentDone = 0;
	protected String desc = "Default";
	protected int taskImportance = 0;
	protected static int ID = 0;
	protected int myID;
	
	{++ID;}
	
	protected boolean isDone(){
		return (percentDone == 1);
	}
	
	protected  String getDescription(){
		return desc;
	}
	
	protected  int getTaskImportance(){
		return taskImportance;
	}
	
	@Override
	public void showMyPercentageDone(){
		System.out.println(percentDone * 100 + "%\n");
	}
	
	@Override
	public void showMyName() {
		System.out.print(desc + "\t");
		
	}
	
	@Override
	public void showMyID(){
		System.out.print("ID " + myID + "\t");
	}
	
	@Override
	public float getPercentDone(){
		return percentDone + myDecorator.getPercentDone();
	}
	
	@Override
	public void regOb(Observer o) {
		myObserver = o;
		
	}

	@Override
	public void notObs() {
		myObserver.updateTPC();
	}
	
	@Override
	public void updatePercentDone(int in){
		percentDone += (((float)in) /100);
		if(percentDone > 1){
			percentDone = 1;
		}
		else if(percentDone < 0){
			percentDone = 0;
		}
		notObs();
	}
}
