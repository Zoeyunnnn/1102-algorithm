#include<stdio.h>
#include<string>
#include<map>
using namespace std;
int main(){
    int n,cs=0;cin>>n;string s;
    while(cin>>s>>n){cout<<"TEST "<<++cs<<":"<<endl;
        map<string,int>LX,LY;for(int k=0;k<n;k++){cin>>s;cin>>LX[s]>>LY[s];}
        map<int,map<string,int>>YPG,XPG;int a,b;map<string,int>RX,RY;
        cin>>s;while(cin>>a>>s>>b){YPG[a][s]=b;RY[s]=a;}cin.clear();
        cin>>s;while(cin>>a>>s>>b){XPG[a][s]=b;RX[s]=a;}cin.clear();
        map<int,int>X,Y;
        for(auto&kmsi:XPG)for(auto&kv:kmsi.second)X[kv.second]=X[kmsi.first]+LX[kv.first];
        for(auto&kmsi:YPG)for(auto&kv:kmsi.second)Y[kv.second]=Y[kmsi.first]+LY[kv.first];
        for(auto&kv:LX){string s=kv.first;
            cout<<s<<" "<<X[RX[s]]<<" "<<Y[RY[s]]<<endl;
        }
    }
    return 0;
}