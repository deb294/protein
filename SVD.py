import numpy as np
import numpy.linalg as SL
#import matplotlib.pyplot as plt


Output = np.genfromtxt('/home/linc/dxb3610/Desktop/data/alphaorbeta.csv',delimiter=',')
U, s, Vh = SL.svd(Output, full_matrices=False)
assert np.allclose(Output, np.dot(U, np.dot(np.diag(s), Vh)))

s[20:] = 0
new_a = np.dot(U, np.dot(np.diag(s), Vh))
#print(new_a[:,:20])
array = np.matrix(new_a[:,:20])
np.savetxt("/home/linc/dxb3610/Desktop/data/alphaorbetasvd1.csv", array, delimiter=" ")
#plt.plot(new_a)
#plt.show()
#plt.savefig('alpha.png')
