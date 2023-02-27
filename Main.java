import java.util.Arrays; //libreria Arrays donde utilize Arrays.toString()

public class Main {

    public static void main(String[] args) {
        Integer[] intVector = { 101, 99, 12, 19, 21, 111, 345, 25, 77, 81 };
        // llamamos al método sort() de QuickSort pasándole el vector intVector como
        // argumento
        QuickSort.sort(intVector);
        // imprimimos el vector
        System.out.println(Arrays.toString(intVector));

        Float[] floatVector = { 19.1f, 456.6f, 23.45f, 12.34f, 11.11f, 354.55f, 78.45f, 28.33f, 45.99f, 108.88f };
        QuickSort.sort(floatVector); // llamamos sort() de QuickSort pasándole el vector como argumento

        // imprimimos el vector ordenado utilizando el método
        // Arrays.toString()
        System.out.println(Arrays.toString(floatVector));

        // String[] strVector = {"zz", "aa", "cc", "hh", "bb", "ee", "ll"};
        // QuickSort.sort(strVector);
        // System.out.println(Arrays.toString(strVector));
    }
}

class QuickSort {

    // método sort() recibe un vector de elementos T

    public static <T extends Comparable<T>> void sort(T[] arr) {
        // comprobamos si el vector esta vacio o no
        if (arr == null || arr.length == 0) {
            return;
        }
        // si el vector no es nulo , llamamos al método quickSort() pasándole el vector,
        // el índice izquierdo y derecho
        quickSort(arr, 0, arr.length - 1);

    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int left, int right) {
        // quickSort() que recibe un vector de elementos T que implementan
        // Comparable<T>, y los índices izquierdo y derecho
        if (left < right) {
            // comprobamos si el índice izquierdo es menor que el derecho
            int partitionIndex = partition(arr, left, right);
            // obtenemos el índice de la partición llamando al método
            // partition()
            quickSort(arr, left, partitionIndex - 1);
            // llamamos a quickSort() recursivamente para la parte izquierda
            // del vectr
            quickSort(arr, partitionIndex + 1, right);
            // llamamos a quickSort() recursivamente para la parte derecha
            // del vector
        }
    }

    /**
     * partition realiza la partición del arreglo
     * Recibe un arreglo de elementos T que implementan Comparable<T>, y los índices
     * izquierdo y derecho.
     * Devuelve el índice de la partición.
     */
    private static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        // Elegimos el último elemento del vector como pivote
        T pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // Intercambiamos el elemento en la posición i con el elemento en la posición j
                swap(arr, i, j);
            }
        }
        // Intercambiamos el elemento en la posición i + 1 con el pivote
        swap(arr, i + 1, right);
        // Devolvemos el índice de la partición
        return i + 1;
    }

    /**
     * swap intercambia dos elementos de un vector.
     * Recibe un vector de elementos T, y dos índices i y j.
     */
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}