package Task2;

public class Main2 {

    public static void main(String[] args) {

        int k = 3;
        System.out.println("Каждый" + k-- + " ребёнок удаляется");

        for (int n = 1; n <= 64; n++) {
            System.out.println("----------------------------------------------------------------------------------------");
            ChildCircle circle = new ChildCircle(n);
            circle.printList();
            int index = 0;
            while (circle.size() != 1) {
                index = circle.move(index, k);
                System.out.println("Ребенок #" + circle.node(index).e + " удалён");
                circle.delete(index);
                circle.printList();
            }
            System.out.printf("%2d детей: ребёнок #" + circle.node(0).e + " является последним\n", n);
        }
    }
}
