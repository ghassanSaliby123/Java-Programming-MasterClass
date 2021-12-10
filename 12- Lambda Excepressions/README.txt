These code examples illustrate the Lambda Excepressions in Java, which work with functional interfaces
The functional interface is the one which has a single method that needs to be implemented 
The functional interface might have other fucntions that are already implemented within the interface but they should be declare as default or static.
These examples cover the following:
1- introduction to lambda and use it with the sort method (instead of the Comperator argument to implemt the compare method)
2- local variables scpoe with lambda (All local variable which are used within lambda should be final or effectivly final, the same case with anonymous class)
3- Functional interface- Consumer which provide a function accept() that take an argument (do some actions) and doesn't return any 
4- Functional interface- Predicate whcih provide a test() method that accept an argument which is the condition and return true or false
5- Functional interfaces- Supplier which provide a get() method that does not accept arguments and return a value
6- Functional interface- Function which provide apply() method that accepts an argument and return a value
7- Streams and utilizing it with collections or by itself. And the method reference
    stream(),map(),filter(),count(),peek(),distinct(),sorted(),flatmap().
