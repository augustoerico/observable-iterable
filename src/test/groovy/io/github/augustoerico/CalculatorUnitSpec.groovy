package io.github.augustoerico

import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

class CalculatorUnitSpec extends Specification {

    static final Double WAIT_TIME = 5.0

    def 'Should add 2 to number'() {
        def cons = new AsyncConditions()
        def result

        given:
        def number = 1

        when:
        Calculator.addTwo(number).subscribe {
            result = it
            cons.evaluate { true }
        }

        then:
        cons.await(WAIT_TIME)
        result == 3

    }

    def 'Should add 2 to all numbers'() {
        def cons = new AsyncConditions()
        def result

        given:
        def numbers = [1, 2, 3]

        when:
        Calculator.addTwoOb(numbers).subscribe {
            result = it
            cons.evaluate { true }
        }

        then:
        cons.await(WAIT_TIME)
        result == [3, 4, 5]
    }

}
