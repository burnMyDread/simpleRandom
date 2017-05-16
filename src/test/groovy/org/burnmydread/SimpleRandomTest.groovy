//
// Generated from archetype; please customize.
//

package org.burnmydread

import org.apache.commons.math3.stat.descriptive.StatisticalSummary
import org.apache.commons.math3.stat.inference.TTest
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Tests for the {@link SimpleRandom} class.
 */
class SimpleRandomTest
    extends Specification
{
    def initTest() {
        when:
            SimpleRandom gen = new SimpleRandom()
            byte[] bytes = new byte[1000]
            gen.nextBytes(bytes)
            println bytes
        then:
            assert bytes.length == 1000
            assert bytes != new byte[1000]
    }

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
            assert generatedInts.grep({it < 0}).size() == 0
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
            assert generatedShort.grep({it < 0}).size() == 0
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
            assert generatedLong.grep({it < 0l}).size() == 0
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
            assert generatedFloats.grep({it < 0.0f}).size() == 0
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
            assert generatedDoubles.grep({it < 0.0}).size() == 0
    }

    def initialTestFornextIntMax1000() {
        when:
        SimpleRandom gen = new SimpleRandom()
        List generatedInts = []
        List nullInts = []
        for(int i = 0; i < 1000; i++) {
            generatedInts.add(gen.nextInt(1000))
            nullInts.add(0)
        }
        println generatedInts
        then:
        assert generatedInts != nullInts
        assert generatedInts.grep({it < 0}).size() == 0
        assert generatedInts.grep({it > 1000}).size() == 0
    }

    def initialTestFornextShortMax1000() {
        when:
        SimpleRandom gen = new SimpleRandom()
        List generatedShort = []
        List nullShorts = []
        short maxValue = 1000
        for(int i = 0; i < 1000; i++) {
            generatedShort.add(gen.nextShort(maxValue))
            nullShorts.add(0)
        }
        println generatedShort
        then:
        assert generatedShort != nullShorts
        assert generatedShort.grep({it < 0}).size() == 0
        assert generatedShort.grep({it > 1000}).size() == 0
    }

    def initialTestFornextLongMax1000() {
        when:
        SimpleRandom gen = new SimpleRandom()
        List generatedLong = []
        List nullLongs = []
        for(int i = 0; i < 1000; i++) {
            generatedLong.add(gen.nextLong(1000l))
            nullLongs.add(0l)
        }
        println generatedLong
        then:
        assert generatedLong != nullLongs
        assert generatedLong.grep({it < 0l}).size() == 0
        assert generatedLong.grep({it > 1000}).size() == 0
    }

    def initialTestFornextCharax100() {
        when:
        SimpleRandom gen = new SimpleRandom()
        List<Character> generatedChar = []
        List nullChars = []
        short maxValue = 100
        for(int i = 0; i < 1000; i++) {
            generatedChar.add(gen.nextChar(maxValue))
            nullChars.add(null)
        }
        println generatedChar
        then:
        assert generatedChar != nullChars
    }

    def initialTestFornextFloatMax1000() {
        when:
        SimpleRandom gen = new SimpleRandom()
        List generatedFloats = []
        List nullFloats = []
        for(int i = 0; i < 1000; i++) {
            generatedFloats.add(gen.nextFloat(1000.0f))
            nullFloats.add(0.0f)
        }
        println generatedFloats
        then:
        assert generatedFloats != nullFloats
        assert generatedFloats.grep({it < 0.0f}).size() == 0
        assert generatedFloats.grep({it > 1000.0f}).size() == 0
    }

    def initialTestFornextDoubleMax1000() {
        when:
        SimpleRandom gen = new SimpleRandom()
        List generatedDoubles = []
        List nullDoubles = []
        for(int i = 0; i < 1000; i++) {
            generatedDoubles.add(gen.nextDouble(1000.0))
            nullDoubles.add(0.0)
        }
        println generatedDoubles
        then:
        assert generatedDoubles != nullDoubles
        assert generatedDoubles.grep({it < 0.0}).size() == 0
        assert generatedDoubles.grep({it > 1000.0}).size() == 0
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

    @Unroll
    def "check that two lists are not statistically similar for method: #methodToTest with a max value of #maxValue"() {
        setup:
            SimpleRandom gen = new SimpleRandom()
            TTest statsFrameWork = new TTest()
        when:
            List listOne = []
            List listTwo = []
            for(int i = 0; i < sizeOfList; i++) {
                listOne.add(gen."$methodToTest"(maxValue))
                listTwo.add(gen."$methodToTest"(maxValue))
            }
            double[] listOneAsDouble = listOne.toArray()
            double[] listTwoAsDouble = listTwo.toArray()
            double pScoreHigherIsBetterHere = statsFrameWork.pairedTTest(listOneAsDouble, listTwoAsDouble)
        then:
            assert pScoreHigherIsBetterHere > 0.9
        where:
            methodToTest     |  maxValue | sizeOfList
            'nextInt'        |  1000000  | 1000000
            'nextFloat'      |  1000000  | 1000000
            'nextLong'       |  1000000  | 1000000
            'nextDouble'     |  1000000  | 1000000

    }

}
