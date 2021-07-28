# Amazing Numbers
Amazing Numbers is just a simple Java project from JetBrains Academy. It covers basic operations on integers as well as with Java Collections. 
It determines various properties of a number such as whether a number is Palindromic, Gapful, Spy, Even, Odd, Duck or Buzz.

How to use:
- Type a single number in order to see its properties
- Type a zero to exit
- Type two numbers to see properties of consecutive numbers:
  - The first parameter represents starting number
  - The second parameter indicated how many consecutive numbers are to be processed
  - For example, input 10 3 will process 10, 11 and 12

Example:

    Welcome to Amazing Numbers!

    Supported requests:
    - enter a natural number to know its properties;
    - enter two natural numbers to obtain the properties of the list:
      * the first parameter represents a starting number;
      * the second parameters show how many consecutive numbers are to be processed;
    - two natural numbers and a property to search for;
    - separate the parameters with one space;
    - enter 0 to exit.
    
    Enter a request: > 7880

      Properties of 7,880
            buzz: false
            duck: true
            palindromic: false
            gapful: false
            even: true
            odd: false

    Enter a request: > 105 5

            105 is buzz, duck, gapful, odd
            106 is duck, even
            107 is buzz, duck, odd
            108 is duck, gapful, even
            109 is duck, odd
            
    Enter a request: > 0
    
    Goodbye!
