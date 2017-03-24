package nl.wesleydekraker.windmillrestservice;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WindmillServiceImplTest {
    private WindmillServiceImpl windmillServiceImpl = ServiceProvider.getWindmillService();

    // Unit tests
    @Test
    public void read() throws Exception {
        assertFalse("De methode read geeft het niet aan als een object niet gevonden is!",
                checkIfWindmill1Exists());
    }

    @Test
    public void update() throws Exception {
        assertFalse("De methode update geeft het niet aan als een object niet gevonden is!",
                updateWindmill1ToWindmill2());
    }

    @Test
    public void delete() throws Exception {
        assertFalse("De methode delete geeft het niet aan als een object niet gevonden is!",
                deleteWindmill2());
    }

    // Integration tests
    @Test
    public void crud() throws Exception {
        createWindmill1();

        assertTrue("Windmolen 1 is niet goed opslagen!",
                checkIfWindmill1Exists());

        updateWindmill1ToWindmill2();

        assertTrue("Windmolen 1 is niet geüpdate naaar windmolen 2!",
                checkIfWindmill2Exists());

        deleteWindmill2();

        assertFalse("Windmolen 2 is niet correct verwijderd!",
                checkIfWindmill2Exists());
    }

    private Windmill getWindmill1() {
        return new Windmill(2,
                "GE 1.5MW", 1.5,
                116, 212,
                52.325491, 4.579099);
    }

    private Windmill getWindmill2() {
        return new Windmill(2,
                "GE 1.7MW", 1.7,
                116, 212,
                52.325491, 4.579099);
    }

    private boolean compareWindmills(Windmill details1, Windmill details2) {
        return details1.getModel().equals(details2.getModel()) &&
                details1.getPower() == details2.getPower() &&
                details1.getHeightTower() == details2.getHeightTower() &&
                details1.getLengthBlade() == details2.getLengthBlade() &&
                details1.getLatitude() == details2.getLatitude() &&
                details1.getLongitude() == details2.getLongitude();
    }

    private void createWindmill1() throws Exception {
        windmillServiceImpl.create(getWindmill1());
    }

    private boolean checkIfWindmill1Exists() throws Exception {
        Windmill windmill = windmillServiceImpl.read(getWindmill1().getId());

        if (windmill != null) {
            return compareWindmills(getWindmill1(), windmill);
        };

        return false;
    }

    private boolean updateWindmill1ToWindmill2() throws Exception {
        return windmillServiceImpl.update(getWindmill2());
    }

    private boolean checkIfWindmill2Exists() throws Exception {
        Windmill windmill = windmillServiceImpl.read(getWindmill2().getId());

        if (windmill != null) {
            return compareWindmills(getWindmill2(), windmill);
        };

        return false;
    }

    private boolean deleteWindmill2() throws  Exception {
        return windmillServiceImpl.delete(getWindmill2().getId());
    }
}