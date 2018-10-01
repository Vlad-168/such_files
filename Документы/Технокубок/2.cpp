#include <iostream>
using namespace std;
int product(int Px, int Py, int Ax, int Ay, int Bx, int By)
{
  return (Bx - Ax) * (Py - Ay) - (By - Ay) * (Px - Ax);
}

int main()
{
  int x, y,d,n,col_vo;
  cin >> n>>d ;
  cin>>col_vo;
  for (int i=0;i<col_vo;i++)
  {
  	cin>>x>>y;
  	int 
	    p1 = product(x, y, 0, d, d, 0),
	    p2 = product(x, y, d, 0, n, n-d),
	    p3 = product(x, y, n, n-d, n-d, n),
	    p4 = product(x, y, n-d, n, 0, d);

  	if ((p1 <= 0 && p2 <= 0 && p3 <= 0 && p4 <= 0) || (p1 >= 0 && p2 >= 0 && p3 >= 0 && p4 >= 0))
    	cout << "YES" <<endl;
  	else
  		cout << "NO"<<endl;

  }
  
}