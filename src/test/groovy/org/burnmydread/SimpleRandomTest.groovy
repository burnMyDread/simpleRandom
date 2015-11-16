//
// Generated from archetype; please customize.
//

package org.burnmydread

import spock.lang.Specification

/**
 * Tests for the {@link SimpleRandom} class.
 */
class SimpleRandomTest
    extends Specification
{
    def initialTestFornextBytes() {
        when:
            SimpleRandom gen = new SimpleRandom()
            byte[] bytes = new byte[1000]
            gen.nextBytes(bytes)
            println bytes
        then:
            assert bytes.length == 1000
            assert bytes != new byte[1000]
    }

    def initialTestFornextInt() {
        when:
            SimpleRandom gen = new SimpleRandom()
            List generatedInts = []
            List nullInts = []
            for(int i = 0; i < 1000; i++) {
                generatedInts.add(gen.nextInt())
                nullInts.add(0)
            }
            println generatedInts
        then:
            assert generatedInts != nullInts
    }

    def initialTestFornextShort() {
        when:
            SimpleRandom gen = new SimpleRandom()
            List generatedShort = []
            List nullShorts = []
            for(int i = 0; i < 1000; i++) {
                generatedShort.add(gen.nextShort())
                nullShorts.add(0)
            }
            println generatedShort
        then:
            assert generatedShort != nullShorts
    }

    def initialTestFornextLong() {
        when:
            SimpleRandom gen = new SimpleRandom()
            List generatedLong = []
            List nullLongs = []
            for(int i = 0; i < 1000; i++) {
                generatedLong.add(gen.nextLong())
                nullLongs.add(0l)
            }
            println generatedLong
        then:
            assert generatedLong != nullLongs
    }

    def initialTestFornextChar() {
        when:
            SimpleRandom gen = new SimpleRandom()
            List generatedChar = []
            List nullChars = []
            for(int i = 0; i < 1000; i++) {
                generatedChar.add(gen.nextChar())
                nullChars.add(null)
            }
            println generatedChar
        then:
            assert generatedChar != nullChars
    }

    def initialTestFornextFloat() {
        when:
            SimpleRandom gen = new SimpleRandom()
            List generatedFloats = []
            List nullFloats = []
            for(int i = 0; i < 1000; i++) {
                generatedFloats.add(gen.nextFloat())
                nullFloats.add(0.0f)
            }
            println generatedFloats
        then:
            assert generatedFloats != nullFloats
    }

    def initialTestFornextDouble() {
        when:
            SimpleRandom gen = new SimpleRandom()
            List generatedDoubles = []
            List nullDoubles = []
            for(int i = 0; i < 1000; i++) {
                generatedDoubles.add(gen.nextDouble())
                nullDoubles.add(0.0)
            }
            println generatedDoubles
        then:
            assert generatedDoubles != nullDoubles
    }

    def initialTestFornextPositiveOrNegativeDouble() {
        when:
        SimpleRandom gen = new SimpleRandom()
        List generatedDoubles = []
        List nullDoubles = []
        for(int i = 0; i < 1000; i++) {
            generatedDoubles.add(gen.nextPositiveOrNegativeDouble())
            nullDoubles.add(0.0)
        }
        println generatedDoubles
        then:
        assert generatedDoubles != nullDoubles
    }
}
