//
// Generated from archetype; please customize.
//

package org.burnmydread

import java.nio.ByteBuffer


/**
 * SimpleRandom Groovy class.
 * The intent is to have a easy to use Secure RNG.
 */
class SimpleRandom {
    private InputStream devRandom

    SimpleRandom()  {

    }

    void init() throws IllegalStateException {
        try {
            devRandom = new File('/dev/urandom').newInputStream()
        } catch (IOException e) {
            try {
                devRandom = new File('/dev/random').newInputStream()
            } catch (IOException e2) {
                throw new IllegalStateException('unsupported platform, /dev/urandom and /dev/random not found.')
            }
        }
    }

    private initIfNeeded() {
        if(devRandom == null) {
            init()
        }
    }

    void nextBytes(byte[] bytes) {
        initIfNeeded()
        devRandom.read(bytes, 0, bytes.length )
    }

    byte[] nextBytes(int size) {
        byte[] rawBytes = new byte[size]
        nextBytes( rawBytes )
        rawBytes
    }

    ByteBuffer nextByteBuffer(int size) {
        ByteBuffer.wrap(nextBytes(size))
    }

    byte nextByte() {
        byte[] out = new byte[1]
        nextBytes(out)
        out[0]
    }

    int nextPositiveInt() {
        int out = nextPositiveOrNegativeInt()
        if (out == Integer.MIN_VALUE) {
            out = Integer.MAX_VALUE
        } else if(out < 0) {
            out *= -1
        }
        out
    }

    int nextPositiveOrNegativeInt() {
        ByteBuffer buffer = nextByteBuffer(4)
        buffer.getInt()
    }

    int nextInt() {
        nextPositiveInt()
    }


    int nextInt(int maxValue) {
        if(maxValue < Short.MAX_VALUE) {
            short shortenedMaxValue = Short.parseShort("${maxValue}")
            return (0 + nextShort(shortenedMaxValue))
        } else {
            int out = nextInt()
            while (out > maxValue) {
                out = nextInt()
            }
           return out
        }
    }

    short nextPositiveOrNegativeShort() {
        ByteBuffer buffer = nextByteBuffer(2)
        buffer.getShort()
    }

    short nextPositiveShort() {
        short out = nextPositiveOrNegativeShort()
        if (out == Short.MIN_VALUE) {
            out = Short.MAX_VALUE
        } else if(out < 0) {
            out *= -1
        }
        out
    }

    short nextShort() {
        nextPositiveShort()
    }

    short nextShort(short maxValue) {
        short out = nextPositiveShort()
        while (out > maxValue) {
            out = nextPositiveShort()
        }
        out
    }

    long nextPositiveOrNegativeLong() {
        ByteBuffer buffer = nextByteBuffer(8)
        buffer.getLong()
    }

    long nextPositiveLong() {
        short out = nextPositiveOrNegativeLong()
        if (out == Long.MIN_VALUE) {
            out = Long.MAX_VALUE
        } else if(out < 0l) {
            out *= -1l
        }
        out
    }


    long nextLong() {
        nextPositiveLong()
    }

    long nextLong(long maxValue) {
        if(maxValue < Integer.MAX_VALUE) {
            int shortenedMaxValue = Integer.parseInt("${maxValue}")
            return (0l + nextInt(shortenedMaxValue))
        } else {
            long out = nextPositiveLong()
            while (out > maxValue) {
                out = nextPositiveLong()
            }
           return out
        }
    }

    boolean nextBoolean() {
        nextByte() % 2 == 0
    }

    char nextChar() {
        nextPositiveOrNegativeShort()
    }

    char nextChar(short maxValue) {
        short out = nextPositiveOrNegativeShort()
        while (out > maxValue) {
            out = nextPositiveOrNegativeShort()
        }
         out
    }

    char nextChar(char maxValue) {
        nextChar((short)maxValue)
    }

    float nextPositiveOrNegativeFloat() {
        ByteBuffer buffer = nextByteBuffer(4)
        buffer.getFloat()
    }

    float nextPositiveFloat() {
        float out = nextPositiveOrNegativeFloat()
        if (out == Float.MIN_VALUE) {
            out = Float.MAX_VALUE
        } else if(out < 0.0f) {
            out *= -1.0f
        }
        out
    }

    float nextFloat() {
        nextPositiveFloat()
    }

    float nextFloat(float maxValue) {
        float out = nextPositiveFloat()
        while (out > maxValue) {
            out = nextPositiveFloat()
        }
        out
    }

    float nextFloat(int maxValue) {
        nextFloat((float)maxValue)
    }

    double nextPositiveOrNegativeDouble() {
        ByteBuffer buffer = nextByteBuffer(8)
        buffer.getDouble()
    }

    double nextPositiveDouble() {
        double out = nextPositiveOrNegativeDouble()
        if (out == Double.MIN_VALUE) {
            out = Double.MAX_VALUE
        } else if(out < 0.0) {
            out *= -1.0
        }
        out
    }

    double nextDouble() {
        nextPositiveDouble()
    }

    double nextDouble(double maxValue) {
        if(maxValue < Float.MAX_VALUE) {
            float shortenedMaxValue = Float.parseFloat("${maxValue}")
            return (0.0 + nextFloat(shortenedMaxValue))
        } else {
            double out = nextPositiveDouble()
            while (out > maxValue) {
                out = nextPositiveDouble()
            }
            return out
        }
    }

    double nextDouble(int maxValue) {
        nextDouble((double)maxValue)
    }

}
