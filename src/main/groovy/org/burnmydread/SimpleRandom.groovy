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
    private static final BufferedReader devRandom = new BufferedReader(new FileReader('/dev/random'))


    void nextBytes(byte[] bytes) {
        char[] out = new char[bytes.length]
        int index = 0
        //The reason that this is not just one call to devRandom.read is that I was getting
        //poor entropy after the first 32 or so bytes.
        while ( index  < bytes.length) {
            //The Math.min covers the case where index - bytes.length is < 32
            devRandom.read(out, index, Math.min(bytes.length - index, 32))
            index += 32
        }
        out.eachWithIndex{ char entry, int i ->
            bytes[i] = (byte)entry
        }
    }

    ByteBuffer nextByteBuffer(int size) {
        byte[] rawBytes = new byte[size]
        nextBytes ( rawBytes )
        ByteBuffer.wrap(rawBytes)
    }

    byte nextByte() {
        byte[] out = new byte[1]
        nextBytes(out)
        out[0]
    }

    int unsignedNextInt() {
        int out = signedNextInt()
        if (out < 0) {
            out *= -1
        }
        out
    }

    int signedNextInt() {
        ByteBuffer buffer = nextByteBuffer(4)
        buffer.getInt()
    }

    int nextInt() {
        unsignedNextInt()
    }


    int nextInt(int maxValue) {
        int out = nextInt()
        while (out > maxValue) {
            out = unsignedNextInt()
        }
        out
    }

    short signedNextShort() {
        ByteBuffer buffer = nextByteBuffer(2)
        buffer.getShort()
    }

    short unsignedNextShort() {
        short out = signedNextShort()
        if (out < 0) {
            out *= -1
        }
        out
    }

    short nextShort() {
        unsignedNextShort()
    }

    short nextShort(short maxValue) {
        short out = unsignedNextShort()
        while (out > maxValue) {
            out = unsignedNextShort()
        }
        out
    }

    long signedNextLong() {
        ByteBuffer buffer = nextByteBuffer(8)
        buffer.getLong()
    }

    long unsignedNextLong() {
        short out = signedNextLong()
        if (out < 0) {
            out *= -1
        }
        out
    }


    long nextLong() {
        unsignedNextLong()
    }

    long nextLong(long maxValue) {
        long out = unsignedNextLong()
        while (out > maxValue) {
            out = unsignedNextLong()
        }
        out
    }

    boolean nextBoolean() {
        signedNextInt() % 2 == 0
    }

    char nextChar() {
        (char) nextShort()
    }

    char nextChar(short maxvalue) {
        (char) nextShort(maxvalue)
    }

    char nextChar(int maxvalue) {
        (char) nextShort((short) (maxvalue % Short.MAX_VALUE))
    }

    char nextChar(char maxvalue) {
        (char) nextShort((short) maxvalue % Short.MAX_VALUE)
    }

    float signedNextFloat() {
        ByteBuffer buffer = nextByteBuffer(4)
        buffer.getFloat()
    }

    float unsignedNextFloat() {
        short out = signedNextFloat()
        if (out < 0) {
            out *= -1
        }
        out
    }

    float nextFloat() {
        unsignedNextFloat()
    }

    float nextFloat(float maxValue) {
        float out = unsignedNextFloat()
        while (out > maxValue) {
            out = unsignedNextFloat()
        }
        out
    }

    float nextFloat(int maxValue) {
        nextFloat((float)maxValue)
    }

    double signedNextDouble() {
        ByteBuffer buffer = nextByteBuffer(4)
        buffer.getDouble()
    }

    double unsignedNextDouble() {
        short out = signedNextDouble()
        if (out < 0) {
            out *= -1
        }
        out
    }

    double nextDouble() {
        unsignedNextDouble()
    }

    double nextDouble(double maxValue) {
        float out = unsignedNextDouble()
        while (out > maxValue) {
            out = unsignedNextDouble()
        }
        out
    }

    double nextDouble(int maxValue) {
        nextDouble((double)maxValue)
    }

}
