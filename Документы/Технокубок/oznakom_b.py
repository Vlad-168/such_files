a=str(input())
index = 0
index2 = 0
for i in range(len(a)):
	if a[i] == '(':
		index = i
	if a[i] == ')':
		index2 = i
		break
string = a[index+1:index2]
ind = 0
chi = ''
for i in range(len(string)):
	if (string[i] >= "A" and string[i]<="Z") or (string[i] >= "a" and string[i]<="z"):
		ind = i
		break
	else:
		chi += string[i]
endstr = string[ind:index2]*int(chi)
qw = a[index2+1:]
endstr = endstr+qw
endstr = endstr.replace(")",'')
asd = a[:index].replace('(','')
if asd == '':
	endend = endstr*1
else:
	endend = endstr*int(asd)
print(endend)
