package bank;

import java.io.Serializable;

public class Applications implements Serializable {
	public static final long serialVersionUID = 7162534L;
	
	static Boolean approved;
	String applicant;
	
	public Applications(Boolean approved, String applicant) {
		Applications.approved = approved;
		this.applicant = applicant;
	}

	public static Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		Applications.approved = approved;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
}
