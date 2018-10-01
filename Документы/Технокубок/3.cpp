#include <iostream>
using namespace std;

int main()
{
	int n,a;
	cin>>n;
	int mas[n];
	cout<<10^n;
	cin>>a;
	for (int i=0;i<n;i++)
	{
		a = a/(10^n);
		mas[i] = a;
		cout<<mas[i]<<" ";
	}
	int max = mas[0];
	for (int i=1;i<n;i++)
	{
		if (mas[i] > max) max = mas[i];
	}
	cout<<max;
}