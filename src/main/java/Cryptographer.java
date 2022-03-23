import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static java.lang.Math.random;
import static java.lang.Math.scalb;

public class Cryptographer {




    public static String get_result(String text, String key) {
        String B64 = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        String binary_normal = Utils.to_binary(B64);

        StringBuilder binary_xor = new StringBuilder();
        for (int i = 0; i < binary_normal.length(); i++) {
            boolean k = (int) key.charAt(i % key.length()) == 49;
            boolean t = (int) binary_normal.charAt(i) == 49;
            int d = (k && !t) || (!k && t) ? 1 : 0;
            binary_xor.append(d);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i <= binary_xor.length() - 8; i += 8) {
            int k = Integer.parseInt(binary_xor.substring(i, i + 8), 2);
            output.append((char) k);
        }
        return output.toString();
    }


}
