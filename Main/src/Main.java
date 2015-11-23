public class Main {

    public static void main(String[] args) {
//        int ageForMurzik = 3;
//        Cat murzik = new Cat();
//        murzik.setAge(3);
//        murzik.setName("Murzik");
//        murzik.setSex(true);
//        murzik.setWeight(2);
//        System.out.println("Murzik age :" + murzik.getAge() + " Murzik's name: "
//                + murzik.getName() + " Murzik's weight: " + murzik.getWeight());
//
//        Cat barsik = new Cat();
//        barsik.setName("Barsik");
//        barsik.setAge(4);
//        barsik.setWeight(10);
//        System.out.println("Barsik age :" + barsik.getAge() + " Barsik's name: "
//                + barsik.getName() + " Barsik's weight: " +  barsik.getWeight());
//        barsik.voice();
//
//        String murzikCustomVoise = "Myau Myua Myau";
//
//        System.out.println(murzik.retCustomVoice(murzikCustomVoise));

        Car ferrari = new Car();
        ferrari.setCarWeignt(12345);
        ferrari.setColour("Red");
        ferrari.setFuelConsumption(5);
        ferrari.setHoresePowers(700);
        ferrari.setMsunufacturer("Ferrari");
        System.out.println("CarWeight :" + ferrari.getCarWeignt() + " Car Colour " + ferrari.getColour()+
        "Car fuel consuption " + ferrari.getFuelConsumption() + " Car horse powers " + ferrari.getHoresePowers());
              ferrari.carStarted();
        ferrari.carSoped();




    }
}