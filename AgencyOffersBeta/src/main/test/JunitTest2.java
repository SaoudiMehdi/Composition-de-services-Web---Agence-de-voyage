import Beans.Car;
import DAO.CarsDAO;
import org.junit.Test;

public class JunitTest2 {
    @Test
    public void testAdding(){
        // assertTrue(CarsDAO.findAllCars().isEmpty());
        Car c2 = new Car();
        c2.setBrand("Renault 19");

        CarsDAO.saveCar(c2);
        //assertEquals(2, CarsDAO.findAllCars().size());
        CarsDAO.deleteCar(c2);
        //assertEquals(1, CarsDAO.findAllCars().size());
    }

}
