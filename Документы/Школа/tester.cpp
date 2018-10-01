#include <iostream>
using namespace std;

int F(int n)
{
	if (n>3)
		return F(n/3)*3;
	else return 2;
}

int main()
{
	cout<<F(23);

}