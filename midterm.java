import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int a=1;
        while(n>0){
            int fileNum = Integer.parseInt(sc.nextLine().split(" ")[1]);
            // System.out.println("file number:"+fileNum);
            HashMap<Integer, Integer> fileKB  = new HashMap();
            while(fileNum>0){
                String tmp = sc.nextLine();
                int id = Integer.parseInt(tmp.split(" ")[0]);
                int KB = Integer.parseInt(tmp.split(" ")[1]);
                fileKB.put(id, KB);
                
                fileNum--;
            }
            // System.out.println(fileKB.get(1));
            
            
            int treeNum = Integer.parseInt(sc.nextLine().split(" ")[1]);
            // System.out.println("tree number:"+treeNum);
            HashMap<Integer,String> treeOrder  = new HashMap();
            while(treeNum>1){
                String tmp = sc.nextLine();
                int id = Integer.parseInt(tmp.split(" ")[0]);
                String id2 = tmp.split(" ")[1];
                if(treeOrder.containsKey(id)) treeOrder.put(id, treeOrder.get(id)+" "+id2);
                else treeOrder.put(id, id2);
                
                treeNum--;
            }
            // System.out.println(treeOrder.get(2));

            Boolean bool = false;
            while(!bool){
                bool = true;
                for(Object key : treeOrder.keySet()){
                    if(!fileKB.containsKey(key)){
                        int sum=0;
                        String temp = treeOrder.get(key)+"";
                        String[] str = temp.split(" ");
                        Boolean b = true;
                        for(String s : str){
                            int i = Integer.parseInt(s);
                            if(fileKB.containsKey(i)) sum += fileKB.get(i);
                            else b=false;
                        }
                        String tmp = key+"";
                        int t = Integer.parseInt(tmp);
                        if(sum!=0 && b) {
                            fileKB.put(t, sum+1);
                        }
                        else bool = false;
                    }
                    
                }
            }
            

            System.out.println("ANS "+a);
            for(Object key : treeOrder.keySet()){
                System.out.println(key+" "+fileKB.get(key));
            }
            n--;
            a++;
        }
    }
}