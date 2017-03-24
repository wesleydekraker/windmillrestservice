package nl.wesleydekraker.windmillrestservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Windmill {
	int id;
	String model;
	double power;
	int lengthBlade;
	int heightTower;
	double latitude;
	double longitude;

    public Windmill() {
        super();
    }

    public Windmill(int id) {
        this.id = id;
    }

    public Windmill(int id, String model, double power, int lengthBlade, int heightTower, double latitude, double longitude) {
        this(id);
        this.model = model;
        this.power = power;
        this.lengthBlade = lengthBlade;
        this.heightTower = heightTower;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public double getPower() {
        return power;
    }

    public int getLengthBlade() {
        return lengthBlade;
    }

    public int getHeightTower() {
        return heightTower;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Windmill windmill = (Windmill) o;

        return id == windmill.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
