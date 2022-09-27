# Cracker-
This algorithm processes any equation of one variable in form of a string and computes the value. Based on an algorithm developed long ago in java to process any mathematical expression accepted by some of the most advanced calculators.will be putting that up soon. But cracker's ultimate function is named "crack1" and it requires 2 parameters both strings. The first is a String of a linear equation of one variable with an "=" sign and then a String of the independent variable (character).certain alphabets can't be used as variables such as 'a, x,l, s, ' and a few others since the whole algorithm is based on string processing so I suggest you stick with 'g d m q and r' . Both classes must however be used in the same package:Mycalc and cracker.  Cracker's functions are however all static for obvious reasons (It's Java). A sample of the test is found in cracker's main function. 

        
        String equation="2+3m=5";// this line assigns the equation
        System.out.println("\n"+equation);
        System.out.println(crack1(equation,"m"));//result computation
        
The result?
         m=+1.1063829787234043

Theoretically, any LINEAR equation consisting of the characters in the layout below  excluding "/" (division) can be evaluated by cracker.


![img_20180104_004328_174](https://user-images.githubusercontent.com/37802577/51503484-9668ba80-1ddb-11e9-86be-ceee4bd5e30e.jpg)


HAVE FUN!!!!!!!
