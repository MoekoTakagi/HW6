import java.util.ArrayList;

public class QuickSort{
  static int pivot(ArrayList<Integer> a,int i,int j){
    int k=i+1;
    while(k<=j && a.get(i)==a.get(k)) k++;
    if(k>j) return -1;
    if(a.get(i)>=a.get(k)) return i;
    return k;
  }
  static int partition(ArrayList<Integer> a,int i,int j,int x){
    int l=i,r=j;
    // 検索が交差するまで繰り返します
    while(l<=r){
      // 軸要素以上のデータを探します
      while(l<=j && a.get(l)<x)  l++;
      // 軸要素未満のデータを探します
      while(r>=i && a.get(r)>=x) r--;
      if(l>r) break;
      int t=a.get(l);
      a.set(l, a.get(r));
      a.set(r, t);
      l++; r--;
    }
    return l;
  }
  public static void quickSort(ArrayList<Integer> a,int i,int j){
    if(i==j) return;
    int p=pivot(a,i,j);
    if(p!=-1){
      int k=partition(a,i,j,a.get(p));
      quickSort(a,i,k-1);
      quickSort(a,k,j);
    }
  }
  public static void sort(ArrayList<Integer> a){
    quickSort(a,0,a.size()-1);
  }
}