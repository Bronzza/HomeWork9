public class Main {
    public static void main(String[] args) {
        System.out.println("Initial console message");
        MyArrayList <String> arrayList = new MyArrayList<>();
        arrayList.add("hello");
        System.out.println(arrayList.get(0));
    }
}
