package com.ntuc.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20, nullable = true)
	private String firstname;
	
	@Column(length = 25, nullable = false)
	private String lastname;
	@Column(length = 25, nullable = false)
	private String email;
	@Column(length = 20, nullable = true)
	private String phone;
	@Column(nullable = false)
	private Date hiredate;
	@Column(length = 10, nullable = false)
	private String jobid;
	
	private Float salary;
	private Float commpct;
	private Integer mgrid;
	private Integer deptid;
	
//	@ManyToOne
//	@JoinColumn(name="deptid")
//	private department dept;
	
//	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//	private List<EmployeeDetail> details = new ArrayList<>();
	
	

	
	

	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public employee(Integer id, String firstname, String lastname, String email, String phone, Date hiredate, String jobid,
		Float salary, Float commpct, Integer mgrid, Integer deptid) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.phone = phone;
	this.hiredate = hiredate;
	this.jobid = jobid;
	this.salary = salary;
	this.commpct = commpct;
	this.mgrid = mgrid;
	this.deptid = deptid;
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Float getCommpct() {
		return commpct;
	}

	public void setCommpct(Float commpct) {
		this.commpct = commpct;
	}

	public Integer getMgrid() {
		return mgrid;
	}

	public void setMgrid(Integer mgrid) {
		this.mgrid = mgrid;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	
	/*public List<EmployeeDetail> getDetails(){
		return details;
	}
	
	public void setDetails(List<EmployeeDetail> details) {
		this.details = details;
	}
	
*/
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commpct == null) ? 0 : commpct.hashCode());
		result = prime * result + ((deptid == null) ? 0 : deptid.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((hiredate == null) ? 0 : hiredate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jobid == null) ? 0 : jobid.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((mgrid == null) ? 0 : mgrid.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}



	@Override
	public String toString() {
		return "employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phone=" + phone + ", hiredate=" + hiredate + ", jobid=" + jobid + ", salary=" + salary
				+ ", commpct=" + commpct + ", mgrid=" + mgrid + ", deptid=" + deptid + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		employee other = (employee) obj;
		if (commpct == null) {
			if (other.commpct != null)
				return false;
		} else if (!commpct.equals(other.commpct))
			return false;
		if (deptid == null) {
			if (other.deptid != null)
				return false;
		} else if (!deptid.equals(other.deptid))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (hiredate == null) {
			if (other.hiredate != null)
				return false;
		} else if (!hiredate.equals(other.hiredate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jobid == null) {
			if (other.jobid != null)
				return false;
		} else if (!jobid.equals(other.jobid))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (mgrid == null) {
			if (other.mgrid != null)
				return false;
		} else if (!mgrid.equals(other.mgrid))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
	
	
	
}
