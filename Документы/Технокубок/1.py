a=int(input())
mas = [0]*a
index  =0 
b = int(input())
b = str(b)
for i in range(0,a):
	mas[i] = int(b[i])
maxim = max(mas)
for i in range(0,a):
	if mas[i] == maxim:
		index =i
b= b.replace(str(maxim),'')
summ =maxim
chet = 0
for i in range(0,len(b)-1):
	m=int(b[i])
	u = int(b[i+1:])
	if summ ==(m+u):
		chet+=1
		print("YES")
		break
if chet == 0:
	print("NO")		 