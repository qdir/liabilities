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
    private final List<Task> tasks;
    /**
     *
     */
    private final List<Task> tasksDone;
    /**
     *
     */
    private final List<Task> deletedCommands;
    /**
     *
     */
    private final TaskDateComparator comparator;
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
        this.comparator = new TaskDateComparator();
        this.time = Time.getInstance();
    }

    /**
     *
     * @param task
     * @return
     */
    public synchronized boolean addTask(Task task) {
        boolean add = true;
        if (task != null) {
            for (int i = 0; i < tasks.size() && add; i++) {
                if (task.getID().compareTo(this.tasks.get(i).getID()) == 0) {
                    add = false;
                }
            }
            this.tasks.add(task);
            this.sort();
        }
        return add;
    }

    /**
     *
     * @param task
     * @return
     */
    public boolean deleteCommand(Task task) {
        boolean delete = false;
        if (task != null) {
            for (int i = 0; i < tasks.size() && !delete; i++) {
                if (task.getID().compareTo(this.tasks.get(i).getID()) == 0) {
                    Task c = this.tasks.get(i);
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
            Task c = this.tasksDone.get(i);
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
            Task c = this.tasks.get(i);
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
    public List<Task> getDeleteCommands() {
        return new ArrayList<>(this.deletedCommands);
    }

    /**
     *
     * @return
     */
    public List<Task> getTaskList() {
        return new ArrayList<>(this.tasks);
    }

    /**
     *
     * @return
     */
    public List<Task> getTasksListDone() {
        return new ArrayList<>(this.tasksDone);
    }

}
