package InterstingInfo;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class softAssertionExample {

    @Test
    public void Test1(){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(5).isEqualTo(5);
        softAssertions.assertAll();

    }


    @Test
    public void Test2(){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(5).isEqualTo(5);
        softAssertions.assertAll();
        System.out.println("test done");
    }
}
