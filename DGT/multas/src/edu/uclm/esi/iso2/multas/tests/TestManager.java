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
}