# Amazing Numbers
Amazing Numbers is just a simple Java project from JetBrains Academy. It covers basic operations on integers as well as with Java Collections. 
It determines various properties of a number such as whether a number is even, odd, buzz, duck, palindromic, gapful, spy, square, sunny, jumping, happy or sad.

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
- Enter two natural numbers and two or more properties to search for:
  - E.G. input `1 10 even square` will find 10 numbers that are both even and square
- Property preceded by minus `-` will exclude numbers that have it from output.


Examples:

    Welcome to Amazing Numbers!

    Supported requests:
    - enter a natural number to know its properties;
    - enter two natural numbers to obtain the properties of the list:
      * the first parameter represents a starting number;
      * the second parameter shows how many consecutive numbers are to be printed;
    - two natural numbers and properties to search for;
    - a property preceded by minus must not be present in numbers;
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
         jumping: true
           happy: true
             sad: false
            even: false
             odd: true

    Enter a request: 1 10

               1 is odd, palindromic, spy, square, jumping, happy
               2 is even, palindromic, spy, jumping, sad
               3 is odd, palindromic, spy, sunny, jumping, sad
               4 is even, palindromic, spy, square, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
               8 is even, palindromic, spy, sunny, jumping, sad
               9 is odd, palindromic, spy, square, jumping, sad
              10 is even, duck, jumping, happy

    Enter a request: 1 5 -odd

               2 is even, palindromic, spy, jumping, sad
               4 is even, palindromic, spy, square, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               8 is even, palindromic, spy, sunny, jumping, sad
              10 is even, duck, jumping, happy

    Enter a request: 1 5 -even

               1 is odd, palindromic, spy, square, jumping, happy
               3 is odd, palindromic, spy, sunny, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
               9 is odd, palindromic, spy, square, jumping, sad

    Enter a request: 1 5 -odd -even gapful

    The request contains mutually exclusive properties: [-ODD, -EVEN]
    There are no numbers with these properties.

    Enter a request: 1 5 odd square -odd

    The request contains mutually exclusive properties: [-ODD, ODD]
    There are no numbers with these properties.

    Enter a request: 1 5 sunny square

    The request contains mutually exclusive properties: [SQUARE, SUNNY]
    There are no numbers with these properties.

    Enter a request: 1 5 -sunny -square

               2 is even, palindromic, spy, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
              10 is even, duck, jumping, happy

    Enter a request: 1 7 sunny square

    The request contains mutually exclusive properties: [SQUARE, SUNNY]
    There are no numbers with these properties.

    Enter a request: 1 2 sunny polindromic

    The property [POLINDROMIC] is wrong.
    Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]

    Enter a request: 1 2 sunny palindromic

               3 is palindromic, spy, sunny, odd
               8 is palindromic, spy, sunny, even
               
Example 2: Numbers that have one specified property

    Enter a request: > 2000 5 happy

           2,003 is odd, duck, happy
           2,008 is even, duck, happy
           2,019 is odd, duck, happy
           2,026 is even, duck, happy
           2,030 is even, buzz, duck, happy
Example 3: Numbers with all specified properties

    Enter a request: 1 5 even sunny happy -duck -gapful

           3,968 is even, sunny, happy
           34,224 is even, sunny, happy
           75,624 is even, sunny, happy
           134,688 is even, sunny, happy
           178,928 is even, sunny, happy

    Enter a request: 0

    Goodbye!
