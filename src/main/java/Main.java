import java.util.Scanner;

public class Main {
    private static String input(String out_text){
        System.out.printf(out_text);
        return new Scanner(System.in).nextLine();
    }
    public static String get_code(String text, String key){
        return Cryptographer.get_result(text, key);
    }
    public static String get_decode(String text, String key) throws Exception {
        return Decoder.get_result(text, key);
    }
    public static void main(String[] args) {
        while (true) {
            String act = input("Выберете действие:%n1. Зашифровать текст%n" +
                    "2. Расшифровать текст%nq. Выйти%n");
            switch (act){
                case "1":
                    System.out.println();
                    String key = input("Введите ключ шифрования (ост. пустым для авт. созд.): ");
                    String text = input("Введите шифруемый текст: ");
                    String binary_key = key.isEmpty()?Utils.create_key(256): Utils.to_binary(key);
                    String binary_result = get_code(text, binary_key);

                    System.out.printf("Результат:%n\"%s\"%n",binary_result);
                    System.out.printf("Ключ:%n\"%s\"%n",binary_key);
                    break;
                case "2":
                    System.out.println();
                    String key_decode = input("Введите ключ дешифровки: ");
                    String text_decode = input("Введите зашифрованный текст: ");
                    try {
                        String result_decode = get_decode(text_decode, key_decode);
                        System.out.printf("Результат:%n\"%s\"%n",result_decode);

                    } catch (Exception e) {
                        System.out.println("Не удалось расшифровать");
                    }
                    break;
                case "q":
                    System.exit(0);
            }
        }
    }
}
