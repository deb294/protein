with open('spam.txt', 'r') as file:
   file.readline() # skip the first line
   rows = [[int(x) for x in line.split(',')[:-1]] for line in file]
   cols = [list(col) for col in zip(*rows)]
   print(cols)