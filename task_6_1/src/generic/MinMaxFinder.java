package generic;

interface MinMaxFinder<T extends Comparable<T>> {
    T findMin(T[] array);
    T findMax(T[] array);
}
