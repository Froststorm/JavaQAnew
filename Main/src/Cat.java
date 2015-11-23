public class Cat {
  int age, weight;
  String name;
  boolean sex;

    public Cat() {
    }

    public Cat(int age, int weight, String name, boolean sex) {
        this.age = age;
        this.weight = weight;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public  void  voice(){
        System.out.println("Myau...myau");
    }
    public  String retCustomVoice (String customVoice){
        return  customVoice;
    }
}
