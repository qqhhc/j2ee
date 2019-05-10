package entity;

/**
 * @Author: qhc
 * @Date: 2019/4/9 15:31
 */
public class Student {
    //属性第一个字符必须小写
    private Integer id;
    private String stuNo;
    private String stuName;
    private String stuBirthday;
    private String stuPhone;
    private String stuAddress;
    private Double stuHeight;

    //空的构造方法
    //带属性的构造方法
    //get/set方法
    //toString方法
    public Student() {
        super();
    }

    public Student(String stuNo, String stuName, String stuBirthday, String stuPhone, String stuAddress, Double stuHeight) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuBirthday = stuBirthday;
        this.stuPhone = stuPhone;
        this.stuAddress = stuAddress;
        this.stuHeight = stuHeight;
    }
    public Student(Integer id, String stuNo, String stuName, String stuBirthday, String stuPhone, String stuAddress, Double stuHeight) {
        this.id = id;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuBirthday = stuBirthday;
        this.stuPhone = stuPhone;
        this.stuAddress = stuAddress;
        this.stuHeight = stuHeight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public Double getStuHeight() {
        return stuHeight;
    }

    public void setStuHeight(Double stuHeight) {
        this.stuHeight = stuHeight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuBirthday='" + stuBirthday + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuHeight=" + stuHeight +
                '}';
    }
}
