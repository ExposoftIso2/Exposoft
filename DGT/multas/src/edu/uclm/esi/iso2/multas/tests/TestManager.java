package edu.uclm.esi.iso2.multas.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.DriverManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import edu.uclm.esi.iso2.multas.dao.DriverDao;
import edu.uclm.esi.iso2.multas.dao.GeneralDao;
import edu.uclm.esi.iso2.multas.domain.Driver;
import edu.uclm.esi.iso2.multas.domain.Inquiry;
import edu.uclm.esi.iso2.multas.domain.Manager;
import edu.uclm.esi.iso2.multas.domain.Sanction;

public class TestManager {
    
    private Configuration cfg;
    private SessionFactory factory;
    private Session session;
    Connection con;
    Statement st;
    @Before
    public void setUp() throws IOException {

        cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        factory=cfg.buildSessionFactory();
        session=factory.openSession();

        Transaction t=session.beginTransaction();
        Query<Inquiry> query=session.createQuery("delete from Inquiry");
        query.executeUpdate();
        query=session.createQuery("delete from Sanction");
        query.executeUpdate();
        t.commit();
    }

    @Test
    public void test200_120() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 200, "Ciudad Real", 120);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test181_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 181, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test190_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 190, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test180_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 180, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test171_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 171, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test170_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 170, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test151_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 151, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test150_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 150, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test121_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 121, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test120_120() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 120, "Ciudad Real", 120);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test181_110() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 181, "Ciudad Real", 110);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test180_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 180, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test171_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 171, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test170_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 170, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test161_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 161, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test160_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 160, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test141_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 141, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test140_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 140, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test111_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 111, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test110_110() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 110, "Ciudad Real", 110);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test171_100() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 171, "Ciudad Real", 100);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test170_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 170, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test161_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 161, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test160_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 160, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test151_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 151, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test150_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 150, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test131_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 131, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test130_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 130, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test101_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 101, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test100_100() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 100, "Ciudad Real", 100);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test161_90() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 161, "Ciudad Real", 90);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test160_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 160, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test151_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 151, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test150_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 150, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test141_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 141, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test140_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 140, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test121_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 121, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test120_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 120, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test91_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 91, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test90_90() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 90, "Ciudad Real", 90);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test151_80() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 151, "Ciudad Real", 80);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test150_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 150, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test141_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 141, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test140_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 140, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test131_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 131, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test130_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 130, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test111_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 111, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test110_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 110, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test81_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 81, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test80_80() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 80, "Ciudad Real", 80);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test141_70() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 141, "Ciudad Real", 70);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test140_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 140, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test131_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 131, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test130_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 130, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test121_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 121, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test120_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 120, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test101_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 101, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test100_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 100, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test71_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 71, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test70_70() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 70, "Ciudad Real", 70);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test131_60() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 131, "Ciudad Real", 60);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test130_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 130, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test121_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 121, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test120_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 120, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test111_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 111, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test110_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 110, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test91_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 91, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test90_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 90, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test61_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 61, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test60_60() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 60, "Ciudad Real", 60);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
  
    @Test
    public void test101_50() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 101, "Ciudad Real", 50);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test100_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 100, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test91_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 91, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test90_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 90, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test81_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 81, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test80_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 80, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test71_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 71, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test70_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 70, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test51_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 51, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test50_50() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 50, "Ciudad Real", 50);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    
    @Test
    public void test91_40() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 91, "Ciudad Real", 40);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test90_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 90, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test81_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 81, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test80_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 80, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test71_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 71, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test70_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 70, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test61_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 61, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test60_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 60, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test41_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 41, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test40_40() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 40, "Ciudad Real", 40);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }  
    
    @Test
    public void test81_30() {
        Manager m = Manager.get();
        int idInquiry = m.openInquiry("0000", 81, "Ciudad Real", 30);
        GeneralDao <Inquiry>dao = new GeneralDao<>();
        Inquiry i=dao.findById(Inquiry.class, idInquiry);
        //comprobacion de que se genera la inquiry
        assertNotNull(i);
        Sanction s= m.identifyDriver(idInquiry, "5000000");
        
        //comprobacion sancion correcta
        assertTrue(s.getAmount()==600);
        assertTrue(s.getPoints()==6);
        
        DriverDao dDao = new DriverDao();
        Driver driver = dDao.findByDni("5000000");
        int puntos_antes=driver.getPoints();
        m.pay(s);
        Driver driverActualizado = dDao.findByDni("5000000");
        //comprobacion del pago y resta de puntos
        assertNotNull(s.getDateOfPayment());
        assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
   }
    @Test
    public void test80_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 80, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test71_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 71, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==500);
    	assertTrue(s.getPoints()==6);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-6));
    }
    @Test
    public void test70_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 70, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test61_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 61, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==400);
    	assertTrue(s.getPoints()==4);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-4));
    }
    @Test
    public void test60_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 60, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test51_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 51, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==300);
    	assertTrue(s.getPoints()==2);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-2));
    }
    @Test
    public void test50_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 50, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test31_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 31, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	assertTrue(s.getAmount()==100);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }
    @Test
    public void test30_30() {
    	Manager m = Manager.get();
    	int idInquiry = m.openInquiry("0000", 30, "Ciudad Real", 30);
    	GeneralDao <Inquiry>dao = new GeneralDao<>();
    	Inquiry i=dao.findById(Inquiry.class, idInquiry);
    	//comprobacion de que se genera la inquiry
    	assertNotNull(i);
    	Sanction s= m.identifyDriver(idInquiry, "5000000");

    	//comprobacion sancion correcta
    	System.out.println(s.getAmount());
    	assertTrue(s.getAmount()==0);
    	assertTrue(s.getPoints()==0);

    	DriverDao dDao = new DriverDao();
    	Driver driver = dDao.findByDni("5000000");
    	int puntos_antes=driver.getPoints();
    	m.pay(s);
    	Driver driverActualizado = dDao.findByDni("5000000");
    	//comprobacion del pago y resta de puntos
    	assertNotNull(s.getDateOfPayment());
    	assertTrue(driverActualizado.getPoints()==(puntos_antes-0));
    }    
}