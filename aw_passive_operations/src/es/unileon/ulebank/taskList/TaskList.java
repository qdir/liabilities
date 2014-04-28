/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.taskList;

import es.unileon.ulebank.handler.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author runix
 */
public class TaskList {

    private final List<Command> tasks;
    private final List<Command> tasksDone;
    private final CommandDateComparator comparator;
    private final Date date;

    public TaskList() {
        this.tasks = new ArrayList<>();
        this.tasksDone = new ArrayList<>();
        this.comparator = new CommandDateComparator();
        this.date = new Date(System.currentTimeMillis());
    }

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

    public Date getDate() {
        return this.date;
    }

    public List<Command> getTaskList() {
        return new ArrayList<>(this.tasks);
    }

    public List<Command> getTasksListDone() {
        return new ArrayList<>(this.tasksDone);
    }

    public boolean deleteCommand(Command command) {
        boolean delete = false;
        if (command != null) {
            for (int i = 0; i < tasks.size() && !delete; i++) {
                if (command.getID().compareTo(this.tasks.get(i).getID()) == 0) {
                    this.tasks.remove(i);
                    delete = true;
                }
            }
            this.sort();
        }
        this.sort();
        return delete;
    }

    public void undoCommand(Handler id) {
        for (int i = 0; i < this.tasksDone.size(); i++) {
            Command c = this.tasksDone.get(i);
            if(c.getID().compareTo(id) == 0){
               c.undo();
               this.tasksDone.remove(i);
            }
        }
    }

    public void setTime(long timestamp) {
        this.date.setTime(timestamp);
    }

    public void executeTasks() {
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getEffectiveDate().getTime() <= this.date.getTime()) {
                Command c = this.tasks.get(i);
                c.execute();
                this.tasks.remove(i);
                this.tasksDone.add(c);
            }
        }
        this.sort();;
    }

    public void setTime(Date date) {
        this.setTime(date.getTime());
    }

    public void forwardDays(int days) {
        if (days > 0) {
            //days * hours* minutes* seconds * milliseconds
            long timeToForward = (long) (days) * 24 * 60 * 60 * 1000;
            this.date.setTime(timeToForward + this.date.getTime());
            this.executeTasks();
        }
    }

    public void backwardDays(int days) {
        if (days > 0) {
            //Undo tasks ?
            long timeToForward = (long) (-days) * 24 * 60 * 60 * 1000;
            this.date.setTime(timeToForward + this.date.getTime());
        }
    }

    private void sort() {
        Collections.sort(this.tasks, this.comparator);
        Collections.sort(this.tasksDone, this.comparator);
    }
}
