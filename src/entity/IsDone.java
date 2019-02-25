package entity;

public class IsDone extends Entity {

    private static final long serialVersionUID = 1L;

    private Task task;
    
    private boolean isDone;
    
    private String comment;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
    
}
