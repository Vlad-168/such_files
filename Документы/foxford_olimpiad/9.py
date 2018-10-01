a=2**2019
a-=1
chet = 0
a=bin(a)
print(a)
a= str(a)
for i in range(0,len(a)):
	if a[i] =='1':
		chet +=1

print(chet)