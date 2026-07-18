class MedianFinder {
    PriorityQueue<Integer>max;
    PriorityQueue<Integer>min;
    public MedianFinder() {
        max=new PriorityQueue<>((a,b)->b-a);
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //1. add in smaller one
        max.add(num);
        //2. check for when to put
        if(!min.isEmpty()&& max.peek()>min.peek()){
            min.add(max.poll());
        }
        //3. check if size is more, maxheap can have atleast one more
        if(max.size()>min.size()+1){
            min.add(max.poll());
        }
        else if(max.size()<min.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()){
            return (double)(max.peek()+min.peek())/2;
        }
        else{
            return (double)max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */