import java.util.Scanner;
import java.util.regex.Pattern;
public class Main {
    static Scanner in = new Scanner(System.in);
    static boolean stop;
    public static void main(String[] args) {
        for (;;) {
            System.out.println(calc(in.next()));
            if (stop) break;
        }
    }
    public static String calc(String input) {
        Num number1 = new Num();
        Num number2 = new Num();
        String data1 = "2345678910";
        String data2 = "IIIVIIIX";
        int numArab = 0;
        String RezultStr = "";

        Pattern operator = Pattern.compile("[\\+\\-\\/\\*]");
        String[] parts = operator.split(input.toUpperCase());
        try {
            if (parts.length != 2) {
                throw new Exception ("��������� ���������  ������� �������� ��� ������� �������. ���� �� �������� �������������� ���������. ");
            } else if ((parts.length == 2) && (data1.contains(parts[0])) && (data1.contains(parts[1]))) {
                if ((Integer.parseInt(parts[0]) >= 0) && (Integer.parseInt(parts[0]) <= 10) && (Integer.parseInt(parts[1]) >= 0) && (Integer.parseInt(parts[0]) <= 10)) {
                    number1.languge = 0;
                    if (input.contains("+")) number1.rezult = (Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]));
                    if (input.contains("-")) number1.rezult = (Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]));
                    if (input.contains("*")) number1.rezult = (Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]));
                    if (Integer.parseInt(parts[1])==0) throw new Exception("�� ���� ������ ������.");
                    if (input.contains("/")) number1.rezult = (Integer.parseInt(parts[0]) / Integer.parseInt(parts[1]));
                }
            } else if ((parts.length == 2) && (data2.contains(parts[0])) && (data2.contains(parts[1]))) {
                number1.languge = 1;
                number1.unitRom = parts[0];
                number2.unitRom = parts[1];
                if (input.contains("+")) numArab = number1.unitRomToArab() + number2.unitRomToArab();
                if (input.contains("-")) numArab = number1.unitRomToArab() - number2.unitRomToArab();
                if (input.contains("*")) numArab = number1.unitRomToArab() * number2.unitRomToArab();
                if (input.contains("/")) numArab = number1.unitRomToArab() / number2.unitRomToArab();
                if (numArab < 1) throw new Exception ("� ������� ������� ��� ������������� ����� ��� ����.");
                number1.numU = numArab % 10;
                number1.numT = numArab / 10;
            } else {
                throw new Exception ("��������� ������ ��� ������������ ���������. ������������� ���� ��������(�� 1 �� 10) ����(������� �� I �� X).");
            }

            switch (number1.languge) {
                case 0:
                    RezultStr = number1.toString();
                    stop=false;
                    break;
                case 1:
                    RezultStr = (number1.tensArabToRom() + number1.unitArabToRom());
                    stop=false;
                    break;
            }
        }
        catch(Exception ex){
             RezultStr=ex.getMessage();
             stop=true;
         }
        return RezultStr;
}
}
class Num {
    int rezult;
    String p="";
    int languge;
    int numU, numT, numR;
    String a, b, unitRom;
    public String toString(){
        return p+rezult;
    }

      String unitArabToRom() {
        switch (numU) {
            case 0:
                a = "";
                break;
            case 1:
                a = "I";
                break;
            case 2:
                a = "II";
                break;
            case 3:
                a = "III";
                break;
            case 4:
                a = "IV";
                break;
            case 5:
                a = "V";
                break;
            case 6:
                a = "VI";
                break;
            case 7:
                a = "VII";
                break;
            case 8:
                a = "VIII";
                break;
            case 9:
                a = "IX";
                break;
        }
        return a;
    }

    String tensArabToRom() {
        switch (numT) {
            case 0:
                b = "";
                break;
            case 1:
                b = "X";
                break;
            case 2:
                b = "XX";
                break;
            case 3:
                b = "XXX";
                break;
            case 4:
                b = "XL";
                break;
            case 5:
                b = "L";
                break;
            case 6:
                b = "LX";
                break;
            case 7:
                b = "LXX";
                break;
            case 8:
                b = "LXXX";
                break;
            case 9:
                b = "XC";
                break;
            case 10:
                b = "C";
                break;
        }
        return b;
    }

    int unitRomToArab() {
        switch (unitRom) {
            case "I":
                numR = 1;
                break;
            case "II":
                numR = 2;
                break;
            case "III":
                numR = 3;
                break;
            case "IV":
                numR = 4;
                break;
            case "V":
                numR = 5;
                break;
            case "VI":
                numR = 6;
                break;
            case "VII":
                numR = 7;
                break;
            case "VIII":
                numR = 8;
                break;
            case "IX":
                numR = 9;
                break;
            case "X":
                numR = 10;
                break;
        }
        return numR;
    }
}
/*System.out.println("��������� ��������� �� �������� �������������� ��������� ���� ������� ������������ ������.");
        System.out.println("������� ������� ���������. ���������� ������ ��� �����.");
        System.out.println("����� ������ ���� �� 1 �� 10 ������������.");
        System.out.println("��������� ����� ������ ���� ������.");
        System.out.println("����������� ����� �������� ������������ ���� � ��������� ���� �������� �������.");
        System.out.println("������� ������������ ������.");
        System.out.println("����������� ������ ������������ � �������� ������� ����� ���� ������ ������������� �����.");
 */