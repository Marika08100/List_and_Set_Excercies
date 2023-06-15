import java.util.*;

public class Main {

    public static void main(String[] args) {

        addNumber();
        separateEvenAndOddNumbers();
        diceRolls();
        countRolledNumber(diceRolls(), 3);
        containsRepeat();
        getLength();
        getMaxAndMinLength();
    }


    /*     1. Adott az alábbi tömb:
           int[] numbers = {1, 2, 7, 2, 3, 4, 10, 8, 9, 11, 5, 4, 3, 6, 5, 6, 5, 1, 8, 10, 9, 15};
           Készíts Set-et ebből a tömbből úgy, hogy végigmész a tömbön, és egyesével hozzáadod a Set-hez a tömbben szereplő számokat.
           Hány darab különböző számot tartalmaz a tömb? (A létrehozott Set alapján ez már könnyen megmondható.) Gondolkozz!
                   Miért nem jó a kérdés megválaszolására, ha List-et készítesz Set helyett?
                   És milyen sorrendben szerepelnek a számok a létrehozott Set-ben? (Írd ki a képernyőre, nézd meg!) <- novekvo
        */
    public static void addNumber() {

        int[] numbers = {1, 2, 7, 2, 3, 4, 10, 8, 9, 11, 5, 4, 3, 6, 5, 6, 5, 1, 8, 10, 9, 15};

        Set<Integer> array = new HashSet<>();
        for (int number : numbers) {
            array.add(number);
        }
        System.out.println(array);

    }


    /*       2. Az előző feladat tömbjét használd!
                   Válogasd szét a tömb számait: külön legyenek a párosok, külön a páratlanok.
           Ezúttal is használj Set-et!
                   Hány darab különböző páros és páratlan számot tartalmaz a tömb?
   */
    public static void separateEvenAndOddNumbers() {
        int[] numbers = {1, 2, 7, 2, 3, 4, 10, 8, 9, 11, 5, 4, 3, 6, 5, 6, 5, 1, 8, 10, 9, 15};

        Set<Integer> even = new HashSet<>();
        Set<Integer> odd = new HashSet<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                even.add(number);
            } else {
                odd.add(number);
            }
        }
        int countOdd = odd.size();
        int countEven = even.size();
        System.out.println("Different even numbers " + countEven);
        System.out.println("Different odd numbers " + countOdd);
    }

    /*
    3. Készíts egy dobókockát (random szám generálás 1-6 között), amivel dobj 1000-szer!
    A dobás eredményeit List-ben tárold! Számítsd ki a dobások átlagát!
     Írd ki minden számra, hányszor lett dobva! Pl. 1 -> 150 db dobás
*/
    public static List<Integer> diceRolls() {
        List<Integer> diceRolls = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int rolledNumber = random.nextInt(6) + 1;
            diceRolls.add(rolledNumber);

        }
        int sum = 0;
        for (int number : diceRolls) {
            sum += number;
        }

        double average = (double) sum / diceRolls.size();
        System.out.println("The average of rolls " + average);

        return diceRolls;
    }

    public static void countRolledNumber(List<Integer> numbers, int target) {
        int count = 0;
        for (int number : numbers) {
            if (number == target) {
                count++;
            }
        }
        System.out.println(target + " -> " + count + " roll.");
    }


    /*   4. Adott az alábbi tömb:
       int[] numbers = {34808, 422, 334, 12014, 412617, 292389, 342260, 32244, 334534, 497721, 3775, 544, 433, 55340, 257952, 1496173, 73, 539141, 3355, 305720, 3677429, 114047, 5656 };
       Írj metódusokat az alábbi kérdések megválaszolására:
⎼ Van ismétlődés a tömbben? (Szerepel-e többször ugyanaz a szám?)
⎼ Hány számjegyből állnak a számok a tömbben? Vizsgáld meg, hogy a számok hány számjegyből állnak - másképp, hogy milyen “hosszúak”! Pl. a tömb első eleme, a 34808 5 számjegyből áll, azaz 5 “hosszú”, úgymond.
⎼ Mennyi a legkisebb és a legnagyobb “hosszúság”?
*/
    public static void containsRepeat() {
        int[] numbers = {34808, 422, 334, 12014, 412617, 292389, 342260, 32244, 334534, 497721, 3775, 544, 433, 55340, 257952, 1496173, 73, 539141, 3355, 305720, 3677429, 114047, 5656};
        Set<Integer> numberList = new HashSet<>();
        for (int number : numbers) {
            numberList.add(number);
        }

        boolean isDuplicated = numbers.length != numberList.size();
        if (!isDuplicated) {
            System.out.println("It's not duplicated");
        } else {
            System.out.println("It's duplicated");
        }

    }

    // TODO ⎼ Hány számjegyből állnak a számok a tömbben? Vizsgáld meg, hogy a számok hány számjegyből állnak - másképp,
//  hogy milyen “hosszúak”! Pl. a tömb első eleme, a 34808 5 számjegyből áll, azaz 5 “hosszú”, úgymond.
    public static void getLength() {
        int[] numbers = {34808, 422, 334, 12014, 412617, 292389, 342260, 32244, 334534, 497721, 3775, 544, 433, 55340, 257952, 1496173, 73, 539141, 3355, 305720, 3677429, 114047, 5656};
        for (int number : numbers) {
            int digits = String.valueOf(number).length();
            System.out.println(number + " consists of " + digits + " digits.");
        }

    }

    // TODO ⎼ Mennyi a legkisebb és a legnagyobb “hosszúság”?
    public static void getMaxAndMinLength() {
        int[] numbers = {34808, 422, 334, 12014, 412617, 292389, 342260, 32244, 334534, 497721, 3775, 544, 433, 55340, 257952, 1496173, 73, 539141, 3355, 305720, 3677429, 114047, 5656};

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (int number : numbers) {
            int length = String.valueOf(number).length();
            if (length < minLength) {
                minLength = length;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        System.out.println("The smallest length: " + minLength);
        System.out.println("The largest length: " + maxLength);
    }
}
