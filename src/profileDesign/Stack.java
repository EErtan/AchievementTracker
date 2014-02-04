package profileDesign;

import java.util.EmptyStackException;

public class Stack {
	
	private Node head = null;
	int numberOfTasks = 0;
	
	private class Node{
		
		private Decorator task = null;
		private Node next = null;
		
		private Node(Decorator d){
			task = d;
			if(!isEmpty()){
				next = head;
			}
		}
	}
	
	public boolean isEmpty(){
		return (head == null);
	}
		
	public Decorator pop(){
		if(isEmpty()){throw new EmptyStackException();}
		--numberOfTasks;
		Decorator d = head.task;
		head = head.next;
		return d;
	}
	
	public void push(Decorator d){
		++numberOfTasks;
		head = new Node(d);
	}
	
	public float  getTaskTotalPercentage(){
		if(isEmpty()){throw new EmptyStackException();}
		return (head.task.getPercentDone()) / numberOfTasks;
	}
	
	public void showTasks(){
		Node temp = head;
		for(int i = 0; i < numberOfTasks; ++i){
			temp.task.showMyName();
			temp.task.showMyID();
			temp.task.showMyPercentageDone();
			temp=temp.next; // may error if it is null
		}
	}
	
	public boolean updateTask(int taskNum, int amount){
		if((taskNum > numberOfTasks) || (taskNum < 1)){
			return false;
		}
		else{
			Node temp = head;
			for(int i = numberOfTasks - taskNum; i > 0; --i){
				temp = temp.next;
			}
			temp.task.updatePercentDone(amount);
		}		
		return true;
	}
}
