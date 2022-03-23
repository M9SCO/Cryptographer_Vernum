import java.util.Base64;

public class Decoder {
    public static String get_result(String text, String key) {
        String binary_xor = Utils.to_binary(text);
        StringBuilder binary_normal = new StringBuilder();
        for (int i = 0; i < binary_xor.length(); i++) {
            boolean k = (int) key.charAt(i % key.length())==49;
            boolean t = (int) binary_xor.charAt(i)==49;
            int d = (k && !t) || (!k && t)? 1:0;
            binary_normal.append(d);
        }

        String B64 = Utils.from_binary(binary_normal.toString());


        byte [] barr = Base64.getDecoder().decode(B64);
        return new String(barr);

    }

}