//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    System.out.println("Task 1");
    System.out.println(Tasks.task1(Arrays.asList("Ivan", "Peter", "Sasha", "Oleg")));
    System.out.println("\nTask 2");
    System.out.println(Tasks.task2(Arrays.asList("Ivan", "Peter", "Sasha", "Oleg")));
    System.out.println("\nTask 3");
    System.out.println(Tasks.task3(new String[]{"1, 2, 0", "4, 5"}));
    System.out.println("\nTask 4");
    Tasks.randomStream().limit(10).forEach(System.out::println);
    System.out.println("\nTask 5");
    Tasks.zip(
            Arrays.asList("One", "Two", "Three", "Four", "Five").stream(),
            Arrays.asList("Ivan", "Peter", "Sasha", "Oleg").stream()
    ).forEach(System.out::println);
}
