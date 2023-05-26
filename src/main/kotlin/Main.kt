fun main() {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(4, 5)
    val list3 = listOf(6, 7, 8, 9)

    val iterator1 = list1.iterator()
    val iterator2 = list2.iterator()
    val iterator3 = list3.iterator()

    val iterators = mutableListOf(iterator1, iterator2, iterator3)

    val iteratorOfIterators = IteratorOfIterators(iterators)

    while (iteratorOfIterators.hasNext()) {
        println(iteratorOfIterators.next())
    }
}



class IteratorOfIterators<T>(private val iterators: MutableList<Iterator<T>>) : Iterator<T> {

    private var currentIterator: Iterator<T>? = null

    override fun hasNext(): Boolean {
        while (currentIterator == null || !currentIterator!!.hasNext()) {
            if (iterators.isEmpty()) {
                return false
            }
            currentIterator = iterators.removeAt(0)
        }
        return true
    }

    override fun next(): T {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return currentIterator!!.next()
    }
}