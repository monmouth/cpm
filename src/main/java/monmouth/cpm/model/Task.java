package monmouth.cpm.model;

import java.util.Date;

public class Task {
	private long id;
	private Date start;
	private Date finish;
	private Date es;
	private Date ef;
	private Date ls;
	private Date lf;
	private int duration;
	private int slack;
	
	public Task() {
		
	}
	
	public Task(long id, Date start, Date finish) {
		this.id = id;
		this.start = start;
		this.finish = finish;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
}
