package jetty;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:52 2018/3/22
 */
public class Persion {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    public  Persion() {
    }
    public Persion setId(int id) {
        this.id = id;
        return this;
    }
    public Persion setName(String name) {
        this.name = name;
        return this;
    }
    public Persion setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    public Persion setAddress(String address) {
        this.address = address;
        return this;
    }
    public Persion printId() {
        System.out.println(this.id);
        return this;
    }
    public Persion printName() {
        System.out.println(this.name);
        return this;
    }
    public Persion printPhoneNumber() {
        System.out.println(this.phoneNumber);
        return this;
    }
    public Persion printAddress() {
        System.out.println(this.address);
        return this;
    }
}
