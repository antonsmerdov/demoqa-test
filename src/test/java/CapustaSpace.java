import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

class Test123 {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
        System.out.println(df.format(new Date()));

    }
}

public class CapustaSpace {
    @Test
    void registration() {
//       open("https://10minutemail.com/");
//       $("copy_icon").click();
        open("https://stage.capusta.space/registration");
       $(".Registration_form_29bPF").shouldBe(visible);
       $("#input-email").setValue(SimpleDateFormat()+"@sdsd.dfd");
       sleep(5000);
       $(".button").click();
       $("#input-link").setValue("test.ru");
       $(".button").click();
       $(".OptionPanel_container_nUU0h").click();

        $(".BaseButton_button_2Jv2Z").click();
       sleep(5000);

    }
}
