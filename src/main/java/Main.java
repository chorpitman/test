import static java.lang.Character.toUpperCase;

public class Main {

//    public static String lat2cyr(String s) {
//        StringBuilder sb = new StringBuilder(s.length());
//        int i = 0;
//        while (i < s.length()) {// Идем по строке слева направо. В принципе, подходит для обработки потока
//            char ch = s.charAt(i);
//            boolean lc = Character.isLowerCase(ch); // для сохранения регистра
//            ch = toUpperCase(ch);// поднимаю регистр
//
//            if (ch == 'Y' & (i + 1 < s.length())) {
//                // Префиксная нотация вначале.
//                // Проверяем, что символ первый, что с него начинается слово
//                i++; // преходим ко второму символу сочетания
//                ch = toUpperCase(s.charAt(i));
//                switch (ch) {
//                    case 'E':
//                        sb.append(ch('Є', lc));
//                        break;
//                    case 'I':
//                        sb.append(ch('Ї', lc));
//                        break;
//                    case 'U':
//                        sb.append(ch('Ю', lc));
//                        break;
//                    case 'A':
//                        sb.append(ch('Я', lc));
//                        break;
//                    default: //проверяем первый ли это символ
//                        if (i == 1) {
//                            sb.append(ch('Й', lc));
//                        } else {
//                            sb.append(ch('И', lc));
//                        }
//                        i--;
//                }
//            }
//
//            else if (ch == 'I' & i > 0 & (i + 1 < s.length())) {
//                // Префиксная нотация вначале.
//                // Если с искомого символа начинается слово.
//                i++;
//                // преходим ко второму символу сочетания
//                ch = toUpperCase(s.charAt(i));
//                switch (ch) {
//                    case 'E':
//                        sb.append(ch('Є', lc));
//                        break;
//                    case 'U':
//                        sb.append(ch('Ю', lc));
//                        break;
//                    case 'A':
//                        sb.append(ch('Я', lc));
//                        break;
//                    default:
//                        sb.append(ch('І', lc));
//                        // если не встретили искомое совпадение, то возращаемся на одну последовательному поиску.
//                        i--;
//                }
//            }
//
//            else if (ch == 'S' & i >= 0 & (i + 1 < s.length())) { // Префиксная нотация вначале.  Если с искомого символа начинается слово.
//                i++; // преходим ко второму символу сочетания
//                ch = toUpperCase(s.charAt(i));
//                switch (ch) {
//                    case 'H':
//                        sb.append(ch('Ш', lc));
//                        break;
//                    default:
//                        sb.append(ch('C', lc));
//
//                        // если не встретили искомое совпадение, то возращаемся на одну последовательному поиску.
//                        i--;
//                }
//            }
//
//            else if (ch == 'C' & (i + 1 < s.length())) {
//                // Префиксная нотация вначале.  Если с искомого символа начинается слово.
//                i++; // преходим ко второму символу сочетания
//                ch = toUpperCase(s.charAt(i));
//                switch (ch) {
//                    case 'H':
//                        sb.append(ch('Ч', lc));
//                        break;
//                    default: // если не встретили искомое совпадение, то возращаемся на одну последовательному поиску.
//                        i--;
//                }
//            }
//
//            else if (ch == 'K' & (i + 1 < s.length())) { //
//                i++; // преходим ко второму символу сочетания
//                ch = toUpperCase(s.charAt(i));
//                switch (ch) {
//                    case 'H':
//                        sb.append(ch('X', lc));
//                        break;
//                    default: // если не встретили искомое совпадение, то возращаемся на одну последовательному поиску.
//                        sb.append(ch('К', lc));
//                        i--;
//                }
//            }
//
//            else if (ch == 'T' & (i + 1 < s.length())) { //
//                i++; // преходим ко второму символу сочетания
//                ch = toUpperCase(s.charAt(i));
//                switch (ch) {
//                    case 'S':
//                        sb.append(ch('Ц', lc));
//                        break;
//                    default: // если не встретили искомое совпадение, то возращаемся на одну последовательному поиску.
//                        sb.append(ch('Т', lc));
//                        i--;
//                }
//            }
//
//            else if (ch == 'Z' & (i + 1 < s.length())) { //
//                i++; // преходим ко второму символу сочетания
//                ch = toUpperCase(s.charAt(i));
//                switch (ch) {
//                    case 'H':
//                        sb.append(ch('Ж', lc));
//                        break;
//                    case 'G':
//                        sb.append(ch('З', lc));
//                        break;
//                    default: // если не встретили искомое совпадение, то возращаемся на одну последовательному поиску.
//                        sb.append(ch('З', lc));
//                        i--;
//                }
//            }
//
////            else if (i + 1 < s.length() && toUpperCase(s.charAt(i + 1)) == 'H') {// Постфиксная нотация, требует информации о двух следующих символах. Для потока придется сделать обертку с очередью из трех символов.
////                switch (ch) {
////                    case 'Z':
////                        sb.append(ch('Ж', lc));
////                        break;
////                    case 'K':
////                        sb.append(ch('Х', lc));
////                        break;
////                    case 'C':
////                        sb.append(ch('Ч', lc));
////                        break;
////                    case 'S':
////                        if (i + 2 < s.length() && toUpperCase(s.charAt(i + 2)) == 'H') { // проверка на двойной постфикс
////                            sb.append(ch('Щ', lc));
////                            i++; // пропускаем первый постфикс
////                        } else {
////                            sb.append(ch('Ш', lc));
////                        }
////                        break;
////                    case 'E':
////                        sb.append(ch('Э', lc));
////                        break;
////                    case 'I':
////                        sb.append(ch('Ы', lc));
////                        break;
////                    default:
////                        throw new IllegalArgumentException("Illegal transliterated symbol '" + ch + "' at position " + i);
////                }
////                i++; // пропускаем постфикс
////            }
//            else {// одиночные символы
//                switch (ch) {
//                    case 'A':
//                        sb.append(ch('А', lc));
//                        break;
//                    case 'B':
//                        sb.append(ch('Б', lc));
//                        break;
//                    case 'V':
//                        sb.append(ch('В', lc));
//                        break;
//                    case 'H':
//                        sb.append(ch('Г', lc));
//                        break;
//                    case 'G':
//                        sb.append(ch('Ґ', lc));
//                        break;
//                    case 'D':
//                        sb.append(ch('Д', lc));
//                        break;
//                    case 'Z':
//                        sb.append(ch('З', lc));
//                        break;
//                    case 'I':
//                        sb.append(ch('И', lc));
//                        break;
//                    case 'Y':
//                        sb.append(ch('И', lc));
//                        break;
//                    case 'K':
//                        sb.append(ch('К', lc));
//                        break;
//                    case 'L':
//                        sb.append(ch('Л', lc));
//                        break;
//                    case 'M':
//                        sb.append(ch('М', lc));
//                        break;
//                    case 'N':
//                        sb.append(ch('Н', lc));
//                        break;
//                    case 'O':
//                        sb.append(ch('О', lc));
//                        break;
//                    case 'P':
//                        sb.append(ch('П', lc));
//                        break;
//                    case 'R':
//                        sb.append(ch('Р', lc));
//                        break;
//                    case 'S':
//                        sb.append(ch('С', lc));
//                        break;
//                    case 'T':
//                        sb.append(ch('Т', lc));
//                        break;
//                    case 'U':
//                        sb.append(ch('У', lc));
//                        break;
//                    case 'F':
//                        sb.append(ch('Ф', lc));
//                        break;
//                    default:
//                        sb.append(ch(ch, lc));
//                }
//            }
//
//            i++; // переходим к следующему символу
//        }
//        return sb.toString();
//    }
//
//    /**
//     * Вспомогательная функция для восстановления регистра
//     */
//
//    private static char ch(char ch, boolean toLowerCase) {
//        if (toLowerCase) return Character.toLowerCase(ch);
//        else return ch;
//    }

    /**
     * Пробы
     */
    public static void main(String[] args) {
        Transliterator transliterator = new Transliterator();
        String s1 = "Alushta";
        String s2 = "Borshchahivka";
        String s3 = "Vyshhorod";
        String s4 = "Hadiach";
        String s5 = "Zghorany";
        String s6 = "Galagan";
        String s7 = "Dmytro";
        String s8 = "Esman";
        String s9 = "Yenakiieve";
        String s10 = "Naienko";
        String s11 = "Zhytomyr";
        String s12 = "Zakarpattia";
        String s13 = "Medvyn";
        String s14 = "Irshava";
        String s15 = "Staryye Skomorokhi";
        String s16 = "Bila Tserkva";

//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println(s5);
//        System.out.println(s6);
//        System.out.println(s7);
//        System.out.println(s8);
//        System.out.println(s11);
        System.out.println(s16);
        System.out.println("======================");
        System.out.println(transliterator.lat2cyr(s1));
        System.out.println(transliterator.lat2cyr(s2));
        System.out.println(transliterator.lat2cyr(s3));
        System.out.println(transliterator.lat2cyr(s4));
        System.out.println(transliterator.lat2cyr(s5));
        System.out.println(transliterator.lat2cyr(s6));
        System.out.println(transliterator.lat2cyr(s7));
        System.out.println(transliterator.lat2cyr(s8));
        System.out.println(transliterator.lat2cyr(s9));
        System.out.println(transliterator.lat2cyr(s10));
        System.out.println(transliterator.lat2cyr(s11));
        System.out.println(transliterator.lat2cyr(s12));
        System.out.println(transliterator.lat2cyr(s13));
        System.out.println(transliterator.lat2cyr(s14));
        System.out.println(transliterator.lat2cyr(s15));
        System.out.println(transliterator.lat2cyr(s16));

    }
}