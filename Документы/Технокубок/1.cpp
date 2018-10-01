#include <iostream>
using namespace std;

int main()
{
	int n,a;
	int chet =0;
	cin>>n;
	for (int i=0;i<n;i++)
	{
		cin>>a;
		if (a == 0)
		{
			chet++;
		}
	}
	if (chet == n)
		cout<<"EASY";
	else
		cout<<"HARD";
}