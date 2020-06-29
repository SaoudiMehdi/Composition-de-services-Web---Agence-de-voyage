import Beans.Car;
import DAO.CarsDAO;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
@RunAsClient
public class testArchive {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Car.class, CarsDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testFinder(){
        assertTrue(!CarsDAO.findAllCars().isEmpty());
        System.out.println(String.format("Total of Cars %d", CarsDAO.findAllCars().size()));

        assertEquals(31, CarsDAO.findAllCars().size());
    }

    @Inject
    private Car car;



    @Test
    public void testAdding(){
        // assertTrue(CarsDAO.findAllCars().isEmpty());
        Car c2 = new Car();
        car.setBrand("Renault 19");
        c2.setBrand("Renault 19");

        CarsDAO.saveCar(car);
        //assertEquals(2, CarsDAO.findAllCars().size());
        CarsDAO.deleteCar(car);
        //assertEquals(1, CarsDAO.findAllCars().size());
    }


}
