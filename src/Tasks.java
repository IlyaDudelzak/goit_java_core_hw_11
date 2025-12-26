import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tasks {
    public static String task1(List<String> nameList) {
        int index = 0;
        int amount = 0;
        StringBuilder sb = new StringBuilder();
        for(String name : nameList) {
            if(index % 2 > 0) {
                if (amount > 0) sb.append(", ");
                sb.append(index);
                sb.append(". " + name);
                amount++;
            }
            index++;
        }
        return sb.toString();
    }
    public static List<String> task2(List<String> strings) {
        return strings.stream()
                .map(s -> s.toUpperCase(Locale.ROOT))
                .sorted(Comparator.reverseOrder()) // Сортируем сразу в обратном порядке
                .toList();
    }
    public static String task3(String[] strings) {
        List<Integer> numberList = new ArrayList<>();
        for(String string : strings) {
            String[] separated = string.split(", ");
            for(String number : separated) {
                numberList.add(Integer.valueOf(number));
            }
        }
        numberList = numberList.stream().sorted().toList();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(Integer number : numberList) {
            if(index > 0) sb.append(", ");
            sb.append(number);
            index++;
        }
        return sb.toString();
    }
    public static Stream<Long> randomStream() {
        return randomStream(3290579824087514605L);
    }
    public static Stream<Long> randomStream(long seed) {
        return randomStream(seed, 25214903917L, 11L, 2L << 47);
    }
    public static Stream<Long> randomStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, n -> ((n * a) + c) % m);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> listA = first.toList();
        List<T> listB = second.toList();
        return IntStream.range(0, Math.min(listA.size(), listB.size()) * 2)
                .mapToObj(i -> i % 2 == 0 ? listA.get(i >> 1) : listB.get(i >> 1));
    }
}
