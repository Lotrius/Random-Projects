import random
import linecache
from tkinter import *


r = "Test file.txt"
x = "Hangman words.txt"

# List of letters guessed already
letters_guessed = []


# Got the code from http://stackoverflow.com/questions/845058/how-to-get-line-count-cheaply-in-python
# Spent forever figuring out how it works
# Curse Python and its lack of defining variable types
def file_len(file):
    with open(file) as f:
        for i, line in enumerate(f):
            pass
    return i + 1


# Get a random line from the file
def random_line(file):
    rand = random.randint(1, file_len(file))
    return linecache.getline(file, rand)


# Guessing the word
def guess_word():
    # The limit for how many wrong guesses the user is allowed
    guess_limit = 100

    # Get a random string from the files
    rand_str = random_line(r).lower().rstrip()

    # Create an array that contains the blank lines and spaces for the string
    guess_array = []
    for i, char in enumerate(rand_str):
        if ' ' == char:
            guess_array.append(' ')
        else:
            guess_array.append('_')

    # The array as a string
    word = ''.join(guess_array)

    while (word != rand_str) and (guess_limit != 0):
        print(guess_array)
        print("Guesses remaining: ", guess_limit)
        print("Letters guessed", letters_guessed)

        guess = input("Guess a letter: ").lower()

        if (len(guess) == 1) and (guess in rand_str) and (guess not in letters_guessed):
            letters_guessed.append(guess)
            for y, ch in enumerate(rand_str):
                if guess == ch:
                    guess_array[y] = ch
                    word = ''.join(guess_array)
        else:
            if (guess not in letters_guessed) and (len(guess) == 1):
                letters_guessed.append(guess)
            guess_limit -= 1

        '''
        # One possible implementation. Allow multiple letters at once
        if guess in rand_str:
            for y, ch in enumerate(guess):
                for z, cha in enumerate(rand_str):
                    if cha == ch:
                        guess_array[z] = guess[y]
            word = ''.join(guess_array)
        '''

    print(list(rand_str), guess_limit)
    return rand_str


def draw():
    canvas = Canvas(root)
    canvas.create_line(15, 25, 200, 25)
    canvas.create_line(300, 35, 300, 200, dash=(4, 2))
    canvas.create_line(55, 85, 155, 85, 105, 180, 55, 85)

    canvas.pack(fill=BOTH, expand=1)


root = Tk()

root.title("Hangman")
root.geometry("500x500")

Label(root, text="HANGMAN", font=("Helvetica", 50), fg="black").pack()
draw()
Label(root, text=random_line(x), font=("Helvetica", 50), fg="black").pack()

mainloop()
