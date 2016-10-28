package ui;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


public class Student {
	
	public Student(String id, String marks, String feedback) {
		super();
		this.id = id;
		this.marks = marks;
		this.feedback = feedback;
	}
	String id;
	String marks;
	String feedback;
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}

	

}
