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
    /* MP COMMENT
     * Couple of points here:
     * 1. This throws an IOException that needs to be handled, so at a minimum you'll need
     *    a constructor for this class, although IO should generally not be done in a constructor
     *    either.  Even better would be have an init method that initializes its state, but
     *    that makes the API a little harder to use.
     * 2. Check for the existence of /dev/urandom first - preferable to use this on Linux. 
     *    FreeBSD only has /dev/random, so fallback to using that.  
     * 3. Readers are for text-based input, whereas I think of /dev/urandom as a byte stream,
     *    so you should use a Java InputStream. Not sure about using a BufferedInputStream either -
     *    I don't think you want that here.  I think you just want to read unbuffered, but
     *    I could be thinking incorrectly about that.
     */
    private static final BufferedReader devRandom = new BufferedReader(new FileReader('/dev/random'))
    

    void nextBytes(byte[] bytes) {
        /* MP COMMENT
         * Using a char array is not useful here and technically this line is wrong - byte is a single
         * byte whereas char is 2 bytes in Java. If you switch to InputStream rather than reader you'll
         * just deal with byte[], as is appropriate here.
         */
        char[] out = new char[bytes.length]
        int index = 0
        /* MP COMMENT
         * How were you measuring that you were getting poor entry after the first 32 bytes?
         * I'm not clear on how I would know that unless I was just getting repeated data.
         * In which case, using /dev/urandom on Linux should fix that problem and you can
         * then just do a single read of the desired size.
         */
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
        /* MP COMMENT
         * This implementation only uses half the range of a unsigned short. 
         * That may be fine as long as you document it.  Otherwise, you'll need
         * grab an unsignedInt from the byte stream and then modulos it by Short.MAX_VALUE.
         * Similar comment applies to unsignedInt.  For unsignedLong, you're out of luck
         * in Java unless you want to use BigInt (probably not worth it).
         */
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
        /* MP COMMENT
         * Probably grabbing the next byte would suffice rather than a full int.
         */
        signedNextInt() % 2 == 0
    }

    char nextChar() {
        /* MP COMMENT
         * chars are unsigned, so you should unsignedNextShort() here
         * Ditto for all the other "nextChar" methods below
         */
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
    
    /* MP COMMENT
     * According to the https://en.wikipedia.org/wiki/IEEE_floating_point standard there
     * is no such thing as an unsigned float (or double).  So if your API requires returning
     * a positive floating point value, you should just call it that - unsigned would
     * imply somethign that doesn't exist.
     */ 
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
