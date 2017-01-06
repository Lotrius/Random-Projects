# We love math (?)
import math

# HI
var = "Hello world\n"
print(var)

# You can change variable types wow
var = 5
print("The number of the day is", var)

# Wow amazing
x, y = 1, 2
print("JK there are two now they are", x, y)
print("But two is too many let's change it to ", x, y, "\n", sep='') # How to get rid of white spaces

# Can have elements of different types in arrays
almostNums = [1, 2, "hi"]
print("My favorite array is", almostNums)

# Iterating through an array
print("They are, in order:")
for elt in almostNums:
    print(elt)
print("\n")

# More for loop practice
for i in range(0, 10):
    print(i)
print("\n")

# Get input from user
var = input("Enter your name: ")
print("Your name is", var, "\n")

# r u cool yet
var = int(input("Enter your age: "))
if var < 21:
    print("Sucks to suck\n")
elif var == 21:
    print("AYYYYY\n")
else:
    print("ur old\n")

# More casting
print("The cool age is", int("21"),"\n")

# While loops
x = 0
while x < 5:
    print(x)
    x += 1
print("\n")

# We love functions too
def func(num, exp):
    # ** (double star) is exponent
    print(num, "^", exp, "=", num ** exp)
func(2,3)
