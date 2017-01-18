import random
import linecache


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
    r = "Test file.txt"
    x = "Hangman words.txt"

    rand_str = random_line(r).lower().rstrip()

    guess_array = []
    for i, char in enumerate(rand_str):
        if ' ' == char:
            guess_array.append(' ')
        else:
            guess_array.append('_')

    guess_limit = 100
    word = ''.join(guess_array)

    while (word != rand_str) and (guess_limit != 0):
        print(guess_array)
        guess = input("Guess: ").lower()

        if guess in rand_str:
            for y, ch in enumerate(guess):
                for z, cha in enumerate(rand_str):
                    if cha == ch:
                        guess_array[z] = guess[y]
            word = ''.join(guess_array)

        guess_limit -= 1

    print(list(rand_str), guess_limit)

guess_word()
