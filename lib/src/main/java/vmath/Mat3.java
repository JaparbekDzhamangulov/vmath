package vmath;

public class Mat3 {
    private final float[] m;

    public Mat3() {
        m = new float[] {
            1.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 1.0f
        };
    }

    public Mat3(float m00, float m01, float m02,
                float m10, float m11, float m12,
                float m20, float m21, float m22) {
        if (Float.isNaN(m00) || Float.isNaN(m01) || Float.isNaN(m02) ||
                Float.isNaN(m10) || Float.isNaN(m11) || Float.isNaN(m12) ||
                Float.isNaN(m20) || Float.isNaN(m21) || Float.isNaN(m22)) {
            throw new ArithmeticException();
        }
        m = new float[] {
                m00, m01, m02,
                m10, m11, m12,
                m20, m21, m22 };
    }

    public Mat3(float[] m) {
        if (m == null || m.length != 9) {
            throw new IllegalArgumentException();
        }
        for (float value : m) {
            if (Float.isNaN(value)) {
                throw new ArithmeticException();
            }
        }
        this.m = m.clone();
    }

    public float get(int i, int j) {
        if (i < 0 || i >= 3 || j < 0 || j >= 3) {
            throw new IndexOutOfBoundsException();
        }
        return m[i * 3 + j];
    }
}
