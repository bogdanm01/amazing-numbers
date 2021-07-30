# Amazing Numbers
Amazing Numbers is just a simple Java project from JetBrains Academy. It covers basic operations on integers as well as with Java Collections. 
It determines various properties of a number such as whether a number is Palindromic, Gapful, Spy, Even, Odd, Duck or Buzz.

How to use:
- Behavior of the program is different depending on the form of the user request, see supported requests in example down below.
- Enter a single natural number in order to see its properties
- Enter a zero to exit
- Enter two natural numbers to see properties of consecutive numbers:
  - The first parameter represents starting number
  - The second parameter indicate how many consecutive numbers are to be processed
  - E.G. input `10 3` will process 10, 11 and 12
- Enter two natural numbers and a property to search for:
  - E.G. input `1 10 even` will find 10 even numbers starting from one
- Enter two natural numbers and two properties to search for:
  - E.G. input `1 10 even square` will find 10 numbers that are both even and square

Example:

    Welcome to Amazing Numbers!

    Supported requests:
    - enter a natural number to know its properties;
    - enter two natural numbers to obtain the properties of the list:
      * the first parameter represents a starting number;
      * the second parameters show how many consecutive numbers are to be processed;
    - two natural numbers and two properties to search for;
    - separate the parameters with one space;
    - enter 0 to exit.

    Enter a request: 1

    Properties of 1
            buzz: false
            duck: false
     palindromic: true
          gapful: false
             spy: true
          square: true
           sunny: false
            even: false
             odd: true

    Enter a request: 1 8 square

               1 is palindromic, spy, square, odd
               4 is palindromic, spy, square, even
               9 is palindromic, spy, square, odd
              16 is square, even
              25 is square, odd
              36 is square, even
              49 is buzz, square, odd
              64 is square, even

    Enter a request: 1 7 sunny

               3 is palindromic, spy, sunny, odd
               8 is palindromic, spy, sunny, even
              15 is sunny, odd
              24 is sunny, even
              35 is buzz, sunny, odd
              48 is sunny, even
              63 is buzz, sunny, odd

    Enter a request: 1 7 sunny square

    The request contains mutually exclusive properties: [SQUARE, SUNNY]
    There are no numbers with these properties.

    Enter a request: 1 2 sunny polindromic

    The property [POLINDROMIC] is wrong.
    Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]

    Enter a request: 1 2 sunny palindromic

               3 is palindromic, spy, sunny, odd
               8 is palindromic, spy, sunny, even

    Enter a request: 0

    Goodbye!
