import DAO.CarsDAO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitTest {
    @Test
    public void testFinder(){
        assertTrue(!CarsDAO.findAllCars().isEmpty());
        System.out.println(String.format("Total of Cars %d", CarsDAO.findAllCars().size()));

        assertEquals(31, CarsDAO.findAllCars().size());
    }
}
