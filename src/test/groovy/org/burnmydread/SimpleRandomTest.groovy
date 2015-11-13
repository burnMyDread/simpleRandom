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
            byte[] bytes = new byte[100]
            gen.nextBytes(bytes)
            println bytes
        then:
            assert bytes.length == 100
            assert bytes != new byte[100]
    }

    def initialTestFornextInt() {
        when:
        SimpleRandom gen = new SimpleRandom()
        List generatedInts = []
        List nullInts = []
        for(int i = 0; i < 10; i++) {
            generatedInts.add(gen.nextInt())
            nullInts.add(0)
        }
        println generatedInts
        then:
        assert generatedInts != nullInts
    }
}
