package es.unileon.ulebank.tasklist;

import java.util.Date;

public class FakeTask extends Task{

	public static int STATE_EXECUTE = 0;
	public static int STATE_REDO = 1;
	public static int STATE_UNDO = 2;
	public static int STATE_NORMAL = 4;
	
	public int state;
	
	public FakeTask(Date date) {
		super(date,null);
		state = STATE_NORMAL;
	}

	@Override
	public void execute() {
		state = STATE_EXECUTE;
	}
	
	@Override
	public void redo() {
		state = STATE_REDO;
	}
	
	@Override
	public void undo() {
		state = STATE_UNDO;
	}
	
	public int getState() {
		return this.state;
	}
}
