package edu.uclm.esi.iso2.multas.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.uclm.esi.iso2.multas.dao.DriverDao;
import edu.uclm.esi.iso2.multas.dao.GeneralDao;
import edu.uclm.esi.iso2.multas.dao.OwnerDao;

@Entity
@Table
public class Inquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable=false, updatable=false)
	private Date dateOfIssue;
	@Column(nullable=false, updatable=false)
	private String location;
	@ManyToOne(targetEntity=Owner.class)
	private Owner owner;
	@Column(nullable=false, updatable=false)
	private double speed;
	@Column(nullable=false, updatable=false)
	private double maxSpeed;
	@OneToOne(fetch = FetchType.LAZY, targetEntity=Sanction.class, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Sanction sanction;
	
	public Inquiry() {
		
	}
	
	public Inquiry(String license, double speed, String location, double maxSpeed) {
		this();
		this.dateOfIssue=new Date(System.currentTimeMillis());
		this.speed=speed;
		this.maxSpeed=maxSpeed;
		this.location=location;
		this.owner=findOwner(license);
	}

	private Owner findOwner(String license) {
		OwnerDao dao=new OwnerDao();
		return dao.findByLicense(license);
	}

	public Sanction createSanctionFor(String dni) {
		int points=calculatePoints();
		int amount=calculateAmount();
		Sanction sanction=new Sanction();
		DriverDao dao=new DriverDao();
		Driver driver=dao.findByDni(dni);
		sanction.setSanctionHolder(driver);
		sanction.setPoints(points);
		sanction.setAmount(amount);
		GeneralDao<Sanction> daoSanction=new GeneralDao<>();
		daoSanction.insert(sanction);
		return sanction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	private int points(int lInf1, int lSup1, int lSup2){
		if(speed>=lInf1 && speed<=lSup1)
			return 2;
		else if (speed>=(lSup1+1) && speed<=lSup2)
			return 4;
		else if (speed>=(lSup2+1))
			return 6;
		
		return 0;
	}

	private int calculatePoints() {
		if (maxSpeed==30)
			return points(51, 60, 70);
		else if(maxSpeed==40)
			return points(61, 70, 80);
		else if(maxSpeed==50)
			return points(71, 80, 90);
		else if(maxSpeed==60)
			return points(91, 110, 120);
		else if(maxSpeed==70)
			return points(101, 120, 130);
		else if(maxSpeed==80)
			return points(111,130,140);
		else if(maxSpeed==90)
			return points(121, 140, 150);
		else if(maxSpeed==100)
			return points(131, 150, 160);
		else if(maxSpeed==110)
			return points(141,160,170);
		else if(maxSpeed==120)
			return points(151,170,180);
		return -1;
	}
	
	private int amount(int lInf1, int lInf2, int lSup1, int lSup2){
		if (speed<=maxSpeed)
			return 0;
		else if (speed>=(maxSpeed+1) && speed<=lInf1)
			return 100;
		else if (speed>=(lInf1+1) && speed<=lInf2)
			return 300;
		else if (speed>=(lInf2+1) && speed<=lSup1)
			return 400;
		else if (speed>=(lSup1+1) && speed<=lSup2)
			return 500;
		else if (speed>=(lSup2+1))
			return 600;
		return -1;
	}
	
	private int calculateAmount() {
		if (maxSpeed==30) {
			return amount(50, 60, 70, 80);
		} else if (maxSpeed==40) {
			return amount(60, 70, 80, 90);
		} else if (maxSpeed==50) {
			return amount(70, 80, 90, 100);
		} else if (maxSpeed==60) {
			return amount(90, 110, 120, 130);
		} else if (maxSpeed==70) {
			return amount(100, 120, 130, 140);
		} else if (maxSpeed==80) {
			return amount(110, 130, 140, 150);
		} else if (maxSpeed==90) {
			return amount(120, 140, 150, 160);
		} else if (maxSpeed==100) {
			return amount(130, 150, 160, 170);
		} else if (maxSpeed==110) {
			return amount(140, 160, 170, 180);
		} else if (maxSpeed==120) {
			return amount(150, 170, 180, 190);
		}
		return 0;
	}
}
