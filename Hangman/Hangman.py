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

r = "Test file.txt"
x = "Hangman words.txt"

# Gets a random word from the files
# lower() changes the word to lowercase
# rstrip() removes the newline at the end
rand_str = random_line(x).lower().rstrip()


# Guessing the word
def guess_word():
    guess = input("Guess the word: ").lower()
    if rand_str == guess:
        print("Wow you're good")
    else:
        print("Wrong, the word was", rand_str.upper())
        guess_word()

hel = ''.join(['h','e','l'])
lo = 'hel'

print(hel == lo)