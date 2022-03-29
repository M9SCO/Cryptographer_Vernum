import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Cryptographer {




    public static String get_result(String text, String key) {
        text = "success" + text;
        String B64 = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        String binary_normal = Utils.to_binary(B64);

        StringBuilder binary_xor = new StringBuilder();
        for (int i = 0; i < binary_normal.length(); i++) {
            boolean k = (int) key.charAt(i % key.length()) == 49;
            boolean t = (int) binary_normal.charAt(i) == 49;
            int d = (k && !t) || (!k && t) ? 1 : 0;
            binary_xor.append(d);
        }
        return binary_xor.toString();
    }


}
