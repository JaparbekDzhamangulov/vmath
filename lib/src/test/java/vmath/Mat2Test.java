package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat2Test {

    @Test
    void givenNoArgs_whenMat2Created_thenMatrixIsIdentity() {
        var m = new Mat2();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
    }
  
    @Test
    void givenArgs_whenMat2Created_thenMatrixHasGivenValues() {
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenNaNValues_whenMat2Created_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> new Mat2(
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN
        ));

        assertThrows(ArithmeticException.class, () -> new Mat2(
            1.0f, 2.0f,
            3.0f, Float.NaN
        ));
    }

    @Test
    void givenArrayArg_whenMat2Created_thenMatrixHasGivenValues() {
        var a = new float[] {
            1.0f, 2.0f,
            3.0f, 4.0f
        };
        var m = new Mat2(a);

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenNullArray_whenMat2Created_thenThrowsException() {
        float[] a = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a));
    }

    @Test
    void givenArrayOfInvalidLength_whenMat2Created_thenThrowsException() {
        var a1 = new float[] {
            1.0f, 2.0f,
            3.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a1));

        var a2 = new float[] {
            1.0f, 2.0f,
            3.0f, 4.0f, 5.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a2));
    }

    @Test
    void givenArrayWithNaNs_whenMat2Created_thenThrowsException() {
        float[] a1 = {
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat2(a1));

        float[] a2 = {
            1.0f, 2.0f,
            3.0f, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat2(a2));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenInvalidIndices_whenGetIsCalled_thenThrowsException() {
        var m = new Mat2();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(2, 0));

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, 2));
    }

    void givenMatrices_whenMultiplied_thenResultIsCorrect() {
        Mat2 m1 = new Mat2(1.0f, 2.0f, 3.0f, 4.0f);
        Mat2 m2 = new Mat2(5.0f, 6.0f, 7.0f, 8.0f);
        
        Mat2 newMat = m1.mul(m2);

        assertEquals(19.0f, newMat.get(0, 0));
        assertEquals(22.0f, newMat.get(0, 1));
        assertEquals(43.0f, newMat.get(1, 0));
        assertEquals(50.0f, newMat.get(1, 1));
    }
}
