package bot;

public class ElementInfo {

    private int serialNumber;

    private String abbreviation;

    private String russianName;

    private float mass;

    ElementInfo(int serialNumber,String abbreviation,String  russianName,float mass) {
        this.abbreviation = abbreviation;
        this.mass = mass;
        this.russianName = russianName;
        this.serialNumber = serialNumber;
    }


    @Override
    public String toString() {
        return "ElementInfo{" +
                "serialNumber=" + serialNumber +
                ", abbreviation='" + abbreviation + '\'' +
                ", russianName='" + russianName + '\'' +
                ", mass=" + mass +
                '}';
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getRussianName() {
        return russianName;
    }

    public void setRussianName(String russianName) {
        this.russianName = russianName;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}
