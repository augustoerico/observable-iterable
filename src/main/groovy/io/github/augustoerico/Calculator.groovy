package io.github.augustoerico

import rx.Observable

class Calculator {

    static Observable addTwo(number) {
        Observable.just(number + 2)
    }

    static Observable addTwoOb(numbers) {
        Observable.from(numbers)
            .flatMap {
                addTwo(it)
            }
            .reduce([]) { acc, elem ->
                acc << elem
                acc
            }
    }

}
