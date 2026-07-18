class Solution {
    public int leastInterval(char[] tasks, int n) {
        //1.frequency map
        HashMap<Character,Integer>map=new HashMap<>();
        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        //2.build pq 
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        pq.addAll(map.values());

        //3.Queue for cooldown<remaining time, available at time
        Queue<int[]>cooldownQueue=new LinkedList<>();
        int time=0;

        while(!pq.isEmpty()|| !cooldownQueue.isEmpty()){
            time++;
            //4. check if cooldown period is finished
            if(!cooldownQueue.isEmpty()&& cooldownQueue.peek()[1]==time){
                pq.add(cooldownQueue.poll()[0]);
            }
            //5.process the recent task
            if(!pq.isEmpty()){
                int count=pq.poll()-1;
                if(count>0){
                    cooldownQueue.add(new int[]{count,time+n+1});
                }
            }
        }
        return time;
        
    }
}