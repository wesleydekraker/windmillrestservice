package nl.wesleydekraker.windmillrestservice;

import java.util.ArrayList;
import java.util.List;

public class WindmillServiceImpl {
    private List<Windmill> windmills = new ArrayList<>();

	public WindmillServiceImpl() {
		windmills.add(new Windmill(1,
                "GE 1.5MW", 1.5,
                116, 212,
                52.325491, 4.579099));
	}

    public Windmill create(Windmill windmill) {
	    windmill.setId(newId());
        windmills.add(windmill);

        return windmill;
    }

    public List<Windmill> readAll() {
        return windmills;
    }

    public Windmill read(int id) {
	    int index = windmills.indexOf(new Windmill(id));

        if (index != -1) {
            return windmills.get(index);
        }

        return null;
    }

    public boolean update(Windmill windmill) {
        int index = windmills.indexOf(windmill);

        if (index != -1) {
            windmills.set(index, windmill);
            return true;
        }

        return false;
    }

	public boolean delete(int id) {
		return windmills.remove(new Windmill(id));
	}

    private int newId() {
        int max = 0;
        for (Windmill windmill : windmills) {
            if (max < windmill.getId()) {
                max = windmill.getId();
            }
        }

        return max + 1;
    }
}
