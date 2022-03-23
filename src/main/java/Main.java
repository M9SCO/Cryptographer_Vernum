import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String text = "а я хочу THREE HUNDRED BUCKS";
        System.out.println(text);

        String key = Utils.create_key(Utils.to_binary(Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8))).length());

        String res = Cryptographer.get_result(text, key);
        System.out.println("===-===");
        System.out.println(res);
        System.out.println(Utils.from_binary(key));
        System.out.println("===-===");

        String revert = Decoder.get_result(res, key);

        System.out.println(revert);

    }


}
