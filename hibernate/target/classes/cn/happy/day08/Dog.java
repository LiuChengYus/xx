package cn.happy.day08;

/**
 * Created by CY on 2017/12/28.
 */
public class Dog {
    private  Integer dogage;
    private  String  dogname;

    //重写hashCode方法(前提条件必须重写equals方法)
    @Override
    public int hashCode() {
        int result=17;
        result =result * 31+dogage;
        System.out.println(result+"1");
        result =result * 31+dogname.hashCode();
        System.out.println(result+"2");
        return result;
    }

    //重写equals方法
   @Override
    public boolean equals(Object obj) {
       Dog dog= (Dog)obj;
       if (this.getDogname().equals(dog.getDogname())){
           return  true;
       }
        return false;
    }

    public Integer getDogage() {
        return dogage;
    }

    public void setDogage(Integer dogage) {
        this.dogage = dogage;
    }

    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }
}
