
public class Car {
    String colour;
    String msunufacturer;
    int fuelConsumption;
    int carWeignt;
    int horesePowers;

    public Car() {
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMsunufacturer() {
        return msunufacturer;
    }

    public void setMsunufacturer(String msunufacturer) {
        this.msunufacturer = msunufacturer;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getCarWeignt() {
        return carWeignt;
    }

    public void setCarWeignt(int carWeignt) {
        this.carWeignt = carWeignt;
    }

    public int getHoresePowers() {
        return horesePowers;
    }

    public void setHoresePowers(int horesePowers) {
        this.horesePowers = horesePowers;
    }
    public  void  voice() {
        System.out.println(" Beeep beeep ");
    }
    public  void  carStarted() {
        System.out.println(" Car started ");
    }

    public  void  carSoped() {
        System.out.println(" Car stoped ");
    }
}