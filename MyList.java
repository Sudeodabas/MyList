public class MyList <T> {
    int capacity;
    T[] list;
    T[] listTemp;
    int listSize=0;
    public void setList(){
        this.list=(T[])new Object[this.capacity];
    }

    public MyList(int capacity){
        this.capacity=capacity;
        this.setList();
    }
    public MyList(){//başlangıç boyutu
        this.capacity=10;
        this.setList();
    }
    public int size(){
        return this.listSize;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public  void newCapacity(){
        this.listTemp=(T[]) new Object[this.capacity];
        for (int i=0;i<this.list.length;i++){
            this.listTemp[i]=this.list[i];
        }
        this.list=this.list;
    }
    public void sizeNew(){
        int a=0;
        for (int i=0;i<this.list.length;i++){
            if(this.list[i]!=null)
                a++;
        }
        this.listSize=a;
    }
    public void add(T data){
        if(this.size()<this.capacity){
            list[this.listSize]=data;
            this.sizeNew();
        }
        else{
            this.capacity=this.capacity*2;
            this.newCapacity();
            this.add(data);

        }
    }
    public T get(int index){
     return this.list[index];
    }
    public void remove(int index){
        T[] list2=this.list;
        this.list[index]=null;
        for(int i=0;i<list2.length-1;i++){
            if (index==0){
                this.list[i]=list2[i+1];
            }
            else if(index!=0&&i>index){
                this.list[i]=list2[i];
            }
            else if(index!=0&&i>index){
                this.list[i]=list2[i+1];
            }
        }
    }
    public void set(int index, T data){
        this.list[index]=data;
    }
    @Override
    public String toString(){
        System.out.println("[ ");
        for (T x:list) {
            if(x!=null)
                System.out.println(x+ ", ");
        }
        System.out.println("]");
        return "";
    }
    public int indexOf(T data){
        for (int i=0;i<this.list.length;i++){
            if(data==this.list[i]){
                return i;
            }
        }
         return -1;
    }
    public int lastIndexOf(T data){
        int lastIx=-1;
        for(int i=0;i<this.list.length;i++){
            if(data==this.list[i])
                lastIx=i;

        }
        return lastIx;
    }
    public boolean isEmpty(){
        for (int i=0;i<this.list.length;i++){
            if(list[i]!=null)
                return false;
        }
        return true;
    }
    public Object[] toArray(){
        Object[] tempArray=new Object[this.list.length];
        for (int i=0;i<this.list.length;i++){
            tempArray[i]=list[i];
        }
        return tempArray;
    }
    public void clear(){
        for (int i=0;i<this.list.length;i++){
            list[i]=null;
        }
    }
    public MyList<T> subList(int start,int finish) {
        MyList<T> temp=new MyList<>(finish-start+1);
        for (int i=start;i<finish;i++){
            temp.add((T)this.list[i]);
        }
        return temp;
    }
    public boolean contains(T data){
        for (int i=0;i<this.list.length;i++){
            if (list[i]==data)
                return true;
        }
        return false;
    }
}
