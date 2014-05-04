/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.taskList;

import es.unileon.ulebank.command.Command;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.time.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author runix
 */
public class TaskList {

    /**
     *
     */
    private final List<Command> tasks;
    /**
     *
     */
    private final List<Command> tasksDone;
    /**
     *
     */
    private final List<Command> deletedCommands;
    /**
     *
     */
    private final CommandDateComparator comparator;
    /**
     * Bank's time
     */
    private final Time time;
    /**
     *
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
        this.tasksDone = new ArrayList<>();
        this.deletedCommands = new ArrayList<>();
        this.comparator = new CommandDateComparator();
        this.time = Time.getInstance();
    }

    /**
     *
     * @param command
     * @return
     */
    public synchronized boolean addTask(Command command) {
        boolean add = true;
        if (command != null) {
            for (int i = 0; i < tasks.size() && add; i++) {
                if (command.getID().compareTo(this.tasks.get(i).getID()) == 0) {
                    add = false;
                }
            }
            this.tasks.add(command);
            this.sort();
        }
        return add;
    }

    /**
     *
     * @param command
     * @return
     */
    public boolean deleteCommand(Command command) {
        boolean delete = false;
        if (command != null) {
            for (int i = 0; i < tasks.size() && !delete; i++) {
                if (command.getID().compareTo(this.tasks.get(i).getID()) == 0) {
                    Command c = this.tasks.get(i);
                    this.tasks.remove(i);
                    this.deletedCommands.add(c);
                    delete = true;
                }
            }
            this.sort();
        }
        return delete;
    }

    /**
     *
     * @param id
     */
    public void undoCommand(Handler id) {
        for (int i = 0; i < this.tasksDone.size(); i++) {
            Command c = this.tasksDone.get(i);
            if (c.getID().compareTo(id) == 0) {
                c.undo();
            }
        }
    }

    /**
     *
     */
    public void executeTasks() {
        int i = 0;
        while (this.tasks.get(i).getEffectiveDate().getTime() <= this.time.getTime()) {
            Command c = this.tasks.get(i);
            c.execute();
            this.tasks.remove(i);
            this.tasksDone.add(c);
            ++i;
        }
        this.sort();;
    }

    private void sort() {
        Collections.sort(this.tasks, this.comparator);
        Collections.sort(this.tasksDone, this.comparator);
    }

    /**
     *
     * @return
     */
    public List<Command> getDeleteCommands() {
        return new ArrayList<>(this.deletedCommands);
    }

    /**
     *
     * @return
     */
    public List<Command> getTaskList() {
        return new ArrayList<>(this.tasks);
    }

    /**
     *
     * @return
     */
    public List<Command> getTasksListDone() {
        return new ArrayList<>(this.tasksDone);
    }

}
