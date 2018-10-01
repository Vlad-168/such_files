#include <iostream>
using namespace std;

int main()
{
	string str;
	getline(cin,str);
    int a=0,b=0,len;
    len = str.length();
    for (int i=0;i<len;i++)
    {
        if ((str[i]>='A')&&(str[i]<='Z'))a++;
        if (str[i]>='a'&&str[i]<='z')b++;
    }
    
    double am = 100*a/len;
    cout<<"Big "<<100.0*1.0/8.0<<"%"<<"\nSmall "<<b*100/len<<'%'<<endl;
}
/*int second()
{
	int n,m,col_min, x ,y;
	cin<<n<<m;
	cin << col_min;
	int mas[n][m];
	for (int i=0;i<n;i++)
	{
		for (int j=0;j<m;j++)
		{
			mas[i][j]=0;
		}
	}
	for (int i=0;i<col_min;i++)
	{
		cin<<x<<y;
		for (int j=0;j<)
	}
}*/
