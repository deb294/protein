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
for path, subdirs, files in os.walk(root):
    for file in files:
        if fnmatch(file,pattern):
        #if file.endswith(pattern):
            #print (os.path.join(path,file))
            filename = os.path.join(path,file)
            
            print (filename)
    #np.savetxt("filename.csv", filename, delimiter=" ", newline='', fmt='%s')