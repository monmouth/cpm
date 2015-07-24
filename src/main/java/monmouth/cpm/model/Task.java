package monmouth.cpm.model;

import java.util.Date;

/**
 * Task class to represent an activity in a project. There're two kinds of Task,
 * one has its own specified start date and the other only has duration.
 * @author ken
 *
 */
public class Task implements Comparable<Object>{
	public static final int START_TASK_ID = Integer.MIN_VALUE;
	public static final int FINISH_TASK_ID = Integer.MAX_VALUE;
	private long id;
	private Date start;
	private Date finish;
	private Date es;
	private Date ef;
	private Date ls;
	private Date lf;
	private int duration;
	private int slack;

	/**
	 * Default non-arg constructor.
	 */
	public Task() {
		
	}

	/**
	 * Constructor for tasks with specified start date.
	 * @param id task id
	 * @param start start date
	 * @param duration task duration in days
	 */
	public Task(int id, Date start, int duration) {
		this.id = id;
		this.start = start;
		this.duration = duration;
	}

	/**
	 * Constructor for tasks with dependent preceding tasks.
	 * @param id task id
	 * @param duration task duration in days
	 */
	public Task(int id, int duration) {
		this.id = id;
		this.duration = duration;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date ps) {
		this.start = ps;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date pf) {
		this.finish = pf;
	}
	

	public Date getEs() {
		return es;
	}

	public void setEs(Date es) {
		this.es = es;
	}

	public Date getEf() {
		return ef;
	}

	public void setEf(Date ef) {
		this.ef = ef;
	}

	public Date getLs() {
		return ls;
	}

	public void setLs(Date ls) {
		this.ls = ls;
	}

	public Date getLf() {
		return lf;
	}

	public void setLf(Date lf) {
		this.lf = lf;
	}

	public int getSlack() {
		return slack;
	}

	public void setSlack(int slack) {
		this.slack = slack;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}	
	
	public boolean isDummy() {
		return false;
	}
	
	public String toString() {
		if (isDummy()) {
			return "Dummy";
		} else {
			return "Task-" + id;
		}
	}

	@Override
	public int compareTo(Object o) {
		Task target = (Task) o;
		return new Long(this.getId() - target.getId()).intValue();
	}
}
