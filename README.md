# SE2832 Lab 1 Triangle Trouble
## Introduction
Telly loves triangles. At least he does on Sesame Street. However, have you ever thought of how to go about determining if a set of numbers defines a valid triangle?

In this exercise, you are going to work with a lab partner to test and verify a piece of software. The software reads in a file which defines triangles and prints out whether the line defines a valid triangle or not and what type of triangle it is.

## Lab Objectives
* Generate test cases for a problem.
* Write accurate and complete defect reports
* Enter defect reports into a mock defect tracking tool
* Define test cases that verify that a defect has been fixed.
* Correct defects in software

## Lab Overview

This lab will involve working with a single lab partner. One partner is to define test cases and test the software, finding defects within the software. The other partner is to fix the software so that failures do not repeat again.

The lab begins with the team downloading the triangle analysis program from the blackboard repository.  The program itself has the user enter a filename. The file itself contains a set of definitions for triangles that are to follow the format defined below. The program reads in each line and processes it, determining if the triangle is valid. If the definition is valid then an appropriate analysis (scalene, isosceles, or equilateral) will be printed out to the console. If it is invalid, an appropriate message will be printed out.
For example, the input line:
```javascript
3.0 3.0 3.0 # This line demonstrates a basic equilateral triangle
```
should print out
```
The triangle 3.0 3.0 3.0 is a valid triangle. The triangle is an equilateral triangle.
```
The input line :
```
10.0 3.0 4.0 # This line represents what should be an invalid triangle.
```
Should print out
```
The triangle 10.0 3.0 4.0 is not a valid triangle.
```
A valid line in the system starts with the definition of the three sides (a,b,c).  Each side may be either an integer or a floating point number, and the two types may be combined together.  The three entries may then be followed by a comment.  Comments start with the character #.  Anything after the # is to be ignored.

A valid triangle meets the following criteria:
 
A scalene triangle is defined as a triangle in which 
a≠b≠c

An isosceles triangle is defined as a triangle in which
a=b≠c ∪ a≠b=c ∪ a=c≠b

An equilateral triangle is defined as a triangle in which
a=b=c

The program itself should not crash, and more so, should indicate lines that are incorrectly formed do not match the input criteria for the program.
