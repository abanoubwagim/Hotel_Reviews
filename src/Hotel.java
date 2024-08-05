public class Hotel {
    private int numberphone ;
    private String name , address ;

    public Hotel(int numberphone, String name, String address) {
        this.numberphone = numberphone;
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getNumberphone() {
        return numberphone;
    }

}
