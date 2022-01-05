package practice.example;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

// 롬복이 getter setter를 자동으로 만들어준다.
// toString() 도 자동으로 만들어준다.
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args){
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("name");
        
        String name=helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("helloLombok  " + helloLombok);

    }

}
