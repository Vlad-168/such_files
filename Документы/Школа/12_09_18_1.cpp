#include <iostream>
using namespace std;

int main()
{
	int n = 8,len = 1, summ = 0,maxlen = 0,maxsumm = 0;
	int mas[n];
	for (int i=0;i<n;i++)
	{
		cin>>mas[i];
	}
	for (int i=0;i<n;i++)
	{
		if (mas[i]<mas[i+1])
		{
			len+=1;
			summ+=mas[i];
			cout<<"LEngth: "<<len<<endl;
		}
		if (mas[i]>mas[i+1])
		{
			if (len>maxlen){
				maxlen = len;
			}
			if (summ>maxsumm)
			{
				maxsumm = summ;
			}
			len = 1;
			summ = 0;
		}
	}
	cout<<"MAXLEN:"<<maxlen<<endl;
	cout<<"MAXSUMM:"<<maxsumm;
}