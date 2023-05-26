import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IteratorOfIteratorsTest {

    @Test
    fun `test hasNext with empty iterators list`() {
        val iteratorOfIterators = IteratorOfIterators<Int>(mutableListOf())
        assertFalse(iteratorOfIterators.hasNext())
    }

    @Test
    fun `test hasNext with non-empty iterators list`() {
        val iterator1 = listOf(1, 2, 3).iterator()
        val iterator2 = listOf(4, 5, 6).iterator()
        val iterator3 = listOf(7, 8, 9).iterator()
        val iteratorOfIterators = IteratorOfIterators(mutableListOf(iterator1, iterator2, iterator3))
        assertTrue(iteratorOfIterators.hasNext())
    }

    @Test
    fun `test next with empty iterators list`() {
        val iteratorOfIterators = IteratorOfIterators<Int>(mutableListOf())
        assertThrows<NoSuchElementException> { iteratorOfIterators.next() }
    }

    @Test
    fun `test next with non-empty iterators list`() {
        val iterator1 = listOf(1, 2, 3).iterator()
        val iterator2 = listOf(4, 5, 6).iterator()
        val iterator3 = listOf(7, 8, 9).iterator()
        val iteratorOfIterators = IteratorOfIterators(mutableListOf(iterator1, iterator2, iterator3))
        assertEquals(1, iteratorOfIterators.next())
        assertEquals(2, iteratorOfIterators.next())
        assertEquals(3, iteratorOfIterators.next())
        assertEquals(4, iteratorOfIterators.next())
        assertEquals(5, iteratorOfIterators.next())
        assertEquals(6, iteratorOfIterators.next())
        assertEquals(7, iteratorOfIterators.next())
        assertEquals(8, iteratorOfIterators.next())
        assertEquals(9, iteratorOfIterators.next())
        assertThrows<NoSuchElementException> { iteratorOfIterators.next() }
    }
}