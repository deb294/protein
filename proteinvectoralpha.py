import pandas as pd
import csv
import numpy as np

import os
from fnmatch import fnmatch

TSRs = []

root = '/media/dxb3610/8C55-2B0F/dataset/alpha'
pattern = "*.keys"
data = np.loadtxt('d1alla_.keys', usecols=(0,))

for path, subdirs, files in os.walk(root):
    for file in files:
        #if fnmatch(name,pattern):
        if file.endswith(pattern):
            print (os.path.join(path,file))
            #with open(file, 'r') as f:
            #data = np.loadtxt(file, usecols=(0,))
                 #print(data)
                 
np.savetxt("hi.csv", data, delimiter=" ")
TSRs = list(data)
requiredLines = []
list_float =[]
average =[]
with open("alphasvd1.csv", "r") as f:
    # Skip the first line
    # f.readline()
    for line in f:
        #line = line.strip()
        if float(line.split(",")[0]) in TSRs:
            #rint(line)
            #print("\n")
            requiredLines.append(line)
            #dct = { item[0]: item[1:] for item in requiredLines }
        np.savetxt("hi2.csv", requiredLines, delimiter=" ", newline='', fmt='%s')
        with open('hi2.csv', "r") as f:
            reader= csv.reader(f)
            data_list = list(reader)
            rows = ['{:.1f}'.format(sum(float(x) for x in y) / len(data_list)) for y in list(zip(*data_list))[1:]]
            average_data_list = [rows]
            #print (average_data_list)
            np.savetxt("hi3.csv", average_data_list, delimiter=" ", newline='', fmt='%s')
            average.append(average_data_list)
            np.savetxt("avg.csv", average, newline='',fmt='%s')


        #header = next(reader)

        
        

       
# or even:   dct = { item[0]: item[1:] for item in ll }
#print(dct)
#import pandas as pd
#data = pd.read_csv('Met.csv')
#data['mass'].mean()
            #for s in  requiredLines:
                #list_float.extend([float(x) for x in s.split(' ')])
            #list_float = np.array(requiredLines) + 0. 
           
            
            #myarray = np.asarray(requiredLines)
            
        #average = list(avg)


            #text_file = open('output.txt', 'w')
            #text_file.write(line)
            #text_file.close()
             # a = np.array(requiredLines)
#print(list_float.mean(axis=0))

#print(*map(mean, zip(*requiredLines)))
#np.savetxt("hi1.csv", requiredLines, delimiter=" ", newline='', fmt='%s')
#np.savetxt("hi2.csv", avg, delimiter=" ", newline='', fmt='%s')
#for l in list_float:
 #   print(l)
#with open("hi1.csv", "w", newline='') as output:
 #   writer = csv.writer(output)
  #  for val in requiredLines:
   #     writer.writerow([val])
