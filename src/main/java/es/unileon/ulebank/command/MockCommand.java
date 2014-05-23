package es.unileon.ulebank.command;

import java.util.Date;

import es.unileon.ulebank.handler.Handler;

public class MockCommand implements Command {

	public static int STATE_EXECUTE = 0;
	public static int STATE_REDO = 1;
	public static int STATE_UNDO = 2;
	public static int STATE_NORMAL = 4;
	private int state;
	private Handler id;
	
	public MockCommand(Handler id) {
		state = STATE_NORMAL;
		this.id = id;
	}

	@Override
	public Handler getID() {
		return this.id;
	}

	@Override
	public void execute() {
		this.state = STATE_EXECUTE;
	}

	@Override
	public void undo() {
		this.state = STATE_UNDO;
	}

	@Override
	public void redo() {
		this.state = STATE_REDO;
	}
	
	public int getState() {
		return this.state;
	}
}
