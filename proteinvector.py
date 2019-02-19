import pandas as pd
import csv
import numpy as np
import string
import os
from fnmatch import fnmatch

TSRs = []
data1 =[]
root = '/home/linc/dxb3610/Documents/SCOPalphaProt'
pattern = "*.keys"
#csv.register_dialect('myDialect', delimiter='\t', dialect='excel',quoting=csv.QUOTE_NONE)
#csv_output = csv.writer(open("test3.csv", "wb"))

class System():
    def __init__(average):
         average.alist = []

def average_clac(myList = [], *args):
    data = np.loadtxt(filename, usecols=(0,))
    # print(data)
    # np.savetxt("hi.csv", data, delimiter=" ")
    TSRs = list(data)
    requiredLines = []
    list_float = []
    average = []
    with open("alphasvd1.csv", "r") as f:
        # Skip the first line
        # f.readline()
        for line in f:
            # line = line.strip()
            if float(line.split(",")[0]) in TSRs:
                # rint(line)
                # print("\n")
                requiredLines.append(line)
                # dct = { item[0]: item[1:] for item in requiredLines }
            np.savetxt("test2.csv", requiredLines, delimiter=" ", newline='', fmt='%s')
            with open('test2.csv', "r") as f:
                reader = csv.reader(f)
                data_list = list(reader)
                rows = ['{:.1f}'.format(sum(float(x) for x in y) / len(data_list)) for y in list(zip(*data_list))[1:]]
                average_data_list = [rows]
                #print (average_data_list)
                #average.append(average_data_list)
                np.savetxt("avg.csv", average_data_list, delimiter=" ", newline='', fmt='%s')
                #output = np.genfromtxt('avg.csv',delimiter=" ")
                #average.append(output)
                #for l in average:
                    #print(l)
    #Output = np.genfromtxt('avg.csv',delimiter=" ")
    #np.savetxt("test3.csv", average, delimiter=" ", newline='', fmt='%s')
    #f=open("test3.csv","a")
   # with open("test3.csv", "a") as f:
        #np.savetxt(f, average_data_list, delimiter=" ", newline='', fmt='%.5f')
    csv_output = csv.writer(open("Alpha_pv.csv", "a"), delimiter = '\t', dialect='excel')
    csv_output.writerow(average_data_list)
    #csv_output.writerow(str(average_data_list).translate(string.maketrans('', ''), '[]\''))
    print ("done")





for path, subdirs, files in os.walk(root):
    for file in files:
        if fnmatch(file,pattern):
        #if file.endswith(pattern):
            #print (os.path.join(path,file))
            filename = os.path.join(path,file)
           # np.savetxt("test2.csv", filename, delimiter=" ", newline='', fmt='%s')
            print (filename)
            #print (file(file, 'r').read())
            data1 = list(filename)
            average_clac(data1)
            #np.savetxt("test3.csv", average_data_list, delimiter=" ", newline='', fmt='%s')
            #f = open(filename, 'r')
            #with open (file, 'r') as f:
            #data = np.loadtxt(f, usecols=(0,))
            #print(data)
            #data1.append(data)
            #np.savetxt("test.csv", data1, delimiter=" ", newline='', fmt='%s')
            #np.savetxt("test.csv", data, delimiter=" ")
            
            
