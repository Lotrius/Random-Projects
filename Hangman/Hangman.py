import random
import linecache
from tkinter import *


class Hangman:

    # Guessing the word
    def __init__(self, master, file):
        self.master = master
        self.file = file

        master.title("Hangman")
        master.geometry("800x800")
        Label(master, text="HANGMAN", font=("Helvetica", 50), fg="black").pack()

        # List of letters guessed already
        self.letters_guessed = []

        # The limit for how many wrong guesses the user is allowed
        self.guess_limit = 100

        # Get a random string from the files
        self.rand_str = self.random_line(self.file).lower().rstrip()

        # Create an array that contains the blank lines and spaces for the string
        self.guess_array = []
        for i, char in enumerate(self.rand_str):
            if ' ' == char:
                self.guess_array.append(' ')
            else:
                self.guess_array.append(' _ ')

        # The array as a string
        self.word = ' '.join(self.guess_array)

        self.guess_entry = Entry(master)
        self.guess_entry.bind('<Return>', self.show)

        self.guessed_letters_gui = StringVar()
        self.guessed_letters_gui.set("Letters guessed:\n" + ' '.join(self.guess_array))
        self.guessed_letters_label = Label(master, textvariable=self.guessed_letters_gui, font=("Helvetica", 30), fg="black")

        self.guess_array_gui = StringVar()
        self.guess_array_gui.set(self.letters_guessed)
        self.guess_array_label = Label(master, textvariable=self.guess_array_gui, font=("Helvetica", 30), fg="black")

        self.guess_limit_gui = StringVar()
        self.guess_limit_gui.set(self.guess_limit)
        self.guess_limit_label = Label(master, textvariable=self.guess_limit_gui, font=("Helvetica", 30), fg="black")

        Label(root, text=self.rand_str, font=("Helvetica", 20), fg="black").pack()
        self.guess_entry.pack();
        self.guess_array_label.pack()
        self.guessed_letters_label.pack()
        self.guess_limit_label.pack()

    def guess_word(self, guess):
        self.guess = guess
        if (len(self.guess) == 1) and (self.guess in self.rand_str) and (self.guess not in self.letters_guessed):
            self.letters_guessed.append(self.guess)
            for y, ch in enumerate(self.rand_str):
                if self.guess == ch:
                    self.guess_array[y] = ch
                    self.word = ''.join(self.guess_array)
        elif (len(self.guess) >= 1) or (self.guess == ""):
            if (self.guess not in self.letters_guessed) and (len(self.guess) == 1):
                self.letters_guessed.append(self.guess)
            self.guess_limit -= 1

        if(self.word == self.rand_str) or (self.guess_limit == 0):
            self.guess_entry.config(state=DISABLED)
            Label(self.master, text="GAME OVER", font=("Helvetica", 20), fg="black").pack()

        self.guessed_letters_gui.set("Letters guessed:\n" + ' '.join(self.letters_guessed))
        self.guess_array_gui.set(self.word)
        self.guess_limit_gui.set(self.guess_limit)

        '''
        # One possible implementation. Allow multiple letters at once
        if guess in rand_str:
            for y, ch in enumerate(guess):
                for z, cha in enumerate(rand_str):
                    if cha == ch:
                        guess_array[z] = guess[y]
            word = ''.join(guess_array)
        '''

    # Got the code from http://stackoverflow.com/questions/845058/how-to-get-line-count-cheaply-in-python
    # Spent forever figuring out how it works
    # Curse Python and its lack of defining variable types
    def file_len(self, file):
        with open(self.file) as f:
            for i, line in enumerate(f):
                pass
        return i + 1

    def show(self, event=None):  # handler
        self.guess = self.guess_entry.get().lower()
        self.guess_entry.delete(0, END)
        self.guess_word(self.guess)

    # Get a random line from the file
    def random_line(self, file):
        self.file = file
        self.rand = random.randint(1, self.file_len(file))
        return linecache.getline(file, self.rand)

    def draw(self, master):
        self.master = master
        self.canvas = Canvas(master)
        self.canvas.create_line(15, 25, 200, 25)
        self.canvas.create_line(300, 35, 300, 200, dash=(4, 2))
        self.canvas.create_line(55, 85, 155, 85, 105, 180, 55, 85)

        self.canvas.pack(fill=BOTH, expand=1)

r = "Test file.txt"
x = "Hangman words.txt"

root = Tk()
hangman_gui = Hangman(root, x)
hangman_gui.guess_word("")
root.mainloop()
