import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tasks {
    public static String task1(List<String> nameList) {
        int index = 0;
        int amount = 0;
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, nameList.size())
                .mapToObj(i -> i % 2 != 0 ? (i == 1 ? "" : ", ") + i + ". " + nameList.get(i) : "")
                .forEach(sb::append);
        return sb.toString();
    }

    public static List<String> task2(List<String> strings) {
        return strings.stream()
                .map(s -> s.toUpperCase(Locale.ROOT))
                .sorted(Comparator.reverseOrder()) // Сортируем сразу в обратном порядке
                .toList();
    }

    public static String task3(String[] strings) {
        List<String> vals = new ArrayList<>();
        Arrays.stream(strings)
                .forEach(s ->
                                vals.addAll(List.of(s.split(", "))));
        StringBuilder sb = new StringBuilder();
        vals.stream().sorted().forEach(s -> sb.append(sb.isEmpty() ? "" : ", ").append(s));
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
