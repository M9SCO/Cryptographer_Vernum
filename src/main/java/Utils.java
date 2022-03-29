import static java.lang.Math.random;

public class Utils {
    public static String to_binary(String text) {
        StringBuilder bin = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            bin.append(String.format("%8s", Integer.toBinaryString(text.charAt(i))).replaceAll(" ", "0"));
        }
        return bin.toString();
    }

    public static String from_binary(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= text.length() - 8; i += 8) {
            int k = Integer.parseInt(text.substring(i, i + 8), 2);
            stringBuilder.append((char) k);
        }
        return stringBuilder.toString();
    }

    public static String create_key(int length) {

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i<length; i++) buf.append(random() > 0.5 ? "1" : "0");
        return buf.toString();
    }
}
