package es.unileon.ulebank.tasklist;

import java.util.Date;

import es.unileon.ulebank.command.MockCommand;
import es.unileon.ulebank.handler.Handler;

public class MockTask extends Task{

	public static int STATE_EXECUTE = 0;
	public static int STATE_REDO = 1;
	public static int STATE_UNDO = 2;
	public static int STATE_NORMAL = 4;
	
	public int state;
	
	public MockTask(Date date, Handler id) {
		super(date,new MockCommand(id));
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
