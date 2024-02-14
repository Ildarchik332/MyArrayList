package MyArrayList;

public class TestClassForMyArray {
    public static void main(String[] args) {
        MyArray<String> array2 = new MyArray();
        array2.add("MMMM");
        array2.add("CCCC");
        array2.add("AAAA");
        array2.add("NNNN");
        array2.add("BBBB");
        MyArray.quickSort(array2, 0, array2.size() - 1);
        for (String x : array2) {
            System.out.println(x);
        }
        MyArray<Integer> rep = new MyArray();
        rep.add(9);
        rep.add(1);
        rep.add(100);
        rep.add(22);
        MyArray.quickSort(rep, 0, rep.size() - 1);
        for (Integer x : rep) {
            System.out.println(x);
        }

    }
}
